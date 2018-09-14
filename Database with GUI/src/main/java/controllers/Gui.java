package controllers;

import java.io.IOException;

import database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage primaryStage){
		Database.getInstance();
		Parent gui = null; //Creates Parent
		try {
			gui = FXMLLoader.load(getClass().getResource("home.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Loads up fmxl file
		primaryStage.setTitle("Franz Blancaflor R00153623"); //Names Primary Stage 
		primaryStage.setScene(new Scene(gui, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
