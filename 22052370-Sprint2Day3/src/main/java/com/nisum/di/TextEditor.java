package com.nisum.di;

//for constructor injection
public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        System.out.println("Constructor Injection in TextEditor");
        this.spellChecker = spellChecker;
    }

    public String spellCheck() {
        return spellChecker.checkSpelling();
    }

}