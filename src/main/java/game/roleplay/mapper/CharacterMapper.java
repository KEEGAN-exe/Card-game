package game.roleplay.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.roleplay.entity.Ability;
import game.roleplay.entity.Character;
import game.roleplay.entity.Element;

public class CharacterMapper {

	private Integer id_character;
	private String name;
	private String lastname;
	private String name_category;
	private Integer live_poins;
	private List<String> elements;
	private List<Map<String, Object>> abilities;

	public CharacterMapper() {
	}

	public CharacterMapper(Integer id_character, String name, String lastname, String name_category, Integer live_poins,
			List<String> elements, List<Map<String, Object>> abilities) {
		this.id_character = id_character;
		this.name = name;
		this.lastname = lastname;
		this.name_category = name_category;
		this.live_poins = live_poins;
		this.elements = elements;
		this.abilities = abilities;
	}

	public CharacterMapper(Character character) {
		this.id_character = character.getIdCharacter();
		this.name = character.getName();
		this.lastname = character.getLastname();
		this.name_category = character.getCategory().getNameCategory();
		this.elements = getNameElement(character.getElements());
		this.abilities = getAbilityDetails(character.getElements());
		this.live_poins = character.getLivePoint();
	}

	private List<Map<String, Object>> getAbilityDetails(List<Element> elements) {
		List<Map<String, Object>> abilityList = new ArrayList<>();
		for (Element element : elements) {
			for (Ability ability : element.getAbilities()) {
				Map<String, Object> abilityDetails = new HashMap<>();
				abilityDetails.put("name_ability", ability.getNameAbility());
				abilityDetails.put("description", ability.getDescription());
				abilityDetails.put("damage", ability.getDamage());
				abilityList.add(abilityDetails);
			}
		}
		return abilityList;
	}

	private List<String> getNameElement(List<Element> elements) {
		List<String> elementNames = new ArrayList<>();
		for (Element element : elements) {
			elementNames.add(element.getNameElement());
		}
		return elementNames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getId_character() {
		return id_character;
	}

	public void setId_character(Integer id_character) {
		this.id_character = id_character;
	}

	public String getName_category() {
		return name_category;
	}

	public void setName_category(String name_category) {
		this.name_category = name_category;
	}

	public Integer getLive_poins() {
		return live_poins;
	}

	public void setLive_poins(Integer live_poins) {
		this.live_poins = live_poins;
	}

	public List<String> getElements() {
		return elements;
	}

	public void setElements(List<String> elements) {
		this.elements = elements;
	}

	public List<Map<String, Object>> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Map<String, Object>> abilities) {
		this.abilities = abilities;
	}

}
