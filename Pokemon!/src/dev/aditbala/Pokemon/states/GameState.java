package dev.aditbala.Pokemon.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.aditbala.Pokemon.Game;
import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.entity.creatures.Player;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.tiles.Tile;
import dev.aditbala.Pokemon.ui.ClickListener;
import dev.aditbala.Pokemon.ui.UIManager;
import dev.aditbala.Pokemon.ui.UIStartScreen;
import dev.aditbala.Pokemon.ui.UITextButton;
import dev.aditbala.Pokemon.worlds.World;

public class GameState extends State {

	private World world;
	private UIManager uiManager;
	
	public GameState(final Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world0.txt", Assets.background);
		handler.setWorld(world);
	}
	
	public void init() {
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UITextButton(0, 300, 500, 200, Assets.TextBox, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
			}
		}));
	}
	
	public void changeWorld(String path, BufferedImage image) {
		world = new World(handler, path, image);
		handler.setWorld(world);
	}
	
	public void clearManager() {
		handler.getMouseManager().setUIManager(null);
		uiManager.clear();
	}
	
	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		uiManager.render(g);
	}
	
	
}
