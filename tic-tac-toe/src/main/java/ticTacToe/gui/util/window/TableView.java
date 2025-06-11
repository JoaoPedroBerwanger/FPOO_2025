package ticTacToe.gui.util.window;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ImageButton;
import ticTacToe.model.Mark;

public class TableView extends AbstractComponent {	
	
	private ImageIcon iconO = null;
	private ImageIcon iconX = null;
	private ImageButton[][] table = new ImageButton[3][3];
	private ReadOnlyTableModel tableModel;
	
	public TableView()
	{
		super();
		super.dimension = new Dimension(100, 100);
		fillTable();
	}
	
	public TableView(ImageIcon icon)
	{
		this();
		this.icon = icon;
	}

	public TableView(int x, int y, int widht, int height, ImageIcon icon)
	{
		super(x, y, widht, height);
		this.icon = icon;
		fillTable();
	}
	
	private void fillTable() 
	{
		int cellWidht = (width()-20/3);
		int cellHeight = (height()-20/3);
		
		for(int lin=0; lin<table.length; lin++)
			for(int col=0; col<table[lin].length; col++)
			{
				int x = 5 + (lin * (cellHeight + 5));
				int y = 5 + (col * (cellWidht + 5));
				
				table[lin][col] = new ImageButton(x, y, cellWidht, cellHeight, null);
			}
	}
	
	public void setIconX(ImageIcon icon)
	{
		this.iconX = icon;
	}
	
	public void setIconO(ImageIcon icon)
	{
		this.iconO = icon;
	}
	
	public ImageIcon iconOf(Mark mark)
	{
		return ((mark == Mark.O) ? iconO :
				((mark == Mark.X) ? iconX : null));
	}
	
	public void setTableModel(ReadOnlyTableModel tableModel)
	{
		this.tableModel = tableModel;
	}
	
	private void paintChildren(Graphics g)
	{
		if(tableModel == null)
			throw new RuntimeExeption("Error: TableModel is null at TableView!");
		
		for(int lin=0; lin<table.length; lin++)
			for(int col=0; col<table[lin].length; col++)
				Mark mark = tableModel.getMark(lin, col);
				table[lin][col].setImage(iconOf(mark));
				table[lin][col].paint(g);
	}
	
	@Override
	public void paint(Graphics g)
	{	
		if(icon == null)
			return;
		
		int xLeft = position.x;
		int yTop = position.y;
		int width = dimension.width;
		int heigth = dimension.height;
		
		g.drawImage(icon.getImage(), xLeft, yTop, width, heigth, null);	
	}
}
