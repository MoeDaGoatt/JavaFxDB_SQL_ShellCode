package org.example.javafxdb_sql_shellcode;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


    public class DB_Application extends Application {

        public static void main(String[] args) {
            launch();
        }


        private Stage primaryStage;

        public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
            this.primaryStage.setResizable(false);
//            showScene1();
            showSplashScreen();

        }

//        private void showScene1() {
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource("splash_screen.fxml"));
//                Scene sc = new Scene(root, 850, 560);
//                sc.getStylesheets().add(getClass().getResource("style.css").toString());
//                primaryStage.setScene(sc);
//                primaryStage.show();
//                changeScene();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
private void showSplashScreen() {
    SplashScreen splashScreen = new SplashScreen(primaryStage, this);
    splashScreen.showSplashScreen();
}

        public void changeScene() {
            try {
                Parent newRoot = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));

                Scene currentScene = primaryStage.getScene();
                Parent currentRoot = currentScene.getRoot();
                currentScene.getStylesheets().add(getClass().getResource("style.css").toString());
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), currentRoot);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(e -> {


                    Scene newScene = new Scene(newRoot, 850, 560);
                    primaryStage.setScene(newScene);


                });

                fadeOut.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
