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
import fxObjects.PCanvas;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import screens.DevelopmentStage;

public class PArt extends Application {
	private PCanvas canvas = new PCanvas();
	
	public static void main(String[] args) {
		launch();
	}
	
	//Main Stage
		public void start(Stage mainStage) throws Exception {
			//Control Variables
				String mainStageTitle = "P-art";
				String mainStageIconImage = "peterHead.PNG";
				
			//Function Objects
				//DrawingScreen draw = new DrawingScreen();
				
			//Monitor Objects
				DevelopmentStage devStage = new DevelopmentStage(mainStage);
				
			//Adding
				mainStage.setScene(getMainScene());
				
			//Setting Events
				//Main Stage
					mainStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
						public void handle(KeyEvent e) {
							if(e.getCode() == KeyCode.BACK_QUOTE)
								if(devStage.isOpen() == false)
									devStage.open();
							if(e.getCode() == KeyCode.C) {
								canvas.clear();
							}
						}
					});
					
					mainStage.addEventHandler(Event.ANY, new EventHandler<Event>() {
						public void handle(Event e) {
							if(devStage.isOpen() == true) {
								devStage.setTracker("Mouse Present: " + canvas.isMousePresent() + "\nMouse Pressed: " + canvas.isMousePressed());
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
				Color topBarColor = Color.rgb(50, 50, 50);
				Color menuTextColor = Color.rgb(255, 255, 255);
				
			//Instantiating Components
				Scene mainScene = new Scene(new Pane());
				//Components for Main Scene
					MenuBar topBar = new MenuBar();
					//Top Bar Menus
						Menu fileMenu = new Menu();
						//File Menu Items
							MenuItem fileNew = new MenuItem("New");
							MenuItem fileOpen = new MenuItem("Open");
							MenuItem fileSave = new MenuItem("Save");
							MenuItem fileSaveAs = new MenuItem("Save as");
							MenuItem[] fileMenuItems = {fileNew, fileOpen, fileSave, fileSaveAs};
						Menu canvasMenu = new Menu();
						//Canvas Menu items
							MenuItem canvasSize = new MenuItem("Change Canvas Size");
							MenuItem canvasBackground = new MenuItem("Set Background Layer");
							MenuItem[] canvasMenuItems = {canvasSize, canvasBackground};
						Menu dockerMenu = new Menu();
						//Docker Menu Items
							MenuItem dockerBrush = new MenuItem("Brush Docker");
							MenuItem dockerColor = new MenuItem("Color Docker");
							MenuItem dockerLayer = new MenuItem("Layer Docker");
							MenuItem dockerTimeline = new MenuItem("Timeline Docker");
							MenuItem[] dockerMenuItems = {dockerBrush, dockerColor, dockerLayer, dockerTimeline};
						Menu helpMenu = new Menu();
						//Help Menu Items
							MenuItem helpTools = new MenuItem("Tools?");
							MenuItem helpCanvas = new MenuItem("Canvas?");
							MenuItem helpDockers = new MenuItem("Dockers?");
							MenuItem[] helpMenuItems = {helpTools, helpCanvas, helpDockers};
							Menu[] topBarMenus = {fileMenu, canvasMenu, dockerMenu, helpMenu};
					Pane mainPane = new Pane();
					//Components for Main Pane
						Pane toolPane = new Pane();
						Pane canvasPane = new Pane();
			
			//Adding to 
				//Main Scene.
					mainScene = new Scene(new VBox(topBar, mainPane));
					
					//Main Pane
						mainPane.getChildren().add(new HBox(toolPane, canvasPane));
						
						//Canvas Pane
							canvasPane.getChildren().add(canvas);
							canvas.setParentPane(canvasPane);
							canvas.setStrokeWidth(20);
							canvas.setStrokeColor(Designer.getColor(0, 50, 100));
						
					//Top Bar Menu Bar
						topBar.getMenus().addAll(topBarMenus);
						
						//File Menu
							fileMenu.getItems().addAll(fileMenuItems);
							
						//Canvas Menu
							canvasMenu.getItems().addAll(canvasMenuItems);
							
						//Docker Menu
							dockerMenu.getItems().addAll(dockerMenuItems);
							
						//Help Menu
							helpMenu.getItems().addAll(helpMenuItems);
							
			//Setting 
				//Appearance
					//Main Pane
						mainPane.setPrefSize(800, 600);
						mainPane.minWidthProperty().bind(mainScene.widthProperty());
						mainPane.minHeightProperty().bind(mainScene.heightProperty());								
						
						//Tool Pane
							toolPane.setBackground(Designer.getBackground(toolPaneColor));
							toolPane.prefWidthProperty().bind(mainPane.widthProperty().divide(4));
							toolPane.prefHeightProperty().bind(mainPane.heightProperty());
							
						//Canvas Pane
							canvasPane.prefWidthProperty().bind(mainPane.widthProperty().multiply(3).divide(4));
							canvasPane.prefHeightProperty().bind(mainPane.heightProperty());
							
					//Top Bar Menu Bar
						topBar.setBackground(Designer.getBackground(topBarColor));
						
						//Menus for Bar Menu Bar	
							fileMenu.setGraphic(Designer.getText("File", menuTextColor));
							canvasMenu.setGraphic(Designer.getText("Canvas", menuTextColor));
							dockerMenu.setGraphic(Designer.getText("Dockers", menuTextColor));
							helpMenu.setGraphic(Designer.getText("Help", menuTextColor));
						
			return mainScene;
		}
	
	//Utility Methods

}
