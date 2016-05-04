package tetris;

import gameEngine.GameEngine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Tetris {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}

	private static void createAndShowGui() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel panel = new GamePanel();
		frame.getContentPane().add(panel);

		GameEngine engine = new GameEngine();

		GameController controller = new GameController();

		panel.init(controller, engine);
		controller.init(panel, engine);
		controller.start();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
