package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Departement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String nom;

	@OneToMany(mappedBy="departement", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Utilisateur> utilisateur = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	private Societe societe;

	public Departement() {
		super();
	}

	public Departement(@NotBlank @Size(max = 20) String nom) {
		super();
		this.nom = nom;
	}

	public Departement(@NotBlank @Size(max = 20) String nom, List<Utilisateur> utilisateur, Societe societe) {
		super();
		this.nom = nom;
		this.utilisateur = utilisateur;
		this.societe = societe;
	}

	public Departement(Long id, @NotBlank @Size(max = 20) String nom, List<Utilisateur> utilisateur, Societe societe) {
		super();
		this.id = id;
		this.nom = nom;
		this.utilisateur = utilisateur;
		this.societe = societe;
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

	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	
	
	


}
