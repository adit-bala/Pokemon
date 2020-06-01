package dev.aditbala.Pokemon;

import dev.aditbala.Pokemon.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Pokemon!", 500, 500);
		game.start();
	}
}
