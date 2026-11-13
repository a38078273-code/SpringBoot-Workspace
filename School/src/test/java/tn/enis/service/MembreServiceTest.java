package tn.enis.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.enis.dao.MembreRepository;
import tn.enis.entities.EnseignantChercheur;
import tn.enis.entities.Membre;

@ExtendWith(MockitoExtension.class)
class MembreServiceTest {

	@Mock
	private MembreRepository membreRepository;

	@InjectMocks
	private MembreService membreService;

	@Test
	void findByCin_delegue_au_repository() {
		Membre attendu = new EnseignantChercheur(1L, "XX99999", "Test", "User", LocalDate.now(), null, "test@enis.tn",
				"PR", "ENIS");
		when(membreRepository.findByCin("XX99999")).thenReturn(attendu);

		Membre resultat = membreService.findByCin("XX99999");

		assertThat(resultat).isEqualTo(attendu);
		verify(membreRepository).findByCin("XX99999");
	}

	@Test
	void save_delegue_au_repository() {
		Membre aSauver = new EnseignantChercheur(null, "YY88888", "Nom", "Pren", LocalDate.now(), null, "nom@x.tn", "MC",
				"X");
		when(membreRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

		Membre resultat = membreService.save(aSauver);

		assertThat(resultat).isSameAs(aSauver);
		verify(membreRepository).save(aSauver);
	}

	@Test
	void findById_delegue_au_repository() {
		Membre m = new EnseignantChercheur(42L, "ZZ77777", "A", "B", LocalDate.now(), null, "a@enis.tn", "PR", "ENIS");
		when(membreRepository.findById(42L)).thenReturn(Optional.of(m));

		assertThat(membreService.findById(42L)).contains(m);
	}

	@Test
	void findByNomStartingWith_delegue_au_repository() {
		when(membreRepository.findByNomStartingWith("D")).thenReturn(List.of());

		assertThat(membreService.findByNomStartingWith("D")).isEmpty();
		verify(membreRepository).findByNomStartingWith("D");
	}

	@Test
	void findByEmail_delegue_au_repository() {
		Membre attendu = new EnseignantChercheur(3L, "WW66666", "E", "M", LocalDate.now(), null, "e@m.tn", "PR", "ENIS");
		when(membreRepository.findByEmail("e@m.tn")).thenReturn(attendu);

		assertThat(membreService.findByEmail("e@m.tn")).isEqualTo(attendu);
		verify(membreRepository).findByEmail("e@m.tn");
	}
}
