package dev.aditbala.Pokemon.entity.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.gfx.Text;
import dev.aditbala.Pokemon.tiles.Tile;
import javax.swing.Timer;

public class NPC4 extends StaticEntity implements ActionListener {

	private boolean start;
	private Timer timer;
	private int counter;
	
	public NPC4(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		timer  = new Timer(3500, this);
		start = false;
		counter = 0;
	}

	@Override
	public void toggleChat() {
		timer.start();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.trees, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		if(start) {
			g.drawImage(Assets.TextBox[0], 0, 300, 500, 200, null);
			Text.drawString(g, "All I can say is...", 25, 350, false, Color.BLACK, Assets.font24);
			Text.drawString(g, "good Luck...", 25, 400, false, Color.BLACK, Assets.font24);
			Text.drawString(g, ":)", 25, 450, false, Color.BLACK, Assets.font24);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		counter++;
		start = true;
		if(counter==2) {
			start = false;
			timer.stop();
		}
		
	}
}
