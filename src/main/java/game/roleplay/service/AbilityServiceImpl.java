package game.roleplay.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.roleplay.entity.Ability;
import game.roleplay.repository.AbilityRepository;

@Service
public class AbilityServiceImpl implements AbilityService {

	@Autowired
	private AbilityRepository repository;

	@Override
	public void insert(Ability ability) {
		repository.save(ability);
	}

	@Override
	public void update(Ability ability) {
		repository.save(ability);
	}

	@Override
	public void delete(Integer abilityId) {
		repository.deleteById(abilityId);
	}

	@Override
	public Ability findById(Integer abilityId) {
		return repository.findById(abilityId).orElse(null);
	}

	@Override
	public Collection<Ability> findAll() {
		return repository.findAll();
	}

}
