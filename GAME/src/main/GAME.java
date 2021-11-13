package main;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
public class GAME extends JFrame {
	private GameScreen gameS;
	private BufferedImage img;
	public GAME() {
		impimg();
		setSize(640,640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gameS=new GameScreen( img);
		add(gameS);
	}
private void impimg() {
	InputStream IMG =getClass().getResourceAsStream("/GAME.jpg");
	try {
		img=ImageIO.read(IMG);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	}
