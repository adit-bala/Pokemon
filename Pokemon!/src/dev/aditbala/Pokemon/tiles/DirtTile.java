package dev.aditbala.Pokemon.tiles;

import java.awt.image.BufferedImage;

import dev.aditbala.Pokemon.gfx.Assets;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
