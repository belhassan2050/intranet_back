package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Boutique {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String nom;
	
	@NotBlank
	@Size(max = 20)
	private String adresse;
	
	@ManyToOne
	@JsonIgnore
	private Societe societe;

	public Boutique() {
		super();
	}

	public Boutique(Long id, @NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String adresse,
			Societe societe) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.societe = societe;
	}

	public Boutique(@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String adresse, Societe societe) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.societe = societe;
	}

	public Boutique(@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	
	
	
	
}