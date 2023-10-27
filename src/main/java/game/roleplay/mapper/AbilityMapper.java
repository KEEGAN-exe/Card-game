package game.roleplay.mapper;

import game.roleplay.entity.Ability;

public class AbilityMapper {

	private Integer id_ability;
	private String name_ability;
	private String description;
	private Double damage;
	private String element;

	public AbilityMapper() {
	}

	public AbilityMapper(Integer id_ability, String name_ability, String description, Double damage, String element) {
		this.id_ability = id_ability;
		this.name_ability = name_ability;
		this.description = description;
		this.damage = damage;
		this.element = element;
	}

	public AbilityMapper(Ability ability) {
		this.id_ability = ability.getId_ability();
		this.name_ability = ability.getNameAbility();
		this.description = ability.getDescription();
		this.damage = ability.getDamage();
		this.element = getNameElement(ability);
	}

	public String getNameElement(Ability ability) {
		String name = ability.getElement().getNameElement();
		return name;
	}

	public Integer getId_ability() {
		return id_ability;
	}

	public void setId_ability(Integer id_ability) {
		this.id_ability = id_ability;
	}

	public String getName_ability() {
		return name_ability;
	}

	public void setName_ability(String name_ability) {
		this.name_ability = name_ability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDamage() {
		return damage;
	}

	public void setDamage(Double damage) {
		this.damage = damage;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

}
