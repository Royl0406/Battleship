import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
    public void PlayMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                System.out.println("audio in progress");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                System.out.println("Can't find file");
            }
        }
        catch(Exception ex) {
            
        }
    }
}
