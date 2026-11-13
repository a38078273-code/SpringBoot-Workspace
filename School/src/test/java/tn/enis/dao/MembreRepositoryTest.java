package tn.enis.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import tn.enis.entities.EnseignantChercheur;
import tn.enis.entities.Etudiant;

@DataJpaTest
class MembreRepositoryTest {

	@Autowired
	private MembreRepository membreRepository;

	@Test
	void save_et_findByCin() {
		EnseignantChercheur encadrant = new EnseignantChercheur(null, "AA11111", "Ben", "Ali", LocalDate.of(1980, 3, 15), null,
				"ben.ali@enis.tn", "MC", "ENIS");
		membreRepository.save(encadrant);

		var trouve = membreRepository.findByCin("AA11111");
		assertThat(trouve).isNotNull();
		assertThat(trouve.getNom()).isEqualTo("Ben");
		assertThat(trouve.getPrenom()).isEqualTo("Ali");
		assertThat(trouve.getEmail()).isEqualTo("ben.ali@enis.tn");
		assertThat(membreRepository.findByEmail("ben.ali@enis.tn")).isEqualTo(trouve);
	}

	@Test
	void findByNomStartingWith_filtre_par_prefixe() {
		membreRepository.save(
				new EnseignantChercheur(null, "BB22222", "Dupont", "Paul", LocalDate.of(1975, 1, 1), null,
						"paul.dupont@enis.tn", "PR", "ENIS"));
		membreRepository
				.save(new Etudiant(null, "CC33333", "Dupuis", "Marie", LocalDate.of(2000, 5, 20), null,
						"marie.dupuis@enis.tn", null, "IA", "Ing", null));

		List<?> dup = membreRepository.findByNomStartingWith("Dup");
		assertThat(dup).hasSize(2);
	}
}
