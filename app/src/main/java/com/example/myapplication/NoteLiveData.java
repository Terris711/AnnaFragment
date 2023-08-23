package com.example.myapplication;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoteLiveData extends ViewModel {
    private MutableLiveData<Integer> isMenuFragment;
    private MutableLiveData<Note> note;
    public NoteLiveData() {
        isMenuFragment = new MediatorLiveData<Integer>();
        isMenuFragment.setValue(0);
        note = new MediatorLiveData<>();
    }

    public MutableLiveData<Integer> getIsMenuFragment() {
        return isMenuFragment;
    }

    public void setIsMenuFragment(int idx) {
        this.isMenuFragment.setValue(idx);
    }

    public MutableLiveData<Note> getNote() {
        return note;
    }

    public void setNote(String noteStr, String title) {
        note.setValue(new Note(noteStr, title));
    }
}

class Note {
    String note;
    String title;

    public Note(String note, String title) {
        this.note = note;
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
