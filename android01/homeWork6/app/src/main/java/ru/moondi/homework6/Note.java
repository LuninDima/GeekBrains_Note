package ru.moondi.homework6;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String noteName;
    private String noteDescription;
    private String noteText;
    private String noteDate;
    private int noteId;

    protected Note(Parcel in) {
        noteName = in.readString();
        noteDescription = in.readString();
        noteText = in.readString();
        noteDate = in.readString();
        noteId = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(noteDescription);
        dest.writeString(noteText);
        dest.writeString(noteDate);
        dest.writeInt(noteId);
    }
}
