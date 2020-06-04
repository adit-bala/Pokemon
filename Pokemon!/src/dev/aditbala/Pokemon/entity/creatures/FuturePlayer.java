package dev.aditbala.Pokemon.entity.creatures;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Timer;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Animation;
import dev.aditbala.Pokemon.gfx.Assets;

public class FuturePlayer extends Creature implements ActionListener {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	//NPCMOVE
	private ArrayList<int[]> movers;
	private int change, counter;
	private Timer timer;
	private boolean begin;
	

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
		timer = new Timer(30000, this);
		begin = false;
		if(x == 250 && y == 250)
			timer.start();
		init();
	}

	public void init() {
		movers.add(new int[] {2, 0});
		movers.add(new int[] {0, -2});
		movers.add(new int[] {1, 0});
		movers.add(new int[] {1, 0});
		movers.add(new int[] {1, 0});
		movers.add(new int[] {1, 0});
	}
	
	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		if(begin) {
			change++;
			mover(movers, change);
			move();
		}
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
			if(x == 250 && y == 250)
				return animLeft.getStillFrame();
			else
				return animRight.getStillFrame();
		}
	}
	public void mover(ArrayList<int[]> movers, int change) {
		xMove = 0;
		yMove = 0;
		if(counter<movers.size()-1) {
			if(change%60 == 0)
				counter++;
			int[] moveNPC = movers.get(counter);
			yMove = +moveNPC[0];
			xMove = +moveNPC[1];
			handler.getWorld().getEntityManager().getPlayer().follow(xMove, yMove);
			
		} else {
			begin = false;
			handler.getWorld().getEntityManager().getPlayer().follow(0, 0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		begin = true;
		timer.stop();
	}
}
