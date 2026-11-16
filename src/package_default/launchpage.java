package package_default;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class launchpage implements ActionListener{
	JFrame frame = new JFrame("von abd entwickelt");
	JButton button = new JButton("Generiere Passwort");
	Random ran = new Random();
	JLabel lable = new JLabel("auf ''Generiere Passwort'' klicken...");
	JButton copy = new JButton("Kopieren");
	launchpage(){
		
		frame.setLayout(null);
		button.setBounds(130, 200, 200, 40);
		button.setFocusable(true);
		button.addActionListener(this);
		//button.setBackground(new java.awt.Color(100, 100, 100));
		//button.setBorderPainted(false);
		button.setFocusPainted(false);
		copy.setLayout(null);
		copy.addActionListener(this);
		copy.setBounds(130, 250, 200, 40);
		copy.setFocusPainted(false);
		copy.setBorderPainted(false);
		button.setBorderPainted(false);
		frame.add(button);
		frame.add(copy);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(460, 360);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new java.awt.Color(100, 100, 100));
		frame.add(lable);
		
		lable.setBounds(30,50,400,50);
		
		lable.setFont(new Font(null, Font.ITALIC, 25));
		lable.setForeground(Color.BLACK);
	}
	public static String password = "";
	@Override
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			this.lable.setBounds(120,50,400,50);
			password = "";
			
			for (int i = 0; i < 15; i++) { 
				if (ran.nextBoolean()) {
	                // random letter
	                char ranchar = (char) ('A' + ran.nextInt(26)); // uppercase
	                if (ran.nextBoolean()) ranchar = Character.toLowerCase(ranchar); // maybe lowercase
	                password += ranchar;
	            } else {
	                // random number
	                char rannum = (char) ('.' + ran.nextInt(20));
	                password += rannum;
	           
	            }
			
			}
			lable.setText(password);
		} else if (e.getSource() == copy) {
			StringSelection stringselect = new StringSelection(password);
			Clipboard clipping = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipping.setContents(stringselect, null);
		}
		
	}
	
	
}
