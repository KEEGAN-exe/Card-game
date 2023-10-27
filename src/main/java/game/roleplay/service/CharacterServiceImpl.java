package game.roleplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.roleplay.entity.Character;
import game.roleplay.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository repository;

	@Override
	public void insert(Character character) {
		repository.save(character);
	}

	@Override
	public void update(Character character) {
		repository.save(character);
	}

	@Override
	public void delete(Integer characterId) {
		repository.deleteById(characterId);
	}

	@Override
	public Character findByIdCharacter(Integer characterId) {
		return repository.findByIdCharacter(characterId);
	}

	@Override
	public List<Character> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Character> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Character findById(Integer characterId) {
		return repository.findById(characterId).orElse(null);
	}

}
