package PracticeCoding;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeExam {
JFrame frame;
JPanel panel;
JButton or;
JButton and;
JButton xor;
JTextField field;
JTextField field2;
	public static void main(String[] args) {
		PracticeExam pe = new PracticeExam();
		pe.setup();
		pe.stuff();
		
	}
	
	
	
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		or = new JButton();
		and = new JButton();
		xor = new JButton();
		field = new JTextField(5);
		field2 = new JTextField(5);
		frame.add(panel);
		panel.add(field);
		panel.add(field2);
		panel.add(and);
		panel.add(or);
		panel.add(xor);
		or.setText("or");
		and.setText("and");
		xor.setText("xor");
		
		frame.setVisible(true);
		frame.pack();

	}
	
	void stuff() {
		or.addActionListener((e)->{
			System.out.println("pressed or");
			String one= field.getText();
			String two = field2.getText();
			int uno = Integer.parseInt(one);
			int dos = Integer.parseInt(two);
			int f1 = uno|dos;
			System.out.println(f1);
			
			
			
		});
		and.addActionListener((e)->{
			String one= field.getText();
			String two = field2.getText();
			int uno = Integer.parseInt(one);
			int dos = Integer.parseInt(two);
			int f1 = uno&dos;
			System.out.println(f1);
		});
		xor.addActionListener((e)->{
			String one= field.getText();
			String two = field2.getText();
			int uno = Integer.parseInt(one);
			int dos = Integer.parseInt(two);
			int f1 = uno^dos;
			System.out.println(f1);
		});
	}
	
	
	
	
	
}
