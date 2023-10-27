package game.roleplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.roleplay.entity.Character;
import game.roleplay.entity.Element;
import game.roleplay.service.CharacterService;
import game.roleplay.service.ElementService;

@RestController
@RequestMapping("/addelement")
public class CharacterElementController {

	@Autowired
	private ElementService elementService;

	@Autowired
	private CharacterService characterService;

	@PostMapping("{characterId}/{elementId}")
	public ResponseEntity<?> addElement(@PathVariable Integer elementId, @PathVariable Integer characterId) {

		Character character = characterService.findByIdCharacter(characterId);
		if (character != null) {
			Element element = elementService.findByIdElement(elementId);
			if (element != null) {

				if (character.getElements().contains(element)) {
					return new ResponseEntity<>("This character already has this item.", HttpStatus.OK);
				}

				character.addElement(element);
				characterService.update(character);
				return new ResponseEntity<>("Added element", HttpStatus.OK);
			}

			return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{characterId}/{elementId}")
	public ResponseEntity<?> deleteElement(@PathVariable Integer elementId, @PathVariable Integer characterId) {
		Character character = characterService.findByIdCharacter(characterId);
		if (character != null) {
			Element element = elementService.findByIdElement(elementId);
			if (element != null) {

				if (!character.getElements().contains(element)) {
					return new ResponseEntity<>("This character no longer has this element.", HttpStatus.OK);
				}

				character.removeElement(element);
				characterService.update(character);
				return new ResponseEntity<>("Removed element", HttpStatus.OK);
			}

			return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}
}
