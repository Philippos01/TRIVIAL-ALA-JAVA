package QUIZ_PCK;
import java.awt.*;
import Sql_server.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.text.JTextComponent;

import QUIZ_PCK.QUIZ.State;

public class CHOOSE_CAT {
/**
 * @wbp.parser.entryPoint
 */
public void choose(){
JTextField textField=new JTextField();
JFrame frame = new JFrame();
frame.setResizable(false);
JTextField Name_of_GAME = new JTextField();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(700, 600);
frame.getContentPane().setBackground(Color.GRAY);// ΠΑΙΡΝΕΙ ΟΡΙΣΜΑ ΤΥΠΟΥ COLOR
frame.getContentPane().setLayout(null);
frame.setLocationRelativeTo(null);//to vazo sti mesi tis othonis
Name_of_GAME.setForeground(Color.ORANGE);
Name_of_GAME.setText("TRIVIAL ALA JAVA");
Name_of_GAME.setBounds(0, 0, 686, 50);// where the textfield will be placed and height/width
Name_of_GAME.setBackground(Color.DARK_GRAY);// TO background του frame του textfield
//Name_of_GAME.setForeground(Color.YELLOW);// τα γραμματα του textfield
Name_of_GAME.setFont(new Font("Calibri", Font.BOLD, 29));
Name_of_GAME.setBorder(BorderFactory.createBevelBorder(1));
Name_of_GAME.setHorizontalAlignment(JTextField.CENTER);
Name_of_GAME.setEditable(false);
frame.getContentPane().add(Name_of_GAME);
JLabel lblNewLabel_1 = new JLabel("TAKE A HISTORY QUIZ!\r\n\r\n");
lblNewLabel_1.setForeground(new Color(240, 248, 255));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel_1.setBounds(57, 50, 235, 50);
frame.getContentPane().add(lblNewLabel_1);
JButton btnNewButton = new JButton("EASY MODE");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			QUIZ quiz = new QUIZ(State.GAME,"HE");
		} catch (ErrorClass e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton.setBounds(37, 156, 272, 95);
frame.getContentPane().add(btnNewButton);
JLabel lblNewLabel = new JLabel("TAKE A MYTHOLOGY QUIZ!\r\n");
lblNewLabel.setForeground(new Color(240, 255, 255));
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel.setBounds(383, 50, 282, 50);
frame.getContentPane().add(lblNewLabel);
textField = new JTextField();
textField.setBounds(350, 50, 3, 513);
frame.getContentPane().add(textField);
textField.setColumns(10);
JButton btnNewButton_1 = new JButton("HARD MODE");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			QUIZ quiz = new QUIZ(State.GAME,"HH");
		} catch (ErrorClass e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton_1.setBounds(37, 337, 272, 95);
frame.getContentPane().add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("EASY MODE");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			QUIZ quiz = new QUIZ(State.GAME,"EM");
		} catch (ErrorClass e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});
btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton_2.setBounds(393, 156, 272, 95);
frame.getContentPane().add(btnNewButton_2);
JButton btnNewButton_3 = new JButton("HARD MODE");
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			QUIZ quiz = new QUIZ(State.GAME,"HM");
		} catch (ErrorClass e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});
btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton_3.setBounds(393, 341, 272, 95);
frame.getContentPane().add(btnNewButton_3);
JLabel lblNewLabel_2 = new JLabel();
lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Philippos\\Downloads\\MENUBACK.v1.jpg"));
lblNewLabel_2.setBounds(0, 50, 686, 513);
frame.getContentPane().add(lblNewLabel_2);
frame.setVisible(true);
}
}
