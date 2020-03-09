package cst438;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity			// annotation for class to be stored in a database
public class Movie {

	@Id
	@GeneratedValue
	private long id;	// primary key for db records
	
	@NotNull
	@Size(min=3, max=25)
	private String title;
	
	@NotNull
	@Size(min=1, max=5)
	private String rating;
	
	@NotNull
	@Size(min=3, max=25)
	private String poster;
	
	public Movie() {
		
	}
	public Movie(long id, String title, String rating, String poster) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.poster = poster;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
}
