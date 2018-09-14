package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class homeController {
	@FXML
	Button addPhone; 
	@FXML
	Button displayProduct;
	@FXML
	Button displayOrder;
	@FXML
	Button findProduct;
	@FXML
	Button orderProduct;
	
	@FXML
	public void addPhone(ActionEvent addPhone) {
		
		Parent phone = null; //Creates Parent
		try {
			phone = FXMLLoader.load(getClass().getResource("addPhone.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) addPhone.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(phone, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void displayProduct(ActionEvent displayProd) {
		Parent dp = null; //Creates Parent
		try {
			dp = FXMLLoader.load(getClass().getResource("displayProduct.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) displayProd.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(dp, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void displayOrder(ActionEvent displayOrder) {
		Parent dOr = null; //Creates Parent
		try {
			dOr = FXMLLoader.load(getClass().getResource("displayOrder.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) displayOrder.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(dOr, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void findProduct(ActionEvent findProd) {
		Parent find = null; //Creates Parent
		try {
			find = FXMLLoader.load(getClass().getResource("findProduct.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) findProd.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(find, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void orderProduct(ActionEvent orderProduct) {
		Parent op = null; //Creates Parent
		try {
			op = FXMLLoader.load(getClass().getResource("orderProduct.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) orderProduct.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(op, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	


}
