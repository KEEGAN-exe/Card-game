package game.roleplay.service;

import java.util.List;

import game.roleplay.entity.Character;

public interface CharacterService {

	public abstract void insert(Character character);

	public abstract void update(Character character);

	public abstract void delete(Integer characterId);

	public abstract Character findByIdCharacter(Integer characterId);

	public abstract List<Character> findAll();
	
	public abstract Character findById(Integer characterId);

	public abstract List<Character> findByName(String name);

}
