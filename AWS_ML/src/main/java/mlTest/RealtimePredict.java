package mlTest;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.machinelearning.AmazonMachineLearningClient;
import com.amazonaws.services.machinelearning.model.GetMLModelRequest;
import com.amazonaws.services.machinelearning.model.GetMLModelResult;
import com.amazonaws.services.machinelearning.model.PredictRequest;
import com.amazonaws.services.machinelearning.model.PredictResult;

public class RealtimePredict {
    public static void main(String[] args) {
        String mlModelId = args[0];
        
        RealtimePredict rtp = new RealtimePredict(mlModelId);
        Map<String,String> record = rtp.parseArgs(args);
        PredictResult response = rtp.predict(record);
        System.out.println(response);
    }
    public static float return_result(String[] args) {
        String mlModelId = args[0];
        
        RealtimePredict rtp = new RealtimePredict(mlModelId);
        Map<String,String> record = rtp.parseArgs(args);
        PredictResult response = rtp.predict(record);
        return response.getPrediction().getPredictedValue();
    }
    
    
    private AmazonMachineLearningClient client;
    private String mlModelId;
    private String predictEndpoint;
    
    public RealtimePredict(String mlModelId) {
    	AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("JDK_Test").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\Admin\\.aws\\credentials), and is in valid format.",
                    e);
        }
        client = new AmazonMachineLearningClient(credentials);
        this.mlModelId = mlModelId;
    }
    
    
    private Map<String, String> parseArgs(String[] args) {
        Map<String, String> record = new HashMap<String,String>();
        
        for(int i=1; i<args.length; i++) {
            String arg = args[i];
            String[] parts = arg.split("=");
            if( parts.length != 2 ) {
                throw new RuntimeException("Command line arguments must take form attributeName=value");
            }
            record.put(parts[0],parts[1]);
        }
        return record;
    }

    
    private PredictResult predict(Map<String, String> record) {
        lookupEndpoint();
        PredictRequest request = new PredictRequest()
            .withMLModelId(mlModelId)
            .withPredictEndpoint(predictEndpoint)
            .withRecord(record);
        return client.predict(request);
    }


    /**
     * finds the realtime endpoint for this ML Model
     */
    private void lookupEndpoint() {
        GetMLModelRequest request = new GetMLModelRequest().withMLModelId(mlModelId);
        GetMLModelResult model = client.getMLModel(request);
        predictEndpoint = model.getEndpointInfo().getEndpointUrl();
    }
    
    
    /**
     * Simple method that makes a realtime prediction and prints the result.
     * WARNING! This only works in the happy case, and doesn't check for
     * error conditions like the lack of a realtime endpoint.
     * @param mlModelId the ML model's identifier
     * @param record all the attributes in the record to make a prediction on
     */
    public static PredictResult simpleHappyCasePrediction(String mlModelId, Map<String,String> record) {
        AmazonMachineLearningClient client = new AmazonMachineLearningClient();
        
        GetMLModelRequest modelRequest = new GetMLModelRequest().withMLModelId(mlModelId);
        GetMLModelResult model = client.getMLModel(modelRequest);
        String predictEndpoint = model.getEndpointInfo().getEndpointUrl();
        
        PredictRequest predictRequest = new PredictRequest()
            .withMLModelId(mlModelId)
            .withPredictEndpoint(predictEndpoint)
            .withRecord(record);
        PredictResult prediction = client.predict(predictRequest);
        return prediction;
    }
}
