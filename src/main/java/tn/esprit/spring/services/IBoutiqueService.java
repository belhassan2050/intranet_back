package tn.esprit.spring.services;

import tn.esprit.spring.entity.Boutique;


public interface IBoutiqueService {
	
	public void AjouterBoutique(Boutique boutique);
	public void AffecterBoutiqueASociete(Long societeId,Long boutiqueId);
	public void UpdateBoutique(Boutique boutique);
	

}
