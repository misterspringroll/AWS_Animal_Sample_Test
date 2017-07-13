package mlTest;


import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

public class HelloTF {

/*
public static void main(String[] args) throws Exception {
	try (Graph g = new Graph()) {
		final String value = "Hello Hello from " + TensorFlow.version();
		
		try (Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
			g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();	
		}
		
		try (Session s = new Session(g);
				Tensor output = s.runner().fetch("MyConst").run().get(0)) {
			System.out.println(new String(output.bytesValue(), "UTF-8"));
			}
		}
	}

*/

/* return question length*/
public static void helloTensorFlow() throws Exception {

		try (Graph g = new Graph()) {
			final String value = "Hello Hello from " + TensorFlow.version();
			
			try (Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
				g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();	
			}
			
			try (Session s = new Session(g);
					Tensor output = s.runner().fetch("MyConst").run().get(0)) {
				System.out.println(new String(output.bytesValue(), "UTF-8"));
				}
			}
		}	
}