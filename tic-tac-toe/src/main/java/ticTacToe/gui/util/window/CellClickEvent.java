package ticTacToe.gui.util.window;

public final class CellClickEvent {
	
	public final int lin;
	public final int col;
	
	public CellClickEvent(int lin, int col){
		this.lin = lin;
		this.col = col;
	}
}
