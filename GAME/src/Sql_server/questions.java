package Sql_server;
public class questions {  
    private int numb_of_quest;
	private String quest1;
	private String ans1;
	private String ans2;
	private String ans3;
	private String final_ans;

    /**
     * Full constructor
     *   
     * @param numb_of_quest	
     * @param quest1
     * @param ans1
     * @param ans2
     * @param ans3
     * @param final_ans
     */
    public questions(int numb_of_quest, String quest1, String ans1, String ans2, String ans3,String final_ans) {        
        this.numb_of_quest = numb_of_quest;
        this.quest1 = quest1;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.final_ans=final_ans;
    }

	public int getNumb_of_quest() {
		return numb_of_quest;
	}

	public void setNumb_of_quest(int numb_of_quest) {
		this.numb_of_quest = numb_of_quest;
	}

	public String getQuest1() {
		return quest1;
	}

	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getFinal_ans() {
		return final_ans;
	}

	public void setFinal_ans(String final_ans) {
		this.final_ans = final_ans;
	}


}

