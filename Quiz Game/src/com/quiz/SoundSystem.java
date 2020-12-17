package com.quiz;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SoundSystem  {
	Clip playingSound;
	Clip correctSound;
	Clip falseSound;
	Clip clapSound;
	Clip finishSound;
	public SoundSystem() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		init_sounds();
		}
	public void init_sounds() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		  
		AudioInputStream playing_audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\Quiz Game\\bin\\com\\quiz\\playing.wav").getAbsoluteFile());
		playingSound = AudioSystem.getClip();
		playingSound.open(playing_audioInputStream); 
		
		
	}

public void playingSoundStart() { 
	playingSound.start();
	
}
public void playingSoundStop() {
	playingSound.stop();
	playingSound.flush();
	playingSound.setFramePosition(0);
}
public void CorrectSoundStart() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	AudioInputStream correct_audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\Quiz Game\\bin\\com\\quiz\\correct.wav").getAbsoluteFile());
	correctSound = AudioSystem.getClip();
	correctSound.open(correct_audioInputStream);
	correctSound.start();
	
	
}
public void FalseSoundStart() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	AudioInputStream false_audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\Quiz Game\\bin\\com\\quiz\\false.wav").getAbsoluteFile());
	falseSound = AudioSystem.getClip();
	falseSound.open(false_audioInputStream);
	falseSound.start();
	
}
public void ClappingSoundStart() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	AudioInputStream clapping_audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\Quiz Game\\bin\\com\\quiz\\clapping.wav").getAbsoluteFile());
	clapSound = AudioSystem.getClip();
	clapSound.open(clapping_audioInputStream);
	clapSound.start();
	
}
public void FinishSoundStart() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	AudioInputStream finish_audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\Quiz Game\\bin\\com\\quiz\\finish.wav").getAbsoluteFile());
	finishSound = AudioSystem.getClip();
	finishSound.open(finish_audioInputStream);
	finishSound.start();
	
}
}