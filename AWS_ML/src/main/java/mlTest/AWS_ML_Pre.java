package mlTest;

import java.io.IOException;
import java.util.LinkedList;

import mlTest.Nested_LL.QA_deposit;

public class AWS_ML_Pre {
	public static int AWS_ML_QA(String Question_Type, String Animal_Classify, int Question_length, LinkedList passing_list) throws IOException
	{
		float max_predict_value = 0,current_value = 0;
		int index_num = 0;
		if (passing_list.size() > 0)
		{
			for(int i = 0; i < passing_list.size() - 1; i++){
				String[] predict_argument = {"ml-EiJZ7qP1lia", "Question_Type=" + Question_Type, "Feature_QuestionTermCount=" + Integer.toString(Question_length), "Animal_Classification="
						+ Animal_Classify, "Feature_AnswerTermCount=" + Integer.toString((((QA_deposit) passing_list.get(i)).get_A_count()))};
				current_value = RealtimePredict.return_result(predict_argument);
				if (current_value > max_predict_value)
				{
					max_predict_value = current_value;
					index_num = ((QA_deposit) passing_list.get(i)).get_index();
				}
			}
		}
		
        return index_num;
	}
}
