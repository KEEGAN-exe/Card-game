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

import game.roleplay.entity.Category;
import game.roleplay.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<?> getCategory() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("{categoryId}")
	public ResponseEntity<?> searchCategory(@PathVariable Integer categoryId) {
		Category category = service.findByIdCategory(categoryId);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		category.setState(true);
		service.insert(category);
		return new ResponseEntity<>("Successfully registered", HttpStatus.OK);
	}

	@PatchMapping("{categoryId}")
	public ResponseEntity<?> searchCategory(@PathVariable Integer categoryId, @RequestBody Category newCategory) {
		Category oldCategory = service.findByIdCategory(categoryId);
		if (oldCategory != null) {
			if (newCategory.getNameCategory() != null) {
				oldCategory.setNameCategory(newCategory.getNameCategory());
			}
			if (newCategory.getDescription() != null) {
				oldCategory.setDescription(newCategory.getDescription());
			}

			return new ResponseEntity<>("Updated category", HttpStatus.OK);
		}

		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
		Category category = service.findByIdCategory(categoryId);
		if (category != null) {
			category.setState(false);
			service.update(category);
			return new ResponseEntity<>("Deleted category", HttpStatus.OK);
		}

		return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}
}
