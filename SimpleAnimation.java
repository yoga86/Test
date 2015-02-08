import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
	int x = 70;
	int y = 70;
	int a = 40;
	int b = 40;
	
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		for(int i=0; i < 170; i++) {
			x++;
			y++;
			a++;
			b++;
			drawPanel.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception ex) {}
		}
	}
	class MyDrawPanel extends JPanel {
	public void paintComponent (Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.green);
		g.fillOval(x, y, a, b);
	}
	}
}