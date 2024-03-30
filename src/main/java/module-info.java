module com.example.slab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.slab1 to javafx.fxml;
    exports com.example.slab1;
}