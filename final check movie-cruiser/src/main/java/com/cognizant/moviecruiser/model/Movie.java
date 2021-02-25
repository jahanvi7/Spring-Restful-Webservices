package com.cognizant.moviecruiser.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Movie {

	private long id;
	private String title;
	private float boxOffice;
	private boolean active;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfLaunch;
	private String genre;
	private boolean teaser;
	
	public Movie() {
		super();
	}

	public Movie(long id, String title, long boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean teaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.teaser = teaser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(float boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
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

	public boolean isTeaser() {
		return teaser;
	}

	public void setTeaser(boolean teaser) {
		this.teaser = teaser;
	}

	@Override
	public String toString() {
		return "Moive [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", teaser=" + teaser + "]";
	}
}
