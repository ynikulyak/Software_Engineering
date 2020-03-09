package cst438;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello {	// localhost:8080/hello?name=chris
	
	@Autowired
	MovieRepository movieRepository; // autoreferences the repository
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("time", new java.util.Date().toString());
		return "index";
	}
	
	@GetMapping("/movie/new")					// method to download a form to create a new movie
	public String createMovie(Model model) {	// create a model
		Movie movie = new Movie();				// create blank movie object
		model.addAttribute("movie", movie);		// add key value "movie" to model	
		return "movie_form";
	}
	
	@PostMapping("/movie")						// method to submit data
	public String processMovieForm(@Valid Movie movie, 
			BindingResult result, 
			Model model) {
		if (result.hasErrors()) {				// checks for data errors
			return "movie_form";				// if errors, returns the form with
												// with the error message
		}
		movieRepository.save(movie);			// saves data to db if no errors
		return "movie_show";					// if no errors, shows the data again
	}
	
	@GetMapping("/movie")						// displays a list of movies in the db
	public String getAllMovieList(Model model) {
		Iterable<Movie> movieList = movieRepository.findAll();
		model.addAttribute("movies", movieList);
		return "movie_list";
	}
}
