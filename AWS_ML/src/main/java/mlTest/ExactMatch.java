package mlTest;

import java.util.LinkedList;

import mlTest.Nested_LL.QA_deposit;

public class ExactMatch {
	public static String ExactMatching(String Question, LinkedList<?> passing_list)
	{
		QA_deposit temp;
		String return_answer = null;
		if (passing_list.size() != 0){
		for (int i = 0; i < passing_list.size()-1; i++)
		{
			temp = (QA_deposit) passing_list.get(i);
			// If the questions are exactly matched to the data in the local database
			if (temp.get_Question().contains(Question))
			{
				return_answer = temp.get_Answer();
				break;
			}
		}
		}
		return return_answer;
	}
}
