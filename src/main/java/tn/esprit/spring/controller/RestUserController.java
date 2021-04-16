package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.SocieteRepository;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/api/user")
public class RestUserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	SocieteRepository societeRepository;
	
	@Autowired
	DepartementRepository departementRepository;

	
	/// http://localhost:8084/api/user/getAllUserBySociete/1/1
	@GetMapping("/getAllUserBySociete/{dep_id}/{societe_id}")
	@ResponseBody
	public List<Utilisateur>getAllUserBySociete(@PathVariable("dep_id")Long depId,@PathVariable("societe_id")Long societeId){
		Departement departement = departementRepository.findById(depId).orElse(null);
		Societe societe = societeRepository.findById(societeId).orElse(null);
		System.out.println(userService.getAllUserBySociete(departement, societe));
		return userService.getAllUserBySociete(departement, societe);
		
	}
		
}
