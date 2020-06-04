package dev.aditbala.Pokemon.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.gfx.Text;

public class UITextButton extends UIObject implements ActionListener {

	private BufferedImage[] images;
	private ClickListener clicker;
	private ArrayList<String> story;
	private Timer timer;
	private boolean change;
	private int frames;
	private Handler handler;
	
	public UITextButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.clicker = clicker;
		this.images = images;
		change = true;
		story = new ArrayList<String>();
		timer = new Timer(3000, this);
		timer.start();
		init();
	}
	
	public void init() {
		story.add("OH! Hello there!");
		story.add("I am you from the future!");
		story.add("You look confused...");
		story.add("But it's okay! Don't worry!");
		story.add("I'll be gone soon");
		story.add("I just need a quick favor!");
		story.add("First of all...");
		story.add("Take off your cap!");
		story.add("Let the hair flow.");
		story.add("Look at how luscious mine is");
		story.add("Anyways...");
		story.add("I'm a very forgetful person.");
		story.add("As you know.");
		story.add("So I need you to help me");
		story.add("I need this item soon");
		story.add("I can't tell you much");
		story.add("But follow me outside");
		story.add("If you find it");
		story.add("You will get a reward!");
		story.add("So come now!");

	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(change) {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
			Text.drawString(g, story.get(frames), 254, 350, true, Color.BLACK, Assets.font24);
			Text.drawString(g, story.get(frames+1), 250, 400, true, Color.BLACK, Assets.font16);
		} 
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frames+=2;
		if(frames > story.size()-1) {
			change = false;
			timer.stop();
		}

	}
}
