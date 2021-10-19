package de.tekup.db.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.Creator;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.CreatorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreatorService {
	
	private CreatorRepository creatorRepos;
	
	public Creator addCreator(Creator creator) {
		return creatorRepos.save(creator);
	}
	
	public Creator getCreatorById(int id) {
		return creatorRepos.findById(id)
				.orElseThrow(()-> new NoSuchElementException("Creator with this id not found"));
	}
	
	public Creator addMatriculeToCreator(int creatorId, Matricule matricule) {
		// TODO : complete this 
		return null;
	}

}
