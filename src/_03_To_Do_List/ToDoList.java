package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JFrame frame;
	JPanel panel;
	
	
	
	String recent = "";
	
	
	
	ArrayList<String> list;
	ToDoList(){
		frame = new JFrame();
		panel= new JPanel();
		String fileName;
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		list = new ArrayList<String>();
		
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.setVisible(true);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
		button1.setText("add task");
		button2.setText("view tasks");
		button3.setText("remove task");
		button4.setText("save list");
		button5.setText("load list");
		frame.pack();
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/Recent.txt"));
			
			String line5 = br.readLine();
//			while(line5 != null){
//				System.out.println(line5);
//				line5 = br.readLine();
//				recent = line5;
				
//			}
			recent = line5;
			System.out.println(recent);
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		ToDoList l = new ToDoList();
	
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			String s = JOptionPane.showInputDialog("Give a task");
			list.add(s);
		}
		
		if(e.getSource()==button2) {
			/* String whichFile = "";
			try {
				BufferedReader br2 = new BufferedReader(new FileReader(recent));
				
				whichFile = br2.readLine();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			*/
			
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(recent));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		
		if(e.getSource()==button3) {
			String v = JOptionPane.showInputDialog("which task do you want to remove (# starting at 0)");
			int w = Integer.parseInt(v);
			list.remove(w);
		}
		
		if(e.getSource()==button4) {
			
			
			try {
				FileWriter fw = new FileWriter(recent);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				for (int i = 0; i < list.size(); i++) {
					
				
				fw.write("\n"+ list.get(i));
					
				
				}
				fw.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			
			
			
		}
		
		if(e.getSource().equals(button5)) {
			String fileName = "";
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();
				
			}
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				ArrayList<String> listdos = new ArrayList<String>();
				String line2 = br.readLine();
				while(line2 != null){
					System.out.println(line2);
					line2 = br.readLine();
					listdos.add(line2);
				}
				
				br.close();
				
				list = listdos;
				
				
				
				
				
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
			
		}
		
	
	}
	
	
}
