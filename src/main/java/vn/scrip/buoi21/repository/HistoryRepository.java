package vn.scrip.buoi21.repository;
import vn.scrip.buoi21.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}