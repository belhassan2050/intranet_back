package tn.esprit.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Boutique;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.request.UpdateBoutiqueRequest;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.services.IBoutiqueService;

@RestController
@RequestMapping("/api/boutique/")
public class BoutiqueController {
	
	@Autowired
	IBoutiqueService boutiqueService ;
	@Autowired
	BoutiqueRepository boutiqueRepository;
	

	///Ajouter boutique : http://localhost:8084//api/boutique/ajouterBoutique
		@PostMapping("/ajouterBoutique")
		public void AjouterDepartement(@RequestBody Boutique boutique){
			boutiqueService.AjouterBoutique(boutique);	
}
		////http://localhost:8084/api/boutique/affecterBoutiqueASociete/1/1
		@PutMapping("affecterBoutiqueASociete/{societe_id}/{boutique_id}")
		public void affecterBoutiqueASociete(@PathVariable("societe_id")Long societeId,@PathVariable("boutique_id")Long boutiqueId) {
			boutiqueService.AffecterBoutiqueASociete(societeId, boutiqueId);
		}
		
		///http://localhost:8084/api/boutique/updataBoutique/1
		@PutMapping("updataBoutique/{boutique_id}")
		public void UpdateBoutique(@PathVariable("boutique_id")Long boutiqueId,@Valid @RequestBody UpdateBoutiqueRequest updateRequest) {
			Boutique boutique = boutiqueRepository.findById(boutiqueId).get();
			boutique.setNom(updateRequest.getNom());
			boutique.setAdresse(updateRequest.getAdresse());
			boutiqueService.UpdateBoutique(boutique);
		}
		
}