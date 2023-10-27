package game.roleplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.roleplay.entity.Element;
import game.roleplay.repository.ElementRepository;

@Service
public class ElementServiceImpl implements ElementService {

	@Autowired
	private ElementRepository repository;

	@Override
	public void insert(Element element) {
		repository.save(element);
	}

	@Override
	public void update(Element element) {
		repository.save(element);
	}

	@Override
	public void delete(Integer elementId) {
		repository.deleteById(elementId);
	}

	@Override
	public List<Element> findAll() {
		return repository.findAll();
	}

	@Override
	public Element findByIdElement(Integer elementId) {
		return repository.findByIdElement(elementId);
	}

	@Override
	public Element findById(Integer elementId) {
		return repository.findById(elementId).orElse(null);
	}

}
