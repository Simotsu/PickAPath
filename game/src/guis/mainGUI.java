package guis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Characters.Druid;
import Characters.Marauder;
import Characters.Necromancer;
import Characters.Paladin;
import Database.comCustomer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

	public class mainGUI extends Application{
		//Create Buttons Here
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btForward = new Button("Forward");
		Button btStats = new Button("change to stats");
		Button btEnter = new Button("Enter");
		//Create Text Fields/Area for Story line
		TextField tfInput = new TextField("");
		TextArea taNew = new TextArea("Hello "+   " , " + "you have awoken from your slumber... \n\n" + "It seems that you have met with a terrible fate...\n\n"
		+ "I have brought you here, you will give your life to these rooms I have set before you...\n\n"+"you must shed every drop to make it to the end..\n\n"+
				"each room will test your wit, resourcefulness and power\n\n"+ "I will not reveal myself to the end, but know this.. you will surely die and walk these halls forever...\n\n"+
		        "Please remind me again, what is your name?...");
		//Create Images for first room.
		Image main = new Image("img/dng1.jpg");
		ImageView mainImg = new ImageView(main);
		Image dng_2 = new Image("img/dng2.jpg");
		ImageView dng2 = new ImageView(dng_2);
		Image main1 = new Image("img/th.jpg");
		ImageView mainImg1 = new ImageView(main1);
		Image main2 = new Image("img/th (1).jpg");
		ImageView mainImg2 = new ImageView(main2);
		Button click = new Button("", mainImg);
		Button btInput = new Button("Change to Input");
		int room = 1;
		int btCounter = 0;

		BorderPane bPane = new BorderPane();
		String Player = "";
		Marauder player;
		Necromancer player1;
		Paladin player2;
		Druid player3;
		String name;
		String[][] myStory = new String[18][18];	//Multi-Dimensional array 
		//one side to hold the story the other side will hold the corresponding image to that room
		@Override
		public void start(Stage primaryStage) throws Exception {
			taNew.setEditable(false);//This makes our textArea unEditable(user cannot delete or write in it)
			taNew.setPrefHeight(400);//set the Textarea's dimensions
			taNew.setPrefWidth(300);
			

			
			//This is the code for the Left button(when available)
			btLeft.setOnAction(e -> {
				try {
					if (room == 5) {//if you are in room 5
						room = 12;//change the room to 12
					bPane.setTop(getBackground(room));//go to getBackgroundMethod() and find BG from room 12
					taNew.setText(getStory(room));//find room 12's story
					room++;//add 1 to room to indicate you are moving forward
					bPane.setBottom(getGPane());//get the information from getGPane
					System.out.print(room);
					}
					if (room == 8) {// if you are in room 8
						room = 13;//go to room 13
					bPane.setTop(getBackground(room));//go to getBackgroundMethod()
					taNew.setText(getStory(room));
					room++;
					bPane.setBottom(getGPane());
					System.out.print(room);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			btInput.setOnAction(e -> {
				try {
					bPane.setLeft(getGPane2());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			//Right buttons code(when available)
			btRight.setOnAction(e -> {
				try {
					if (room == 5) {
						room = 10;
					bPane.setTop(getBackground(room));//go to getBackgroundMethod()
					taNew.setText(getStory(room));
					room++;
					bPane.setBottom(getGPane());
					System.out.print(room);
					}
					if (room == 9) {
						room = 16;
						bPane.setTop(getBackground(room));//go to getBackgroundMethod()
						taNew.setText(getStory(room));
						room++;
						bPane.setBottom(getGPane());
						System.out.print(room);
					}
					}
				 catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			btStats.setOnAction(e -> {
				try {
					bPane.setLeft(getGPane4());
				
			}
				 catch (Exception e1) {
						e1.printStackTrace();
					}
			});
			
			//Button forward(always available except in room 10 which is exit)
			btForward.setOnAction(e -> {
				try {
					if (room == 13 || room == 12) {//if your in room 13, or 12 you have to de directed back to the main story via room 6
						room = 5;//(really room 6 but room 1 = 0)
					}
					if (room == 16) {//same as explained above but for room 16
						room = 8;
					}
					if (room == 18) {
						room = 9;
					}
					bPane.setTop(getBackground(room));//go to getBackgroundMethod()
					taNew.setText(getStory(room));
					room++;
					bPane.setBottom(getGPane());
					System.out.print(room);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			//Initially set the pane up for this GUI
			bPane.setTop(mainImg);
			bPane.setBottom(getGPane());
			bPane.setLeft(getGPane2());
			bPane.setRight(mainImg2);
			bPane.setCenter(taNew);

			
			//Set up the Scene
			Scene scene = new Scene(bPane, 500, 520);
			primaryStage.setTitle("Pick a Path");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setWidth(1172);
			primaryStage.setHeight(1000);
			//This code is to keep the GUI cenetered on your monitors screen
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX((primScreenBounds.getWidth() - primaryStage
					.getWidth()) / 2);
			primaryStage.setY((primScreenBounds.getHeight() - primaryStage
					.getHeight()) / 2);
		}
	
		//make a GridPane that holds left contents of the BorderPane IE: bPane.setLeft()
		public GridPane getGPane2() {
			GridPane pane = new GridPane();
			//pane.add(getVBox(), 0, 0);//gets the Vbox method to setup data here
			pane.add(tfInput, 0, 1);//input button
			HBox hBox = new HBox();
			hBox.getChildren().addAll(btStats,btEnter);
			
			pane.add(hBox,0,2);
			return pane;
		}
		
		public GridPane getGPane3() {
			GridPane pane = new GridPane();
			pane.add(tfInput, 0, 1);
			return pane;
		}
		public GridPane getGPane4() {
			GridPane pane = new GridPane();
			TextArea newArea = new TextArea();
			newArea.setPrefColumnCount(8);
			newArea.setPrefRowCount(8);
			//newArea.setText(player.toString());
			pane.add(newArea, 0, 1);
			pane.add(btInput, 0, 2);
			newArea.setText(showStats());
			return pane;
		}
		
		public GridPane getGPane() {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.getChildren().clear();
			pane.add(btForward, 1, 0);
			if(room == 5){
				pane.add(btLeft, 0, 0);
				pane.add(btRight, 3, 0);
			}
			else if(room == 8) {
				pane.add(btLeft, 0, 0);
			}
			else if(room == 9) {
				pane.add(btRight, 3, 0);
			}
			if(room == 10)
			{
				pane.getChildren().clear();
				pane.add(new Button("Exit Game"), 0, 0);
			}
			return pane;
		}
		
		public String getStory(int num) {
		

		myStory[1][0] = "Room 2 you have made it inside of the first Puzzle Room..\n\n If you solve this visual challenge you will be rewarded!\n\n if not you will be devoured";
		myStory[2][0] = "Room 3 has been entered Do This or That and get Out.";
		myStory[3][0] = "Room 4 has been entered Do This or That and get Out.";
		myStory[4][0] = "Room 5 has been entered Do This or That and get Out.";
		myStory[5][0] = "Room 6 has been entered Do This or That and get Out.";
		myStory[6][0] = "Room 7 has been entered Do This or That and get Out.";
		myStory[7][0] = "Room 8 has been entered Do This or That and get Out.";
		myStory[8][0] = "Room 9 has been entered Do This or That and get Out.";
		myStory[9][0] = "Room 10 has been entered Do This or That and get Out.";
		myStory[10][0] = "Room 11 has been entered Do This or That and get Out.";
		myStory[11][0] = "Room 12 has been entered Do This or That and get Out.";
		myStory[12][0] = "Room 13 has been entered Do This or That and get Out.";
		myStory[13][0] = "Room 14 has been entered Do This or That and get Out.";
		myStory[14][0] = "Room 15 has been entered Do This or That and get Out.";
		myStory[15][0] = "Room 16 has been entered Do This or That and get Out.";
		myStory[16][0] = "Room 17 has been entered Do This or That and get Out.";
		myStory[17][0] = "Room 18 has been entered Do This or That and get Out.";

			return myStory[num][0];
		}
		public ImageView getBackground(int num) {

			myStory[0][1] = "img/dng2.jpg";
			myStory[0][2] = "img/dng3.jpg";
			myStory[0][3] = "img/dng4.jpg";
			myStory[0][4] = "img/dng6.jpg";
			myStory[0][5] = "img/dng6.jpg";
			myStory[0][6] = "img/dng7.jpg";
			myStory[0][7] = "img/dng8.jpg";
			myStory[0][8] = "img/dng9.jpg";
			myStory[0][9] = "img/dng10.jpg";
			myStory[0][10] = "img/dung11.jpg";
			myStory[0][11] = "img/dung12.jpg";
			myStory[0][12] = "img/dung13.jpg";
			myStory[0][13] = "img/dung14.jpg";
			myStory[0][14] = "img/dung15.jpg";
			myStory[0][15] = "img/dung16.jpg";
			myStory[0][16] = "img/dung17.jpg";
			myStory[0][17] = "img/dung18.jpg";

			Image main = new Image(myStory[0][num]);
			ImageView newView = new ImageView(main);
			if (room == 9) {
				newView.setFitHeight(600);
				newView.setFitWidth(500);
			}
			else {
			newView.setFitHeight(600);
			newView.setFitWidth(1160);
			}
			return newView;
		}
		
public String showStats() {
	String stats = "";
	try {
		Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
		System.out.println("Connected");
		// create a statement
		Statement myStmt = myConn.createStatement();
		
		ResultSet myRs = myStmt.executeQuery("select * from player");
		while (myRs.next()) {
			stats += "Name: " + myRs.getString(2).toString() + "\nHP: " + myRs.getString(3).toString()
					+ "\nSTR: " + myRs.getString(4).toString() + "\nAGI: " + myRs.getString(5).toString()
					+ "\nINT: " + myRs.getString(6).toString() + "\nAGI: " + myRs.getString(7).toString()
					+ "\nAGI: " + myRs.getString(8).toString() + "\nAGI: " + myRs.getString(9).toString();
		System.out.println(stats);
		}
		myConn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return stats;
}

	}
