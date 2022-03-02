package screens;

/*
 * Peter Gauld
 * Drawing Screen - This is meant to act as the main screen in P-art. Here the user can interact with the menu bar, tools, and the canvas.
 * 
 * 2/25/2022 - File Created.
 * 3/2/2022 - Drawing scene is now a functional class instead of a method in P-art.
 */

import fxAppeareance.Designer;
import fxObjects.DockerBrush;
import fxObjects.DockerColor;
import fxObjects.DockerLayer;
import fxObjects.DockerTimeline;
import fxObjects.PCanvas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DrawingScreen extends Scene{
	private PCanvas canvas = new PCanvas();
	private DrawingScreen drawingScreen = this;
	
	public DrawingScreen() {
		super(new Pane());
		this.setRoot(drawingPane());
	}
	
	private Pane drawingPane() {	
		//Control Variables
			Color toolPaneColor = Color.rgb(20, 20, 20);
			Color topBarColor = Color.rgb(50, 50, 50);
			Color menuTextColor = Color.rgb(255, 255, 255);
			
		//Instantiating Components
			Pane drawingPane = new Pane();
			//Components for Drawing Pane
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
			
		//Instantiating Event Components
			DockerBrush brush = new DockerBrush(drawingScreen);
			DockerColor color = new DockerColor(drawingScreen);
			DockerLayer layer = new DockerLayer(drawingScreen);
			DockerTimeline timeline = new DockerTimeline(drawingScreen);
				
		//Adding to 
			//Drawing Pane.
				drawingPane.getChildren().add(new VBox(topBar, mainPane));
						
				//Main Pane
					mainPane.getChildren().add(new HBox(toolPane, canvasPane));
			
					//Canvas Pane
						canvasPane.getChildren().add(canvas);
						canvas.setParentPane(canvasPane);
						canvas.setStrokeWidth(20);
							
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
						mainPane.minWidthProperty().bind(drawingPane.widthProperty());
						mainPane.minHeightProperty().bind(drawingPane.heightProperty());								
										
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
										
					//Events	
						//Docker Menu Items
							dockerBrush.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									brush.openStage();
								}
							});
									
							dockerColor.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									color.openStage();
								}
							});
									
							dockerLayer.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									layer.openStage();
								}
							});
									
							dockerTimeline.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									timeline.openStage();
								}
							});
						
		return drawingPane;
	}	

	public void clearCanvas() {
		canvas.clear();
	}
	
	public PCanvas getCanvas() {
		return canvas;
	}
}
