package fxFiles;

/*
 * Peter Gauld
 * FX Resource Handler - This program is meant to help with error handling for resources when setting components in Java FX.
 * 
 * 2/15/2022 - File Created.
 */

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FxResourceHandler {
	public static void addStageIcon(Stage iconify, String icon) {
		//This method is to use a try catch for error handling the in case image is not available.
		try {
			iconify.getIcons().add(new Image("resources/" + icon));
		}
		catch(Exception e) {
			System.out.println("Error Retrieving Image: " + icon);
		}
	}		
}
