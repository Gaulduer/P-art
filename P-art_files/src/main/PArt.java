package main;


/*
 * Peter Gauld
 * P-art - An art program by Peter Gauld!
 * 
 * 2/13/2022 - File Created. 
 * 2/14/2022 - UI window added. Menu Bar, Menus, and Menu Items added. Tool and Canvas Panes added.
 * 2/15/2022 - Development Window Added. Mouse click and entry/exit listeners added.
 */

import fxAppeareance.Designer;
import fxFiles.FxResourceHandler;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PArt extends Application {
	//Attributes
		Boolean devStageOpen = false;
		Boolean mousePresent = false;
		Boolean mousePressed = false;
	
	public static void main(String[] args) {
		launch();
	}
	
	//Main Stage
		public void start(Stage mainStage) throws Exception {
			//Control Variables
				String mainStageTitle = "P-art";
				String mainStageIconImage = "peterHead.PNG";
				
			//Monitor Variables
				TextArea tracker = new TextArea();
				
			//Adding
				mainStage.setScene(getMainScene());
				
			//Setting Events
				//Main Stage
					mainStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
						public void handle(KeyEvent e) {
							if(devStageOpen == false)
								if(e.getCode() == KeyCode.BACK_QUOTE)
									devStage(mainStage, tracker);
						}
					});
					
					mainStage.addEventHandler(Event.ANY, new EventHandler<Event>() {
						public void handle(Event e) {
							if(devStageOpen == true) {
								tracker.setText("Mouse Present: " + mousePresent + "\nMouse Pressed: " + mousePressed);
							}
						}
					});
					
					mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
						public void handle(WindowEvent e) {
							System.exit(0);
						}
					});
			
			//Presenting
				mainStage.setTitle(mainStageTitle);
				FxResourceHandler.addStageIcon(mainStage, mainStageIconImage);
				mainStage.centerOnScreen();
				mainStage.show();
		}
		
		public Scene getMainScene() {
			//Control Variables
				Color toolPaneColor = Color.rgb(20, 20, 20);
				Color canvasPaneColor = Color.rgb(255, 255, 255);
				Color topBarColor = Color.rgb(50, 50, 50);
				Color menuTextColor = Color.rgb(255, 255, 255);
				
			//Instantiating Components
				Scene mainScene = new Scene(new Pane());
				//Components for Main Scene
					MenuBar topBar = new MenuBar();
					//Top Bar Menus
						Menu file = new Menu();
						//File Menu Items
							MenuItem fileNew = new MenuItem("New");
							MenuItem fileOpen = new MenuItem("Open");
							MenuItem fileSave = new MenuItem("Save");
							MenuItem fileSaveAs = new MenuItem("Save as");
							MenuItem[] fileMenuItems = {fileNew, fileOpen, fileSave, fileSaveAs};
						Menu canvas = new Menu();
						//Canvas Menu items
							MenuItem canvasSize = new MenuItem("Change Canvas Size");
							MenuItem canvasBackground = new MenuItem("Set Background Layer");
							MenuItem[] canvasMenuItems = {canvasSize, canvasBackground};
						Menu docker = new Menu();
						//Docker Menu Items
							MenuItem dockerBrush = new MenuItem("Brush Docker");
							MenuItem dockerColor = new MenuItem("Color Docker");
							MenuItem dockerLayer = new MenuItem("Layer Docker");
							MenuItem dockerTimeline = new MenuItem("Timeline Docker");
							MenuItem[] dockerMenuItems = {dockerBrush, dockerColor, dockerLayer, dockerTimeline};
						Menu help = new Menu();
						//Help Menu Items
							MenuItem helpTools = new MenuItem("Tools?");
							MenuItem helpCanvas = new MenuItem("Canvas?");
							MenuItem helpDockers = new MenuItem("Dockers?");
							MenuItem[] helpMenuItems = {helpTools, helpCanvas, helpDockers};
							Menu[] topBarMenus = {file, canvas, docker, help};
					Pane mainPane = new Pane();
					//Components for Main Pane
						Pane toolPane = new Pane();
						Pane canvasPane = new Pane();
						
							
			
			//Adding to 
				//Main Scene.
					mainScene = new Scene(new VBox(topBar, mainPane));
					
					//Main Pane
						mainPane.getChildren().add(new HBox(toolPane, canvasPane));
					
					//Top Bar Menu Bar
						topBar.getMenus().addAll(topBarMenus);
						
						//File Menu
							file.getItems().addAll(fileMenuItems);
							
						//Canvas Menu
							canvas.getItems().addAll(canvasMenuItems);
							
						//Docker Menu
							docker.getItems().addAll(dockerMenuItems);
							
						//Help Menu
							help.getItems().addAll(helpMenuItems);
							
			//Setting 
				//Appearance
					//Main Pane
						mainPane.setPrefSize(800, 600);
						mainPane.minWidthProperty().bind(mainScene.widthProperty());
						mainPane.minHeightProperty().bind(mainScene.heightProperty());
						canvasPane.setBackground(Designer.getBackground(new Color(0, 0, 0, 1)));
								
						//Canvas Pane
							canvasPane.setBackground(Designer.getBackground(canvasPaneColor));
							canvasPane.prefWidthProperty().bind(mainPane.widthProperty().multiply(3).divide(4));
							canvasPane.prefHeightProperty().bind(mainPane.heightProperty());
						
						//Tool Pane
							toolPane.setBackground(Designer.getBackground(toolPaneColor));
							toolPane.prefWidthProperty().bind(mainPane.widthProperty().divide(4));
							toolPane.prefHeightProperty().bind(mainPane.heightProperty());
							
					//Top Bar Menu Bar
						topBar.setBackground(Designer.getBackground(topBarColor));
						
						//Menus for Bar Menu Bar	
							file.setGraphic(Designer.getText("File", menuTextColor));
							canvas.setGraphic(Designer.getText("Canvas", menuTextColor));
							docker.setGraphic(Designer.getText("Dockers", menuTextColor));
							help.setGraphic(Designer.getText("Help", menuTextColor));
							
				//Events
					//Canvas Pane
						canvasPane.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								mousePresent = true;
							}
						});
								
						canvasPane.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								mousePresent = false;
							}
						});
						
						canvasPane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								mousePressed = true;
							}
						});
						
						canvasPane.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								mousePressed = false;
							}
						});
						
						
			return mainScene;
		}
		
	//Development Stage
		private void devStage(Stage parentStage, TextArea tracker) {		
			//Limit Variables
				Boolean[] triggered = {false}; 
			
			//Instantiating Components 
				Stage devStage = new Stage();
				Scene mainScene = new Scene(new Pane(tracker));
				
			//Instantiating Events
				EventHandler<KeyEvent> parentClosesDev = new EventHandler<KeyEvent>() {
					public void handle(KeyEvent e) {
						if(e.getCode() == KeyCode.BACK_QUOTE && triggered[0] == true)
							devStage.fireEvent(new WindowEvent(devStage, WindowEvent.WINDOW_CLOSE_REQUEST));
						else
							triggered[0] = true;
					}
				};
				
			//Setting
				//Appearance
					//Development Stage
						devStage.setTitle("Development Window");
				
		 			//Tracker
						tracker.setPrefSize(300, 50);
		 				tracker.setEditable(false);
		 				
				//Events
					//Development Stage
		 				devStage.setOnShown(new EventHandler<WindowEvent>() {
							public void handle(WindowEvent e) {
								parentStage.addEventHandler(KeyEvent.KEY_PRESSED, parentClosesDev);
								devStageOpen = true;
							}
						});
		 				
		 				devStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
							public void handle(WindowEvent e) {
								devStageOpen = false;
								parentStage.removeEventHandler(KeyEvent.KEY_PRESSED, parentClosesDev);
								devStage.close();
							}
						});
		 				
		 			//Parent Stage
						
						
						
			//Presenting
				devStage.setScene(mainScene);
				devStage.show();
		}
	
	//Utility Methods

}
