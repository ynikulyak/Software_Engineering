package cst438;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class General {
   
   /*
    *autowired means spring looks at data type of variable: do I know anything 
    *about personRepository? 
    *annotation tells Spring where an injection needs to occurs
    */
   @Autowired
   MovieRepository movieRepository;
   
  //welcome page with link to the movie form 
  @GetMapping("/index")
  public String hello() {
     return "index";
  }
   
//download an empty form
  @GetMapping("/movies/new")
  public String createMovie(Model model) {
     Movie movie = new Movie();
     model.addAttribute("movie", movie);
     return "movie_form";//return html form where user can enter first name, last name and food
  }
  

  //post entity in db if the form was filled correctly, otherwise fill the form again
  @PostMapping("/movies")
     public String processMovieForm(@Valid Movie movie, BindingResult result, 
           Model model) {
     
     LocalDateTime current = LocalDateTime.now(); 
     
     // to print in a particular format 
     DateTimeFormatter format =  
       DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");   
     
     String formatedDateTime = current.format(format);
     movie.setDate(formatedDateTime); 
     //check if there were errors in form, if they are, th:if would display
     //error message in a form field with error
     if(result.hasErrors()) {
        return "movie_form";
     }
     
     //save in db
     movieRepository.save(movie);
     return "movie_show";//if no errors in form, return movie_show.html
  }
  
  //show all movies from db
  @GetMapping("/movies")
  public String getAllMovies(Model model) {
     
     //takes every row in movie table, create movie object, put in list, put
     //list in a model and display by html
     Iterable<Movie> movie = movieRepository.findByOrderByTitleDateDesc();
     
     model.addAttribute("movie", movie);
     
     return "movie_list";
  }
  
}
