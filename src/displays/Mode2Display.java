package displays;
import java.awt.Color;
import java.awt.Graphics;

import main.GameFrame;
import main.Gui;

public class Mode2Display{
	
	private Gui gui;
	private GameFrame gameframe;
	private int size,startX,startY,frameW,frameH;
	//game stuff
	
	public Mode2Display(Gui gui1, GameFrame gameframe){
		gui=gui1;
		this.gameframe=gameframe;
		frameW=9;
		frameH=9;
	}
	
	public void render(Graphics g) {
		if((gui.getWidth()/frameW)<gui.getHeight()/frameH) {
			size=gui.getWidth()/frameW;
		}else {
			size=gui.getHeight()/frameH;
		}
		
		startX=(int)((gui.getWidth()/2.0)-((size*frameW)/2.0));
		startY=(int)((gui.getHeight()/2.0)-((size*frameH)/2.0));
		
		
		for(int y=0; y< frameH; y++) {
			for(int x=0; x<frameW;x++) {
				g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
				g.fillRect(startX+size*x, startY+size*((frameH-1)-y), size, size);
			}
		}
	}
}
