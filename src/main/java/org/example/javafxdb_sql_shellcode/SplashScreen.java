package org.example.javafxdb_sql_shellcode;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * splash screen class
 */
public class SplashScreen {
    private final Stage primaryStage;
    private final DB_Application mainApp;  // Reference to main application

    /**
     * splash screen constructor
     * @param primaryStage
     * @param mainApp
     */
    public SplashScreen(Stage primaryStage, DB_Application mainApp) {
        this.primaryStage = primaryStage;
        this.mainApp = mainApp;
    }

    /**
     * splash screen show method
     */
    public void showSplashScreen() {
        Label loginLabel = new Label("Login");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        VBox vbox = new VBox(10, loginLabel, usernameField, passwordField, loginButton, registerButton);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Scene splashScene = new Scene(vbox, 400, 300);
        primaryStage.setScene(splashScene);
        primaryStage.show();

        loginButton.setOnAction(e -> {
            fadeOutAndLoadMainScene();
        });

        registerButton.setOnAction(e -> {
            fadeOutAndLoadMainScene();
        });
    }

    /**
     * fade out method
     */
    private void fadeOutAndLoadMainScene() {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), primaryStage.getScene().getRoot());
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> {
            mainApp.changeScene();
        });
        fadeOut.play();
    }
}
