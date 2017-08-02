package mlTest;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class TextToSpeech {
	private String name;
	private Voice voice;
	public TextToSpeech(String input){
		this.name = input;
		this.voice = VoiceManager.getInstance().getVoice(this.name);
		this.voice.allocate();
	}
	public void Voice_Output(String input)
	{
		this.voice.speak(input);
	}
}
