package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addPhoneController {
	private static int prodID = 0;
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField make;
	@FXML
	TextField model;
	@FXML
	TextField description;
	@FXML
	TextField price;
	@FXML
	TextField storage;
	@FXML
	TextArea info;

	@FXML
	public void submit(ActionEvent submit) {
		// Adds product to Database
		if (!make.getText().isEmpty() && !model.getText().isEmpty() && !description.getText().isEmpty()
				&& !price.getText().isEmpty() && !storage.getText().isEmpty()) {
			if (make.getText().length() < 45 && model.getText().length() < 45 && description.getText().length() < 45
				&& price.getText().length() < 45 && storage.getText().length() < 45) {
				try {
					int store = Integer.parseInt(price.getText());
					store = Integer.parseInt(storage.getText());

					try {
						// Creates Statement
						String insertSQL = " Insert into products values (' " + prodID + "', '" + make.getText()
								+ "', '" + model.getText() + "', '" + price.getText() + "', '" + storage.getText()
								+ "');";

						// Executes Statement
						Database.insert(insertSQL);
						System.out.println(insertSQL);

						// Shows user the product added
						info.setText(
								"Product No: " + prodID + "\n Make: " + make.getText() + "\n Model: " + model.getText()
										+ "\n Price:€" + price.getText() + "\n Storage: " + storage.getText() + " GB");

						// Increments prodID
						prodID += 1;

						// Ends Statement
					} catch (Exception io) {
						System.out.println("error" + io);
					}
					;

				} catch (NumberFormatException nF) {
					info.setText("PRICE AND STORAGE MUST BE INTEGERS");
				} 
			}
			else
				info.setText("Enter strings less than 45 characters long");
		}
		else
			info.setText("DO NOT LEAVE EMPTY FIELDS");
	}

	@FXML
	public void back(ActionEvent back) {
		Parent bck = null; // Creates Parent
		try {
			bck = FXMLLoader.load(getClass().getResource("home.fxml"));// Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * getting the source of the action event, Casting it to a node Getting the
		 * scene from that, From the scene getting the window And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) back.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(bck, 600, 400)); // Sets scene to size
		primaryStage.setResizable(false);// Disables changing it's size
		primaryStage.show();// Show stage
	}

}