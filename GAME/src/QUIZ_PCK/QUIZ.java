package QUIZ_PCK;

import java.awt.*;
import Sql_server.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.text.JTextComponent;
import Sql_server.Sql_Data;

public class QUIZ implements ActionListener {
	String[] questions = { "which company invented java;", "when was java invented",
			"which was the presidnet of america" };
	String[][] options = { { "apple", "ibm", "microsoft", "linux" }, { "1989", "1893", "1928", "2000" },
			 };
	char[] answers = { 'C', 'D', 'C' };
	char guess;
	String answer;
	int index = 0;
	boolean result_of_ans;
	int correct_ans = 0;
	double result;
	int seconds = 10;
	Sql_Data sql = new Sql_Data();
	int total_quest =10;//**********************************************thelei allagi
	JFrame frame = new JFrame();
	JTextField Name_of_GAME = new JTextField();// ανω ετικετα με ονομα παιχνιδιου
	JTextArea quest_textarea = new JTextArea();// κατω ετικετα με ερωτησεις
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JLabel timelabel = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	JTextComponent textfield = new JTextField();
	JTextArea textarea = new JTextArea();

	Timer timer = new Timer(1000, new ActionListener() {//kathe sec 
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));// returns the string represantation of int
			if (seconds <= 0)
				displayAnswer();

		}
	});

	QUIZ() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(869, 735);
		frame.getContentPane().setBackground(Color.GRAY);// ΠΑΙΡΝΕΙ ΟΡΙΣΜΑ ΤΥΠΟΥ COLOR
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//to vazo sti mesi tis othonis
		Name_of_GAME.setForeground(Color.ORANGE);
		Name_of_GAME.setText("TRIVIAL ALA JAVA");
		Name_of_GAME.setBounds(0, 0, 855, 50);// where the textfield will be placed and height/width
		Name_of_GAME.setBackground(Color.DARK_GRAY);// TO background του frame του textfield
		//Name_of_GAME.setForeground(Color.YELLOW);// τα γραμματα του textfield
		Name_of_GAME.setFont(new Font("Calibri", Font.BOLD, 29));
		Name_of_GAME.setBorder(BorderFactory.createBevelBorder(1));
		Name_of_GAME.setHorizontalAlignment(JTextField.CENTER);
		Name_of_GAME.setEditable(false);
		quest_textarea.setEditable(false);
		// TEXTAREA
		quest_textarea.setBounds(0, 50, 855, 77);// changed
		quest_textarea.setLineWrap(true);
		quest_textarea.setWrapStyleWord(true);
		quest_textarea.setBackground(Color.DARK_GRAY);
		quest_textarea.setForeground(Color.ORANGE);
		quest_textarea.setFont(new Font("Monospace", Font.BOLD, 25));// changed
		quest_textarea.setBorder(BorderFactory.createBevelBorder(1));
		quest_textarea.setText(questions[index]);
		buttonA.setSelectedIcon(new ImageIcon("C:\\Users\\Philippos\\Downloads\\istockphoto-466873090-612x612.jpg"));
		buttonA.setHorizontalAlignment(SwingConstants.LEFT);
		buttonA.setBounds(36, 178, 789, 75);
		buttonA.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonA.setFocusable(false);// δεν το μαρκαρει οταν το πατας
		buttonA.addActionListener(this);
		// buttonA.setText(options[index][0]);//BAZEI ΤΕΧΤ ΣΤΑ ΚΟΥΜΠΙΑ
		buttonB.setHorizontalAlignment(SwingConstants.LEFT);// horizontal alignment at the begining
		buttonB.setBounds(36, 296, 789, 75);
		buttonB.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		// buttonB.setText(options[index][1]);
		buttonC.setHorizontalAlignment(SwingConstants.LEFT);
		buttonC.setBounds(36, 414, 789, 75);
		buttonC.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
										// Η ActionPerformed()
		// buttonD.setText(options[index][3]);
		// timer
		seconds_left.setBounds(749, 604, 106, 94);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("DigifaceWide", Font.BOLD, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		timelabel.setForeground(new Color(0, 0, 0));
		timelabel.setBackground(Color.BLACK);
		timelabel.setToolTipText("");
		timelabel.setText("TIMER:");
		timelabel.setBounds(749, 576, 106, 31);
		timelabel.setFont(new Font("Modern No. 20", Font.BOLD, 18));
		timelabel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(timelabel);
		frame.getContentPane().add(seconds_left);
		frame.getContentPane().add(buttonA);
		frame.getContentPane().add(buttonB);
		frame.getContentPane().add(buttonC);
		frame.getContentPane().add(quest_textarea);
		frame.getContentPane().add(Name_of_GAME);
		frame.setVisible(true);
		// call next question
		nextQuestion();
		
	}

	public void nextQuestion() {
		if (index >= total_quest  ) { // result_of_ans=false to vazo kai auto

			results();
		} else {
			textfield.setText("Question" + (index + 1));
			quest_textarea.setText(sql.getQuest(index));
			buttonA.setText(sql.getAns1(index));
			buttonB.setText(sql.getAns2(index));
			buttonC.setText(sql.getAns3(index));
			timer.start();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {// BUTTON CLICKING METHOD it will trigger something AUTOMATICALLY AFTER
												// AN EVENT
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);

		if (e.getSource() == buttonA) {
			answer = "Α";
			if (answer.equals(sql.getRight_ans(index)))  {
				correct_ans++;
			}
		}
		if (e.getSource() == buttonB) {
			answer = "Β";
			if (answer.equals(sql.getRight_ans(index)))  {
				correct_ans++;
			}
		}
		if (e.getSource() == buttonC) {
			answer = "Γ";
			if (answer.equals(sql.getRight_ans(index)))  {
				correct_ans++;
			}
		}

		displayAnswer();
	}

	public void displayAnswer() {
		timer.stop();
		timer.setRepeats(true);
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);


		if (sql.getRight_ans(index).equals("Α")) {
			buttonA.setForeground(new Color(0, 153, 0));
		} else {
			buttonA.setForeground(new Color(255, 0, 0));
		}

		if (sql.getRight_ans(index).equals("Β") ) {
			buttonB.setForeground(new Color(0, 153, 0));
		} else {
			buttonB.setForeground(new Color(255, 0, 0));
		}

		if (sql.getRight_ans(index).equals("Γ") ) {
			buttonC.setForeground(new Color(0, 153, 0));
		} else {
			buttonC.setForeground(new Color(255, 0, 0));
		}

		Timer pause = new Timer(2000, new ActionListener() {//TO FTIAXNOUME ME 2SEC DELAY ΓΙΑ ΝΑ ΓΥΡΝΑΕΙ ΣΤΑ ΑΡΧΙΚΑ ΧΡΩΜΑΤΑ ΜΕ ΚΑΘΕ ΕΠΟΜΕΝΗ ΕΡΩΤΗΣh
//οταν το timer ftasei ta 2sec θα γινει perform αυτο που ειναι μεσα στην action performed λδ αλλαγη χρωματων
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonA.setForeground(new Color(0, 0, 0));
				buttonB.setForeground(new Color(0, 0, 0));
				buttonC.setForeground(new Color(0, 0, 0));
				answer = "";
				seconds = 10;//παμε ξανα 10  τα δευτερολεπτα 
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				index++;
				nextQuestion();

			}
		});
		pause.setRepeats(false);//δεν εχει σχεση με το κατω timer απλα με την αλληλεπιδραση των χρωματων και το delay καθε ερωτησης.
		pause.start();
	
		
	}

	public void results() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		System.out.println(correct_ans);
		System.out.println(total_quest);
		result = ((correct_ans / (double) total_quest) * 100);
		System.out.println(result + "%");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
