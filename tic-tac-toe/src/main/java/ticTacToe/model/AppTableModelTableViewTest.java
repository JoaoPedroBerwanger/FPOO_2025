package ticTacToe.model;

import java.net.URL;
import javax.swing.ImageIcon;
import ticTacToe.gui.util.window.MainWindow;
import ticTacToe.gui.util.window.TableView;
import ticTacToe.model.table.SimpleTableModel;
import ticTacToe.model.Mark;

public class AppTableModelTableViewTest {

	SimpleTableModel tableModel = new SimpleTableModel();
	MainWindow window = new MainWindow();
	TableView tableView = createTableView();

	private ImageIcon loadImage(String fileName)
	{
	    String path = "/ticTacToe/images/" + fileName;
	    URL url = getClass().getResource(path);

	    if (url == null) {
	        System.err.println("Imagem não encontrada: " + path);
	    } else {
	        System.out.println("Imagem carregada: " + url);
	    }

	    return new ImageIcon(url);
	}

	private TableView createTableView() {
		ImageIcon icon = loadImage("tic-tac-toe.png");
		TableView table = new TableView(50, 50, 200, 200, null);

		icon = loadImage("markX.png");
		table.setIconX(icon);

		icon = loadImage("markO.png");
		table.setIconO(icon);

		return table;
	}

	public AppTableModelTableViewTest() {

		ImageIcon iconX = loadImage("markX.png");
		ImageIcon iconO = loadImage("markO.png");

		tableView.setIconX(iconX);
		tableView.setIconO(iconO);

		ImageIcon icon = loadImage("background.jpg");
		window.setBackground(icon);

		window.add(tableView);
	}

	private void play() throws Exception {
		Thread.sleep(1000);
		tableModel.setMark(1, 1, Mark.X);
		tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(0, 0, Mark.O);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(0, 1, Mark.X);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(2, 1, Mark.O);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(2, 0, Mark.X);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(0, 2, Mark.O);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(1, 0, Mark.X);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(1, 2, Mark.O);
		//tableView.repaint();

		Thread.sleep(1000);
		tableModel.setMark(2, 2, Mark.X);
		//tableView.repaint();
	}

	public static void main(String[] args) throws Exception {
		AppTableModelTableViewTest app = new AppTableModelTableViewTest();
		app.play();
	}
}
