package tn.enis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tn.enis.dao.MembreRepository;
import tn.enis.entities.Membre;

@Service
@RequiredArgsConstructor
public class MembreService {

	private final MembreRepository membreRepository;

	@Transactional(readOnly = true)
	public Optional<Membre> findById(Long id) {
		return membreRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Membre> findAll() {
		return membreRepository.findAll();
	}

	@Transactional
	public Membre save(Membre membre) {
		return membreRepository.save(membre);
	}

	@Transactional
	public void deleteById(Long id) {
		membreRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Membre findByCin(String cin) {
		return membreRepository.findByCin(cin);
	}

	@Transactional(readOnly = true)
	public List<Membre> findByNomStartingWith(String prefixe) {
		return membreRepository.findByNomStartingWith(prefixe);
	}

	@Transactional(readOnly = true)
	public Membre findByEmail(String email) {
		return membreRepository.findByEmail(email);
	}
}
