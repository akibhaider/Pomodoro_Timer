module org.example.lab07_210041222 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab07_210041222 to javafx.fxml;
    exports org.example.lab07_210041222;
}