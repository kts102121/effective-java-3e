package me.ron.effectivejava3rd.chap02.item05.injectfactory;

import javax.net.ssl.SSLPeerUnverifiedException;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Supplier<? extends Lexicon> dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary.get());
    }

    public boolean isValid() { return false; }
    public List<String> suggestions(String typo) { return null; }
}

interface Lexicon {}
class KoreanDictionary implements Lexicon {}
class EnglishDictionary implements Lexicon {}

class Main {
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(KoreanDictionary::new);
        if(spellChecker.isValid() == false) {
            System.out.println("false!");
        }
    }
}