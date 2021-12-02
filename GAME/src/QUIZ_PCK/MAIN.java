package QUIZ_PCK;

import QUIZ_PCK.QUIZ.State;
import Sql_server.ErrorClass;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			QUIZ quiz = new QUIZ(State.MENU,"");
		} catch (ErrorClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
