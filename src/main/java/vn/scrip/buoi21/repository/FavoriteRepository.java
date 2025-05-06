package vn.scrip.buoi21.repository;
import vn.scrip.buoi21.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}