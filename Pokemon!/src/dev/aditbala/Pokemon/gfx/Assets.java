package dev.aditbala.Pokemon.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	private static final int Game_width = 500, Game_height = 500;
	
	
	public static Font font24, font16;
	
	public static BufferedImage grass, dirt, shrubs, trees, center, background, StartRoute, ditto;
	public static BufferedImage[] player_down, player_up, player_left, player_right, StartScreen, TextBox, Doctor_down, Doctor_up, Doctor_left, Docter_right;
	
	public static void init() {
		font24 = FontLoader.loadFont("res/fonts/Pokemon GB.ttf", 22);
		font16 = FontLoader.loadFont("res/fonts/Pokemon GB.ttf", 16);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SimplePokemonTileset.png"));
		SpriteSheet textures = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonSpriteSheet.png"));
		SpriteSheet Start = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonStartScreens.png"));
		SpriteSheet Background = new SpriteSheet(ImageLoader.loadImage("/textures/Background.png"));
		SpriteSheet Routes = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonBackground.png")); 
		SpriteSheet textBox = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonTextBox.png"));
		SpriteSheet Doctor = new SpriteSheet(ImageLoader.loadImage("/textures/DoctorOak.png"));
		SpriteSheet Ditto = new SpriteSheet(ImageLoader.loadImage("/textures/ditto.png"));
		
		
		ditto = Ditto.crop(0, 0, width, height);
		TextBox = new BufferedImage[1];
		
		TextBox[0] = textBox.crop(0, 0, 500, 200);
		
		StartRoute = Routes.crop(0, 0, 2024, 944);
		
		background = Background.crop(0, 0, Game_width, Game_height);
	
		StartScreen = new BufferedImage[4];
		
		StartScreen[0] = Start.crop(0, 0, Game_width, Game_height);
		StartScreen[1] = Start.crop(Game_width, 0, Game_width, Game_height);
		StartScreen[2] = Start.crop(Game_width*2, 0, Game_width, Game_height);
		StartScreen[3] = Start.crop(Game_width*3, 0, Game_width, Game_height);
		
		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_up = new BufferedImage[4];
		
		player_down[0] = textures.crop(0, 0, width, height);
		player_down[1] = textures.crop(width, 0, width, height);
		player_down[2] = textures.crop(width*2, 0, width, height);
		player_down[3] = textures.crop(width*3, 0, width, height);
		
		player_left[0] = textures.crop(0, height, width, height);
		player_left[1] = textures.crop(width, height, width, height);
		player_left[2] = textures.crop(width*2, height, width, height);
		player_left[3] = textures.crop(width*3, height, width, height);
		
		player_right[0] = textures.crop(0, height*2, width, height);
		player_right[1] = textures.crop(width, height*2, width, height);
		player_right[2] = textures.crop(width*2, height*2, width, height);
		player_right[3] = textures.crop(width*3, height*2, width, height);
		
		player_up[0] = textures.crop(0, height*3, width, height);
		player_up[1] = textures.crop(width, height*3, width, height);
		player_up[2] = textures.crop(width*2, height*3, width, height);
		player_up[3] = textures.crop(width*3, height*3, width, height);
		
		Doctor_down = new BufferedImage[4];
		Doctor_left = new BufferedImage[4];
		Docter_right = new BufferedImage[4];
		Doctor_up = new BufferedImage[4];
		
		Doctor_down[0] = Doctor.crop(0, 0, width, height);
		Doctor_down[1] = Doctor.crop(width, 0, width, height);
		Doctor_down[2] = Doctor.crop(width*2, 0, width, height);
		Doctor_down[3] = Doctor.crop(width*3, 0, width, height);
		
		Doctor_left[0] = Doctor.crop(0, height, width, height);
		Doctor_left[1] = Doctor.crop(width, height, width, height);
		Doctor_left[2] = Doctor.crop(width*2, height, width, height);
		Doctor_left[3] = Doctor.crop(width*3, height, width, height);
		
		Docter_right[0] = Doctor.crop(0, height*2, width, height);
		Docter_right[1] = Doctor.crop(width, height*2, width, height);
		Docter_right[2] = Doctor.crop(width*2, height*2, width, height);
		Docter_right[3] = Doctor.crop(width*3, height*2, width, height);
		
		Doctor_up[0] = Doctor.crop(0, height*3, width, height);
		Doctor_up[1] = Doctor.crop(width, height*3, width, height);
		Doctor_up[2] = Doctor.crop(width*2, height*3, width, height);
		Doctor_up[3] = Doctor.crop(width*3, height*3, width, height);
	
		
		shrubs = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width*2, 0, width, height);
		center = sheet.crop(width*3, 0, width, height);
		trees = sheet.crop(width*4, 0, width, height);

		
		
	}
	
}
