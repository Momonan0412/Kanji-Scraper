package com.example.kanjiscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScrapperClass {
    String url;
    Document document;
    String cssQueryForKanji = ".character-grid";
    ScrapperClass(){
        url = "https://www.wanikani.com/kanji?difficulty=pleasant";
        try {
            document = Jsoup.connect(url).get();
            Elements kanjiData = document.select(cssQueryForKanji);
            for(Element k : kanjiData){
                String level = k.select(".character-grid__header-text").text();
                System.out.println(level);
                Elements dataElements = k.select(".subject-character__content");
                for(Element data : dataElements){
                    String kanji = data.select(".subject-character__characters").text();
                    String furigana = data.select(".subject-character__reading").text();
                    String english = data.select(".subject-character__meaning").text();
                    System.out.println("Kanji: " + kanji);
                    System.out.println("Furigana: " + furigana);
                    System.out.println("English: " + english);
                    if(DatabaseUtilities.insertJapaneseLearningData(level, kanji, furigana, english)){
                        System.out.println("Success!");
                    }
                    System.out.println("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new ScrapperClass();
    }
}
