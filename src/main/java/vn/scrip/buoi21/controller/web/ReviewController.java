package vn.scrip.buoi21.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.scrip.buoi21.entity.Movie;
import vn.scrip.buoi21.entity.Review;
import vn.scrip.buoi21.service.MovieService;
import vn.scrip.buoi21.service.ReviewService;
import java.util.List;
@Controller
public class ReviewController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;
    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable Integer id, Model model) {
        Movie movie = movieService.findById(id);
        List<Review> reviews = reviewService.findByMovieId(id);
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);
        return "movie-detail"; // trả về view movie-detail.html
    }
}
