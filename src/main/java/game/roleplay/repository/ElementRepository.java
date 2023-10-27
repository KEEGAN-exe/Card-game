package game.roleplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import game.roleplay.entity.Element;

public interface ElementRepository extends JpaRepository<Element, Integer> {

	@Query(value = "SELECT * FROM elements WHERE state = true", nativeQuery = true)
	public abstract List<Element> findAll();

	@Query(value = "SELECT * FROM elements WHERE state = true AND id_element = ?", nativeQuery = true)
	public abstract Element findByIdElement(Integer elementId);
}
