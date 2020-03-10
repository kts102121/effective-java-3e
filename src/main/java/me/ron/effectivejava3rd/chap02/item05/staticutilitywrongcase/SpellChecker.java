package me.ron.effectivejava3rd.chap02.item05.staticutilitywrongcase;

import java.util.List;

public class SpellChecker {
    private static final Lexicon DICTIONARY = new KoreanDictionary();

    private SpellChecker() {
        throw new AssertionError("Cannot instantiate this object.");
    }

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}

interface Lexicon {}
class KoreanDictionary implements Lexicon {}