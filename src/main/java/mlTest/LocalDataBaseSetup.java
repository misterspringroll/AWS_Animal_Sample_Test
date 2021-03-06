package mlTest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import mlTest.Nested_LL.MyNode;
import mlTest.Nested_LL.MyQType;
public class LocalDataBaseSetup {
	// Initialize the local database, reading from txt file
	public static MyNode Initialization() throws IOException{
		MyNode Main_Depo = new MyNode();
		String line2;
        BufferedReader in2;
        int line_num2 = 0;
        in2 = new BufferedReader(new InputStreamReader(LocalDataBaseSetup.class.getResourceAsStream("/Perfect_Depository.txt")));
        line2 = in2.readLine();
        /* Initialize data collectors*/
        String txt_Question = null;
        String txt_Answer = null;
        String Q_Type = null;
        String Q_id = null;
        int Q_count = 0;
        int A_count = 0;
        int A_Num_count = 0;
        String txt_Subject = null;
        while(line2 != null)
       {
         // Classify the type of input data
       	 String data = line2;
       	 if (line_num2 % 8 == 0)
       	 {
       		 txt_Question = data.toLowerCase();
       	 }
       	 else if (line_num2 % 8 == 1)
       	 {
       		 txt_Answer = data;
       	 }
       	else if (line_num2 % 8 == 2)
      	 {
       		 Q_Type = data.toLowerCase();
      	 }
       	else if (line_num2 % 8 == 3)
      	 {
       		 Q_count = Integer.parseInt(data);
      	 }
       	else if (line_num2 % 8 == 4)
     	 {
       		 A_count = Integer.parseInt(data);
     	 }
       	else if (line_num2 % 8 == 5)
     	 {
       		 A_Num_count = Integer.parseInt(data);
     	 }
       	else if (line_num2 % 8 == 6)
       	 {
       		txt_Subject = data.toLowerCase();
       	 }
       	else
       	{
       		Q_id = data;
       		Main_Depo.add(A_Num_count,txt_Question,txt_Answer,Q_Type,Q_count,A_count,txt_Subject,Q_id);
       	}
       	line_num2 ++;
        line2 = in2.readLine();
       }
       in2.close();
       return Main_Depo;
	}
	// After obtaining the user-inputed question, return the list of possible answers from the local database
	public static LinkedList<?> GetPassingList(MyNode depo, String animal, String QType){
		LinkedList<?> temp = new LinkedList<Object>();
		MyQType temp_QA  = null;
		MyNode temp_depo = depo;
		while (temp_depo.next != null)
    	{
    		if (temp_depo.get_animal_name().contains(animal))
    		{
    			temp_QA = temp_depo.get_ll();
    			break;
    		}
    		temp_depo = temp_depo.next;
    	}

		while (temp_QA != null)
    	{
    		if (temp_QA.get_question_type().contains(QType))
    		{
    			temp = temp_QA.get_QA();
    			break;
    		}
    		temp_QA = temp_QA.next;
    	}
		return temp;
	}
}
