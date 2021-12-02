	package QUIZ_PCK;

import java.awt.*;
import Sql_server.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.text.JTextComponent;
import Sql_server.*;

public class QUIZ implements ActionListener {
	String[] questions = { "which company invented java;", "when was java invented",
			"which was the presidnet of america" };
	String[][] options = { { "apple", "ibm", "microsoft", "linux" }, { "1989", "1893", "1928", "2000" },
			 };
	char[] answers = { 'C', 'D', 'C' };
	char guess;
	String answer;
	String parameter;
	static String category;
	public static int index = 0;
	boolean result_of_ans;
	static int correct_ans = 0;
	double result;
	int seconds = 10;
	QuestionsDao sql_quest = new QuestionsDao();
	static int total_quest ;//**********************************************thelei allagi
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
	MENU menu=new MENU();

	Timer timer = new Timer(1000, new ActionListener() {//kathe sec 
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));// returns the string represantation of int
			if (seconds <= 0)
				try {
					displayAnswer();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		}
	});
	public enum State{
		MENU,
		GAME,
		
	}
	QUIZ(){
		
	}

	QUIZ(State STATE,String mode) throws ErrorClass {
		if (STATE==State.GAME) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 800);
		frame.getContentPane().setBackground(Color.GRAY);// ΠΑΙΡΝΕΙ ΟΡΙΣΜΑ ΤΥΠΟΥ COLOR
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//to vazo sti mesi tis othonis
		Name_of_GAME.setForeground(Color.ORANGE);
		Name_of_GAME.setText("TRIVIAL ALA JAVA");
		Name_of_GAME.setOpaque(result_of_ans);
		Name_of_GAME.setBounds(0, 0, 886, 50);// where the textfield will be placed and height/width
		Name_of_GAME.setBackground(Color.DARK_GRAY);// TO background του frame του textfield
		//Name_of_GAME.setForeground(Color.YELLOW);// τα γραμματα του textfield
		Name_of_GAME.setFont(new Font("Calibri", Font.BOLD, 29));
		Name_of_GAME.setBorder(BorderFactory.createBevelBorder(1));
		Name_of_GAME.setHorizontalAlignment(JTextField.CENTER);
		Name_of_GAME.setEditable(false);
		quest_textarea.setEditable(false);
		// TEXTAREA
		quest_textarea.setBounds(0, 49, 886, 75);// changed
		quest_textarea.setLineWrap(true);
		quest_textarea.setWrapStyleWord(true);
		quest_textarea.setBackground(Color.DARK_GRAY);
		quest_textarea.setForeground(Color.ORANGE);
		quest_textarea.setFont(new Font("Monospace", Font.BOLD, 25));// changed
		quest_textarea.setBorder(BorderFactory.createBevelBorder(1));
		quest_textarea.setText(questions[index]);
		buttonA.setSelectedIcon(new ImageIcon("C:\\Users\\Philippos\\Downloads\\istockphoto-466873090-612x612.jpg"));
		buttonA.setHorizontalAlignment(SwingConstants.LEFT);
		buttonA.setBounds(136, 336, 620, 75);
		buttonA.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonA.setFocusable(false);// δεν το μαρκαρει οταν το πατας
		buttonA.addActionListener(this);
		// buttonA.setText(options[index][0]);//BAZEI ΤΕΧΤ ΣΤΑ ΚΟΥΜΠΙΑ
		buttonB.setHorizontalAlignment(SwingConstants.LEFT);// horizontal alignment at the begining
		buttonB.setBounds(136, 443, 620, 75);
		buttonB.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		// buttonB.setText(options[index][1]);
		buttonC.setHorizontalAlignment(SwingConstants.LEFT);
		buttonC.setBounds(136, 542, 620, 75);
		buttonC.setFont(new Font("Monospace", Font.PLAIN, 20));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
										// Η ActionPerformed()
		// buttonD.setText(options[index][3]);
		// timer
		seconds_left.setBounds(780, 669, 106, 94);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("DigifaceWide", Font.BOLD, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		timelabel.setForeground(Color.RED);
		timelabel.setBackground(Color.RED);
		timelabel.setToolTipText("");
		timelabel.setText("TIMER:");
		timelabel.setBounds(780, 639, 106, 31);
		timelabel.setFont(new Font("Modern No. 20", Font.BOLD, 18));
		timelabel.setHorizontalAlignment(JTextField.CENTER);
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Philippos\\Desktop\\LOGOS\\prog2 back\\background.jpg"));
		lblNewLabel_2.setBounds(0, 121, 886, 642);
		frame.getContentPane().add(timelabel);
		frame.getContentPane().add(seconds_left);
		frame.getContentPane().add(buttonA);
		frame.getContentPane().add(buttonB);
		frame.getContentPane().add(buttonC);
		frame.getContentPane().add(quest_textarea);
		frame.getContentPane().add(Name_of_GAME);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		// call next question
		if(mode=="HE") {
			category="HE";
			total_quest=10;
		nextQuestionEH();}
		else if(mode=="HH") {
			category="HH";
			total_quest=10;
		nextQuestionHH();
		}
		else if(mode=="EM") {
			category="EM";
			total_quest=14;
			nextQuestionEM();
		}
		else {
			category="HM";
			total_quest=12;
			nextQuestionHM();
		}
		}
		else if(STATE==State.MENU) {
			menu.render();
		}
		try {
			
		}
		catch(Exception e) {
			throw new ErrorClass(e.getMessage());
		}
		}

	public void nextQuestionEH() throws ErrorClass {
		if (index >= total_quest  ) { // result_of_ans=false to vazo kai auto
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			Results r=new Results();
			r.seeResults();
		} else {
			try {
			textfield.setText("Question" + (index + 1));
			quest_textarea.setText(sql_quest.getQuestionsEH().get(index).getQuest1());
			buttonA.setText(sql_quest.getQuestionsEH().get(index).getAns1());
			buttonB.setText(sql_quest.getQuestionsEH().get(index).getAns2());
			buttonC.setText(sql_quest.getQuestionsEH().get(index).getAns3());
			parameter="EH";
			timer.start();}
			catch (Exception e){
				throw new ErrorClass(e.getMessage());
			}
		}

	}
	public void nextQuestionEM() throws ErrorClass {
		if (index >= total_quest  ) { // result_of_ans=false to vazo kai auto
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			Results r=new Results();
			r.seeResults();
		} else {
			try {
			textfield.setText("Question" + (index + 1));
			quest_textarea.setText(sql_quest.getQuestionsEM().get(index).getQuest1());
			buttonA.setText(sql_quest.getQuestionsEM().get(index).getAns1());
			buttonB.setText(sql_quest.getQuestionsEM().get(index).getAns2());
			buttonC.setText(sql_quest.getQuestionsEM().get(index).getAns3());
			parameter="EM";
			timer.start();}
			catch (Exception e){
				throw new ErrorClass(e.getMessage());
			}
		}

	}

	public void nextQuestionHH() throws ErrorClass {
		if (index >= total_quest  ) { // result_of_ans=false to vazo kai auto
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			Results r=new Results();
			r.seeResults();
		} else {
			try {
			textfield.setText("Question" + (index + 1));
			quest_textarea.setText(sql_quest.getQuestionsHH().get(index).getQuest1());
			buttonA.setText(sql_quest.getQuestionsHH().get(index).getAns1());
			buttonB.setText(sql_quest.getQuestionsHH().get(index).getAns2());
			buttonC.setText(sql_quest.getQuestionsHH().get(index).getAns3());
			parameter="HH";
			timer.start();}
			catch (Exception e){
				throw new ErrorClass(e.getMessage());
			}
		}

	}

	public void nextQuestionHM() throws ErrorClass {
		if (index >= total_quest  ) { // result_of_ans=false to vazo kai auto
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			Results r=new Results();
			r.seeResults();
		} else {
			try {
			textfield.setText("Question" + (index + 1));
			quest_textarea.setText(sql_quest.getQuestionsHM().get(index).getQuest1());
			buttonA.setText(sql_quest.getQuestionsHM().get(index).getAns1());
			buttonB.setText(sql_quest.getQuestionsHM().get(index).getAns2());
			buttonC.setText(sql_quest.getQuestionsHM().get(index).getAns3());
			parameter="HM";
			timer.start();}
			catch (Exception e){
				throw new ErrorClass(e.getMessage());
			}
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
			try {
				if(category=="HE") {
				if (answer.equals(sql_quest.getQuestionsEH().get(index).getFinal_ans()))  {
					correct_ans++;
				}
				}
				else if(category=="HH") {
					if (answer.equals(sql_quest.getQuestionsHH().get(index).getFinal_ans()))  {
						correct_ans++;
					}
				}
				else if(category=="EM") {
					if (answer.equals(sql_quest.getQuestionsEM().get(index).getFinal_ans()))  {
						correct_ans++;
					}
				}
				else {
					if (answer.equals(sql_quest.getQuestionsHM().get(index).getFinal_ans()))  {
						correct_ans++;
					}
				}
				}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
		else if (e.getSource() == buttonB) {
			answer = "Β";
			try {
				if(category=="HE") {
					if (answer.equals(sql_quest.getQuestionsEH().get(index).getFinal_ans()))  {
						correct_ans++;
					}
					}
					else if(category=="HH") {
						if (answer.equals(sql_quest.getQuestionsHH().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
					else if(category=="EM") {
						if (answer.equals(sql_quest.getQuestionsEM().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
					else {
						if (answer.equals(sql_quest.getQuestionsHM().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
				}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == buttonC) {
			answer = "Γ";
			try {
				if(category=="HE") {
					if (answer.equals(sql_quest.getQuestionsEH().get(index).getFinal_ans()))  {
						correct_ans++;
					}
					}
					else if(category=="HH") {
						if (answer.equals(sql_quest.getQuestionsHH().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
					else if(category=="EM") {
						if (answer.equals(sql_quest.getQuestionsEM().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
					else {
						if (answer.equals(sql_quest.getQuestionsHM().get(index).getFinal_ans()))  {
							correct_ans++;
						}
					}
				}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		try {
			displayAnswer();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void displayAnswer() throws Exception {
		timer.stop();
		timer.setRepeats(true);
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);

		if(category=="HE") {
		if (sql_quest.getQuestionsEH().get(index).getFinal_ans().equals("Α")) {
			buttonA.setForeground(new Color(0, 153, 0));
		} else {
			buttonA.setForeground(new Color(255, 0, 0));
		}

		if (sql_quest.getQuestionsEH().get(index).getFinal_ans().equals("Β") ) {
			buttonB.setForeground(new Color(0, 153, 0));
		} else {
			buttonB.setForeground(new Color(255, 0, 0));
		}

		if (sql_quest.getQuestionsEH().get(index).getFinal_ans().equals("Γ") ) {
			buttonC.setForeground(new Color(0, 153, 0));
		} else {
			buttonC.setForeground(new Color(255, 0, 0));
		}
		}
		if(category=="HH") {
			if (sql_quest.getQuestionsHH().get(index).getFinal_ans().equals("Α")) {
				buttonA.setForeground(new Color(0, 153, 0));
			} else {
				buttonA.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsHH().get(index).getFinal_ans().equals("Β") ) {
				buttonB.setForeground(new Color(0, 153, 0));
			} else {
				buttonB.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsHH().get(index).getFinal_ans().equals("Γ") ) {
				buttonC.setForeground(new Color(0, 153, 0));
			} else {
				buttonC.setForeground(new Color(255, 0, 0));
			}
			}
		if(category=="EM") {
			if (sql_quest.getQuestionsEM().get(index).getFinal_ans().equals("Α")) {
				buttonA.setForeground(new Color(0, 153, 0));
			} else {
				buttonA.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsEM().get(index).getFinal_ans().equals("Β") ) {
				buttonB.setForeground(new Color(0, 153, 0));
			} else {
				buttonB.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsEM().get(index).getFinal_ans().equals("Γ") ) {
				buttonC.setForeground(new Color(0, 153, 0));
			} else {
				buttonC.setForeground(new Color(255, 0, 0));
			}
			}
		if(category=="HM") {
			if (sql_quest.getQuestionsHM().get(index).getFinal_ans().equals("Α")) {
				buttonA.setForeground(new Color(0, 153, 0));
			} else {
				buttonA.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsHM().get(index).getFinal_ans().equals("Β") ) {
				buttonB.setForeground(new Color(0, 153, 0));
			} else {
				buttonB.setForeground(new Color(255, 0, 0));
			}

			if (sql_quest.getQuestionsHM().get(index).getFinal_ans().equals("Γ") ) {
				buttonC.setForeground(new Color(0, 153, 0));
			} else {
				buttonC.setForeground(new Color(255, 0, 0));
			}
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
				try {
					if(parameter=="EH") {
					nextQuestionEH();}
					else if(parameter=="HM") {
						nextQuestionHM();}
					else if(parameter=="HH") {
						nextQuestionHH();}
					else if	(parameter=="EM") {
						nextQuestionEM();}
				} catch (ErrorClass e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		pause.setRepeats(false);//δεν εχει σχεση με το κατω timer απλα με την αλληλεπιδραση των χρωματων και το delay καθε ερωτησης.
		pause.start();
	
		
	}

	public  String results() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		result = ((correct_ans / (double) total_quest) * 100);
		String results="You answered "+ correct_ans +" out of "+ total_quest +" questions right\n givng a correct chance of "+ result+"%\n THANKS FOR PLAYING:)";
		return results;
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
