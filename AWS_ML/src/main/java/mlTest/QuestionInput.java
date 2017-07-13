package mlTest;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import mlTest.Nested_LL.MyNode;

public class QuestionInput {
	/* the main*/
	public static void main(String[] args) throws IOException{
		MyNode Main_Depo = LocalDataBaseSetup.Initialization();
        String Animal_Classify, Question_Type, QA_Answer;
        int Question_length;
        LinkedList passing_list = null;
        while(true){
		Scanner reader = new Scanner(System.in);
        System.out.println("Please enter your question, enter exit to quit:");
        String Question = reader.nextLine();
        if (Question.toLowerCase().contains("exit"))
        {
        	return;
        }
        System.out.println("The Question is: " + Question);
        Animal_Classify = Question_Analysis.getQSubject(Question);
        Question_Type = Question_Analysis.getQType(Question);
        Question_length = Question_Analysis.getQlength(Question);
        System.out.println("The Question type is: " + Question_Type);
        System.out.println("The Animal classification is: " + Animal_Classify);
        System.out.println("The Term count of this question is: " + Question_length);
        passing_list = LocalDataBaseSetup.GetPassingList(Main_Depo, Animal_Classify, Question_Type);
        QA_Answer = ExactMatch.ExactMatching(Question, passing_list);
        if (QA_Answer == null) // only do ML model based prediction when exact matching fails
        {
        	System.out.println("Exact Mathing Failed.. Triggering AWS Machine Learning Based QA System...");
        	QA_Answer = AWS_ML_Pre.AWS_ML_QA(Question_Type, Animal_Classify, Question_length, passing_list);
        }
        System.out.println("The Answer is: " + QA_Answer);
    }
	}
}
