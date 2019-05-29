//package assignment2;

/**
 * This program provides a GUI through which you can enter the members of a basketball team by name and position
 * @author modified from version by Professor Kartchner
 * @version 1.0
 */
import java.text.NumberFormat;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class TicketGUIDriver extends Application{
	private static TextField lastNameField, firstNameField, speedField, speedLimitField, fineField;
	  private Label firstNameLabel, lastNameLabel, speedLabel, speedLimitLabel, fineLabel;
	  private Button calculateFine, printNotice, exit, clearButton;
	  private Ticket ticket;
	  private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	  private TextArea textArea;
	  //private Image icon;
	  private boolean isWorkZone, isSchoolZone;
   
   public static void main(String[] args){
	   launch(args);
   }
   
   public void start(Stage stage)
   {
	   //labels
	     firstNameLabel = new Label("First Name:");
	     firstNameLabel.setFont(new Font(16));
	     lastNameLabel = new Label("Last Name:");
	     lastNameLabel.setFont(new Font(16));
	     speedLabel = new Label("Speed traveling");
	     speedLabel.setFont(new Font(16));
	     speedLimitLabel = new Label("Speed Limit");
	     speedLimitLabel.setFont(new Font(16));
	     Insets insets = new Insets(10);
	     VBox labels = new VBox();
	     VBox.setMargin(firstNameLabel, insets);
	     VBox.setMargin(lastNameLabel, insets);
	     VBox.setMargin(speedLabel, insets);
	     VBox.setMargin(speedLimitLabel, insets);

	     labels.setAlignment(Pos.CENTER_RIGHT);
	     labels.getChildren().addAll(firstNameLabel, lastNameLabel,speedLabel, speedLimitLabel);

	     
	     //textfields
	     firstNameField = new TextField();
	     lastNameField = new TextField();
	     speedField = new TextField();
	     speedLimitField = new TextField();
	     
	     VBox fields = new VBox();
	     VBox.setMargin(firstNameField, insets);
	     VBox.setMargin(lastNameField, insets);
	     VBox.setMargin(speedField, insets);
	     VBox.setMargin(speedLimitField, insets);
	     fields.setAlignment(Pos.CENTER_LEFT);
	     fields.getChildren().addAll(firstNameField, lastNameField, speedField, speedLimitField);
	     
	     //Labels and textfields
	     HBox speedInfo = new HBox();
	     speedInfo.getChildren().addAll(labels, fields);
	     
	     //Work Zone Radio Buttons
	     VBox workZoneBox = new VBox();
	     workZoneBox.setStyle("-fx-border-color: gray;");
	     workZoneBox.setPadding(new Insets(10,10,10,10));
	     Label positionLabel = new Label("Within a Work Zone?");
	     positionLabel.setFont(new Font(16));
	     String [] workZoneLabels = {"Yes", "No"};
	     ToggleGroup workZoneGroup = new ToggleGroup();
	     RadioButton [] workRadioButtons = new RadioButton[workZoneLabels.length];
	     for (int i=0; i < workZoneLabels.length; i++)
	     {
	    	 workRadioButtons[i] = new RadioButton(workZoneLabels[i]);
	    	 workRadioButtons[i].setToggleGroup(workZoneGroup);
	    	 workRadioButtons[i].setPadding(new Insets(10,10,10,10));
	     }
	     workZoneBox.getChildren().add(positionLabel);
	     workZoneBox.getChildren().addAll(workRadioButtons);
	     
	     //School Zone Radio Buttons
	     VBox schoolZoneBox = new VBox();
	     schoolZoneBox.setStyle("-fx-border-color: gray;");
	     schoolZoneBox.setPadding(new Insets(10,10,10,10));
	     Label schoolPositionLabel = new Label("Within a School Zone?");
	     schoolPositionLabel.setFont(new Font(16));
	     String [] schoolZoneLabels = {"Yes", "No"};
	     ToggleGroup schoolZoneGroup = new ToggleGroup();
	     RadioButton [] schoolRadioButtons = new RadioButton[schoolZoneLabels.length];
	     for (int i=0; i < workZoneLabels.length; i++)
	     {
	    	 schoolRadioButtons[i] = new RadioButton(schoolZoneLabels[i]);
	    	 schoolRadioButtons[i].setToggleGroup(schoolZoneGroup);
	    	 schoolRadioButtons[i].setPadding(new Insets(10,10,10,10));
	     }
	     schoolZoneBox.getChildren().add(schoolPositionLabel);
	     schoolZoneBox.getChildren().addAll(schoolRadioButtons);
	     
	     HBox radioBox = new HBox();
	     radioBox.setStyle("-fx-border-color: gray;");
	     radioBox.setPadding(new Insets(10,10,10,10));
	     radioBox.getChildren().addAll(workZoneBox, schoolZoneBox);
	     
	     //Fine label and textfield
	     fineLabel = new Label("Fine");
	     fineLabel.setFont(new Font(16));
	     fineField = new TextField();
	     HBox fineBox = new HBox();
	     fineBox.setStyle("-fx-border-color: gray;");
	     fineBox.setPadding(new Insets(10,10,10,10));
	     HBox.setMargin(fineLabel, insets);
	     HBox.setMargin(fineField, insets);
	     fineBox.getChildren().addAll(fineLabel, fineField);
	     
	     //Textarea for the notice
	     VBox noticeBox = new VBox();
	     textArea = new TextArea();
	     textArea.setPrefColumnCount(30);
	     textArea.setPrefRowCount(15);
	     textArea.setPadding(new Insets(10,10,10,10));
	     VBox.setMargin(noticeBox, new Insets(10,10,10,10));
	     noticeBox.setAlignment(Pos.CENTER);
	     noticeBox.getChildren().add(textArea);
	     
	     //buttons
	     HBox buttonBox = new HBox();
	     buttonBox.setPadding(new Insets(10,10,10,10));
	     calculateFine = new Button("Calculate Fine");
	     HBox.setMargin(calculateFine, insets);
	     calculateFine.setOnAction(
	    		 event ->
	    		 {
	    		   //Gather information from textfields and radio buttons
	  	           String firstName = firstNameField.getText();
	  	           String lastName = lastNameField.getText();
	  	           int speed = Integer.parseInt(speedField.getText());
	  	           int speedLimit = Integer.parseInt(speedLimitField.getText());
	  	           if (workRadioButtons[0].isSelected()) isWorkZone = true;
	  	           else isWorkZone = false;
	  	           if (schoolRadioButtons[0].isSelected()) isSchoolZone = true;
	  	           else isSchoolZone = false;
	  	           
	  	           //create a Ticket object
	  	           ticket = new Ticket(firstName+" "+lastName, speed, speedLimit, isWorkZone, isSchoolZone);
	  	           //display the fine in the fine textfield
	  	           double fine = ticket.calculateFine();
	  	           fineField.setText(currencyFormat.format(fine));    
	    		 });
	     
	     exit = new Button("Exit");
	     HBox.setMargin(exit, insets);
	     exit.setOnAction(
	    		 event ->
	    		 {
	    			 System.exit(0);
	    		 });
	     
	     clearButton = new Button("Clear");
	     HBox.setMargin(clearButton, insets);
	     clearButton.setOnAction(
	    		 event ->
	    		 {
	    			 //clear fields
	    			 firstNameField.setText("");
	    			 lastNameField.setText("");
	    			 speedField.setText("");
	    			 speedLimitField.setText("");;
	    			 textArea.setText("");
	    			 fineField.setText("");
	    		 });
	     
	     printNotice = new Button("Print Notice");
	     HBox.setMargin(printNotice, insets);
	     printNotice.setOnAction(
	    		 event ->
	    		 {
	    			 //Gather information from textfields and radio buttons
	    			 String firstName = firstNameField.getText();
	    			 String lastName = lastNameField.getText();
	    			 int speed = Integer.parseInt(speedField.getText());
	    			 int speedLimit = Integer.parseInt(speedLimitField.getText());
	    			 if (workRadioButtons[0].isSelected()) isWorkZone = true;
	    			 else isWorkZone = false;
	    			 if (schoolRadioButtons[0].isSelected()) isSchoolZone = true;
	    			 else  isSchoolZone = false;

	    			 //Create ticket object
	    			 ticket = new Ticket(firstName+" "+lastName, speed, speedLimit, isWorkZone, isSchoolZone);
	    			 textArea.setText(ticket.printNotice());
	    		 });     	     
	     buttonBox.getChildren().addAll(calculateFine, printNotice, clearButton, exit);

	     //main panel
	     VBox mainPanel = new VBox();
	     VBox.setMargin(speedInfo,insets);
	     Label imageLabel = new Label("Department of Motor Vehicles");
	     imageLabel.setFont(new Font(16));
	     try{
	    	 //if image file can be found, set up image
	    	 ImageView image = new ImageView("dmv.jpg");
	    	 image.setFitHeight(70);
	    	 image.setFitWidth(100);
	    	 HBox imageBox = new HBox();
	    	 imageBox.setAlignment(Pos.CENTER);
	    	 HBox.setMargin(imageBox, new Insets(10,10,10,10));
	    	 HBox.setMargin(image, new Insets(10,10,10,10));
	    	 imageBox.getChildren().addAll(image,imageLabel);
	    	 mainPanel.getChildren().add(imageBox);
	     }catch (Exception e)
	     {
	    	 //if image file can't be found
	    	 HBox imageLabelBox = new HBox();
	    	 imageLabelBox.setAlignment(Pos.CENTER);
	    	 HBox.setMargin(imageLabelBox, new Insets(10,10,10,10));
	    	 imageLabelBox.getChildren().addAll(imageLabel);
	    	 mainPanel.getChildren().add(imageLabelBox);
	     }
	     mainPanel.getChildren().addAll(speedInfo, radioBox, fineBox, buttonBox, textArea);

	     
	   Scene scene = new Scene(mainPanel);
	   stage.setScene(scene);
	   stage.setTitle("Speeding Ticket Utility");
	   stage.show();
   }
  
}
