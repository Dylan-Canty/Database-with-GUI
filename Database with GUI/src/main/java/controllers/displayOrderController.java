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

public class displayOrderController {
	@FXML
	TextField custName;
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextArea info;
	
	@FXML
	public void submit(ActionEvent submit) {
		String text = "";
		
		if(custName.getText().isEmpty() == false) {
			String querySQL = "Select * from orders where customerName like '" + custName.getText() + "';";
		
			if(custName.getText().length() < 45) {
		// Executes Statement
		ResultSet ret = Database.queryStatement(querySQL);
		

		try {
			while (ret.next()) {
				text = "OrderNumber:\t" + ret.getInt("orderNumber") + "\n";
				text += "customerName:\t" + ret.getString("customerName") + "\n";
				text += "Make:\t" + ret.getString("make") + "\n";
				text += "ProdID:\t€" + ret.getString("model") + "\n";
				text += "Quantity:\t" + ret.getInt("quantity") + "\n\n";
			}
			
			ret.beforeFirst();
			if(ret.next() == false)
				text = "ENTER A REAL NAME";
		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
			else
				text = "Enter name less than 45 characters";
		}
		
		else
			text = "Think again, dont be stupid";
		// Displays text
		info.setText(text);
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

