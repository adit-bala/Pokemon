package dev.aditbala.Pokemon.entity.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import dev.aditbala.Pokemon.entity.Entity;
import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Animation;
import dev.aditbala.Pokemon.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	private boolean control;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_HEIGHT, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 21;
		bounds.y = 45;
		bounds.width = 20;
		bounds.height = 20;
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		//Control
		if(x == 100.0 && y == 101.0)
			control = false;
		else
			control = true;
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		if(control)
			getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//NPCconversation
		checkNPCcollision();
	} 

	private void checkNPCcollision() {
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().right) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				//System.out.print("Collision!");
				e.toggleChat();
			}
		}
	}

	public void follow(float moveX, float moveY) {
		
		if(moveX == 0 && moveY == 0)
			control = true;
		xMove = 0;
		yMove = 0;
		
		yMove = +moveY;
		xMove = +moveX;
	}
	
	public void setControl(boolean control) {
		this.control = control;
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = +speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = +speed;
	}
	
	public int getxPos() {
		return (int) (x - handler.getGameCamera().getxOffset());
	}
	
	public int getyPos(){
		return (int) (y - handler.getGameCamera().getyOffset());
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
			return animRight.getStillFrame();
		}
	}
}
