package mlTest;

import java.util.LinkedList;

public class Nested_LL {
	public static class QA_deposit{
		private int txt_index;
		private String txt_Question;
		private String txt_Answer;
		private int Q_count;
		private int A_count;
		public QA_deposit(int a, String b, String c, int d, int e)
		{
			txt_index = a;
			txt_Question = b;
			txt_Answer = c;
			Q_count = d;
			A_count = e;
		}
		public int get_index(){
			return this.txt_index;
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
		public int getAcount(){
			return this.A_count;
		}
	}
	public static class MyQType {
        private String question_type;
        private LinkedList QA_deposit;
        public MyQType next;
        public MyQType (){
        	this.question_type = null;
            this.QA_deposit = new LinkedList();
            this.next = null;
        }
        private MyQType(int txt_index, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count) {
            this.question_type = Q_Type;
            this.QA_deposit = new LinkedList();
    		QA_deposit temp = new QA_deposit(txt_index,txt_Question,txt_Answer,Q_count,A_count);
            this.get_QA().add(temp);
            this.next = new MyQType();
        }
        protected void add(int txt_index, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count) {
        	if (this.get_question_type() == null)
        	{
        		this.question_type = Q_Type;
        		this.QA_deposit = new LinkedList();
        		QA_deposit temp = new QA_deposit(txt_index,txt_Question,txt_Answer,Q_count,A_count);
	            this.get_QA().add(temp);
	            this.next = new MyQType();
	            return;
        	}
        	MyQType temp = this;
        	while (temp.next != null)
        	{
        		if (temp.get_question_type()==Q_Type)
        		{
        			QA_deposit temp_QA = new QA_deposit(txt_index,txt_Question,txt_Answer,Q_count,A_count);
        			temp.get_QA().add(temp_QA);
        			return;
        		}
        		temp = temp.next;
        	}
        	temp.next = new MyQType(txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count);
        }
        public String get_question_type(){
        	return this.question_type;
        }
        public LinkedList get_QA(){
        	return QA_deposit;
        }
    }
	public static class MyNode {
        private String animal_name;
        private MyQType ll_deposit;
        public MyNode next;
        public MyNode (){
        	this.animal_name = null;
            this.ll_deposit = new MyQType();
            this.next = null;
        }
        private MyNode(int txt_index, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count, String txt_Subject) {
            this.animal_name = txt_Subject;
            this.ll_deposit = new MyQType();
            this.get_ll().add(txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count);
            this.next = new MyNode();
        }
        // txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count,txt_Subject
        public void add(int txt_index, String txt_Question, String txt_Answer, String Q_Type, int Q_count, int A_count, String txt_Subject) {
        	if (this.get_animal_name() == null)
        	{
        		this.animal_name = txt_Subject;
        		this.ll_deposit = new MyQType();
	            this.get_ll().add(txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count);
	            this.next = new MyNode();
	            return;
        	}
        	MyNode temp = this;
        	while (temp.next != null)
        	{
        		if (temp.get_animal_name()==txt_Subject)
        		{
        			temp.get_ll().add(txt_index,txt_Question,txt_Answer,Q_Type,Q_count,A_count);
        			return;
        		}
        		temp = temp.next;
        	}
        	temp.next = new MyNode(txt_index, txt_Question, txt_Answer, Q_Type, Q_count, A_count, txt_Subject);
        }
        public String get_animal_name(){
        	return this.animal_name;
        }
        public MyQType get_ll(){
        	return ll_deposit;
        }
    }
}
