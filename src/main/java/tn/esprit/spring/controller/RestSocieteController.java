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

import com.fasterxml.jackson.annotation.JsonFormat;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.SocieteRepository;
import tn.esprit.spring.services.ISocieteService;

@RestController
@RequestMapping("/api/societe/")
public class RestSocieteController {
	
	@Autowired
	ISocieteService societeService ;
	
	@Autowired
	SocieteRepository societeRepository ;
	
	
	///// Ajouter societe : http://localhost:8084//api/societe/ajouterSociete
	@PostMapping("/ajouterSociete")
	public void AjouterSociete (@RequestBody Societe societe){
		societeService.AjouterSociete(societe);
	}
	
	// affecter dep a societe : http://localhost:8084/api/societe/affDepASociete/1/1
	@PutMapping("/affDepASociete/{dep_id}/{societe_id}")
	public void AffecterDepASociete(@PathVariable("dep_id")Long depId,@PathVariable("societe_id")Long societeId){
		societeService.AffecterDepASociete(depId, societeId);
	}
	
	///getAllDepartementBySociete : http://localhost:8084/api/societe/getAllDep/1
	@GetMapping("getAllDep/{societe_id}")
	public List<Departement>getAllDepartementBySociete(@PathVariable("societe_id")Long societeId){
		return societeService.getAllDepartementBySociete(societeId);	
	}


}
