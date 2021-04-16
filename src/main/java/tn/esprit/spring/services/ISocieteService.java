package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;

public interface ISocieteService {
	
	public void AjouterSociete(Societe societe);
	public void AffecterDepASociete(Long depId,Long societeId);
	public List<Departement> getAllDepartementBySociete(Long societeId);


}
