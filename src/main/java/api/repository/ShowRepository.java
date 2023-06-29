package api.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api.model.Show;

@Primary
public interface ShowRepository extends JpaRepository <Show, Integer>{
	
//	List<Show> findByShowTitle(String show_title);


}
