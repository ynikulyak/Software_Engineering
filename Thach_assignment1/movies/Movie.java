package cst438;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	//generating ID for database
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3, max=99)
	private String title;
	
	@NotNull
	@Size(min=3, max=40)
	private String name;
	//rules for cant be null, number can only be enter from 1 to 5 with min n max.
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
	
	private String date;
	
	public Movie() {
		title = null;
		name = null;
		rating = null;
	}

	public Movie(long id, String title, String name, Integer rating, String date) {
		super();
		this.title = title;
		this.name = name;
		this.rating = rating;
		this.id = id;
		this.date = date;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
