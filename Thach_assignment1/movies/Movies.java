package cst438;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//controller page
@Controller
public class Movies {
	//auto generate data into mySql
	@Autowired
	MovieRepository movieRepository;

	@GetMapping("movies/new") //getmapping will open movies/new in url
	public String createMovie(Model model) {
		Movie movie = new Movie();//declare new movie
		model.addAttribute("movie", movie);
		return("/movies_form");//link to our html file we cerate
	}

	@PostMapping("/movies")//This to post whatever info we have from this page to /movies url
	public String processMovie(@Valid Movie movie,
			BindingResult result, Model model) {//binding whatever we enter from movies
		
		LocalDateTime now = LocalDateTime.now();//delcare for data to be entry
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YYY");
		String formateDateTime = now.format(format);
		movie.setDate(formateDateTime); //setDate into movie time
		if(result.hasErrors()) {
			return "movies_form";//if error return same page
		}
		movieRepository.save(movie);//if everything is correct save and link to new url
		return "movie_show";
	}
	
	@GetMapping("/movies")//link to our /movies url
	public String getAllMovies(Model model) {
		//goes through list of movie in our database and sort them in order
		Iterable<Movie> movie = movieRepository.findMoviesRatingsOrderByTitleDateDesc();
		model.addAttribute("movies", movie);
		
		return "movies_list";
	}
	
	
	
	
}
