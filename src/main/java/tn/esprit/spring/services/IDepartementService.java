package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;

public interface IDepartementService {
	
	public void AjouterDepartement(Departement departement);
	public void AffecterUserADepartement(Long userId,Long depId);
	public List<Departement>getAllDepartementBySociete(Societe societe);

}
