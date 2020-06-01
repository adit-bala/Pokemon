package dev.aditbala.Pokemon.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.aditbala.Pokemon.Game;
import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.entity.creatures.Player;
import dev.aditbala.Pokemon.entity.statics.Tree;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.tiles.Tile;
import dev.aditbala.Pokemon.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world0.txt", Assets.background);
		handler.setWorld(world);
	}
	
	public void changeWorld(String path, BufferedImage image) {
		world = new World(handler, path, image);
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	
}
