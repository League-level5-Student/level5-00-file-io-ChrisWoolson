package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public static void main(String[] args) {
		String l = "";
	
	try {
	BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/Encrypt"));
	String m = br.readLine();
	
	while(m != null){
		l = m;
		m = br.readLine();
	}
	
	
	
	
	
	
	
	}
	catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String q = "";
	for (int i = 0; i < l.length() ; i++) {
		if(i%2 == 0) {
			q+= (char)(l.charAt(i)-2);
		}
	}
	
	JOptionPane.showMessageDialog(null, q);;
	}
	
}
	
	

