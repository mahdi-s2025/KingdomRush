module com.kingdomrush {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;
    requires static lombok;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;
    requires com.google.common;

    opens com.kingdom_rush to javafx.fxml;
    exports com.kingdom_rush;
    opens com.kingdom_rush.controller to javafx.fxml;
    exports com.kingdom_rush.controller;
    exports com.kingdom_rush.model;
    exports com.kingdom_rush.model.spells;

}