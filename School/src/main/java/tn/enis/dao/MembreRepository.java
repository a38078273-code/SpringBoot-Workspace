package tn.enis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.entities.Membre;

import java.util.List;

public interface MembreRepository extends JpaRepository<Membre,Long>
{

    Membre findByCin(String cin);
    List<Membre> findByNomStartingWith(String caractere);
    Membre findByEmail(String email);

}