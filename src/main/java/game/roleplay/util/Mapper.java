package game.roleplay.util;

import java.util.ArrayList;
import java.util.Collection;

import game.roleplay.entity.Ability;
import game.roleplay.entity.Character;
import game.roleplay.mapper.AbilityMapper;
import game.roleplay.mapper.CharacterMapper;

public class Mapper {

	
	public static Collection<CharacterMapper> toCharacter(Collection<Character> characters){
		Collection<CharacterMapper> collection = new ArrayList<>();
		for(Character character : characters) {
			CharacterMapper mapper = new CharacterMapper(character);
			collection.add(mapper);
		}
		
		return collection;
	}
	
	public static CharacterMapper toFirstCharacter(Character character) {
		CharacterMapper mapper = new CharacterMapper(character);
		return mapper;
	}
	
	public static Collection<AbilityMapper> toAbility(Collection<Ability> abilities){
		Collection<AbilityMapper> collection = new ArrayList<>();
		for(Ability ability : abilities) {
			AbilityMapper mapper = new AbilityMapper(ability);
			collection.add(mapper);
		}
		
		return collection;
	}
}
