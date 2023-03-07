module ca.unb.cs3035.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    exports ca.unb.cs3035.project.Controllers;
    exports ca.unb.cs3035.project.Controllers.Admin;
    exports ca.unb.cs3035.project.Controllers.Client;
    exports ca.unb.cs3035.project.Models;
    exports ca.unb.cs3035.project.Views;
    exports ca.unb.cs3035.project;
    opens ca.unb.cs3035.project to javafx.fxml;
}