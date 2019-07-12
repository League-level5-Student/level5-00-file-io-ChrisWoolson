package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		
	
	String s = JOptionPane.showInputDialog("input a message");
	String z = "";
	
	
	for (int i = 0; i < s.length(); i++) {
		z+= (char)(s.charAt(i)+2);
		z+= "0";
	}
	
	
	
	
	
	try {
		FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/Encrypt");
	
		fw.write(z);
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	}
	
}
