package dev.aditbala.Pokemon.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(2);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile shrubsTile = new ShrubsTile(0);
	public static Tile centerTile = new CenterTile(3);
	public static Tile treesTile = new TreesTile(4);
	
	
	//CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	public int getId() {
		return id;
	}
}
