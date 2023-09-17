package api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Show;
import api.model.ShowType;

@Primary
public interface ShowRepository extends JpaRepository<Show, Integer> {

	Optional<Show> findByShowTitle(String showTitle);

	List<Show> findByShowType(ShowType showType);

}
