package dev.aditbala.Pokemon.states;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.gfx.Music;
import dev.aditbala.Pokemon.gfx.Text;
import dev.aditbala.Pokemon.ui.ClickListener;
import dev.aditbala.Pokemon.ui.UIManager;
import dev.aditbala.Pokemon.ui.UIStartScreen;
import dev.aditbala.Pokemon.ui.UITextButton;

public class MenuState extends State {

	private UIManager uiManager;
	

	public MenuState(final Handler handler) {
		super(handler);
		init();
	}
	@Override
	public void changeWorld(String path, BufferedImage image) {
		
	}
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
	@Override
	public void init() {
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIStartScreen(0, 0, 500, 500, Assets.StartScreen, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				//handler.getGame().getGameState().init();
			}
		}));	
	}
	
	@Override
	public void clearManager() {
		// TODO Auto-generated method stub
		
	}

}