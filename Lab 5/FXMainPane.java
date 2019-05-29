package com.fgonzalesv;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button btn1, btn2, btn3, btn4, btn5, btnSpa;
	Label mainLabel;
	TextField txtField;
	
	//  declare two HBoxes
	HBox firstBox;
	HBox secondBox;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		btn1 = new Button("Hello");
		btn2 = new Button("Howdy");
		btn3 = new Button("Chinese");
		btn4 = new Button("Clear");
		btn5 = new Button("Exit");
		mainLabel = new Label("Feedback");
		txtField = new TextField();
		
		// Optional Task 4)
		btnSpa = new Button("Español");
		
		//  instantiate the HBoxes
		firstBox = new HBox();
		secondBox = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(btn1,new Insets(10, 30, 30, 0));
		HBox.setMargin(btn2,new Insets(10, 30, 30, 0));
		HBox.setMargin(btn3,new Insets(10, 30, 30, 0));
		HBox.setMargin(btnSpa,new Insets(10, 30, 30, 0));
		HBox.setMargin(btn4,new Insets(10, 0, 30, 0));
		HBox.setMargin(btn5,new Insets(10, 0, 30, 30));
		HBox.setMargin(mainLabel,new Insets(0, 20, 0, 0));
		firstBox.setAlignment(Pos.CENTER);
		secondBox.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		secondBox.getChildren().addAll(mainLabel, txtField);
		//  add the buttons to the other HBox
		firstBox.getChildren().addAll(btn1, btn2, btn3, btnSpa, btn4, btn5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(firstBox, secondBox);
		
		
		// Task#4 add onAction to buttons:
		btn1.setOnAction(new ButtonHandler());
		btn2.setOnAction(new ButtonHandler());
		btn3.setOnAction(new ButtonHandler());
		// Optional Task
		btnSpa.setOnAction(new ButtonHandler());
		btn4.setOnAction(new ButtonHandler());
		btn5.setOnAction(new ButtonHandler());
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			switch (((Labeled) event.getTarget()).getText()) {
			case "Hello":
				txtField.setText(dataManager.getHello());
				break;
			case "Howdy":
				txtField.setText(dataManager.getHowdy());
				break;
			case "Chinese":
				txtField.setText(dataManager.getChinese());
				break;
				// Optional Task
			case "Español":
				txtField.setText(dataManager.getEspañol());
				break;
			case "Clear":
				txtField.setText("");
				break;
			case "Exit":
				Platform.exit();
				System.exit(0);
				break;
			}
			
		}
		
	}
}

