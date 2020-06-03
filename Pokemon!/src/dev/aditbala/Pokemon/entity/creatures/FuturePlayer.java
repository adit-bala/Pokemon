package dev.aditbala.Pokemon.entity.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Animation;
import dev.aditbala.Pokemon.gfx.Assets;

public class FuturePlayer extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	//NPCMOVE
	private ArrayList<int[]> movers;
	private int change, counter;

	public FuturePlayer(Handler handler, float x, float y, int width, int height) {
super(handler, x, y, Creature.DEFAULT_CREATURE_HEIGHT, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 21;
		bounds.y = 45;
		bounds.width = 20;
		bounds.height = 20;
		
		//Animations
		animDown = new Animation(500, Assets.Doctor_down);
		animUp = new Animation(500, Assets.Doctor_up);
		animLeft = new Animation(500, Assets.Doctor_left);
		animRight = new Animation(500, Assets.Docter_right);
		//initialize
		movers = new ArrayList<int[]>();
		change = 0;
		counter = 0;
		init();
	}

	public void init() {
		movers.add(new int[] {-1, 0});
		movers.add(new int[] {1, 0});
	}
	
	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		change++;
		mover(movers, change);
		move();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if (yMove > 0){
			return animDown.getCurrentFrame();
		} else {
			return animLeft.getStillFrame();
		}
	}
	public void mover(ArrayList<int[]> movers, int change) {
		xMove = 0;
		yMove = 0;
		if(change%120 == 0)
			counter++;
		int[] moveNPC = movers.get(counter);
		yMove = +moveNPC[0];
		xMove = +moveNPC[1];

	}

}
