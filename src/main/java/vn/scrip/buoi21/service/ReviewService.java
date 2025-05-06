package vn.scrip.buoi21.service;

import vn.scrip.buoi21.entity.Review;

import java.util.List;
public interface ReviewService
{
        List<Review> findByMovieId(Integer movieId);  // Tìm các review của phim theo movieId
        Review findById(Integer id);                  // Tìm review theo ID
        void save(Review review);                      // Lưu review
        void deleteById(Integer id);                  // Xóa review theo ID
}
