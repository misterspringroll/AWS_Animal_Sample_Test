package mlTest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import mlTest.Nested_LL.MyNode;
import mlTest.Nested_LL.MyQType;
public class LocalDataBaseSetup {
	public static MyNode Initialization() throws IOException{
		MyNode Main_Depo = new MyNode();
		String line2;
        BufferedReader in2;
        String classify = null;
        double currentline = 0;
        int line_num2 = 0;
		 in2 = new BufferedReader(new FileReader("E:\\workspace\\AWS_ML\\src\\main\\resources\\Perfect_Depository.txt"));
        line2 = in2.readLine();
        /* Initialize data collectors*/
        int txt_index = 0;
        String txt_Question = null;
        String txt_Answer = null;
        String Q_Type = null;
        int Q_count = 0;
        int A_count = 0;
        String txt_Subject = null;
        while(line2 != null)
       {
         // Classify the type of input data
       	 String data = line2;
       	 if (line_num2 % 7 == 0)
       	 {
       		 txt_index = Integer.parseInt(data);
       	 }
       	 else if (line_num2 % 7 == 1)
       	 {
       		 txt_Question = data;
       	 }
       	else if (line_num2 % 7 == 2)
      	 {
      		 txt_Answer = data;
      	 }
       	else if (line_num2 % 7 == 3)
      	 {
      		 Q_Type = data;
      	 }
       	else if (line_num2 % 7 == 4)
     	 {
     		 Q_count = Integer.parseInt(data);
     	 }
       	else if (line_num2 % 7 == 5)
     	 {
       		A_count = Integer.parseInt(data);
     	 }
       	 else
       	 {
       		txt_Subject = data;
       		Main_Depo.add(txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count,txt_Subject);
       	 }
       	line_num2 ++;
        line2 = in2.readLine();
       }
       return Main_Depo;
	}
	public static LinkedList GetPassingList(MyNode depo, String animal, String QType){
		LinkedList temp = null;
		MyQType temp_QA  = null;
		MyNode temp_depo = depo;
		while (temp_depo.next != null)
    	{
    		if (temp_depo.get_animal_name() == animal)
    		{
    			temp_QA = temp_depo.get_ll();
    			break;
    		}
    		temp_depo = temp_depo.next;
    	}
		while (temp_QA.next != null)
    	{
    		if (temp_QA.get_question_type() == QType)
    		{
    			temp = temp_QA.get_QA();
    			break;
    		}
    		temp_depo = temp_depo.next;
    	}
		return temp;
	}
	public static String GetLocalAnswer(int index_num) throws IOException{
		String line;
		String return_answer = null;
    	BufferedReader in;
    	int line_num = 0;
    	in = new BufferedReader(new FileReader("E:\\workspace\\AWS_ML\\src\\main\\resources\\Perfect_Depository.txt"));
    	line = in.readLine();
    	while(line != null)
    	{
    		line_num ++;
    		if (line_num == index_num)
    		{
    			String answer = line;
    			return_answer = answer; 
    			break;
    		}
    		line = in.readLine();
    	}
    	in.close();
    	return return_answer;
	}
}
