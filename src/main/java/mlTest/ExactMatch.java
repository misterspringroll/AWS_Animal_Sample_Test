package mlTest;

import java.util.LinkedList;

import mlTest.Nested_LL.QA_deposit;

public class ExactMatch {
	public static String[] ExactMatching(String Question, LinkedList<?> passing_list)
	{
		QA_deposit temp;
		String return_answer = null;
		String return_ID = null;
		if (passing_list.size() != 0){
		for (int i = 0; i <= passing_list.size()-1; i++)
		{
			temp = (QA_deposit) passing_list.get(i);
			String temp_Question = temp.get_Question();
			// If the questions are exactly matched to the data in the local database
			if (temp_Question.equals(Question))
			{
				return_answer = temp.get_Answer();
				return_ID = temp.get_Qustion_ID();
				break;
			}
		}
		}
		return new String[] {return_answer,return_ID};
	}
}
