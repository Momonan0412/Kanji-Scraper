module com.example.kanjiscraper {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive org.jsoup;
    requires java.sql;
    requires jbcrypt;


    opens com.example.kanjiscraper to javafx.fxml;
    exports com.example.kanjiscraper;
}