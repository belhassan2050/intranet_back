package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Societe;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long>{
	
	@Query(value="Select dep.id,dep.nom,dep.societe_id from departement dep left join societe s on dep.societe_id = s.id",nativeQuery=true)
	public List<Departement> getAllDepartementBySociete(@Param("societe") Societe societe);
	
}
