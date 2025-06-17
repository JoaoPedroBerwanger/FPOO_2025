package ticTacToe.gui.util.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ImageButton;
import ticTacToe.model.Mark;
import ticTacToe.model.table.ReadOnlyTableModel;

public class TableView extends AbstractComponent implements Paintable {	
	
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
	    int cellWidth = (width() - 20) / 3;
	    int cellHeight = (height() - 20) / 3;
	    
	    for (int lin = 0; lin < table.length; lin++) {
	        for (int col = 0; col < table[lin].length; col++) {
	            int x = position.x + (col * (cellWidth + 5));
	            int y = position.y + (lin * (cellHeight + 5));
	            
	            table[lin][col] = new ImageButton(x, y, cellWidth, cellHeight, null);
	        }
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
	
	public void paintChildren(Graphics g)
	{
		if(tableModel == null)
			throw new RuntimeException("Error: TableModel is null at TableView!");

		for(int lin = 0; lin < table.length; lin++) {
			for(int col = 0; col < table[lin].length; col++) {
				Mark mark = tableModel.getMark(lin, col);
				System.out.println("Desenhando [" + lin + "][" + col + "] = " + mark);
				
				table[lin][col].setImage(iconOf(mark));
				table[lin][col].paint(g);
			}
		}
	}
	
	List<CellClickListener> cellClickListeners = new ArrayList<>();
	
	public void addCellClickListener(CellClickListener listener) {
		cellClickListeners.add(listener);
	}
	
	public void removeCellClickListener(CellClickListener listener) {
		cellClickListeners.remove(listener);
	}
	
	private void dispatchCellClickEvent(int lin, int col) {
		CellClickEvent event = new CellClickEvent(lin, col);
		cellClickListeners.forEach(listener -> listener.onClick(event));
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
		
		paintChildren(g);
	}
	
	@Override
	protected void onMouseMove(MouseEvent me){
		
		for(int lin=0; lin<table.length; lin++) {
			for(int col=0; col<table[lin].length; col++) {
				
				if(table[lin][col].isOver(me.getPoint()))
					dispatchCellClickEvent(lin, col);
			}
		}
	}
}
