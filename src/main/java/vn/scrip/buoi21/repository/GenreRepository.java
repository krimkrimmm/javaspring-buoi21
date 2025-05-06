package vn.scrip.buoi20.repository;
import vn.scrip.buoi21.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}