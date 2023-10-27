package game.roleplay.controller;

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

import game.roleplay.entity.Element;
import game.roleplay.service.ElementService;

@RestController
@RequestMapping("/element")
public class ElementController {

	@Autowired
	private ElementService service;

	@GetMapping
	public ResponseEntity<?> getElement() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("{elementId}")
	public ResponseEntity<?> searchElement(@PathVariable Integer elementId) {
		Element element = service.findByIdElement(elementId);

		if (element != null) {
			return new ResponseEntity<>(element, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> addElement(@RequestBody Element element) {
		element.setState(true);
		service.insert(element);
		return new ResponseEntity<>("successfully registered", HttpStatus.OK);
	}

	@PatchMapping("{elementId}")
	public ResponseEntity<?> updateElement(@PathVariable Integer elementId, @RequestBody Element newElement) {

		Element oldElement = service.findByIdElement(elementId);
		if (oldElement != null) {
			if (newElement.getDescription() != null) {
				oldElement.setDescription(newElement.getDescription());
			}
			if (newElement.getNameElement() != null) {
				oldElement.setNameElement(newElement.getNameElement());
			}

			service.update(oldElement);

			return new ResponseEntity<>("Updated element", HttpStatus.OK);
		}

		return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{elementId}")
	public ResponseEntity<?> deleteElement(@PathVariable Integer elementId) {
		Element element = service.findByIdElement(elementId);
		if (element != null) {
			element.setState(false);
			service.update(element);
			return new ResponseEntity<>("Deleted element", HttpStatus.OK);
		}
		return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
	}
}
