package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.repository.SocieteRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.ISocieteService;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/api/departement/")
public class RestDepartementController {
	
	@Autowired
	IDepartementService departementService ;
	@Autowired
	IUserService userService;
	@Autowired
	SocieteRepository societeRepository;
	@Autowired
	ISocieteService societeService;
	
	///Ajouter departement : http://localhost:8084//api/departement/ajouterDepartement
	@PostMapping("/ajouterDepartement")
	public void AjouterDepartement(@RequestBody Departement departement){
		departementService.AjouterDepartement(departement);
	}
	
	//Affecter user a departement : http://localhost:8084/api/departement/affecterUserADep/1/1
	@PutMapping("/affecterUserADep/{user_id}/{dep_id}")
	public void affecterUserADepartement(@PathVariable("user_id") Long userId,@PathVariable("dep_id")Long depId){
		departementService.AffecterUserADepartement(userId, depId);
	}
	
	//http://localhost:8084/api/departement/getAllDepartementBySociete/1
	@GetMapping(value = "getAllDepartementBySociete/{societe_id}")
	@ResponseBody
	public List<Departement> getAllDepartementBySociete(@PathVariable("societe_id") Long societeId) {
	    	Societe societe=societeRepository.findById(societeId).orElse(null);
			System.out.println(departementService.getAllDepartementBySociete(societe)); 
			return departementService.getAllDepartementBySociete(societe);
	}
}
