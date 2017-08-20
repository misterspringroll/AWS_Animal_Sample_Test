package mlTest;

public class Question_Analysis {
	/* Return Question Type after classify the animal type*/
	public static String getQType(String inputQ){
		String[] Question_splited = inputQ.trim().split("\\s+"); 
        String Question_Type;
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
        return Question_Type.toLowerCase();
	}
	/* Return Animal Subject*/
	public static String getQSubject(String inputQ)
	{
		String Q_Subject = null;
		if (inputQ.toLowerCase().contains("lion"))
  		 {
			Q_Subject = "lion";
  		 }
  		 else if (inputQ.toLowerCase().contains("zebra"))
  		 {
  			Q_Subject = "zebra";
  		 }
  		else if (inputQ.toLowerCase().contains("gazelle"))
 		 {
  			Q_Subject = "gazelle";
 		 }
  		else if (inputQ.toLowerCase().contains("tiger"))
 		 {
  			Q_Subject = "tiger";
 		 }
  		else if (inputQ.toLowerCase().contains("warthog"))
 		 {
  			Q_Subject = "warthog";
 		 }
  		else if (inputQ.toLowerCase().contains("leopard"))
 		 {
  			Q_Subject = "leopard";
 		 }
  		else if (inputQ.toLowerCase().contains("cheetah"))
 		 {
  			Q_Subject = "cheetah";
 		 }
  		else
  		{
  			Q_Subject = "Default";
  		}
		return Q_Subject.toLowerCase();
	}
	/* return question length*/
	public static int getQlength(String inputQ){
		String[] Question_splited = inputQ.trim().split("\\s+"); 
        int Question_length = Question_splited.length;
        return Question_length;
	}
}
