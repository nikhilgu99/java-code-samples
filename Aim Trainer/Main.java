import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class Target extends JButton{
	JButton button;
	
	Random rand = new Random();
	
	static int score = 0;
	
	int coordX = rand.nextInt(450);
	int coordY = rand.nextInt(450);
	
	Target(ImageIcon icon, int targetSize){
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				score++;
				setVisible(false);
				System.out.println("HIT");
			}
		});
		
		setBorderPainted(false);
		setBounds(coordX, coordY, targetSize, targetSize);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setIcon(resizeIcon(icon, targetSize, targetSize));
		setVisible(false);
	}
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}

public class Main extends JFrame{
	//JFrame frame;
	Main(String title){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setSize(500, 500);
		setTitle(title);
		setVisible(true);
	}
	
	//Global elements
	static Main b = new Main("Aim Trainer");
	
	static JPanel startPanel = new JPanel();
	static JPanel gamePanel = new JPanel();
	static JPanel resultPanel = new JPanel();
	static JLabel titleLabel = new JLabel("Aim Trainer", SwingConstants.CENTER);
	static JButton startButton = new JButton("Start");
	static JLabel scoreLabel = new JLabel("", SwingConstants.CENTER);
	static JButton endButton = new JButton("Quit");
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter target size: ");
		//int size = sc.nextInt();
		
		/* Start screen */
		
		startPanel.setBackground(Color.black);
		startPanel.setBounds(0,0,500,500);
		
		titleLabel.setBounds(0, 0, 500, 100);
		titleLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
		titleLabel.setForeground(Color.white);
		
		startButton.setBounds(125, 100, 250, 100);
		startButton.setFont(new Font("Helvetica", Font.BOLD, 36));
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		
		startPanel.add(titleLabel);
		startPanel.add(startButton);
		
		/* Game screen */
		
		gamePanel.setBackground(Color.gray);
		gamePanel.setBounds(0, 0, 500, 500);
		gamePanel.setLayout(null);
		
		/* End of game result screen */
		resultPanel.setBackground(Color.black);
		resultPanel.setBounds(0, 0, 500, 500);
		
		scoreLabel.setBounds(0, 0, 500, 100);
		scoreLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
		scoreLabel.setForeground(Color.white);
		
		endButton.setBounds(125, 200, 250, 100);
		endButton.setFont(new Font("Helvetica", Font.BOLD, 36));
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		resultPanel.add(scoreLabel);
		resultPanel.add(endButton);
		
		b.add(startPanel);
		b.repaint();
	}
	
	static void startGame(){
		System.out.println("Starting Game");
		
		b.remove(startPanel);
		b.add(gamePanel);
		b.repaint();
		
		for(int x = 0; x <= 12; x++){
			ImageIcon icon = new ImageIcon("src/circles/circle" + x + ".png");
			gamePanel.add(new Target(icon, 50));
			gamePanel.repaint();
		}
		
		// Show circles for 1 second and then remove them.
		Component[] cList = gamePanel.getComponents();
		
		final Timer timer = new Timer(1000, null);
		timer.addActionListener(new ActionListener() {
			int loc = 0;
			
		    public void actionPerformed(ActionEvent evt) {
		    	System.out.println(loc);
		    	if (loc == 13) {
		    		timer.stop();
		    		endGame();
		    	}else{
		    		if(loc == 0){
		    			cList[0].setVisible(true);
		    			loc++;
		    		}else{
		    			cList[loc - 1].setVisible(false);
		    			cList[loc].setVisible(true);
		    			loc++;
		    		}
		    	}
		    }
		});
        timer.setRepeats(true);
        timer.start();
		
	}
	
	static void endGame(){
		System.out.println("Ending Game - " + Target.score + "/13");
		
		scoreLabel.setText("Score: " + Target.score + "/13");
		
		b.remove(gamePanel);
		b.add(resultPanel);
		b.repaint();
	}
}
