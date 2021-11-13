package main;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameScreen extends JPanel{
private BufferedImage img;
public GameScreen(BufferedImage img){
this.img=img;
}
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img,0,0,null);
}	
}

