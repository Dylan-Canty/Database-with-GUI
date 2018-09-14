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

public class findProductController {
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField prodNo;
	@FXML
	TextArea prodList;

	@FXML
	public void submit(ActionEvent submit) {
		String text = "";
		if (!prodNo.getText().isEmpty()) {
			String id = prodNo.getText();
			// Creates Statement
			String querySQL = "Select * from products where productId = ' " + id + "';";

			// Executes Statement
			ResultSet ret = Database.queryStatement(querySQL);

			try {
				
				
				while (ret.next()) {
					

					text += "ProdNo:\t" + ret.getInt("productID") + "\n";
					text += "Make:\t" + ret.getString("make") + "\n";
					text += "Model:\t" + ret.getString("model") + "\n";
					text += "Price:\t€" + ret.getInt("price") + "\n";
					text += "Storage:\t" + ret.getInt("storage") + "GB\n";

					prodList.setText(text);
				}
				
				ret.beforeFirst();
				if(ret.next() == false)
					prodList.setText("HELLO");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else
			prodList.setText("HELLO");
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
