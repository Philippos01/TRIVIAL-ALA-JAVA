package Sql_server;
import java.util.List;
public class Our_quest  {
public static void main(String[]args){
try {
QuestionsDao quest = new QuestionsDao ();
List<questions> questEH = quest.getQuestionsEH();
List<questions> questEM = quest.getQuestionsEM();
List<questions> questHH = quest.getQuestionsHH();
List<questions> questHM = quest.getQuestionsHM();
for (questions q:questEH){
	System.out.println(q.getNumb_of_quest()+"\n");
	System.out.println(q.getQuest1());
	System.out.println(q.getAns1());
	System.out.println(q.getAns2());
	System.out.println(q.getAns3());
	System.out.println("the right answer is:"+q.getFinal_ans());
}
for(questions q1:questEM) {
	System.out.println(q1.getNumb_of_quest()+"\n");
	System.out.println(q1.getQuest1());
	System.out.println(q1.getAns1());
	System.out.println(q1.getAns2());
	System.out.println(q1.getAns3());
	System.out.println("the right answer is:"+q1.getFinal_ans());
}
}
catch (Exception e){
System.out.println(e.getMessage());
}

}
}
