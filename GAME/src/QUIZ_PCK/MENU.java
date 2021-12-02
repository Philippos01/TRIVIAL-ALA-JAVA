package QUIZ_PCK;
import java.awt.*;
import Sql_server.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import QUIZ_PCK.QUIZ.State;

import javax.swing.text.JTextComponent;

public class MENU  {
/**
 * @wbp.parser.entryPoint
 */
public void render() {
CHOOSE_CAT cat=new CHOOSE_CAT();
JFrame frame = new JFrame();
frame.setResizable(false);
JTextField Name_of_GAME = new JTextField();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(700, 700);
frame.getContentPane().setBackground(Color.GRAY);// ΠΑΙΡΝΕΙ ΟΡΙΣΜΑ ΤΥΠΟΥ COLOR
frame.getContentPane().setLayout(null);
frame.setLocationRelativeTo(null);//to vazo sti mesi tis othonis
Name_of_GAME.setForeground(Color.ORANGE);
Name_of_GAME.setText("TRIVIAL ALA JAVA");
Name_of_GAME.setBounds(0, 0, 697, 50);// where the textfield will be placed and height/width
Name_of_GAME.setBackground(Color.DARK_GRAY);// TO background του frame του textfield
//Name_of_GAME.setForeground(Color.YELLOW);// τα γραμματα του textfield
Name_of_GAME.setFont(new Font("Calibri", Font.BOLD, 29));
Name_of_GAME.setBorder(BorderFactory.createBevelBorder(1));
Name_of_GAME.setHorizontalAlignment(JTextField.CENTER);
Name_of_GAME.setEditable(false);
frame.getContentPane().add(Name_of_GAME);
JButton btnNewButton = new JButton("PLAY");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		cat.choose();
		/*try {
			QUIZ quiz = new QUIZ(State.GAME, null);
		} catch (ErrorClass e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton.setBounds(258, 143, 164, 142);
btnNewButton.setFocusable(false);
frame.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("EXIT GAME");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton_1.setBounds(258, 393, 164, 142);
btnNewButton_1.setFocusable(false);
frame.getContentPane().add(btnNewButton_1);
JLabel lblNewLabel = new JLabel("");
lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Philippos\\Downloads\\MENUBACK.v1.jpg"));
lblNewLabel.setBounds(0, 43, 686, 620);
frame.getContentPane().add(lblNewLabel);
frame.setVisible(true);
}
}									



/*btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
}
});*/