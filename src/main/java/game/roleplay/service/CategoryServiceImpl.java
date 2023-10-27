package game.roleplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.roleplay.entity.Category;
import game.roleplay.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Override
	public void insert(Category category) {
		repository.save(category);
	}

	@Override
	public void update(Category category) {
		repository.save(category);
	}

	@Override
	public void delete(Integer categoryId) {
		repository.deleteById(categoryId);
	}

	@Override
	public Category findByIdCategory(Integer categoryId) {
		return repository.findByIdCategory(categoryId);
	}

	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}
}
