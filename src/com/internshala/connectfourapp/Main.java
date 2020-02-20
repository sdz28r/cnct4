package com.internshala.connectfourapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private  Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menu = createMenu();
        menu.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menu);

        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(new Scene(rootGridPane));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public MenuBar createMenu(){

        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem newGameItem = new MenuItem("New Game");
        newGameItem.setOnAction(actionEvent -> controller.resetGame());

        MenuItem resetGameItem = new MenuItem("Reset Game");
        resetGameItem.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem quitGameItem = new MenuItem("Quit Game");
        quitGameItem.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGameItem, resetGameItem, separatorMenuItem, quitGameItem);

        //Help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Connect4");
        aboutGame.setOnAction(actionEvent -> aboutConnect4());

        SeparatorMenuItem separator = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Siddhant");
        alert.setContentText("I like to learn new things everyday. This game is proof of that.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How to play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a " +
                "color and then take turns dropping colored discs from the top into a seven-column, " +
                "six-row vertically suspended grid. The pieces fall straight down, occupying the next available " +
                "space within the column. The objective of the game is to be the first to form a horizontal, " +
                "vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. " +
                "The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}