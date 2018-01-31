package guis;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

	public class MainScreen extends Application{
		Button btStart = new Button();
		BorderPane bPane = new BorderPane();
		Image main = new Image("img/the_castle.jpg");
		ImageView mainImg = new ImageView(main);
		Image main2 = new Image("img/start_button.png");
		ImageView mainImg2 = new ImageView(main);
		BackgroundImage myStart = new BackgroundImage(new Image("img/start_button.png"), 
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		BackgroundImage myBI = new BackgroundImage(new Image("img/splashBlood.gif"), 
						BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		@SuppressWarnings("static-access")
		@Override
		public void start(Stage primaryStage) throws Exception {
		
			btStart.setBackground(new Background(myStart));
			btStart.setMinHeight(20);
			btStart.setMinWidth(20);
			
			btStart.setOnAction(e -> {
				try {
				movieScreen newMain = new movieScreen();
				newMain.start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			bPane.setTop(mainImg);
			bPane.setCenter(getHBox());
			bPane.setAlignment(mainImg, Pos.CENTER);
			Scene scene = new Scene(bPane, 500, 520);
			bPane.setBackground(new Background(myBI));
			primaryStage.setTitle("Pick a Path");
			primaryStage.setScene(scene);
			
			primaryStage.show();
			primaryStage.setWidth(1172);
			primaryStage.setHeight(1000);
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX((primScreenBounds.getWidth() - primaryStage
					.getWidth()) / 2);
			primaryStage.setY((primScreenBounds.getHeight() - primaryStage
					.getHeight()) / 2);
		}
	
		
		public GridPane getGPane() {
			GridPane pane = new GridPane();
			return pane;
		}
		
		public HBox getHBox() {
			HBox hBox = new HBox();
			hBox.setPrefWidth(300);
			hBox.setAlignment(Pos.CENTER);
			btStart.setMinWidth(hBox.getPrefWidth());
			btStart.setMinHeight(200);

			hBox.getChildren().addAll(btStart);
			return hBox;
		}
		
		
		
	}
