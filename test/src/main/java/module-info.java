module com.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.test to javafx.fxml;
    exports com.test;
}