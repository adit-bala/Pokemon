package dev.aditbala.Pokemon.entity.statics;

import java.awt.Graphics;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.tiles.Tile;
import dev.aditbala.Pokemon.ui.ClickListener;
import dev.aditbala.Pokemon.ui.UIManager;
import dev.aditbala.Pokemon.ui.UITextButton;

public class NPC1 extends StaticEntity {

	private UIManager uiManager;
	
	public NPC1(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void toggleChat() {
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}
}
