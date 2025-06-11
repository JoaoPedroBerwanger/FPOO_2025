package appTest;

import java.awt.Button;
import java.net.URL;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ImageButton;
import ticTacToe.gui.util.window.MainWindow;
import ticTacToe.gui.util.window.Paintable;

public class AppImageButtonTest {
	
	public static void main(String[] args) {
		final String path = "../ticTacToe/images/";
		URL url = AppImageButtonTest.class.getResource(path+ "background.jpg");ImageIcon icon = new ImageIcon(url);
		ImageButton button = new ImageButton(100,100,50,50, icon);
		MainWindow window = new MainWindow();
		window.add(button);
		window.addMouseListener(button.mouseListener());
		window.addMouseMotionListener(button.mouseMotionListener());
		}
}