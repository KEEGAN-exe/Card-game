package game.roleplay.service;

import java.util.Collection;

import game.roleplay.entity.Ability;

public interface AbilityService {

	public abstract void insert(Ability ability);

	public abstract void update(Ability ability);

	public abstract void delete(Integer abilityId);

	public abstract Ability findById(Integer abilityId);

	public abstract Collection<Ability> findAll();

}
