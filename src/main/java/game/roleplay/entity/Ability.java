package game.roleplay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "abilities")
@Entity
public class Ability implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ability;
	@Column(nullable = false)
	private String nameAbility;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Double damage;
	@Column(nullable = false)
	@JsonIgnore
	private Boolean state;

	@ManyToOne
	@JoinColumn(name = "id_element")
	private Element element;

	public Ability() {
	}

	public Ability(Integer id_ability, String nameAbility, String description, Double damage, Boolean state) {
		this.id_ability = id_ability;
		this.nameAbility = nameAbility;
		this.description = description;
		this.damage = damage;
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Integer getId_ability() {
		return id_ability;
	}

	public void setId_ability(Integer id_ability) {
		this.id_ability = id_ability;
	}

	public String getNameAbility() {
		return nameAbility;
	}

	public void setNameAbility(String nameAbility) {
		this.nameAbility = nameAbility;
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
}
