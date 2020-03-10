package me.ron.effectivejava3rd.chap02.item05.dependencyinjection;

import java.util.List;
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid() { return false; }
    public List<String> suggestions(String typo) { return null; }
}

class Main {
    public static void main(String[] args) {
        Lexicon lexicon = new TestDictionary();
        SpellChecker spellChecker = new SpellChecker(lexicon);
        spellChecker.isValid();

        Lexicon lexicon1 = new KoreanDictionary();
        SpellChecker spellChecker1 = new SpellChecker(lexicon1);
        spellChecker1.isValid();
    }
}

interface Lexicon { }
class KoreanDictionary implements Lexicon {}
class TestDictionary implements Lexicon{}