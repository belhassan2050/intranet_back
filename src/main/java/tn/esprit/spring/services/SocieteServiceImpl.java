package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.SocieteRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class SocieteServiceImpl implements ISocieteService {
	
	@Autowired
	SocieteRepository societeRepository;
	
	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void AjouterSociete(Societe societe) {
		societeRepository.save(societe);		
	}	
	
	
	public void AffecterDepASociete(Long depId,Long societeId){
		
		Societe societe = societeRepository.findById(societeId).orElse(null);
		Departement departement = departementRepository.findById(depId).orElse(null);
		if(departement!=null){
			departement.setSociete(societe);
			departementRepository.save(departement);
		}
		
	}
	
	public List<Departement> getAllDepartementBySociete(Long societeId){
		return societeRepository.findById(societeId).get().getDepartements();
		
	}

	
	
}
