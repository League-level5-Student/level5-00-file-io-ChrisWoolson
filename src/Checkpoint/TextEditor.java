package Checkpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener{

	JFrame frame;
	JPanel panel;
	JButton save;
	JButton load;
	JTextArea text;
	String fileName;
	
	
	
	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		te.start();
	}
	
	
	
	public void start() {
		frame = new JFrame();
		panel = new JPanel();
		save = new JButton();
		load = new JButton();
		text = new JTextArea(10,40);
		
		frame.add(panel);
		panel.add(text);
		panel.add(load);
		panel.add(save);
		frame.setVisible(true);
		frame.pack();
		
		save.setText("Save");
		load.setText("Load");
		save.addActionListener(this);
		load.addActionListener(this);
		
		

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(save)) {
			String s = JOptionPane.showInputDialog("what is the name of the file you want to save to?");
			try {
				FileWriter fw = new FileWriter(s);
				fw.write(text.getText());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("failed");
			}
			
			
			
			
		}
		if(e.getSource().equals(load)) {
			
			
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				 fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
			
			
			
			
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String lines = "";
				String line = br.readLine();
				while(line != null){
					lines += line+"\n";
					System.out.println(line);
					line = br.readLine();
				}
				br.close();
				text.setText(lines);
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
	}
	
}
