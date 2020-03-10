package me.ron.effectivejava3rd.chap02.item05.singletonwrongcase;

import java.util.List;

public class SpellChecker {
    private final Lexicon dictionary = new KoreanDictionary();

    private SpellChecker() {

    }

    public static SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) { return false; }
    public List<String> suggestions(String typo) { return null; }
}

interface Lexicon {}
class KoreanDictionary implements Lexicon {}
