package com.Richard.NoteHaven.service.interfaces;


import com.Richard.NoteHaven.persistence.entity.NoteEntity;


import java.util.List;

public interface INoteService {

    NoteEntity createNote(NoteEntity noteEntity);

    NoteEntity updateNote(NoteEntity noteEntity, Long id);

    NoteEntity searchNote(Long id);

    List<NoteEntity> getAllNote();

    void deleteNote(Long id);

}
