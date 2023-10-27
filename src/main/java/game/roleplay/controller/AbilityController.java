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

import game.roleplay.entity.Ability;
import game.roleplay.mapper.AbilityMapper;
import game.roleplay.service.AbilityService;
import game.roleplay.util.Mapper;

@RestController
@RequestMapping("/ability")
public class AbilityController {
	
	@Autowired
	private AbilityService service;
	
	@GetMapping
	public ResponseEntity<?> getAbility() {
		Collection<AbilityMapper> ability = Mapper.toAbility(service.findAll());
		if(ability != null) {
			return new ResponseEntity<>(ability, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("{abilityId}")
	public ResponseEntity<?> searchAbility(@PathVariable Integer abilityId) {
		Ability ability = service.findById(abilityId);
		if (ability != null) {
			return new ResponseEntity<>(ability, HttpStatus.OK);
		}
		return new ResponseEntity<>("Ability not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> addAbility(@RequestBody Ability ability) {
		ability.setState(true);
		service.insert(ability);
		return new ResponseEntity<>("Successfully registered", HttpStatus.OK);
	}

	@PatchMapping("{abilityId}")
	public ResponseEntity<?> searchAbility(@PathVariable Integer abilityId, @RequestBody Ability newAbility) {
		Ability oldAbility = service.findById(abilityId);
		if (oldAbility != null) {

			if(newAbility.getDescription() != null) {
				oldAbility.setDescription(newAbility.getDescription());
			}
			if(newAbility.getDamage() != null) {
				oldAbility.setDamage(newAbility.getDamage());
			}
			if(newAbility.getNameAbility() != null) {
				oldAbility.setNameAbility(newAbility.getNameAbility());
			}
			if(newAbility.getElement() != null) {
				oldAbility.setElement(newAbility.getElement());
			}
			return new ResponseEntity<>("Updated ability", HttpStatus.OK);
		}

		return new ResponseEntity<>("Ability not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{abilityId}")
	public ResponseEntity<?> deleteAbility(@PathVariable Integer abilityId) {
		Ability ability = service.findById(abilityId);
		if (ability != null) {
			ability.setState(false);
			service.update(ability);
			return new ResponseEntity<>("Deleted ability", HttpStatus.OK);
		}

		return new ResponseEntity<>("Ability not found", HttpStatus.NOT_FOUND);
	}

}
