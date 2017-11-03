import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class SpeedReader {
	String filename; 
	int width; 
	int height; 
	int fontsize; 
	int wpm; 

	/*
	 * Construct a new SpeedReader that process from the given arguments 
	 */
	public SpeedReader (String filename, int width, int height, int fontsize, int wpm ){ 
		this.filename = filename;
		this.width = width; 
		this.height = height;
		this.fontsize = fontsize; 
		this.wpm = wpm; 

	}

	/*
	 *  Create a panel with width and height, set the font size with font size, 
	 *  display each word in from the file at the given speed wpm. 
	 */
	public void speedRead() throws InterruptedException, IOException {
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontsize);
		g.setFont(f);
		WordGenerator w1 = new WordGenerator (filename); 
		int centery = (height - g.getFontMetrics(f).getHeight())/2 + g.getFontMetrics(f).getAscent();   					 /*Find the center coordinate that place the string in y axis*/
		double sleeptime = 60.0 /wpm;
		while (w1.hasNext()) {
			String s = w1.next();
			if (s.length() == 0 || s.length() == 1 ) {
				g.setColor(Color.RED);
				g.drawString(s.substring(0), (width- g.getFontMetrics(f).stringWidth(s))/2, centery);	   						 /*Paint the first letter to red when the length = 0-1*/ 
			}
			else if (s.length() >= 2 && s.length() <= 5 ) {
				int  centerx = (width- g.getFontMetrics(f).stringWidth(s.substring(1,2)))/2;									/* Find the center of x coordinate of the focus letter */
				g.drawString(s.substring(0,1), centerx - g.getFontMetrics(f).stringWidth(s.substring(0,1)), centery); 		/*Draw the first letter in black*/
				g.setColor(Color.RED);
				g.drawString(s.substring(1,2), centerx, centery); 															/*Draw the second letter in red */
				g.setColor(Color.BLACK);
				g.drawString(s.substring(2,s.length()), centerx + g.getFontMetrics(f).stringWidth(s.substring(1,2)), centery);  /* Draw the rest letter in black */
			}
			else if (s.length() >= 6 && s.length() <= 9 ) {
				int  centerx = (width- g.getFontMetrics(f).stringWidth(s.substring(3,4)))/2;  								/* Find the center of x coordinate of the focus letter */ 
				g.drawString(s.substring(0,2), centerx - g.getFontMetrics(f).stringWidth(s.substring(0,2)), centery); 		/* Draw the 1-2 letter in black */
				g.setColor(Color.RED);
				g.drawString(s.substring(2,3), centerx, centery); 															/*Draw the third letter in red */
				g.setColor(Color.BLACK);
				g.drawString(s.substring(3,s.length()), centerx + g.getFontMetrics(f).stringWidth(s.substring(3,4)), centery); /* Draw the rest letter in black */
			}
			else if (s.length() >= 10 && s.length() <= 13 ) {
				int  centerx = (width- g.getFontMetrics(f).stringWidth(s.substring(4,5)))/2;									/* Find the center of x coordinate of the focus letter */ 
				g.drawString(s.substring(0,3), centerx - g.getFontMetrics(f).stringWidth(s.substring(0,3)), centery); 		/* Draw the 1-3 letter in black */
				g.setColor(Color.RED);
				g.drawString(s.substring(3,4), centerx, centery); 															/*Draw the forth letter in red */
				g.setColor(Color.BLACK);
				g.drawString(s.substring(4,s.length()), centerx + g.getFontMetrics(f).stringWidth(s.substring(4,5)), centery);  /* Draw the rest letter in black */
			}
			else if (s.length() > 13 ) {
				int  centerx = (width- g.getFontMetrics(f).stringWidth(s.substring(5,6)))/2;									/* Find the center of x coordinate of the focus letter */ 
				g.drawString(s.substring(0,4), centerx - g.getFontMetrics(f).stringWidth(s.substring(0,4)), centery); 		/* Draw the 1-4 letter in black */
				g.setColor(Color.RED);
				g.drawString(s.substring(4,5), centerx, centery); 															/* Draw the fifth letter in red */
				g.setColor(Color.BLACK);
				g.drawString(s.substring(5,s.length()), centerx + g.getFontMetrics(f).stringWidth(s.substring(5,6)), centery); /* Draw the rest letter in black */
			}
			Thread.sleep((long) (sleeptime*1000));        																	/* Get how much time each word will show up */
			g.setColor(Color.WHITE);																		        /* Set the color to white */
			g.fillRect(0, 0, width, height);            												 				        /* paint the whole image to white */
			g.setColor(Color.BLACK);                    																	/* change color back to black */
		}
		String word_sentence = "words =" + w1.getWordCount() + " Sentences =" + w1.getSentenceCount();
		g.drawString(word_sentence, (width- g.getFontMetrics(f).stringWidth(word_sentence))/2, centery);	
		
	}

	public static void main(String[] args) throws IOException, InterruptedException{
		if (args.length == 5) {                            															/* to check if there are exactly 5 arguments in total */ 
		SpeedReader s1 = new SpeedReader (args[0], Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]), Integer.parseInt(args[4]));
		s1.speedRead(); 
		}
		else
		{
		System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>"); 								/* Print out the usage message */
		}
	}

}
