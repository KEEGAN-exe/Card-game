package game.roleplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import game.roleplay.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT * FROM categories WHERE state = true", nativeQuery = true)
	public abstract List<Category> findAll();

	@Query(value = "SELECT * FROM categories WHERE state = true AND id_category = ?", nativeQuery = true)
	public abstract Category findByIdCategory(Integer categoryId);
}
