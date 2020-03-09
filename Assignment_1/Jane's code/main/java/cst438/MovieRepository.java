package cst438;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
 *needed to allow spring to create table in db automatically
 *spring will generate an implementation for this interface with some basic 
 *methods that allow an entity to be retrieved by primary key or be inserted or 
 *removed from the movie table
 */
public interface MovieRepository extends CrudRepository<Movie, Long>{

   //hibernate query references class name Movie not table
   @Query("select m from Movie as m order by title, date desc")
   List<Movie> findByOrderByTitleDateDesc(); 
   
}
