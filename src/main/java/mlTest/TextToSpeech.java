package mlTest;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class TextToSpeech {
	private String name;
	private Voice voice;
	public TextToSpeech(String input){
		this.name = input;
        VoiceManager voiceManager = VoiceManager.getInstance();
        System.out.println("voiceManager: " + voiceManager);
        Voice helloVoice = voiceManager.getVoice(this.name);
        System.out.println("helloVoice: " + helloVoice);
        this.voice = helloVoice;
        this.voice.allocate();
	}
	public void Voice_Output(String input)
	{
		this.voice.speak(input);
		this.voice.deallocate();
	}
}
