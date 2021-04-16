package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;

public interface IUserService {
	
	public List<Utilisateur> getAllUserBySociete(Departement departement,Societe societe);

}
