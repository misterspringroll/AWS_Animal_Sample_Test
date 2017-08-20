package mlTest;

import java.util.LinkedList;

import mlTest.Nested_LL.QA_deposit;

public class Nested_LL {
	// Datatype to put in the nested linked list
	public static class QA_deposit{
		private String Question_ID;
		private String txt_Question;
		private String txt_Answer;
		private int Q_count;
		private int A_count;
		private int A_Num_count;
		public QA_deposit(int a, String b, String c, int d, int e, String f)
		{
			this.Question_ID = f;
			this.txt_Question = b;
			this.txt_Answer = c;
			this.Q_count = d;
			this.A_count = e;
			this.A_Num_count = a;
		}
		public int get_A_Num_count(){
			return this.A_Num_count;
		}
		public String get_Question(){
			return this.txt_Question;
		}
		public String get_Answer(){
			return this.txt_Answer;
		}
		public int get_Qcount(){
			return this.Q_count;
		}
		public int get_A_count(){
			return this.A_count;
		}
		public String get_Qustion_ID(){
			return this.Question_ID;
		}
	}
	// Nested Linked List
	public static class MyQType {
        private String question_type;
        private LinkedList<QA_deposit> QA_deposit;
        public MyQType next;
        public MyQType (){
        	this.question_type = null;
            this.QA_deposit = new LinkedList<QA_deposit>();
            this.next = null;
        }
        protected void add(int A_Num_count, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count, String Question_ID) {
        	MyQType temp = this;
        	if (this.get_question_type() == null)
        	{
        		this.question_type = Q_Type;
        		this.QA_deposit = new LinkedList<QA_deposit>();
        		QA_deposit temp_QA = new QA_deposit(A_Num_count,txt_Question,txt_Answer,Q_count,A_count, Question_ID);
	            temp.get_QA().add(temp_QA);
	            this.next = new MyQType();
	            return;
        	}
        	else if (temp.get_question_type().contains(Q_Type))
        	{
        		QA_deposit temp_QA = new QA_deposit(A_Num_count,txt_Question,txt_Answer,Q_count,A_count,Question_ID);
    			temp.get_QA().add(temp_QA);
        	}
        	else
        	{
        		temp.next.add(A_Num_count, txt_Question, txt_Answer, Q_Type, Q_count, A_count, Question_ID);
        	}
        }
        public String get_question_type(){
        	return this.question_type;
        }
        public LinkedList<QA_deposit> get_QA(){
        	return QA_deposit;
        }
    }
	// First Linked List
	public static class MyNode {
        private String animal_name;
        private MyQType ll_deposit;
        public MyNode next;
        public MyNode (){
        	this.animal_name = null;
            this.ll_deposit = new MyQType();
            this.next = null;
        }
        public void add(int A_Num_count, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count, String txt_Subject, String Question_ID) {
    		MyNode temp = this;
        	if (this.get_animal_name() == null)
        	{
        		this.animal_name = txt_Subject;
        		this.ll_deposit = new MyQType();
	            this.get_ll().add(A_Num_count,txt_Question,txt_Answer,Q_Type,Q_count,A_count, Question_ID);
	            this.next = new MyNode();
	            return;
        	}
        	else if(temp.get_animal_name().contains(txt_Subject))
        	{
        		temp.get_ll().add(A_Num_count,txt_Question,txt_Answer,Q_Type,Q_count,A_count,Question_ID);
        	}
        	else
        	{
        		temp.next.add(A_Num_count, txt_Question, txt_Answer, Q_Type, Q_count, A_count, txt_Subject, Question_ID);
        	}
        }
        public String get_animal_name(){
        	return this.animal_name;
        }
        public MyQType get_ll(){
        	return ll_deposit;
        }
    }
}
