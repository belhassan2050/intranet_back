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
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepartementRepository depRepository;
	
	@Autowired
	SocieteRepository societeRepository;
	
	public List<Utilisateur> getAllUserBySociete(Departement departement,Societe societe){
		
		return userRepository.getAllUserBySociete(departement,societe);
		
	}
	

	
	

}
