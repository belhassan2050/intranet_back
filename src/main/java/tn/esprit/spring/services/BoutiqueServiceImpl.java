package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Boutique;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.repository.SocieteRepository;

@Service
public class BoutiqueServiceImpl implements IBoutiqueService{
	
	
	@Autowired
	BoutiqueRepository boutiqueRepository ; 
	@Autowired
	SocieteRepository societeRepository;
	
	public void AjouterBoutique(Boutique boutique){
		boutiqueRepository.save(boutique);
	}
	
public void AffecterBoutiqueASociete(Long societeId,Long boutiqueId){
		
		Societe societe = societeRepository.findById(societeId).orElse(null);
		Boutique boutique = boutiqueRepository.findById(boutiqueId).orElse(null);
		if(boutique!=null){
			boutique.setSociete(societe);
			boutiqueRepository.save(boutique);
		}
}

	public void UpdateBoutique(Boutique boutique) {
		boutiqueRepository.save(boutique);
	}
}
