package dev.aditbala.Pokemon.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.entity.creatures.FuturePlayer;
import dev.aditbala.Pokemon.entity.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private FuturePlayer futurePlayer;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() < b.getY())
				return -1;
			return 1;
		}
		
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		entities.add(player);
	}
	
	public void tick() {
		for(int i =0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for(Entity e: entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	//GETTERS AND SETTERS
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public FuturePlayer getFuturePlayer() {
		return futurePlayer;
	}

	public void setFuturePlayer(FuturePlayer futurePlayer) {
		this.futurePlayer = futurePlayer;
	}

	public int size() {
		return entities.size();
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
