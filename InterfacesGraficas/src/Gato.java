import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gato implements Runnable {
	
	private JFrame frame;
	private final int WIDTH = 506;
	private final int HEIGHT = 527;
	private Thread thread;
	private Painter painter;
	private BufferedImage board;
	private BufferedImage redX;
	private BufferedImage blueCircle;
	private String[] espacios = new String[9];
	private boolean tuTurno = false;
	private boolean oponente = true;
	private boolean ganaste = false;
	private boolean enemigoGano = false;
	//private boolean empate = false;
	private int tamanoDelEspacio = 160;
	private int primerLugar = -1;
	private int segundoLugar = -1;
	private Font fuenteLarga = new Font("Verdana", Font.BOLD, 50);
	private String cadenaGano = "Ganaste!";
	private String cadenaEnemigoGano = "Perdiste!";
	//private String tieString = "Game ended in a tie.";
	private int[][] ganar = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

	/**
	 * <pre>
	 * 0, 1, 2 
	 * 3, 4, 5 
	 * 6, 7, 8
	 * </pre>
	 */

	int espera=0;
	
	public Gato() {
		cargarImagenes();
		painter = new Painter();
		painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame = new JFrame();
		frame.setTitle("Juego Gato");
		frame.setContentPane(painter);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		thread = new Thread(this, "Juego Gato");
		thread.start();	
	}

	public void run() {
		while (true) {
			tick();
			painter.repaint();
		}
	}

	private void render(Graphics g) {
		g.drawImage(board, 0, 0, null);
			for (int i = 0; i < espacios.length; i++) {
				if (espacios[i] != null) {
					if (espacios[i].equals("X")) {
						if (oponente) {
							g.drawImage(redX, (i % 3) * tamanoDelEspacio + 10 * (i % 3), (int) (i / 3) * tamanoDelEspacio + 10 * (int) (i / 3), null);
						} 
					} else if (espacios[i].equals("O")) {
						if (oponente) {
							g.drawImage(blueCircle, (i % 3) * tamanoDelEspacio + 10 * (i % 3), (int) (i / 3) * tamanoDelEspacio + 10 * (int) (i / 3), null);
						}
					}
				}
			}
			if (ganaste || enemigoGano) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(10));
				g.setColor(Color.BLACK);
				g.drawLine(primerLugar % 3 * tamanoDelEspacio + 10 * primerLugar % 3 + tamanoDelEspacio / 2, (int) (primerLugar / 3) * tamanoDelEspacio + 10 * (int) (primerLugar / 3) + tamanoDelEspacio / 2, segundoLugar % 3 * tamanoDelEspacio + 10 * segundoLugar % 3 + tamanoDelEspacio / 2, (int) (segundoLugar / 3) * tamanoDelEspacio + 10 * (int) (segundoLugar / 3) + tamanoDelEspacio / 2);

				g.setColor(Color.BLUE);
				g.setFont(fuenteLarga);
				if (ganaste) {
					int stringWidth = g2.getFontMetrics().stringWidth(cadenaGano);
					g.drawString(cadenaGano, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
				} else if (enemigoGano) {
					g.setColor(Color.RED);
					int stringWidth = g2.getFontMetrics().stringWidth(cadenaEnemigoGano);
					g.drawString(cadenaEnemigoGano, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
				}
			}
		/*	if (empate) {
				Graphics2D g2 = (Graphics2D) g;
				g.setColor(Color.BLACK);
				g.setFont(fuenteLarga);
				int stringWidth = g2.getFontMetrics().stringWidth(tieString);
				g.drawString(tieString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
			}*/
	}

	private void tick() {
		if (!tuTurno) {
		   final Random r = new Random();
	               int espacio = r.nextInt(9);
					 if (espacios[espacio] == null){ 
						    espacios[espacio] = "X";
							verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
					 }
					
					    else if(espacio==0 && espacios[0]==null){
	                    	espacios[0] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	}  
	                    
	                    else if(espacio==0 && espacios[1]==null){
	                    	espacios[1] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[2]==null){
	                    	espacios[2] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[3]==null){
	                    	espacios[3] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[4]==null){
	                    	espacios[4] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[5]==null){
	                    	espacios[5] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[6]==null){
	                    	espacios[6] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[7]==null){
	                    	espacios[7] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	} 
	                    
	                    else if(espacio==0 && espacios[8]==null){
	                    	espacios[8] = "X";
	                    	verificaSiGanoOponente();
							oponente = true;
							tuTurno = false;
                    	}  	
	                   
	                    else if(espacio==1 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==1 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==1 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==2 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==2 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==0 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==2 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
					 
		                else if(espacio==3 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==3 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==3 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==4 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==4 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==4 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==5 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==5 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==5 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==6 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==6 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==6 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==7 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==7 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==7 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }
	                     
		                else if(espacio==8 && espacios[0]==null){
		                    	espacios[0] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }  
		                    
		                else if(espacio==8 && espacios[1]==null){
		                    	espacios[1] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[2]==null){
		                    	espacios[2] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[3]==null){
		                    	espacios[3] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[4]==null){
		                    	espacios[4] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[5]==null){
		                    	espacios[5] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[6]==null){
		                    	espacios[6] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[7]==null){
		                    	espacios[7] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    } 
		                    
		                else if(espacio==8 && espacios[8]==null){
		                    	espacios[8] = "X";
		                    	verificaSiGanoOponente();
								oponente = true;
								tuTurno = false;
	                    }else 
	                    	   verificaSiGanoOponente();
						       tuTurno = true;    
		            }   		
	}

	private void verificaSiGanaste() {
		for (int i = 0; i < ganar.length; i++) {
			if (oponente) {
				if (espacios[ganar[i][0]] == "O" && espacios[ganar[i][1]] == "O" && espacios[ganar[i][2]] == "O") {
					primerLugar = ganar[i][0];
					segundoLugar = ganar[i][2];
					ganaste = true;
				}
			} else {
				if (espacios[ganar[i][0]] == "X" && espacios[ganar[i][1]] == "X" && espacios[ganar[i][2]] == "X") {
					primerLugar = ganar[i][0];
					segundoLugar = ganar[i][2];
					ganaste = true;
				}
			}
		}
	}

	protected void verificaSiGanoOponente() {
		for (int i = 0; i < ganar.length; i++) {
			if (oponente) {
				if (espacios[ganar[i][0]] == "X" && espacios[ganar[i][1]] == "X" && espacios[ganar[i][2]] == "X") {
					primerLugar = ganar[i][0];
					segundoLugar = ganar[i][2];
					enemigoGano = true;
				}
			} else {
				if (espacios[ganar[i][0]] == "O" && espacios[ganar[i][1]] == "O" && espacios[ganar[i][2]] == "O") {
					primerLugar = ganar[i][0];
					segundoLugar = ganar[i][2];
					enemigoGano = true;
				}
			}
		}
	}

	/*private void checkForTie() {
		for (int i = 0; i < spaces.length; i++) {
			if (spaces[i] == null) {
				return;
			}
		}
		tie = true;
	}*/

	private void cargarImagenes() {
		try {
			board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
			redX = ImageIO.read(getClass().getResourceAsStream("/redX.png"));
			blueCircle = ImageIO.read(getClass().getResourceAsStream("/blueCircle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Gato gato = new Gato();
	}

	private class Painter extends JPanel implements MouseListener {
		private static final long serialVersionUID = 1L;

		public Painter() {
			setFocusable(true);
			requestFocus();
			setBackground(Color.WHITE);
			addMouseListener(this);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			render(g);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (tuTurno && !ganaste && !enemigoGano) {
					int x = e.getX() / tamanoDelEspacio;
					int y = e.getY() / tamanoDelEspacio;
					y *= 3;
					int posicion = x + y;
					if (espacios[posicion] == null) {
						if (!oponente && espacios[posicion] == "O" && espacios[posicion] == "X"){
							espacios[posicion] = "X";
							tuTurno=true;
							oponente=false;
					}else espacios[posicion] = "O";
						tuTurno = false;
						oponente=true;
						repaint();
						verificaSiGanaste();
					}
				}	
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

	}

}