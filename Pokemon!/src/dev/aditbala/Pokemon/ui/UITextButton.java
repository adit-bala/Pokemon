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
		story.add("I am you from the");
		story.add("future!");
		story.add("You look confused...");
		story.add("But it's okay!");
		story.add("Don't worry!");
		story.add("You still have");
		story.add("a long life ahead");
		story.add("of you!");
		story.add("I just came back");
		story.add("to say hi.");
		story.add("JUST KIDDING!");
		story.add("First of all...");
		story.add("Take off your cap!");
		story.add("Let the hair flow.");
		story.add("Look at how luscious");
		story.add("mine has become.");
		story.add("Anyways...");
		story.add("I need a favor");
		story.add("from you in");
		story.add("this time period");
		story.add("I'm a very forgetful");
		story.add("person as you");
		story.add("probably know.");
		story.add("So I need you");
		story.add("to help me...");
		story.add("Are you ready?");
		story.add("and although");
		story.add("this is dangerous,");
		story.add("I can't say much.");
		story.add("Just trust me");
		story.add("and we can do ");
		story.add("this together!");
		story.add("and if you help");
		story.add("me, I will give you");
		story.add("you a reward!");
		story.add("and if you help");
		story.add("me, I will give you");
		story.add("you a reward!");
		story.add("Just walk with");
		story.add("me and go out");
		story.add("and explore!");
		story.add("You will know");
		story.add("when you have");
		story.add("found the item!");
		story.add("");
		story.add("Good Luck!");
		story.add("");
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(change) {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
			Text.drawString(g, story.get(frames), 25, 350, false, Color.BLACK, Assets.font24);
			Text.drawString(g, story.get(frames+1), 25, 400, false, Color.BLACK, Assets.font24);
			Text.drawString(g, story.get(frames+2), 25, 450, false, Color.BLACK, Assets.font24);
		} 
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frames+=3;
		if(frames > story.size()-1) {
			change = false;
			timer.stop();
		}

	}
}
