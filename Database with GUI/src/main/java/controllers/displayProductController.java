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
import javafx.stage.Stage;

public class displayProductController {
	@FXML
	Button back;
	@FXML
	TextArea info;
	
	@FXML
	public void initialize() { 
		// Creates Statement
				String querySQL = "Select * from products;";

				// Executes Statement
				ResultSet ret = Database.queryStatement(querySQL);
				String text = "";

				try {
					while (ret.next()) {
						text += "ProdNo:\t" + ret.getInt("productID") + "\n";
						text += "Make:\t" + ret.getString("make") + "\n";
						text += "Model:\t" + ret.getString("model") + "\n";
						text += "Price:\t€" +ret.getString("price") + "\n";
						text += "Storage:\t" + ret.getString("storage") + "GB\n\n";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// Displays text
				info.setText(text);
			}

	
	@FXML
	public void back(ActionEvent back) {
		Parent bck = null; //Creates Parent
		try {
			bck = FXMLLoader.load(getClass().getResource("home.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) back.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(bck, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	
}