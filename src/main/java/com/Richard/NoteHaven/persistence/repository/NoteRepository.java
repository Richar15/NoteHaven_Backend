package com.Richard.NoteHaven.persistence.repository;

import com.Richard.NoteHaven.persistence.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
