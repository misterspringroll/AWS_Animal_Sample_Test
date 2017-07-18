package mlTest;

import java.io.IOException;
import java.util.LinkedList;

import mlTest.Nested_LL.QA_deposit;

public class AWS_ML_Pre {
	public static String AWS_ML_QA(String Question_Type, String Animal_Classify, int Question_length, LinkedList<?> passing_list) throws IOException
	{
		float max_predict_value = 0,current_value = 0;
		String featured_answer = null;
		if (passing_list.size() > 0)
		{	
			// Get the highest predicted score
			for(int i = 0; i < passing_list.size() - 1; i++){
				QA_deposit temp =  (QA_deposit) passing_list.get(i);
				String[] predict_argument = {"ml-0Eq6tyaqWu6", "Question_Type=" + Question_Type, "Feature_QuestionTermCount=" + Integer.toString(Question_length), "Animal_Classification="
						+ Animal_Classify, "Feature_AnswerTermCount=" + Integer.toString(temp.get_A_count()), "Feature_AnswerNumericalTermCount=" + Integer.toString((temp.get_A_Num_count()))};
				current_value = RealtimePredict.return_result(predict_argument);
				if (current_value > max_predict_value)
				{
					max_predict_value = current_value;
					featured_answer = temp.get_Answer();
				}
			}
		}
		
        return featured_answer;
	}
}
