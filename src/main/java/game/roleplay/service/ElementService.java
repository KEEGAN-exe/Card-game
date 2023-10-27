package game.roleplay.service;

import java.util.List;

import game.roleplay.entity.Element;

public interface ElementService {

	public abstract void insert(Element element);

	public abstract void update(Element element);

	public abstract void delete(Integer elementId);

	public abstract Element findByIdElement(Integer elementId);

	public abstract List<Element> findAll();
	
	public abstract Element findById(Integer elementId);

}
