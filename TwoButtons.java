import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Сменить надпись");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Сменить круг");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("Надо что-то сменить");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(600,400);
		frame.setVisible(true);
	}
	class ColorListener implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}
	
	}
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		

		//Создать три набора слов для выбора.
  String[] wordListOne = {"круглосутоный", "трех-звенный", "30000-футовый", "взаимный", "обоюдный выигрыш", "фронтэнд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм", "метод критического пути", "динамичный"};
  String[] wordListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный", "распеределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный", "сетевой", "сфокусированный", "использованный с выгодой", "выровненный", "нацеленный на", "общий", "совместный", "ускоренный"};
  String[] wordListThree = {"процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант", "подход", "уровень завоеванного внимания", "портал", "период времени", "обзор", "образец", "пункт следования"};
  //Вычисляем, сколько слов в каждом спистке
  int oneLength = wordListOne.length;
  int twoLength = wordListTwo.length;
  int threeLength = wordListThree.length;
  //Генерируем три случайных числа
  int rand1 = (int) (Math.random() * oneLength);
  int rand2 = (int) (Math.random() * twoLength);
  int rand3 = (int) (Math.random() * threeLength);
  //Теперь строим фразу
  String phrase = wordListOne[rand1]+" "+wordListTwo[rand2]+" "+wordListThree[rand3];
 

	label.setText(phrase);
	}
	}
	
}

class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColor = new Color(red, green, blue);
		
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColor = new Color(red, green, blue);
		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 150, 150);
				
	}
}