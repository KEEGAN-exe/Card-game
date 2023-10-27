package game.roleplay.service;

import java.util.List;

import game.roleplay.entity.Category;

public interface CategoryService {

	public abstract void insert(Category category);

	public abstract void update(Category category);

	public abstract void delete(Integer categoryId);

	public abstract Category findByIdCategory(Integer categoryId);

	public abstract List<Category> findAll();

}
