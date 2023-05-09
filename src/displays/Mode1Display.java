package displays;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import main.GameFrame;
import main.Gui;

public class Mode1Display{
	
	private Gui gui;
	private GameFrame gameframe;
	private int size,startX,startY,frameW,frameH, gap, edge;
	private Color board, wall, background, player1, player2, hoverColor;
	//game stuff
	
	public Mode1Display(Gui gui1, GameFrame gameframe){
		gui=gui1;
		this.gameframe=gameframe;
		frameW=9;
		frameH=9;
		gap=20;
		edge=300;
		
		//Colors
		wall=new Color(185, 127, 50);
		board=new Color(200, 200, 200);
		background=new Color(60, 60, 60);
		player1=new Color(255, 0, 0);
		player2=new Color(0, 0, 255);
		hoverColor=new Color(0, 255, 255);
	}
	
	public void render(Graphics g) {
		if(((gui.getWidth()-(edge*2))/frameW)<gui.getHeight()/frameH) {
			size=((gui.getWidth()-(edge*2)-(gap*(frameW-1)))/frameW);
		}else {
			size=((gui.getHeight()-(gap*(frameH-1)))/frameH);
		}
		
		startX=(int)((gui.getWidth()/2.0)-((size*frameW+gap*(frameW-1))/2.0));
		startY=(int)((gui.getHeight()/2.0)-((size*frameH+gap*(frameH-1))/2.0));
		
		int[] hover=gameframe.getHover();
		
		g.setColor(background);
		g.fillRect(startX-edge, startY, edge*2+size*frameW+gap*(frameW-1), size*frameH+gap*(frameH-1));
		
		g.setColor(wall);
		for(int i=0; i<gameframe.getWalls1(); i++) {
			g.fillRect(startX-edge+gap, startY+(gap*i*4)+edge, size*2+gap, gap);
		}
		
		g.setColor(wall);
		for(int i=0; i<gameframe.getWalls2(); i++) {
			g.fillRect(startX+size*frameW+gap*frameW, startY+(gap*i*4)+edge, size*2+gap, gap);
		}
		for(int y=0; y< frameH; y++) {
			for(int x=0; x<frameW;x++) {
				g.setColor(board);
				if(hover[0]==0 && x==hover[1] && y==hover[2]) {
					g.setColor(hoverColor);
				}
				g.fillRect(startX+size*x+(gap*x), startY+size*((frameH-1)-y)+(gap*((frameH-1)-y)), size, size);
				
				if(x!=frameW-1 && gameframe.getVWalls()[x][y]!=0) {
					g.setColor(wall);
					g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-y)), gap, size);
					if(y!=frameH-1 && gameframe.getVWalls()[x][y+1]==gameframe.getVWalls()[x][y]) {
						g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), gap, gap);
					}
				}else if(hover[0]==1 && x==hover[1] && (y==hover[2] || y-1==hover[2])) {
					g.setColor(hoverColor);
					g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-y)), gap, size);
					if(y==hover[2]) {
						g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), gap, gap);
					}
				}
				if(y!=frameH-1 && gameframe.getHWalls()[x][y]!=0) {
					g.setColor(wall);
					g.fillRect(startX+size*x+(gap*x), startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), size, gap);
					if(x!=frameW-1 && gameframe.getHWalls()[x+1][y]==gameframe.getHWalls()[x][y]) {
						g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), gap, gap);
					}
				}else if(hover[0]==2 && (x==hover[1] || x-1==hover[1]) && y==hover[2]) {
					g.setColor(hoverColor);
					g.fillRect(startX+size*x+(gap*x), startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), size, gap);
					if(x==hover[1]) {
						g.fillRect(startX+size*x+(gap*x)+size, startY+size*((frameH-1)-y)+(gap*((frameH-1)-(y+1))), gap, gap);
					}
				}
				if(x==gameframe.getP1x() && y==gameframe.getP1y()) {
					if(gameframe.getPlayerTurn()==0) {
						g.setColor(new Color(0, 255, 0));
						g.fillRect((int)(startX+size*x+(gap*x)-0.1*gap), (int)(startY+size*((frameH-1)-y)+(gap*((frameH-1)-y))-0.1*gap), (int)(size+0.2*gap), (int)(size+0.2*gap));
					}
					g.setColor(player1);
					g.fillRect(startX+size*x+(gap*x), startY+size*((frameH-1)-y)+(gap*((frameH-1)-y)), size, size);
				}
				if(x==gameframe.getP2x() && y==gameframe.getP2y()) {
					if(gameframe.getPlayerTurn()==1) {
						g.setColor(new Color(0, 255, 0));
						g.fillRect((int)(startX+size*x+(gap*x)-0.1*gap), (int)(startY+size*((frameH-1)-y)+(gap*((frameH-1)-y))-0.1*gap), (int)(size+0.2*gap), (int)(size+0.2*gap));
					}
					g.setColor(player2);
					g.fillRect(startX+size*x+(gap*x), startY+size*((frameH-1)-y)+(gap*((frameH-1)-y)), size, size);
				}
			}
		}
	}
}