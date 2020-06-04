package dev.aditbala.Pokemon.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.aditbala.Pokemon.Game;
import dev.aditbala.Pokemon.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void changeWorld(String path, BufferedImage image);
	
	public abstract void init();
	
	public abstract void clearManager();
	
	public abstract void tick();
		
	public abstract void render(Graphics g);
	
}
