package dev.aditbala.Pokemon.worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.entity.EntityManager;
import dev.aditbala.Pokemon.entity.creatures.FuturePlayer;
import dev.aditbala.Pokemon.entity.creatures.Player;
import dev.aditbala.Pokemon.entity.statics.Ditto;
import dev.aditbala.Pokemon.entity.statics.NPC1;
import dev.aditbala.Pokemon.entity.statics.NPC2;
import dev.aditbala.Pokemon.entity.statics.NPC3;
import dev.aditbala.Pokemon.entity.statics.NPC4;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.tiles.Tile;
import dev.aditbala.Pokemon.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private String path;
	private BufferedImage image;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path, BufferedImage image) {
		this.path = path;
		this.handler = handler;
		if(path.equals("res/worlds/world0.txt")){
			entityManager = new EntityManager(handler, new Player(handler, 100, 101));
			entityManager.addEntity(new FuturePlayer(handler, 250, 250, 64, 64));
		} else {
			entityManager = new EntityManager(handler, new Player(handler, 100, 100));
			entityManager.addEntity(new FuturePlayer(handler, 200, 450, 64, 64));
		}
		
		//Static Entities
		
		entityManager.addEntity(new NPC1(handler, 450, 400));
		entityManager.addEntity(new NPC2(handler, 870, 470));
		entityManager.addEntity(new NPC3(handler, 880, 650));
		entityManager.addEntity(new NPC4(handler, 1620, 500));
		entityManager.addEntity(new Ditto(handler, 1300, 720));
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		this.image = image;
		
		
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int) (x* Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y* Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
		if(image.equals(Assets.StartRoute))
			g.drawImage(image, (int) (xStart - handler.getGameCamera().getxOffset()), (int) (yStart-handler.getGameCamera().getyOffset()), null);
		else
			g.drawImage(image, 0, 0, null);
		//System.out.println(image.getHeight());
		//Entities
		entityManager.render(g);
		if ((path.equals("res/worlds/world0.txt")) && (entityManager.getPlayer().getxPos() > 70 &&  entityManager.getPlayer().getxPos() < 150) && entityManager.getPlayer().getyPos() > 450) {
			handler.getGame().getGameState().changeWorld("res/worlds/world1.txt", Assets.StartRoute);
		}
	}
	
	public Tile getTile (int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	
}
