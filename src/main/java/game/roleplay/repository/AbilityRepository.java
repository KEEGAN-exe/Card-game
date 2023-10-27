package game.roleplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import game.roleplay.entity.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {

}
