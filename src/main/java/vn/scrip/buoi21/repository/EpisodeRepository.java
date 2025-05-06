package vn.scrip.buoi21.repository;
import vn.scrip.buoi21.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}