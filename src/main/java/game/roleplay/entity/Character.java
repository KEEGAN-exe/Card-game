package game.roleplay.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "characters")
public class Character implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCharacter;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private Integer livePoint;
	@Column(nullable = false)
	@JsonIgnore
	private Boolean state;

	@ManyToOne
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "character_element", joinColumns = @JoinColumn(name = "character_id"), inverseJoinColumns = @JoinColumn(name = "element_id"))
	private List<Element> elements = new ArrayList<Element>();

	public Character() {
	}

	public Character(Integer idCharacter, String name, String lastname, Integer livePoint, Boolean state,
			Category category, List<Element> elements) {
		this.idCharacter = idCharacter;
		this.name = name;
		this.lastname = lastname;
		this.livePoint = livePoint;
		this.state = state;
		this.category = category;
		this.elements = elements;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}


	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
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

	public Integer getLivePoint() {
		return livePoint;
	}

	public void setLivePoint(Integer livePoint) {
		this.livePoint = livePoint;
	}

}