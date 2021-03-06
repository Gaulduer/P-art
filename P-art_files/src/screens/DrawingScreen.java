package screens;

/*
 * Peter Gauld
 * Drawing Screen - This is meant to act as the main screen in P-art. Here the user can interact with the menu bar, tools, and the canvas.
 * 
 * 2/25/2022 - File Created.
 * 3/2/2022 - Drawing scene is now a functional class instead of a method in P-art.
 * 3/23/2022 - Basic save file implemented. Basic open file implemented.
 */

import java.io.File;
import javax.imageio.ImageIO;
import fxAppeareance.Designer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import main.PArt;
import pBrushes.BrushDocker;
import pColor.ColorDocker;
import pGeneral.GeneralDocker;
import pGeneral.HelpDocker;
import pGeneral.PCanvas;
import pLayers.LayerDocker;
import pTimeline.TimelineDocker;
import pTools.ToolDocker;

public class DrawingScreen extends Scene{
	private DrawingScreen drawingScreen = this;
	private PCanvas canvas = new PCanvas();
	private ToolDocker tool = new ToolDocker(this);
	private GeneralDocker[] dockers = new GeneralDocker[0];
	
	public DrawingScreen() {
		super(new Pane());
		this.setRoot(drawingPane());
	}
	
	private Pane drawingPane() {	
		//Control Variables
			Color toolPaneColor = Color.rgb(50, 50, 50);
			Color toolTextColor = Color.rgb(200, 200, 200);
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
						MenuItem helpPArt = new MenuItem("P-art?");
						MenuItem helpTools = new MenuItem("Tools?");
						MenuItem helpCanvas = new MenuItem("Canvas?");
						MenuItem helpDockers = new MenuItem("Dockers?");
						MenuItem[] helpMenuItems = {helpPArt, helpTools, helpCanvas, helpDockers};
					Menu[] topBarMenus = {fileMenu, canvasMenu, dockerMenu, helpMenu};
				Pane mainPane = new Pane();
				//Components for Main Pane
					Pane canvasPane = new Pane();
		
		//Instantiating Event Components
			BrushDocker brush = new BrushDocker(drawingScreen);
			ColorDocker color = new ColorDocker(drawingScreen);
			LayerDocker layer = new LayerDocker(drawingScreen);
			TimelineDocker timeline = new TimelineDocker(drawingScreen);
			HelpDocker help = new HelpDocker(drawingScreen);
			
		//Creating Docker Array (Really just for when all the dockers need to be closed.)
			dockers = new GeneralDocker[] {brush, color, layer, timeline, tool};
				
		//Adding to 
			//Drawing Pane.
				drawingPane.getChildren().add(new VBox(topBar, mainPane));
						
				//Main Pane
					mainPane.getChildren().add(new HBox(tool.dock(), canvasPane));
					
					//Tool Pane
						//toolPane.getChildren().add(columns);
						//Button b1 = new Button();
						//toolPane.getChildren().add(b1);
					
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
				//Attributes	
					this.getCanvas().setTool(tool.getSelectedTool()); //TODO maybe this could be done when selectedTool is set.
					
				//Appearance
					//Main Pane
						mainPane.setPrefSize(800, 600);
						mainPane.minWidthProperty().bind(drawingPane.widthProperty());
						mainPane.minHeightProperty().bind(drawingPane.heightProperty());								
										
					//Tool Pane
						tool.setPrimaryColor(toolPaneColor);
						tool.setSecondaryColor(toolTextColor);
						tool.dock().prefWidthProperty().bind(mainPane.widthProperty().divide(4));
						tool.dock().prefHeightProperty().bind(mainPane.heightProperty());
									
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
						//File Menu Items
							fileNew.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									try {
										new PArt().start(new Stage());
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
							});
						
							fileOpen.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									FileChooser open = new FileChooser();
									File read = open.showOpenDialog(drawingScreen.getWindow());		
									Image print = null;
										try {
											print =  SwingFXUtils.toFXImage(ImageIO.read(read), null);
										} catch (Exception ex) {
											System.err.println(ex);
										}
										
									canvas.getGraphicsContext2D().drawImage(print, 0, 0);
								}
							});
						
							fileSave.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									int imageWidth = (int)canvas.getWidth();
									int imageHeight = (int)canvas.getHeight();
									
									FileChooser save = new FileChooser();
									WritableImage image = new WritableImage(imageWidth, imageHeight);
							
									save.getExtensionFilters().add(new ExtensionFilter(".png", "*.png"));
									save.setTitle("PETER'S WORK.png");
									canvas.snapshot(null, image);
									
									try {
										ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", save.showSaveDialog(drawingScreen.getWindow()));
									}
									catch(Exception ex) {
										System.out.println("Error in File Save Event from the Drawing Screen Class");
										System.err.println(ex);
									}
								}
							});
							
							fileSaveAs.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {		
									int imageWidth = (int)canvas.getWidth();
									int imageHeight = (int)canvas.getHeight();
									
									FileChooser save = new FileChooser();
									WritableImage image = new WritableImage(imageWidth, imageHeight);
									
									save.getExtensionFilters().add(0, new ExtensionFilter(".png", "*.png"));
									save.getExtensionFilters().add(1, new ExtensionFilter(".jpg", "*.jpg"));	
									save.getExtensionFilters().add(2, new ExtensionFilter(".ico", "*.ico"));	
									canvas.snapshot(null, image);
									
									try {
										ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", save.showSaveDialog(drawingScreen.getWindow()));
									}
									catch(Exception ex) {
										System.out.println("Error in File Save As Event from the Drawing Screen Class");
										System.err.println(ex);
									}
								}	
							});
						
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
							
						//Help Menu Items
							helpPArt.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									help.display("P-art is a digital art program made by Peter Gauld. You are able to create, edit, and save images you make! These images are made using a variety of tools available to you. If you have any questions about P-art, please contact Peter Gauld at:\ngaulduer@gmail.com\n\nThank you for drawing!");
								}
							});
							
							helpTools.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									help.display("Tools allow you to edit the canvas. Each tool has a different effect and a different use. Some tools currently do not function, and more will be available in a future release.");
								}
							});
							
							helpCanvas.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									help.display("The canvas is where you draw your image. What is on the canvas is what will be saved!");
								}
							});
							
							helpDockers.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									help.display("Dockers are windows that you can open to change features of the program. In a future release they will be able to merge with the main window.");
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
	
	public ToolDocker getTools() {
		return tool;
	}
	
	public String getToolName() {
		return tool.getSelectedTool().getName();
	}
	
	public void closeAllDockers() {
		for(int i = 0 ; i < dockers.length ; i++)
			dockers[i].close();
	}
}
