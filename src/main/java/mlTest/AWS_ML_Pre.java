package mlTest;

import java.io.IOException;
import java.util.LinkedList;

public class AWS_ML_Pre {
	public static int AWS_ML_QA(String Question_Type, String Animal_Classify, int Question_length, LinkedList passing_list) throws IOException
	{
		String[] predict_argument = {"ml-j9zB7WqMDuP", "Question_Type=" + Question_Type, "Feature_QuestionTermCount=" + Integer.toString(Question_length), "Animal_Classification="
        		+ Animal_Classify};
        float predict_value = RealtimePredict.return_result(predict_argument);
        int index_num = AnswerSearch.return_index(predict_value,passing_list);
        return index_num;
	}
}
