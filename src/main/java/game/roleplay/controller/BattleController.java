package game.roleplay.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.roleplay.mapper.CharacterMapper;

@RestController
@RequestMapping("/battle")
public class BattleController {

	@Autowired
	private CharacterController controller;

	List<CharacterMapper> characters = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<?> selectCharacters(@RequestBody List<Integer> selectedCharacter) {
		if(selectedCharacter.size() < 3) {
			return new ResponseEntity<>("select at least 3 characters.", HttpStatus.OK);
		}
		for (Integer id : selectedCharacter) {
			try {
				CharacterMapper character = (CharacterMapper) controller.searchCharacterById(id).getBody();
				characters.add(character);
			} catch (Exception e) {
				return new ResponseEntity<>("Character with id " + id + " does'nt exist, please select another character", HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(characters, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> myCharacters() {
		return new ResponseEntity<>(characters, HttpStatus.OK);
	}
}
