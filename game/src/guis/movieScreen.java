package guis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Characters.Druid;
import Characters.Marauder;
import Characters.Necromancer;
import Characters.Paladin;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

	public class movieScreen extends Application{
		int size = 50;
		int clock = (int) System.currentTimeMillis() / 1000;
		int currClock;
		int timePassed;
		String Player = "";
		Marauder player;
		Necromancer player1;
		Paladin player2;
		Druid player3;
		Button btEnter = new Button("Enter");
		RadioButton rbMara = new RadioButton("Strength");
		RadioButton rbNecr = new RadioButton("Necromancing");
		RadioButton rbPala = new RadioButton("Defending");
		RadioButton rbDrui = new RadioButton("Agility");
		ToggleGroup rbGroup = new ToggleGroup();
		String word = "";
		TextArea taDesc = new TextArea();
		String descString;
		Image mara1 = new Image("img/warrior.jpg");
		ImageView mara = new ImageView(mara1);
		TextField tfName = new TextField("");
		Font myCntFnt = new Font("Serif", size);
		Text centerText = new Text(100, 1150, "");
		Text topText = new Text();
		Text bottomText = new Text();
		Text leftText = new Text();
		Text rightText = new Text();
		BorderPane bPane = new BorderPane();//declare a borderpane for our movie screen
		public void start(Stage primaryStage) throws Exception {
			//Setting Default Values for all text and background for MovieScreen GUI
			rbMara.setToggleGroup(rbGroup);
			rbNecr.setToggleGroup(rbGroup);
			rbPala.setToggleGroup(rbGroup);
			rbDrui.setToggleGroup(rbGroup);
			rbMara.setUserData("img/warrior");
			rbNecr.setUserData("img/necromancer");
			rbPala.setUserData("img/paladin");
			rbDrui.setUserData("img/druid");
			
			//add toggle listener so when radio button is switched top will display information about the different classes
			
			//switch to lambda version eventually
			rbGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov,
				        Toggle old_toggle, Toggle new_toggle) {
				            if (rbGroup.getSelectedToggle() != null) {
				                final Image image = new Image(
				                        rbGroup.getSelectedToggle().getUserData().toString() + 
				                            ".jpg"
				                    );
								if(rbMara.isSelected()) {
									descString = "HP: 300\nSTR: 9\nAGI: 3\nINT: 0\nBERSERK\nCLEAVE";
								}
								if(rbNecr.isSelected()) {
									descString = "HP: 150\nSTR: 2\nAGI: 6\nINT: 9\nSUMMON DEAD\nRAISE DEAD";
								}
								if(rbPala.isSelected()) {
									descString = "HP: 300\nSTR: 6\nAGI: 4\nINT: 5\nHEAL\nSELF-REVIVAL";
								}
								if(rbDrui.isSelected()) {
									descString = "HP: 180\nSTR: 2\nAGI: 9\nINT: 6\nSUMMON ELEMENTAL\nCALL OF NATURE";
								}
				                mara = new ImageView(image);
								bPane.setRight(getVBox());
				            }                
				        }
				});
			
			
			centerText.setFill(Color.WHITE);
			centerText.setFont(myCntFnt);
			topText.setFill(Color.WHITE);
			bottomText.setFill(Color.WHITE);
			leftText.setFill(Color.WHITE);
			rightText.setFill(Color.WHITE);
			bPane.setStyle("-fx-background-color: #000000;");//change the screen background color to black
			bPane.setCenter(centerText);

			//Create a handler for changing text 
			EventHandler<ActionEvent> eventHandler = e -> {
				currClock = (int) System.currentTimeMillis() / 1000;
				timePassed = currClock - clock;
				System.out.println(timePassed);
				if (centerText.getText().length() != 0 && timePassed < 10) {
					centerText.setText("");
				}
				else if(timePassed < 12) {
					size+=30;
					myCntFnt= new Font("Serif", size);
					centerText.setFont(myCntFnt);
					centerText.setText("Wake Up");
				}
				System.out.println(timePassed);
				if (timePassed >= 12 && timePassed < 18) {
					word += ". ";
					centerText.setText(word);
				}
				if (timePassed >= 18 && timePassed < 20) {
					myCntFnt = new Font("Serif", 30);
					centerText.setFont(myCntFnt);
					centerText.setText("Adventurer please tell me your name...\n Also which area of knowledge you are most proficeint.");
				}
				if (timePassed >= 20 && timePassed < 70) {
					bPane.setBottom(getHbox());
				}
				if (size == 1000) {
				bPane.setBottom(null);
				bPane.setRight(null);
					centerText.setText("Ah it is you, " + Player + ". We have been awaiting your..arrival.");
					clock -= 118;//jumps clock to 148
					size += 1;//stops this from being an infinite loop (makes zine 1001 not 1000)
				}
				if (timePassed >= 158 && timePassed < 159) {
					myCntFnt = new Font("Serif", 30);
					centerText.setFont(myCntFnt);
					centerText.setText("You have met with a terrible fate.");
				}
				if (timePassed >= 160 && timePassed < 161) {
					myCntFnt = new Font("Serif", 30);
					centerText.setFont(myCntFnt);
					centerText.setText("You have met with a terrible fate..");
				}
				if (timePassed >= 163 && timePassed < 164) {
					myCntFnt = new Font("Serif", 30);
					centerText.setFont(myCntFnt);
					centerText.setText("You have met with a terrible fate...");
				}
				if (timePassed >= 165 && timePassed < 170) {
					myCntFnt = new Font("Serif", 30);
					centerText.setFont(myCntFnt);
					centerText.setText("Will you get out alive?");
				}				
				if (timePassed >= 170 && timePassed < 173) {
					size = 1006;
				}
				if (size == 1006) {
					 mainGUI newGui = new mainGUI();
					 size+=1;
					 try {
						newGui.start(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
//we should implement radio buttons that correspons to images and stats in the top corner somewhere
			
			//create the animation for our sleeping text
			Timeline animation = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
			animation.setCycleCount(50);
			animation.play();
			
			
			
			//ENTER BUTTONN LAMBDA EXPRESSION
			btEnter.setOnAction(e -> {
				try {
					
					if (rbMara.isSelected()) {
								 setUpChar();
								 Player = tfName.getText();
								 size = 1000;
					}
					if(rbNecr.isSelected()) {
								setUpChar1();
								Player = tfName.getText();
								size = 1000;
					}
					if(rbPala.isSelected()) {
						setUpChar2();
						Player = tfName.getText();
						size = 1000;
					}
					if(rbDrui.isSelected()) {
						setUpChar3();
						Player = tfName.getText();
						size = 1000;
						 /*save for future
						  *
						 mainGUI newGui = new mainGUI();
						 newGui.start(primaryStage);
						  */
					}			
					
					}
				 catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			
			
			

			Scene scene = new Scene(bPane);//put the pane into the scene
			primaryStage.setTitle("Pick a Path");//set the title at the top left
			primaryStage.setScene(scene);//set the scene
			primaryStage.show();//show the scene
			primaryStage.setWidth(1172);//set width of scene
			primaryStage.setHeight(1000);//set the height of the scene
			//the following code sets the Program to the center of the screen no matter what size it is.
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX((primScreenBounds.getWidth() - primaryStage
					.getWidth()) / 2);
			primaryStage.setY((primScreenBounds.getHeight() - primaryStage
					.getHeight()) / 2);
		}
		public HBox getHbox() {
			HBox hBox = new HBox(10);
			hBox.getChildren().addAll(new Text("Name: "), tfName, rbNecr, rbMara, rbPala, rbDrui, btEnter);
			hBox.setAlignment(Pos.CENTER);
			BorderPane.setMargin(hBox, new Insets(100));
			return hBox;
		}
		
		public void setUpChar() {
				try {
					//1 Get connection always use a try 
					Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
					System.out.println("Connected");
					PreparedStatement prepState01 = (PreparedStatement) myConn.prepareStatement("DELETE FROM player WHERE idplayer = ?");
					prepState01.setInt(1, 1);
					prepState01.executeUpdate(); 
					//2Execute SQL Query
					String query = "INSERT INTO player (idplayer, playerName, playerHP, playerSTR, playerAGI, playerINT, bodyArmor, headArmor, legArmor, footArmor, "
							+ " attr1, attr2) " + 
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
					prepState.setInt(1, 1);
					prepState.setString(2, tfName.getText());
					prepState.setInt(3, 300);
					prepState.setString(4, "9");
					prepState.setString(5, "3");
					prepState.setString(6, "0");
					prepState.setString(7, "Heavy Chainmail");
					prepState.setString(8, "Heavy Coif");
					prepState.setString(9, "Iron Leg Armor");
					prepState.setString(10, "Iron Truage Boots");
					prepState.setString(11, "Berserk");
					prepState.setString(12, "Cleave");
					//4 Process results
					prepState.execute();
					System.out.println("Insert into Commercial Customer Complete");
					myConn.close();
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		public void setUpChar1() {
			try {
				//1 Get connection always use a try 
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
				System.out.println("Connected");
				PreparedStatement prepState01 = (PreparedStatement) myConn.prepareStatement("DELETE FROM player WHERE idplayer = ?");
				prepState01.setInt(1, 1);
				prepState01.executeUpdate(); 
				//2Execute SQL Query
				String query = "INSERT INTO player (idplayer, playerName, playerHP, playerSTR, playerAGI, pLayerINT, bodyArmor, headArmor, legArmor, footArmor, "
						+ " attr1, attr2) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
				prepState.setInt(1, 1);
				prepState.setString(2, tfName.getText());
				prepState.setInt(3, 150);
				prepState.setString(4, "2");
				prepState.setString(5, "6");
				prepState.setString(6, "9");
				prepState.setString(7, "Rotten Robe");
				prepState.setString(8, "Bloody Hood");
				prepState.setString(9, "n/a");
				prepState.setString(10, "Earth Sandles");
				prepState.setString(11, "Call Dead");
				prepState.setString(12, "Summon Dead");
				//4 Process results
				prepState.execute();
				System.out.println("Insert into Commercial Customer Complete");
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	
		public void setUpChar2() {
			try {
				//1 Get connection always use a try 
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
				System.out.println("Connected");
				PreparedStatement prepState01 = (PreparedStatement) myConn.prepareStatement("DELETE FROM player WHERE idplayer = ?");
				prepState01.setInt(1, 1);
				prepState01.executeUpdate(); 
				//2Execute SQL Query
				String query = "INSERT INTO player (idplayer, playerName, playerHP, playerSTR, playerAGI, playerINT, bodyArmor, headArmor, legArmor, footArmor, "
						+ " attr1, attr2) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
				prepState.setInt(1, 1);
				prepState.setString(2, tfName.getText());
				prepState.setInt(3, 300);
				prepState.setString(4, "6");
				prepState.setString(5, "4");
				prepState.setString(6, "5");
				prepState.setString(7, "Holy Breastplate");
				prepState.setString(8, "Heavenly Helmet");
				prepState.setString(9, "Reviving Leg Gaurds");
				prepState.setString(10, "Survival Boots");
				prepState.setString(11, "Heal");
				prepState.setString(12, "Self Revive(once)");
				//4 Process results
				prepState.execute();
				System.out.println("Insert into Commercial Customer Complete");
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		public void setUpChar3() {
			try {
				//1 Get connection always use a try 
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");
				System.out.println("Connected");
				PreparedStatement prepState01 = (PreparedStatement) myConn.prepareStatement("DELETE FROM player WHERE idplayer = ?");
				prepState01.setInt(1, 1);
				prepState01.executeUpdate(); 
				System.out.println("Executed");
				//2Execute SQL Query
				String query = "INSERT INTO player (idplayer, playerName, playerHP, playerSTR, playerAGI, playerINT, bodyArmor, headArmor, legArmor, footArmor, "
						+ " attr1, attr2) " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement prepState = (PreparedStatement) myConn.prepareStatement(query);
				prepState.setInt(1, 1);
				prepState.setString(2, tfName.getText());
				prepState.setInt(3, 180);
				prepState.setString(4, "2");
				prepState.setString(5, "9");
				prepState.setString(6, "6");
				prepState.setString(8, "Robe of Lords");
				prepState.setString(8, "Element Crown");
				prepState.setString(9, "n/a");
				prepState.setString(10, "Enchanted Wrappings");
				prepState.setString(11, "Summon Elemental");
				prepState.setString(12, "Call Nature");
				//4 Process results
				prepState.execute();
				System.out.println("Insert into Commercial Customer Complete");
				myConn.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		
		
		public VBox getVBox() {
			VBox vBox = new VBox();
			taDesc.setPrefSize(150,150);
			taDesc.setText(descString);
			
			vBox.getChildren().add(mara);
			vBox.getChildren().addAll(taDesc);
			
			
			return vBox;
		}
	
	
	
		
		}
	
