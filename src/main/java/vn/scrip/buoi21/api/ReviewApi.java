package vn.scrip.buoi21.api;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi21.entity.Review;
import vn.scrip.buoi21.service.ReviewService;

import vn.scrip.buoi21.service.UserService;
import java.security.Principal;
@RestController
@RequestMapping("/api/reviews")
public class ReviewApi{
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    // Cập nhật review
    @PutMapping("/{id}")
    public void updateReview(@PathVariable("id") Integer id,
                             @RequestBody Review inputReview,
                             Principal principal,
                             HttpServletResponse response) {
        // Tìm review theo id
        Review review = reviewService.findById(id);
        if (review == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Không tìm thấy review
            return;
        }
        // Kiểm tra quyền chỉnh sửa review
        if (principal == null || !review.getUsername().equals(principal.getName())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Không có quyền sửa review
            return;
        }
        // Cập nhật nội dung review
        review.setComment(inputReview.getComment()); // Cập nhật lại comment (content)

        review.setRating(inputReview.getRating()); // Cập nhật lại rating
        reviewService.save(review);
        response.setStatus(HttpServletResponse.SC_OK); // Trả về trạng thái OK sau khi cập nhật
    }
    // Xóa review
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") Integer id,
                             Principal principal,
                             HttpServletResponse response) {

        // Tìm review theo id
        Review review = reviewService.findById(id);
        if (review == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Không tìm thấy review
            return;
        }
        // Kiểm tra quyền xóa review
        if (principal == null || !review.getUsername().equals(principal.getName())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Không có quyền xóa review

            return;
        }
        // Xóa review
        reviewService.deleteById(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Trả về trạng thái No Content sau khi xóa
    }
}



