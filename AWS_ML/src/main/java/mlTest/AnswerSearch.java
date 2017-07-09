package mlTest;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnswerSearch {
	public static int return_index(float arg, LinkedList<double[]> aList) throws IOException {
		
		double predict_score = Double.parseDouble(Float.toString(arg));
		System.out.println("The Predicted score is: "+predict_score);
		double difference1 = 0, difference2 = 0;
		int index_num = 0;
		int i;
		System.out.println(aList.get(0)[1]);
		index_num = (int) aList.get(0)[1];
		difference1 = Math.abs(aList.get(0)[0] - predict_score);
		for(i=0; i< aList.size() -2 ; i++)
		{
			difference2 = Math.abs(aList.get(i+1)[0] - predict_score);
			if (difference1 > difference2)
			{
				index_num =  (int) aList.get(i+1)[1];
				difference1 = difference2;
			}			
		}
		System.out.println("Total answers searched:" + i);
		System.out.println("Predicted Score:"+predict_score);
		System.out.println("Resulted Score Difference:"+difference1);
		return index_num;
	}
}
