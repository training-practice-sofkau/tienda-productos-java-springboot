package com.rest.example.restexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rest")
public class NoteController {

    List<Note> notes = new ArrayList<>();


    @GetMapping("/bring/all")
    public ResponseEntity getAllNotes(){
        return new ResponseEntity(notes, HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity createNewNote(@RequestBody Note note){
        Note newNote = new Note(UUID.randomUUID().toString(),
                note.getAuthor(),
                note.getMessage());
        this.notes.add(newNote);
        return new ResponseEntity(newNote, HttpStatus.CREATED);
    }

    @PutMapping("/{noteId}")
    public ResponseEntity updateNote(@PathVariable("noteId") String id,
                                     @RequestBody Note note){
        List<Note> newList = notes.stream()
                .map(n -> n.getId().equals(id)?note:n).collect(Collectors.toList());

        this.notes = newList;
        return new ResponseEntity(note, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity deleteNote(@PathVariable("noteId") String id){
        List<Note> newNotes = notes.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.notes = newNotes;
        return new ResponseEntity(notes, HttpStatus.GONE);
    }
}
