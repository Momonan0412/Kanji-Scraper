package com.example.kanjiscraper;

import java.io.Serializable;

public class JapaneseKanjiData implements Serializable {
    String kanji;
    String english;
    String furigana;
    public JapaneseKanjiData(String kanji, String english, String furigana) {
        this.kanji = kanji;
        this.english = english;
        this.furigana = furigana;
    }
    @Override
    public String toString(){
        return "Kanji: " + kanji + "\nEnglish: " + english + "\nFurigana: " + furigana;
    }
}
