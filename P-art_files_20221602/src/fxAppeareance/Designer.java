package fxAppeareance;

/*
 * Peter Gauld
 * Java FX Designer - A class meant to contain functions for helping to design FX components.
 * 
 * 2/14/2022 - File created.
 */

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Designer {
	//Background Methods.
		public static Background getBackground(int red, int green, int blue) {
			return new Background(new BackgroundFill[] {new BackgroundFill(Color.rgb(red, green, blue), null, null)});
		}
	
		public static Background getBackground(int red, int green, int blue, int opacity) {
			return new Background(new BackgroundFill[] {new BackgroundFill(Color.rgb(red, green, blue, opacity), null, null)});
		}
		
		public static Background getBackground(Color color) {
			return new Background(new BackgroundFill[] {new BackgroundFill(color, null, null)});
		}
	
	//Color Methods.
		public static Color getColor(int red, int green, int blue) {
			return Color.rgb(red, green, blue);
		}
		
		public static Color getColor(double red, double green, double blue, double opacity) {
			return new Color(red, green, blue, opacity);
		}
		
	//Text Method
		public static Text getText(String say, Color color) {
			Text text = new Text(say);
			text.setFill(color);
			
			return text;
		}
		
		public static Text getText(String say, int red, int green, int blue) {
			Text text = new Text(say);
			text.setFill(Color.rgb(red, green, blue));
			
			return text;
		}
}
