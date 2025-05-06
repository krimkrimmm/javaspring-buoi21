package vn.scrip.buoi21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.scrip.buoi21.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByMovieId(Integer movieId);
}
