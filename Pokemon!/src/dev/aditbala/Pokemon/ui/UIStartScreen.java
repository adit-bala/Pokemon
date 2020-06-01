package dev.aditbala.Pokemon.ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.gfx.Music;;

public class UIStartScreen extends UIObject implements ActionListener {

	private BufferedImage[] images;
	private ClickListener clicker;
	private Timer timer;
	private int frames;
	private Music music;
	
	public UIStartScreen(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		timer = new Timer(1000, this);
		timer.start();
		frames = 0;
		//music.run();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(images[frames], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frames++;
		if(frames == 4)
			frames = 0;
	}
}
