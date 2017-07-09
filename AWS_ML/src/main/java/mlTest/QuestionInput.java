package mlTest;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuestionInput {
	public static void main(String[] args) throws IOException{
		class MyNode {
	        private String animal_name;
	        private LinkedList ll_deposit;
	        private MyNode next;
	        public int size = 0;
	        public MyNode (){
	        	this.animal_name = null;
	            this.ll_deposit = new LinkedList();
	            this.next = null;
	        }
	        public MyNode(String input_name, double[] data_pair) {
	            this.animal_name = input_name;
	            this.ll_deposit = new LinkedList();
	            ll_deposit.add(data_pair);
	            this.next = new MyNode();
	        }
	        private void add(String input_name, double[] data_pair) {
	        	if (this.get_animal_name() == null)
	        	{
	        		this.animal_name = input_name;
	        		this.ll_deposit = new LinkedList();
		            ll_deposit.add(data_pair);
		            this.next = new MyNode();
		            return;
	        	}
	        	MyNode temp = this;
	        	while (temp.next != null)
	        	{
	        		if (temp.get_animal_name()==input_name)
	        		{
	        			temp.get_ll().add(data_pair);
	        			return;
	        		}
	        		temp = temp.next;
	        	}
	        	temp.next = new MyNode(input_name, data_pair);
	        }
	        public String get_animal_name(){
	        	return this.animal_name;
	        }
	        public LinkedList get_ll(){
	        	return ll_deposit;
	        }
	    }
		
        MyNode Main_Depo = new MyNode();
		String line2;
        BufferedReader in2;
        String classify = null;
        double currentline = 0;
        int line_num2 = 0;
		 in2 = new BufferedReader(new FileReader("E:\\workspace\\AWS_ML\\src\\main\\resources\\Perfect_bpResult2.txt"));
        line2 = in2.readLine();
        while(line2 != null)
       {
       	 line_num2 ++;
       	 String data = line2;
       	 if (line_num2 % 3 == 0)
       	 {
       		 double predict_score = Double.parseDouble(data);
       		 double temp1 = predict_score;
       		 double temp2 = currentline;
       		 double temp[] = new double[2];
       		 temp[0] = temp1;
       		 temp[1] = temp2;
       		 if (classify.toLowerCase().contains("lion"))
       		 {
       			 Main_Depo.add("lion",temp);
       		 }
       		 else if (classify.toLowerCase().contains("zebra"))
       		 {
       			Main_Depo.add("zebra",temp);
       		 }
       		else if (classify.toLowerCase().contains("gazelle"))
      		 {
       			Main_Depo.add("gazelle",temp);
      		 }
       		else if (classify.toLowerCase().contains("tiger"))
      		 {
       			Main_Depo.add("tiger",temp);
      		 }
       		else if (classify.toLowerCase().contains("warthog"))
      		 {
       			Main_Depo.add("warthog",temp);
      		 }
       		else if (classify.toLowerCase().contains("leopard"))
      		 {
       			Main_Depo.add("leopard",temp);
      		 }
       		else if (classify.toLowerCase().contains("cheetah"))
      		 {
       			Main_Depo.add("cheetah",temp);
      		 }
       		else
       		{
       			Main_Depo.add("Default",temp);
       		}
       			 
       	 }
       	 else if (line_num2 % 3 == 1)
       	 {
       		 classify = data;
       	 }
       	 else
       	 {
       		 currentline = Double.parseDouble(data);
       	 }
            line2 = in2.readLine();
       }
        
        while(true){
		Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your question, enter exit to quit:");
        String Question = reader.nextLine();
        if (Question.toLowerCase().contains("exit"))
        {
        	return;
        }
        System.out.println("The Question is: " + Question);
        String Animal_Classify, Question_Type;
        LinkedList passing_list = null;
        if (Question.toLowerCase().contains("lion"))
        {
        	Animal_Classify = "lion";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "lion")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("zebra"))
        {
        	Animal_Classify = "zebra";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "zebra")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("gazelle"))
        {
        	Animal_Classify = "gazelle";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "gazelle")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("tiger"))
        {
        	Animal_Classify = "tiger";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "tiger")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("warthog"))
        {
        	Animal_Classify = "warthog";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "warthog")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("leopard"))
        {
        	Animal_Classify = "leopard";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "leopard")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else if (Question.toLowerCase().contains("cheetah"))
        {
        	Animal_Classify = "cheetah";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "cheetah")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        else 
        {
        	Animal_Classify = "Default";
        	MyNode temp = Main_Depo;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name() == "Default")
        		{
        			passing_list = temp.get_ll();
        			break;
        		}
        		temp = temp.next;
        	}
        }
        String[] Question_splited = Question.trim().split("\\s+"); 
        int Question_length = Question_splited.length;
        if (Question_splited[0].toLowerCase().contains("what"))
        {
        	Question_Type = "what";
        }
        else if (Question_splited[0].toLowerCase().contains("where"))
        {
        	Question_Type = "where";
        }
        else if (Question_splited[0].toLowerCase().contains("when"))
        {
        	Question_Type = "when";
        }
        else if (Question_splited[0].toLowerCase().contains("why"))
        {
        	Question_Type = "why";
        }
        else if (Question_splited[0].toLowerCase().contains("how"))
        {
        	Question_Type = "how";
        }
        else if (Question_splited[0].toLowerCase().contains("do"))
        {
        	Question_Type = "do";
        }
        else if (Question_splited[0].toLowerCase().contains("is") || (Question_splited[0].toLowerCase().contains("are")))
        {
        	Question_Type = "be";
        }
        else
        {
        	Question_Type = "Default";
        }
        System.out.println("The Question type is: " + Question_Type);
        System.out.println("The Animal classification is: " + Animal_Classify);
        System.out.println("The Term count of this question is: " + Question_length);
        String[] predict_argument = {"ml-j9zB7WqMDuP", "Question_Type=" + Question_Type, "Feature_QuestionTermCount=" + Integer.toString(Question_length), "Animal_Classification="
        		+ Animal_Classify};
        float predict_value = RealtimePredict.return_result(predict_argument);
        int index_num = AnswerSearch.return_index(predict_value,passing_list);
        System.out.println("Question Index is: " + index_num);
        String line;
        BufferedReader in;
        int line_num = 0;
        in = new BufferedReader(new FileReader("E:\\workspace\\AWS_ML\\src\\main\\resources\\Perfect_Answers.txt"));
        line = in.readLine();
        while(line != null)
        {
        	 line_num ++;
        	 if (line_num == index_num)
        	 {
        		String answer = line;
        		System.out.println(answer); 
        		break;
        	 }
             line = in.readLine();
        }
    }
	}
}
