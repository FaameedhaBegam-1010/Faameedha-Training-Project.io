package com.cognizant.moviecruiser.model;

import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class Movies {

	private Long id;
	private String title;
	private Long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private String genre;
	private Boolean teaser;

	public Movies() {
		super();
	}

	public Movies(Long id, String title, Long gross, Boolean active, Date dateOfLaunch, String genre, Boolean teaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.teaser = teaser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(Long gross) {
		this.gross = gross;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getTeaser() {
		return teaser;
	}

	public void setTeaser(Boolean teaser) {
		this.teaser = teaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((gross == null) ? 0 : gross.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((teaser == null) ? 0 : teaser.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (gross == null) {
			if (other.gross != null)
				return false;
		} else if (!gross.equals(other.gross))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (teaser == null) {
			if (other.teaser != null)
				return false;
		} else if (!teaser.equals(other.teaser))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", gross=" + gross + ", active=" + active + ", dateOfLaunch="
				+ new DateUtil().convertToString(dateOfLaunch) + ", genre=" + genre + ", teaser=" + teaser + "]";
	}

}
