package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;
import tn.esprit.spring.entity.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value ="SELECT * FROM utilisateur u INNER JOIN departement dep ON dep.id = u.departement_id INNER JOIN societe s ON s.id = dep.societe_id", nativeQuery=true)
    public List<Utilisateur> getAllUserBySociete(@Param("departement") Departement departement,@Param("societe") Societe societe);

}
