package game.roleplay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "elements")
public class Element implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idElement;
	@Column(nullable = false)
	private String nameElement;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	@JsonIgnore
	private Boolean state;

	public Element() {
	}

	public Element(Integer idElement, String nameElement, String description, Boolean state) {
		this.idElement = idElement;
		this.nameElement = nameElement;
		this.description = description;
		this.state = state;
	}

	public Integer getIdElement() {
		return idElement;
	}

	public void setIdElement(Integer idElement) {
		this.idElement = idElement;
	}

	public String getNameElement() {
		return nameElement;
	}

	public void setNameElement(String nameElement) {
		this.nameElement = nameElement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
