package tetris;

import gameEngine.Cell;
import gameEngine.GameEngine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4416237109444279611L;

	private TetrisPanel tetrisPanel;

	private JButton pauseBtn;

	public void init(final GameController controller, GameEngine engine) {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		tetrisPanel = new TetrisPanel();
		tetrisPanel.init(controller, engine);
		add(tetrisPanel, BorderLayout.CENTER);

		JPanel bottons = new JPanel();
		bottons.setLayout(new BoxLayout(bottons, BoxLayout.LINE_AXIS));
		bottons.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		bottons.add(Box.createHorizontalGlue());

		pauseBtn = new JButton("Pause/Resume");
		pauseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (controller.isPaused()) {
					tetrisPanel.requestFocus();
					controller.resume();
				} else {
					controller.pause();
				}
			}
		});
		bottons.add(pauseBtn);

		add(bottons, BorderLayout.PAGE_END);
	}

	public void showGameOverMessage() {
		JOptionPane.showMessageDialog(this, "Game is over!");
	}

}

class TetrisPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385925708612132874L;

	public static final int WIDTH = 300;

	public static final int HEIGHT = 500;

	GameEngine engine;

	GameController controller;

	public void init(GameController controller, GameEngine engine) {
		this.engine = engine;
		this.controller = controller;

		addKeyListener(controller);
		setFocusable(true);
		requestFocus();
		setLayout(null);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.fillRect(0, 0, WIDTH, HEIGHT);

		paintStableCells(g2d);
		paintMovingCells(g2d);
	}

	private void paintStableCells(Graphics2D g2d) {
		Cell[] cells = engine.getStableCells();
		if (cells != null) {
			for (Cell c : cells) {
				Color color = c.getColor();
				paintCell(g2d, c, color);
			}
		}
	}

	private void paintMovingCells(Graphics2D g2d) {
		Cell[] cells = engine.getMovablePiece();
		if (cells != null) {
			for (Cell c : cells) {
				Color orig = c.getColor();
				Color color = new Color(orig.getRed(), orig.getGreen(),
						orig.getBlue(), 120);
				paintCell(g2d, c, color);
			}
		}
	}

	private void paintCell(Graphics2D g2d, Cell cell, Color color) {
		int x = cell.getColumn() * 30 + 1;
		int y = HEIGHT - (cell.getY() + 30) + 1;

		g2d.setColor(color.darker());
		g2d.fillRoundRect(x, y, 28, 28, 3, 3);

		g2d.setColor(color);
		g2d.fillRoundRect(x + 2, y + 2, 24, 24, 10, 10);
	}
}