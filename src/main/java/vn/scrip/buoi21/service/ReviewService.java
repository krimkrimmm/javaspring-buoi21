package vn.scrip.buoi21.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.scrip.buoi21.entity.Review;
import vn.scrip.buoi21.exception.NotFoundException;

import vn.scrip.buoi21.model.request.UpdateReviewRequest;
import vn.scrip.buoi21.repository.ReviewRepository;
import java.util.List;
@Service
public class ReviewService {
        @Autowired
        private ReviewRepository reviewRepository;
        public List<Review> findByMovieId(Integer movieId) {
                return reviewRepository.findByMovieId(movieId);
        }
        @Transactional
        public Review updateReview(Integer id, UpdateReviewRequest request) {
                Review review = reviewRepository.findById(Long.valueOf(id))
                        .orElseThrow(() -> new NotFoundException("Không tìm thấy review với id: " + id));

                review.setContent(request.getContent());
                review.setRating(request.getRating());

                return reviewRepository.save(review);
        }

        public void deleteReview(Long id) {
                Review review = reviewRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Không tìm thấy review với id: " + id));

                reviewRepository.delete(review);
        }
}
