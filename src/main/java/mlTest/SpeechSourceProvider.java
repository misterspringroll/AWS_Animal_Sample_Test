package mlTest;

import edu.cmu.sphinx.api.Microphone;

public class SpeechSourceProvider {
    private static final Microphone mic = new Microphone(16000, 16, true, false);

    Microphone getMicrophone() {
        return mic;
    }
}