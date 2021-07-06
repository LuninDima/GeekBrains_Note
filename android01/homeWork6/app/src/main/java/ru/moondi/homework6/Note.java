package ru.moondi.homework6;

public class Note {
    private String noteName;
    private String noteDescription;
    private String noteText;
    private String noteDate;
    private int noteId;

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public Note(String noteName, String noteDescription, String noteText, String noteDate, int noteId) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.noteText = noteText;
        this.noteDate = noteDate;
        this.noteId = noteId;
    }
}
