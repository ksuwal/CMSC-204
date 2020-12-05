import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Kabindra Raj Suwal
 * class to convert Morse code to English
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree mct = new MorseCodeTree();
	
	/**
	 * returns a string with all the data in the tree
	 * in LNR order with an space in between them.
	 * @return
	 */
	public static String printTree(){
		ArrayList<String> codeTree = mct.toArrayList();
		String display = "";
		for(String letter: codeTree) {
			display += letter + " ";
		}
		return display.trim();
	}

	
	/**
	 * Converts Morse code into English.
	 * Each letter is delimited by a space (‘ ‘). 
	 * Each word is delimited by a ‘/’.
	 * @param mCode
	 * @return
	 */
	public static String convertToEnglish(String mCode){
		
		String[] alphabet;
		String[] word = mCode.split(" / ");
		String engTrans = "";

		for(String temp: word) {
			alphabet = temp.split(" ");
			for(String tempLetter: alphabet) {
				engTrans +=mct.fetch(tempLetter);
			}

			engTrans += " ";
			
		}
		return engTrans.trim();
	}
	
	
	/**
	 * Converts a file of Morse code into English
	 * Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’.
	 * @param codeFile
	 * @return
	 * @throws FileNotFoundException when file not found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		Scanner s = new Scanner(codeFile);
		String fileMCode = "";
		
		while(s.hasNextLine())
			fileMCode += s.nextLine() + "\n"; 
		s.close();
		return convertToEnglish(fileMCode.trim());
	}	
	
}