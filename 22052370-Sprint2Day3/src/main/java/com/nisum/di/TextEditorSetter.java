package com.nisum.di;

//for setter injection
public class TextEditorSetter {
    private SpellChecker spellChecker;

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Setter Injection in TextEditorSetter");
        this.spellChecker = spellChecker;
    }

    public String spellCheck() {
        return spellChecker.checkSpelling();
    }

}