package de.tekup.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.Creator;

public interface CreatorRepository extends JpaRepository<Creator, Integer>{

}
