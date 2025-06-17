package ticTacToe.model.score;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.TextButton;

public class ScoreView extends AbstractComponent {

    private ReadOnlyScoreModel scoreModel;
    private TextButton scoreX;
    private TextButton scoreY;
    private ImageIcon background;

    public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel) {
    	
        super(x, y, width, height);
        this.scoreModel = scoreModel;

        scoreX = new TextButton(20, 20, 80, 40, "X: " + scoreModel.scoreX());
        scoreY = new TextButton(width - 100, 20, 80, 40, "O: " + scoreModel.scoreO());

        add(scoreX);
        add(scoreY);
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

	@Override
	public void paint(Graphics g) {
        
		if (background != null) {
            g.drawImage(background.getImage(), position.x, position.y, dimension.width, dimension.height, null);
        }

        scoreX.setText("X: " + scoreModel.scoreX());
        scoreY.setText("O: " + scoreModel.scoreO());

        paintChildren(g);
	}
}
