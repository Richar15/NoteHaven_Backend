package com.Richard.NoteHaven.service.implementation;

import com.Richard.NoteHaven.persistence.entity.NoteEntity;
import com.Richard.NoteHaven.persistence.repository.NoteRepository;
import com.Richard.NoteHaven.service.exception.NoteNotFoundException;
import com.Richard.NoteHaven.service.interfaces.INoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements INoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteEntity createNote(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
        return noteEntity;
    }

    @Override
    public NoteEntity updateNote(NoteEntity noteEntity, Long id) {
        NoteEntity existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Error updating the note, Note not found"));
        existingNote.setName(noteEntity.getName());
        existingNote.setContent(noteEntity.getContent());

        return noteRepository.save(existingNote);
    }

    @Override
    public NoteEntity searchNote(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));
    }

    @Override
    public List<NoteEntity> getAllNote() {
        List<NoteEntity> notes = noteRepository.findAll();
        notes.stream().findAny().orElseThrow(() -> new NoteNotFoundException("notes not found"));
        return notes;
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Error deleting the note, Note not found"));
        noteRepository.deleteById(id);
    }

}
