package vn.scrip.buoi21.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import vn.scrip.buoi21.entity.Movie;
import vn.scrip.buoi21.exception.NotFoundException;
import vn.scrip.buoi21.model.enums.MovieType;
import vn.scrip.buoi21.repository.MovieRepository;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> findHotMovie(Boolean status, Integer limit) {
        return movieRepository.findHotMovie(status, limit);
    }

    public Page<Movie> findByType(MovieType type, Boolean status, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("publishedAt").descending());
        return movieRepository.findByTypeAndStatus(type, status, pageable);
    }

    public Movie findMovieDetails(Integer id, String slug) {
        return movieRepository.findByIdAndSlugAndStatus(id, slug, true);
    }
    // ✅ Thêm phương thức này để dùng trong ReviewController
    public Movie findById(Integer id)
    {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy movie với id: " + id));
    }
}

