package vn.scrip.buoi21.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.scrip.buoi21.entity.Review;
import vn.scrip.buoi21.repository.ReviewRepository;
import vn.scrip.buoi21.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findByMovieId(Integer movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    @Override
    public Review findById(Integer id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteById(Integer id) {
        reviewRepository.deleteById(id);
    }
}

