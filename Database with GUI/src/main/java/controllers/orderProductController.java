package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
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

public class orderProductController {
	private static int ordNo = 0;
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField custName;
	@FXML
	TextField custAddress;
	@FXML
	TextField prodID;
	@FXML
	TextField quantity;
	@FXML
	TextArea info;

	@FXML
	public void submit(ActionEvent submit) {
		ResultSet returnValue = null;
		String query = null;

		// Adds product to Database
		int hold = 0;
		int hold2 = 0;
		if (custName.getText().isEmpty() == false && custAddress.getText().isEmpty() == false && prodID.getText().isEmpty() == false
				&& quantity.getText().isEmpty() == false) {
			
			if (custName.getText().length() < 45 && custAddress.getText().length() < 45 && prodID.getText().length() < 45
					&& quantity.getText().length() < 45) {
			try {

				hold = Integer.parseInt(prodID.getText());
				hold2 = Integer.parseInt(quantity.getText());

				returnValue = Database.queryStatement("Select * from products where productID = '" + hold + "'");

				try {
					while (returnValue.next()) {
						query = "Insert into orders (quantity, make, model, customerName) values ('"
								+ quantity.getText() + "','" + returnValue.getString("make") + "','"
								+ returnValue.getString("model") + "','" + custName.getText() + "');";

						Database.insert(query);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				info.setText("\n Customer name: " + custName.getText() + "\n Customer Address: " + custAddress.getText()
						+ "\n quantity: " + quantity.getText());

			} catch (NumberFormatException nF) {
				info.setText("Enter integers in for productID and quantity");
			};
			}
			else {
				info.setText("Enter Text less than 45 characters long");
			}
		}
		else
			info.setText("Do not leave empty fields");

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