package api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api.model.Show;
import api.repository.ShowRepository;

public interface EpisodeRepository extends JpaRepository <Show, Integer>{



}
