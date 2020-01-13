package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		long userId = 1l;
		new CartDaoSqlImpl().addCartItem(userId, 3);
		testgetAllCartItems();
	}

	public static void testgetAllCartItems() throws CartEmptyException {

		DecimalFormat df = new DecimalFormat("#.00");

		List<MenuItem> list = new ArrayList<>();
		long userId = 1l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart cart = cartDaoSqlImpl.getAllCartItems(userId);
		list = cart.getMenuItemList();

		System.out.format("%-10s%-20s%-15s%-15s", "ID", "NAME", "FREE_DELIVERY", "PRICE");

		String freedelivery;
		for (MenuItem menuItem : list) {
			if (menuItem.getFreeDelivery() == true) {
				freedelivery = "Yes";
			} else {
				freedelivery = "No";
			}
			System.out.format("\n%-10s%-20s%-15s%-15s", menuItem.getId(), menuItem.getName(), freedelivery,
					df.format(menuItem.getPrice()));
		}
		System.out.println("\nTotal Price :" + cart.getTotal());
	}

	public static void testremoveCartItem() throws CartEmptyException {
		long userId = 1l;
		new CartDaoSqlImpl().removeCartItem(userId, 3);
		testgetAllCartItems();

	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testgetAllCartItems();
		testremoveCartItem();
	}
}
