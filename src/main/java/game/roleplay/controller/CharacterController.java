package game.roleplay.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.roleplay.entity.Character;
import game.roleplay.mapper.CharacterMapper;
import game.roleplay.service.CharacterService;
import game.roleplay.util.Mapper;

@RestController
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private CharacterService service;

	@GetMapping
	public ResponseEntity<?> getCharacter() {
		Collection<CharacterMapper> character = Mapper.toCharacter(service.findAll());
		if (character != null) {
			return new ResponseEntity<>(character, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("{characterId}")
	public ResponseEntity<?> searchCharacterById(@PathVariable Integer characterId) {
		CharacterMapper character = Mapper.toFirstCharacter(service.findById(characterId));
		if (character != null) {
			return new ResponseEntity<>(character, HttpStatus.OK);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/name/{characterName}")
	public ResponseEntity<?> searchCharacterByName(@PathVariable String characterName) {
		Collection<CharacterMapper> character = Mapper.toCharacter(service.findByName(characterName));
		if (character != null) {
			return new ResponseEntity<>(character, HttpStatus.OK);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> addCharacter(@RequestBody Character character) {
		character.setState(true);
		service.insert(character);
		return new ResponseEntity<>("Successfully registered", HttpStatus.OK);
	}

	@PatchMapping("{characterId}")
	public ResponseEntity<?> updateCharacter(@RequestBody Character newCharacter, @PathVariable Integer characterId) {
		Character oldCharacter = service.findByIdCharacter(characterId);
		if (oldCharacter != null) {
			if (newCharacter.getName() != null) {
				oldCharacter.setName(newCharacter.getName());
			}
			if (newCharacter.getLastname() != null) {
				oldCharacter.setLastname(newCharacter.getLastname());
			}
			if (newCharacter.getLivePoint() != null) {
				oldCharacter.setLivePoint(newCharacter.getLivePoint());
			}
			if (newCharacter.getCategory() != null) {
				oldCharacter.setCategory(newCharacter.getCategory());
			}

			service.update(oldCharacter);

			return new ResponseEntity<>("Successfully registered", HttpStatus.OK);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{characterId}")
	public ResponseEntity<?> deleteCharacter(@PathVariable Integer characterId) {
		Character character = service.findByIdCharacter(characterId);

		if (character != null) {
			character.setState(false);
			service.update(character);
			return new ResponseEntity<>("Deleted character", HttpStatus.OK);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}
}
