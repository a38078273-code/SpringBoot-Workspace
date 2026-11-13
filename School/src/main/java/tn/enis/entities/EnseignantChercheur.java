package tn.enis.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EnseignantChercheur extends Membre {

	private String grade;
	private String etablissement;

	public EnseignantChercheur(Long id, String cin, String nom, String prenom, LocalDate dateNaissance, byte[] photo,
			String email, String grade, String etablissement) {
		super(id, cin, nom, prenom, dateNaissance, photo, email);
		this.etablissement = etablissement;
		this.grade = grade;
	}

}
