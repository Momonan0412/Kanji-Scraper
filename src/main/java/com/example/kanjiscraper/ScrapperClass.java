package com.example.kanjiscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapperClass {
    String url;

    Document document;
    String cssQueryForKanji = ".character-grid";
    ScrapperClass(){
        url = "https://www.wanikani.com/kanji?difficulty=pleasant";

        try {
            document = Jsoup.connect(url).get();
            Elements kanjiData = document.select(cssQueryForKanji);
            for (Element k : kanjiData) {
                String level = k.select(".character-grid__header-text").text();
                System.out.println(level);
                Elements dataElements = k.select(".subject-character__content");
                for (Element data : dataElements) {
                    String kanji = data.select(".subject-character__characters").text();
                    String furigana = data.select(".subject-character__reading").text();
                    String englishMeaningURL = "https://www.wanikani.com/kanji/" + kanji;
                    Document englishDocument = Jsoup.connect(englishMeaningURL).get();
                    String getCssQueryForEnglishMeaning = ".subject-section__meanings-items";
                    Elements englishMeaningData = englishDocument.select(getCssQueryForEnglishMeaning);
                    StringBuilder englishMeanings = new StringBuilder();
                    int size = englishMeaningData.size();
                    for(int i = 0; i < size; i++){
                        String english = englishMeaningData.get(i).text();
                        englishMeanings.append(english);
                        if(i < size - 1){
                            englishMeanings.append(", ");
                        }
                    }
                    System.out.println("Kanji: " + kanji);
                    System.out.println("Furigana: " + furigana);
                    System.out.println("English: " + englishMeanings);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ScrapperClass();
    }
}
