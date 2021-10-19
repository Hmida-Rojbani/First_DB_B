package de.tekup.db.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.Creator;
import de.tekup.db.entities.Matricule;
import de.tekup.db.services.CreatorService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CretaorCtrl {
	
	private CreatorService creatorService;
	
	@PostMapping("/creator")
	public Creator addCreator(@RequestBody Creator creator) {
		return creatorService.addCreator(creator);
	}
	
	@GetMapping("/creator/{id}")
	public Creator getCreator(@PathVariable int id) {
		return creatorService.getCreatorById(id);
	}
	
	@PostMapping("/creator/{id}/add/matricule")
	public Creator addCreator(@PathVariable int id,
					@RequestBody Matricule matricule) {
		return creatorService.addMatriculeToCreator(id, matricule);
	}

}
