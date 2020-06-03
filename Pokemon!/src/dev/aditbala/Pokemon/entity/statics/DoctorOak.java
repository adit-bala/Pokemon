package dev.aditbala.Pokemon.entity.statics;

import java.awt.Graphics;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.tiles.Tile;

public class DoctorOak extends StaticEntity {

	public DoctorOak(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.Docter_right[0], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	

}
