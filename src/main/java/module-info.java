module com.example.practice_for_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practice_for_final to javafx.fxml;
    exports com.example.practice_for_final;
}