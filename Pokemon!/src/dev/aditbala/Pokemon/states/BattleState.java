package dev.aditbala.Pokemon.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.battles.Battle;

public class BattleState extends State{
	
	private Battle battle;
	
	public BattleState(Handler handler) {
		super(handler);
		battle = new Battle();
	}

	@Override
	public void changeWorld(String path, BufferedImage image) {
		
	}

	@Override
	public void init() {

		
	}

	@Override
	public void clearManager() {

		
	}

	@Override
	public void tick() {
		battle.tick();
	}

	@Override
	public void render(Graphics g) {
		battle.render(g);
	}

}
