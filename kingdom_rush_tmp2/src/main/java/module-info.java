module com.kingdom_rush {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;
    requires static lombok;

    opens com.kingdom_rush to javafx.fxml;
    exports com.kingdom_rush;
    exports com.kingdom_rush.controller;
    opens com.kingdom_rush.controller to javafx.fxml;
}