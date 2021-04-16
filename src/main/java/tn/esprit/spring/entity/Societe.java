package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Societe {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String nom;
	
	@OneToMany(mappedBy="societe", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<Departement> departements = new ArrayList<>();
	
	@OneToMany(mappedBy="societe", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY)
	private List<Boutique> boutique = new ArrayList<>();

	public Societe() {
		super();
	}

	public Societe(@NotBlank @Size(max = 20) String nom) {
		super();
		this.nom = nom;
	}

	public Societe(@NotBlank @Size(max = 20) String nom, List<Departement> departements,
			List<Utilisateur> utilisateurs) {
		super();
		this.nom = nom;
		this.departements = departements;
	}

	public Societe(Long id, @NotBlank @Size(max = 20) String nom, List<Departement> departements,
			List<Utilisateur> utilisateurs) {
		super();
		this.id = id;
		this.nom = nom;
		this.departements = departements;
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

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public List<Boutique> getBoutique() {
		return boutique;
	}

	public void setBoutique(List<Boutique> boutique) {
		this.boutique = boutique;
	}

	
	
	
	
}
