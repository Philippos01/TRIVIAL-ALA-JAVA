package QUIZ_PCK;
import java.awt.*;
import Sql_server.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.text.JTextComponent;

import QUIZ_PCK.QUIZ.State;


public class Results {
/**
 * @wbp.parser.entryPoint
 */
public void seeResults() {
	JFrame frame = new JFrame();
	frame.setResizable(false);
	JTextField Name_of_GAME = new JTextField();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(393, 400);
	frame.getContentPane().setBackground(Color.GRAY);// ΠΑΙΡΝΕΙ ΟΡΙΣΜΑ ΤΥΠΟΥ COLOR
	frame.getContentPane().setLayout(null);
	frame.setLocationRelativeTo(null);//to vazo sti mesi tis othonis
	Name_of_GAME.setForeground(Color.ORANGE);
	Name_of_GAME.setText("TRIVIAL ALA JAVA");
	Name_of_GAME.setBounds(0, 0, 379, 50);// where the textfield will be placed and height/width
	Name_of_GAME.setBackground(Color.DARK_GRAY);// TO background του frame του textfield
	//Name_of_GAME.setForeground(Color.YELLOW);// τα γραμματα του textfield
	Name_of_GAME.setFont(new Font("Calibri", Font.BOLD, 29));
	Name_of_GAME.setBorder(BorderFactory.createBevelBorder(1));
	Name_of_GAME.setHorizontalAlignment(JTextField.CENTER);
	Name_of_GAME.setEditable(false);
	frame.getContentPane().add(Name_of_GAME);
	
	JLabel lblNewLabel = new JLabel("Congratulations! Here is your summary:");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblNewLabel.setBounds(10, 45, 369, 45);
	frame.getContentPane().add(lblNewLabel);
	
	JTextArea textArea = new JTextArea(new QUIZ().results());
	textArea.setBackground(Color.LIGHT_GRAY);
	textArea.setFont(new Font("Dialog", Font.PLAIN, 17));
	textArea.setBounds(0, 96, 379, 267);
	frame.getContentPane().add(textArea);
	frame.setVisible(true);
}
}
