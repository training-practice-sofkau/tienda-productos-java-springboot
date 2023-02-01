package com.sofkau.qa.tiendaproductos.Modelos;

import java.util.Objects;

public class Note {
    private String id;
    private String author;
    private String message;
    private String apellido;

    public Note(String id, String author, String message, String apellido) {
        this.id = id;
        this.author = author;
        this.message = message;
        this.apellido=apellido;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(author, note.author) && Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, message);
    }
}
