package appTest;

import ticTacToe.component.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonPaintableTest {

	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		
		Button button = new Button(10, 10, 5, 5);
		window.add(button);
	}
}
