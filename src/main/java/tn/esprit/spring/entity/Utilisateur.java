 package tn.esprit.spring.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Utilisateur {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String username;
	
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String nom;
	
	@NotBlank
	@Size(max = 20)
	private String prenom;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	private boolean actif=true;
	
	@ManyToOne
	private Departement departement;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Utilisateur() {
		super();
	}

	
	public Utilisateur(@NotBlank @Size(max = 20) String username, @Email String email,
			@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 120) String password, boolean actif, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.actif = actif;
		this.roles = roles;
	}
	

	public Utilisateur(Long id, @NotBlank @Size(max = 20) String username, @Email String email,
			@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 120) String password, boolean actif, List<Departement> departements, Societe societes,
			Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.actif = actif;
		this.departement = departement;
		this.roles = roles;
	}
	

	public Utilisateur(@NotBlank @Size(max = 20) String username, @Email String email,
			@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}


	public Utilisateur(@NotBlank @Size(max = 20) String username, @Email String email,
			@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,
			@NotBlank @Size(max = 120) String password, boolean actif) {
		super();
		this.username = username;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.actif = actif;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	
	
	
	

}
