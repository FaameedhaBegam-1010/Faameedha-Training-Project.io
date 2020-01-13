package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public static final String ADD_MENUITEM_TO_CART = "INSERT into cart (ct_us_id,ct_me_id) values(?,?)";
	public static final String GET_MENUITEM = "select me_id,me_name,me_free_delivery,me_price from menu_item inner join cart on ct_me_id = me_id where ct_us_id=?";
	public static final String GET_TOTAL = "select sum(me_price) as Total from menu_item inner join cart on ct_me_id=me_id where ct_us_id=?";
	public static final String REMOVE_CARTITEM = "delete from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		Cart cart = new Cart();
		try {
			preparedStatement = connection.prepareStatement(GET_MENUITEM);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItemList.add(menuItem);
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (preparedStatementTotal != null)
					preparedStatementTotal.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(REMOVE_CARTITEM);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

	}

}
