package appTest;

import ticTacToe.component.button.ImageButton;
import ticTacToe.gui.util.window.MainWindow;

public class AppImageButtonTest {
	
  public static void main(String[] args) {

	 MainWindow window = new MainWindow();
	 ImageButton button = new ImageButton(100,100, 50, 50, "/ticTacToe/images/background.jpg");
	 window.add(button);
	 window.addMouseListener(button.mouseListener());
	 window.addMouseMotionListener(button.mouseMotionListener());

	 button.addButtonClickListener((event)->{
			System.out.println("Botão clicado" + event.source);
			System.out.println("Point: " + event.source.getPosition());
			System.out.println("Dimension: " + event.source.getSize());
			System.out.println("MouseButton: " + event.mouseButton.name());
		});
  	}
}