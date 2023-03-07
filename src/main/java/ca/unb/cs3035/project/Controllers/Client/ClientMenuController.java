package ca.unb.cs3035.project.Controllers.Client;

import ca.unb.cs3035.project.Models.Model;
import ca.unb.cs3035.project.Views.ClientMenuOptions;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public MenuItem dashboard;
    public MenuItem transactions;
    public MenuItem accounts;
    public MenuItem switch_user;
    public MenuItem help;
    public MenuItem about;
    public Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard.setOnAction(event -> onDashboard());
        transactions.setOnAction(event -> onTransactions());
        accounts.setOnAction(event -> onAccounts());
        switch_user.setOnAction(event -> onSwitchUser());
        help.setOnAction(event -> onHelp());
        about.setOnAction(event -> onAbout());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }

    private void onHelp() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.HELP);
    }

    private void onAbout() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ABOUT);
    }

    private void onSwitchUser() {
        // Get Current Stage
        Stage stage = (Stage) label.getScene().getWindow();
        // Close Stage
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Client Login Success Flag To False
        Model.getInstance().setClientLoginSuccessFlag(false);
    }

    public void quitButtonClicked() {
        System.out.println("Quiting Application...");
        Platform.exit();
    }
}
