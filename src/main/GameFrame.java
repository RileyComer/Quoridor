package main;

import gameObjects.AI;

public class GameFrame {
	
	private int[][] vWalls;
	private int[][] hWalls;
	private AI bob;
	
	private int[] hover;
	
	private int p1x, p1y, p2x, p2y, playerTurn, walls1, walls2;
	
	public GameFrame() {
		vWalls = new int[8][9];
		hWalls = new int[9][8];
		
		p1x=4;
		p1y=0;
		
		p2x=4;
		p2y=8;
		
		playerTurn=0;
		
		walls1=10;
		walls2=10;
		
		hover=new int[3];
		hover[0]=-1;
		
		//testing
		bob=new AI(this);
	}
	 
	public void update(int[][] vWalls, int[][] hWalls, int p1x, int p1y, int p2x, int p2y) {
		 this.vWalls=vWalls;
		 this.hWalls=hWalls;
		 this.p1x=p1x;
		 this.p1y=p1y;
		 this.p2x=p2x;
		 this.p2y=p2y;
	}
	
	public void move(int x, int y) {
		if(playerTurn==0) {
			if((p2x==p1x || p2y==p1y) && (p1x+p1y+1==p2x+p2y || p1x+p1y-1==p2x+p2y)) {
				if(p2y==p1y+1) {
					if(hWalls[p1x][p1y]==0) {
						if(p1y+1!=9-1 && hWalls[p1x][p1y+1]==0) {
							if(x==p1x && y==p1y+2) {
								p1x=x;
								p1y=y;
								playerTurn=1;
								return;
							}
						}else { 
							if(p1x!=9-1 && vWalls[p1x][p1y+1]==0) {
								if(x==p1x+1 && y==p1y+1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
							if(p1x!=0 && vWalls[p1x-1][p1y+1]==0) {
								if(x==p1x-1 && y==p1y+1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
						}
					}
				}else if(p2y==p1y-1) {
					if(hWalls[p1x][p1y-1]==0) {
						if(p1y-1!=0 && hWalls[p1x][p1y-2]==0) {
							if(x==p1x && y==p1y-2) {
								p1x=x;
								p1y=y;
								playerTurn=1;
								return;
							}
						}else { 
							if(p1x!=9-1 && vWalls[p1x][p1y-1]==0) {
								if(x==p1x+1 && y==p1y-1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
							if(p1x!=0 && vWalls[p1x-1][p1y-1]==0) {
								if(x==p1x-1 && y==p1y-1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
						}
					}
				}else if(p2x==p1x+1) {
					if(vWalls[p1x][p1y]==0) {
						if(p1x+1!=9-1 && vWalls[p1x+1][p1y]==0) {
							if(x==p1x+2 && y==p1y) {
								p1x=x;
								p1y=y;
								playerTurn=1;
								return;
							}
						}else { 
							if(p1y!=9-1 && hWalls[p1x+1][p1y]==0) {
								if(x==p1x+1 && y==p1y+1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
							if(p1y!=0 && hWalls[p1x+1][p1y-1]==0) {
								if(x==p1x+1 && y==p1y-1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
						}
					}
				}else if(p2x==p1x-1) {
					if(vWalls[p1x-1][p1y]==0) {
						if(p1x-1!=0 && vWalls[p1x-2][p1y]==0) {
							if(x==p1x-2 && y==p1y) {
								p1x=x;
								p1y=y;
								playerTurn=1;
								return;
							}
						}else {
							if(p1y!=9-1 && hWalls[p1x-1][p1y]==0) {
								if(x==p1x-1 && y==p1y+1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
							if(p1y!=0 && hWalls[p1x-1][p1y-1]==0) {
								if(x==p1x-1 && y==p1y-1) {
									p1x=x;
									p1y=y;
									playerTurn=1;
									return;
								}
							}
						}
					}
				}
			}
			if((x==p1x || y==p1y) && (p1x+p1y+1==x+y || p1x+p1y-1==x+y) && !(x==p2x && y==p2y)) {
				if(x==p1x+1 && vWalls[p1x][p1y]==0) {
					p1x=x;
					p1y=y;
					playerTurn=1;
				}else if(x==p1x-1 && vWalls[p1x-1][p1y]==0) {
					p1x=x;
					p1y=y;
					playerTurn=1;
				}else if(y==p1y+1 && hWalls[p1x][p1y]==0) {
					p1x=x;
					p1y=y;
					playerTurn=1;
				}else if(y==p1y-1 && hWalls[p1x][p1y-1]==0) {
					p1x=x;
					p1y=y;
					playerTurn=1;
				}
			}
		}else if(playerTurn==1) {
			if((p2x==p1x || p2y==p1y) && (p1x+p1y+1==p2x+p2y || p1x+p1y-1==p2x+p2y)) {
				if(p1y==p2y+1) {
					if(hWalls[p2x][p2y]==0) {
						if(p2y+1!=9-1 && hWalls[p2x][p2y+1]==0) {
							if(x==p2x && y==p2y+2) {
								p2x=x;
								p2y=y;
								playerTurn=0;
								return;
							}
						}else {
							if(p2x!=9-1 && vWalls[p2x][p2y+1]==0) {
								if(x==p2x+1 && y==p2y+1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
							if(p2x!=0 && vWalls[p2x-1][p2y+1]==0) {
								if(x==p2x-1 && y==p2y+1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
						}
					}
				}else if(p1y==p2y-1) {
					if(hWalls[p2x][p2y-1]==0) {
						if(p2y-1!=0 && hWalls[p2x][p2y-2]==0) {
							if(x==p2x && y==p2y-2) {
								p2x=x;
								p2y=y;
								playerTurn=0;
								return;
							}
						}else {
							if(p2x!=9-1 && vWalls[p2x][p2y-1]==0) {
								if(x==p2x+1 && y==p2y-1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
							if(p2x!=0 && vWalls[p2x-1][p2y-1]==0) {
								if(x==p2x-1 && y==p2y-1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
						}
					}
				}else if(p1x==p2x+1) {
					if(vWalls[p2x][p2y]==0) {
						if(p2x+1!=9-1 && vWalls[p2x+1][p2y]==0) {
							if(x==p2x+2 && y==p2y) {
								p2x=x;
								p2y=y;
								playerTurn=0;
								return;
							}
						}else {
							if(p2y!=9-1 && hWalls[p2x+1][p2y]==0) {
								if(x==p2x+1 && y==p2y+1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
							if(p2y!=0 && hWalls[p2x+1][p2y-1]==0) {
								if(x==p2x+1 && y==p2y-1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
						}
					}
				}else if(p1x==p2x-1) {
					if(vWalls[p2x-1][p2y]==0) {
						if(p2x-1!=0 && vWalls[p2x-2][p2y]==0) {
							if(x==p2x-2 && y==p2y) {
								p2x=x;
								p2y=y;
								playerTurn=0;
								return;
							}
						}else {
							if(p2y!=9-1 && hWalls[p2x-1][p2y]==0) {
								if(x==p2x-1 && y==p2y+1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
							if(p2y!=0 && hWalls[p2x-1][p2y-1]==0) {
								if(x==p2x-1 && y==p2y-1) {
									p2x=x;
									p2y=y;
									playerTurn=0;
									return;
								}
							}
						}
					}
				}
			}
			if((x==p2x || y==p2y) && (p2x+p2y+1==x+y || p2x+p2y-1==x+y) && !(x==p1x && y==p1y)) {
				if(x==p2x+1 && vWalls[p2x][p2y]==0) {
					p2x=x;
					p2y=y;
					playerTurn=0;
				}else if(x==p2x-1 && vWalls[p2x-1][p2y]==0) {
					p2x=x;
					p2y=y;
					playerTurn=0;
				}else if(y==p2y+1 && hWalls[p2x][p2y]==0) {
					p2x=x;
					p2y=y;
					playerTurn=0;
				}else if(y==p2y-1 && hWalls[p2x][p2y-1]==0) {
					p2x=x;
					p2y=y;
					playerTurn=0;
				}
			}
		}
	}
	
	public void placeVWall(int x, int y) {
		if(vWalls[x][y]==0) {
			if(vWalls[x][y+1]==0) {
				if(hWalls[x][y]==0 || hWalls[x+1][y]==0) {
					if(playerTurn==0 && walls1>0) {
						vWalls[x][y]=y+1;
						vWalls[x][y+1]=y+1;
						playerTurn=1;
						walls1--;
					}else if(playerTurn==1 && walls2>0) {
						vWalls[x][y]=y+1;
						vWalls[x][y+1]=y+1;
						playerTurn=0;
						walls2--;
					}
				}
			}
		}
	}
	
	public void placeHWall(int x, int y) {
		if(hWalls[x][y]==0) {
			if(hWalls[x+1][y]==0) {
				if(vWalls[x][y]==0 || vWalls[x][y+1]==0) {
					if(playerTurn==0 && walls1>0) {
						playerTurn=1;
						hWalls[x][y]=x+1;
						hWalls[x+1][y]=x+1;
						walls1--;
					}else if(playerTurn==1 && walls2>0) {
						playerTurn=0;
						hWalls[x][y]=x+1;
						hWalls[x+1][y]=x+1;
						walls2--;
					}
				}
			}
		}
	}
	
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public int getWalls1() {
		return walls1;
	}
	
	public int getWalls2() {
		return walls2;
	}
	
	public int[][] getVWalls(){
		return vWalls;
	}
	
	public int[][] getHWalls(){
		return hWalls;
	}
	
	public int getP1x() {
		return p1x;
	}
	
	public int getP1y() {
		return p1y;
	}
	
	public int getP2x() {
		return p2x;
	}
	
	public int getP2y() {
		return p2y;
	}
	
	public int[] getHover(){
		return hover;
	}
	
	public void setHover(int type, int x, int y) {
		if(type==0) {
			if(playerTurn==0) {
				if((p2x==p1x || p2y==p1y) && (p1x+p1y+1==p2x+p2y || p1x+p1y-1==p2x+p2y)) {
					if(p2y==p1y+1) {
						if(hWalls[p1x][p1y]==0) {
							if(p1y+1!=9-1 && hWalls[p1x][p1y+1]==0) {
								if(x==p1x && y==p1y+2) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p1x!=9-1 && vWalls[p1x][p1y+1]==0) {
									if(x==p1x+1 && y==p1y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p1x!=0 && vWalls[p1x-1][p1y+1]==0) {
									if(x==p1x-1 && y==p1y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p2y==p1y-1) {
						if(hWalls[p1x][p1y-1]==0) {
							if(p1y-1!=0 && hWalls[p1x][p1y-2]==0) {
								if(x==p1x && y==p1y-2) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p1x!=9-1 && vWalls[p1x][p1y-1]==0) {
									if(x==p1x+1 && y==p1y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p1x!=0 && vWalls[p1x-1][p1y-1]==0) {
									if(x==p1x-1 && y==p1y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p2x==p1x+1) {
						if(vWalls[p1x][p1y]==0) {
							if(p1x+1!=9-1 && vWalls[p1x+1][p1y]==0) {
								if(x==p1x+2 && y==p1y) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p1y!=9-1 && hWalls[p1x+1][p1y]==0) {
									if(x==p1x+1 && y==p1y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p1y!=0 && hWalls[p1x+1][p1y-1]==0) {
									if(x==p1x+1 && y==p1y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p2x==p1x-1) {
						if(vWalls[p1x-1][p1y]==0) {
							if(p1x-1!=0 && vWalls[p1x-2][p1y]==0) {
								if(x==p1x-2 && y==p1y) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p1y!=9-1 && hWalls[p1x-1][p1y]==0) {
									if(x==p1x-1 && y==p1y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p1y!=0 && hWalls[p1x-1][p1y-1]==0) {
									if(x==p1x-1 && y==p1y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}
				}
				if((x==p1x || y==p1y) && (p1x+p1y+1==x+y || p1x+p1y-1==x+y) && !(x==p2x && y==p2y)) {
					if(x==p1x+1 && vWalls[p1x][p1y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(x==p1x-1 && vWalls[p1x-1][p1y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(y==p1y+1 && hWalls[p1x][p1y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(y==p1y-1 && hWalls[p1x][p1y-1]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else {
						hover[0]=-1;
						hover[1]=0;
						hover[2]=0;
					}
				}else {
					hover[0]=-1;
					hover[1]=0;
					hover[2]=0;
				}
			}else if(playerTurn==1) {
				if((p2x==p1x || p2y==p1y) && (p1x+p1y+1==p2x+p2y || p1x+p1y-1==p2x+p2y)) {
					if(p1y==p2y+1) {
						if(hWalls[p2x][p2y]==0) {
							if(p2y+1!=9-1 && hWalls[p2x][p2y+1]==0) {
								if(x==p2x && y==p2y+2) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p2x!=9-1 && vWalls[p2x][p2y+1]==0) {
									if(x==p2x+1 && y==p2y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p2x!=0 && vWalls[p2x-1][p2y+1]==0) {
									if(x==p2x-1 && y==p2y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p1y==p2y-1) {
						if(hWalls[p2x][p2y-1]==0) {
							if(p2y-1!=0 && hWalls[p2x][p2y-2]==0) {
								if(x==p2x && y==p2y-2) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p2x!=9-1 && vWalls[p2x][p2y-1]==0) {
									if(x==p2x+1 && y==p2y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p2x!=0 && vWalls[p2x-1][p2y-1]==0) {
									if(x==p2x-1 && y==p2y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p1x==p2x+1) {
						if(vWalls[p2x][p2y]==0) {
							if(p2x+1!=9-1 && vWalls[p2x+1][p2y]==0) {
								if(x==p2x+2 && y==p2y) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p2y!=9-1 && hWalls[p2x+1][p2y]==0) {
									if(x==p2x+1 && y==p2y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p2y!=0 && hWalls[p2x+1][p2y-1]==0) {
									if(x==p2x+1 && y==p2y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}else if(p1x==p2x-1) {
						if(vWalls[p2x-1][p2y]==0) {
							if(p2x-1!=0 && vWalls[p2x-2][p2y]==0) {
								if(x==p2x-2 && y==p2y) {
									hover[0]=type;
									hover[1]=x;
									hover[2]=y;
									return;
								}
							}else {
								if(p2y!=9-1 && hWalls[p2x-1][p2y]==0) {
									if(x==p2x-1 && y==p2y+1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
								if(p2y!=0 && hWalls[p2x-1][p2y-1]==0) {
									if(x==p2x-1 && y==p2y-1) {
										hover[0]=type;
										hover[1]=x;
										hover[2]=y;
										return;
									}
								}
							}
						}
					}
				}
				if((x==p2x || y==p2y) && (p2x+p2y+1==x+y || p2x+p2y-1==x+y) && !(x==p1x && y==p1y)) {
					if(x==p2x+1 && vWalls[p2x][p2y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(x==p2x-1 && vWalls[p2x-1][p2y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(y==p2y+1 && hWalls[p2x][p2y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else if(y==p2y-1 && hWalls[p2x][p2y-1]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else {
						hover[0]=-1;
						hover[1]=0;
						hover[2]=0;
					}
				}else {
					hover[0]=-1;
					hover[1]=0;
					hover[2]=0;
				}
			}
		}else if(type==1) {
			if(vWalls[x][y]==0) {
				if(vWalls[x][y+1]==0) {
					if(hWalls[x][y]==0 || hWalls[x+1][y]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else {
						hover[0]=-1;
						hover[1]=0;
						hover[2]=0;
					}
				}else {
					hover[0]=-1;
					hover[1]=0;
					hover[2]=0;
				}
			}else {
				hover[0]=-1;
				hover[1]=0;
				hover[2]=0;
			}
		}else if(type==2) {
			if(hWalls[x][y]==0) {
				if(hWalls[x+1][y]==0) {
					if(vWalls[x][y]==0 || vWalls[x][y+1]==0) {
						hover[0]=type;
						hover[1]=x;
						hover[2]=y;
					}else {
						hover[0]=-1;
						hover[1]=0;
						hover[2]=0;
					}
				}else {
					hover[0]=-1;
					hover[1]=0;
					hover[2]=0;
				}
			}else {
				hover[0]=-1;
				hover[1]=0;
				hover[2]=0;
			}
		}
	}
}
