package dev.aditbala.Pokemon.entity.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.aditbala.Pokemon.Handler;
import dev.aditbala.Pokemon.gfx.Assets;
import dev.aditbala.Pokemon.gfx.Text;
import dev.aditbala.Pokemon.states.State;
import dev.aditbala.Pokemon.tiles.Tile;
import javax.swing.Timer;


public class Ditto extends StaticEntity implements ActionListener{

	private boolean start;
	private Timer timer;
	
	public Ditto(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		timer  = new Timer(3000, this);
	}

	public void BattleTime() {
		timer.start();
	}
	
	@Override
	public void toggleChat() {
		start=true;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.ditto, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		if(start) {
			g.drawImage(Assets.TextBox[0], 0, 300, 500, 200, null);
			Text.drawString(g, "HEHEHE...", 25, 350, false, Color.BLACK, Assets.font24);
			Text.drawString(g, "FIGHT ME!", 25, 400, false, Color.BLACK, Assets.font24);
			Text.drawString(g, "DITTO DIT DITTO", 25, 450, false, Color.BLACK, Assets.font24);
			BattleTime();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		start = false;
		State.setState(handler.getGame().battleState);
		timer.stop();
		
	}
}
