package game.roleplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import game.roleplay.entity.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

	@Query(value = "SELECT * FROM characters WHERE state = true", nativeQuery = true)
	public abstract List<Character> findAll();

	@Query(value = "SELECT * FROM characters WHERE state = true AND name LIKE %?%", nativeQuery = true)
	public abstract List<Character> findByName(String name);

	@Query(value = "SELECT * FROM characters WHERE state = true AND id_character = ?", nativeQuery = true)
	public abstract Character findByIdCharacter(Integer characterId);

}
