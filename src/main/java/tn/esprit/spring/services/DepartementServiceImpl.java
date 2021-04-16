package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class DepartementServiceImpl implements IDepartementService{
	
	@Autowired
	DepartementRepository departementRepository ; 
	@Autowired
	UserRepository utilisateurRepository ; 
	
	public void AjouterDepartement(Departement departement){
		departementRepository.save(departement);
	}
	
	public void AffecterUserADepartement(Long userId,Long depId){
		Utilisateur user = utilisateurRepository.findById(userId).orElse(null);
		Departement dep = departementRepository.findById(depId).orElse(null);
		if(user!=null){
			user.setDepartement(dep);
			utilisateurRepository.save(user);
		}	
	}
	
	public List<Departement>getAllDepartementBySociete(Societe societe){
		return departementRepository.getAllDepartementBySociete(societe);
	}

}
