package ewb.ewb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException; 
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

@SpringBootApplication
public class EwbApplication extends SR {

    public EwbApplication(String[] filePaths) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(filePaths);
    }

    public static void main(String[] args) {
        SpringApplication.run(EwbApplication.class, args);

        String[] filePaths = {
            "ewb/src/main/resources/153534__vibekefalden__air-raid-siren_long.wav",
            "ewb/src/main/resources/174021__sonidor__sirene.wav",
            "ewb/src/main/resources/732464__jdh2024__simple-alarms-in-and-out.wav"
        };

        try {
            EwbApplication audioPlayer = new EwbApplication(filePaths);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Choose a sound to play (1, 2, 3): ");
                int soundIndex = sc.nextInt() - 1; // Adjust index to match array indexing
                audioPlayer.play(soundIndex);

                System.out.println("Enter 'stop' to stop or press any key to choose another sound: ");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("stop")) {
                    audioPlayer.stop();
                    break;
                } else {
                    audioPlayer.stop();
                }
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
