package game.roleplay.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "categories")
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;
	@Column(nullable = false)
	private String nameCategory;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	@JsonBackReference
	private Boolean state;

	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Collection<Character> itemsCharacter = new ArrayList<Character>();

	public Category() {
	}

	public Category(Integer idCategory, String nameCategory, String description, Boolean state,
			Collection<Character> itemsCharacter) {
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.description = description;
		this.state = state;
		this.itemsCharacter = itemsCharacter;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Collection<Character> getItemsCharacter() {
		return itemsCharacter;
	}

	public void setItemsCharacter(Collection<Character> itemsCharacter) {
		this.itemsCharacter = itemsCharacter;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}