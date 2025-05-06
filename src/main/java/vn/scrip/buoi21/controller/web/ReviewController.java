package vn.scrip.buoi21.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi21.entity.Movie;
import vn.scrip.buoi21.entity.Review;
import vn.scrip.buoi21.entity.User;
import vn.scrip.buoi21.service.MovieService;
import vn.scrip.buoi21.service.ReviewService;
import vn.scrip.buoi21.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    // Hiển thị thông tin chi tiết phim cùng review
    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable Integer id, Model model, Principal principal) {
        Movie movie = movieService.findById(id);
        List<Review> reviews = reviewService.findByMovieId(id);

        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);

        // Kiểm tra xem người dùng đã đăng nhập chưa
        if (principal != null) {
            User userLogin = userService.findByUsername(principal.getName());
            model.addAttribute("userLogin", userLogin);
        }

        return "movie-detail"; // Trả về giao diện chi tiết phim
    }
}
