package cst438;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/*Domain class, angels the data of app
*a class that is stored in database
*/
@Entity
public class Movie {
   
   /*
    *primary key that can be generated either by db or you can create the value 
    *by yourself; here we let db to create
    */
   @Id
   @GeneratedValue
   private long id;
   
   @NotNull
   @Size(min = 2, max = 25)
   private String title;
   
   @NotNull
   @Size(min = 2, max = 25)
   private String name;
   
   @NotNull
   @Range(min = 1, max = 5)
   private int rating;
   
   private String date;
   
   
   public Movie() {
     
   }
   
   public Movie(long id, String title, String name, int rating, String date) {
      super();
      this.id = id;
      this.title = title;
      this.name = name;
      this.rating = rating;
      this.date = date;
   }


   //Getters and Setters for all fields
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


   public int getRating() {
      return rating;
   }


   public void setRating(int rating) {
      this.rating = rating;
   }

  public String getDate() {
     return date;
  }
  
  public void setDate(String date) {
     this.date = date;
  }
}
