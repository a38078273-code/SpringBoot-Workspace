package tn.enis.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant extends Membre {

	private Date dateInscription;
	private String sujet;
	private String diplome;
	@ManyToOne
	@JoinColumn(name = "encadrant_id")
	private EnseignantChercheur encadrant;

	@Builder

	public Etudiant(Long id, String cin, String nom, String prenom, LocalDate dateNaissance, byte[] photo, String email,
			Date dateInscription, String sujet, String diplome, EnseignantChercheur encadrant) {

		super(id, cin, nom, prenom, dateNaissance, photo, email);
		this.dateInscription = dateInscription;
		this.sujet = sujet;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}

}
