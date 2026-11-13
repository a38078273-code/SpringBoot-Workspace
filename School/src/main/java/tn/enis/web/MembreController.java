package tn.enis.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.enis.entities.Membre;
import tn.enis.service.MembreService;

@RestController
@RequestMapping("/membres")
@RequiredArgsConstructor
public class MembreController {

	private final MembreService membreService;

	@GetMapping
	public List<Membre> findAll() {
		return membreService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Membre> findById(@PathVariable Long id) {
		return membreService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/cin")
	public ResponseEntity<Membre> findByCin(@RequestParam String cin) {
		Membre membre = membreService.findByCin(cin);
		return membre != null ? ResponseEntity.ok(membre) : ResponseEntity.notFound().build();
	}

	@GetMapping("/email")
	public ResponseEntity<Membre> findByEmail(@RequestParam String email) {
		Membre membre = membreService.findByEmail(email);
		return membre != null ? ResponseEntity.ok(membre) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Membre> create(@RequestBody Membre membre) {
		return ResponseEntity.status(HttpStatus.CREATED).body(membreService.save(membre));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		membreService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
