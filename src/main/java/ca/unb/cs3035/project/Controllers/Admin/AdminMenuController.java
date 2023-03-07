package ca.unb.cs3035.project.Controllers.Admin;

import ca.unb.cs3035.project.Models.Model;
import ca.unb.cs3035.project.Views.AdminMenuOptions;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public MenuItem create_client;
    public MenuItem clients;
    public MenuItem deposit;
    public MenuItem switch_user;
    public MenuItem help;
    public MenuItem about;
    public Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        create_client.setOnAction(event -> onCreateClient());
        clients.setOnAction(event -> onClients());
        deposit.setOnAction(event -> onDeposit());
        switch_user.setOnAction(event -> onSwitchUser());
        help.setOnAction(event -> onHelp());
        about.setOnAction(event -> onAbout());
    }

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }

    private void onHelp() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.HELP);
    }

    private void onAbout() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.ABOUT);
    }

    private void onSwitchUser() {
        // Get Current Stage
        Stage stage = (Stage) label.getScene().getWindow();
        // Close Stage
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Admin Login Success Flag To False
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }

    public void quitButtonClicked() {
        System.out.println("Quiting Application...");
        Platform.exit();
    }
}
