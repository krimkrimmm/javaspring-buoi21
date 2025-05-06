package vn.scrip.buoi21.api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi21.entity.Review;

import vn.scrip.buoi21.model.request.UpdateReviewRequest;
import vn.scrip.buoi21.service.ReviewService;
@RestController
@RequestMapping("/api/reviews")
public class ReviewApi {
    @Autowired
    private ReviewService reviewService;
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateReviewRequest request) {
        return ResponseEntity.ok(reviewService.updateReview(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
}
