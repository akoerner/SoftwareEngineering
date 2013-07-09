package common.lib.GUITools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class GUITools {

	private GUITools(){}
	
	public static Font getRandomFont(int size) {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] fontFamilies = ge.getAvailableFontFamilyNames();
		Random randomGenerator = new Random();
		return new Font(
				fontFamilies[randomGenerator.nextInt(fontFamilies.length)],
				Font.BOLD, size);
	}

	public static Color getRandomColor() {
		Random randomGenerator = new Random();
		return new Color(randomGenerator.nextInt(255),
				randomGenerator.nextInt(255), randomGenerator.nextInt(255));
	}

	public static Font loadTTFFontFromFile(String fileName, float size) {
		Font font = null;
		try {
			File f = new File (fileName); 
			System.out.println(f.getAbsolutePath());
			FileInputStream in = new FileInputStream (f);
			Font dynamicFont = Font.createFont (Font.TRUETYPE_FONT, in);
			return dynamicFont.deriveFont (size);
		} catch (Exception ex) {
			font = new Font("serif", Font.PLAIN, 24);
		}
		return font;
	}

	public static void setNativeLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
	}

	public static void setJavaLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting Java LAF: " + e);
		}
	}

	public static void setMotifLookAndFeel() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error setting Motif LAF: " + e);
		}
	}
	
	public static Point getScreenCenterPoint(){
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    return new Point(dim.width/2, dim.height/2);
	}
	
	public static void makeSwingComponentTransparent(float transparencyLevel, JComponent component){
		try {
		    Class<?> awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
		    Method method = awtUtilitiesClass.getMethod("setWindowOpacity", Window.class, float.class); 
		    method.invoke(null, component, transparencyLevel);
		} catch (Exception exc) {
		    exc.printStackTrace();
		}
	}
	
	public static String javaCamelCaseToHuman(String s) {
		 s = (s.charAt(0) + "").toUpperCase() + s.substring(1);
		return s.replaceAll(
		      String.format("%s|%s|%s",
		         "(?<=[A-Z])(?=[A-Z][a-z])",
		         "(?<=[^A-Z])(?=[A-Z])",
		         "(?<=[A-Za-z])(?=[^A-Za-z])"
		      ),
		      " "
		   );
	}
	
	public static String humanToJavaCamelCase(String s) {
		
		s = s.replaceAll(" ", "");
		return (s.charAt(0) + "").toLowerCase() + s.substring(1);
	}
	
	
	
}
