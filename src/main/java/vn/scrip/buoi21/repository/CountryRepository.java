package vn.scrip.buoi21.repository;
import vn.scrip.buoi21.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Integer> {
}