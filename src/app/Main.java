package app;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Lexicon lex = new Lexicon();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Which function would you like to use: ");
		System.out.println("1. Decode a word. \n2. Decode a sentence. \n3. Encode a word. \n4. Encode a sentence.");
		int menu = scan.nextInt();

		switch (menu) {
			case 1:
				System.out.println("Please enter the word you would like decoded: ");
				String decodeWord = scan.nextLine();
				
				decode(decodeWord);
				System.out.println(decodeWord);
				break;
			case 2:
				System.out.println("Plase enter the sentence you would like decoded: ");
				String decodePhrase = scan.nextLine();
				
				decodeMessage(decodePhrase);
				System.out.println(decodePhrase);
				break;
			case 3:
				//encode code
				System.out.println("encode");
				String encodeWord = scan.nextLine();
				
				encode(encodeWord);
				System.out.println(encodeWord);
				break;
			case 4:
				//encodeMessage code
				System.out.println("encodeMessage");
				String encodePhrase = scan.nextLine();
				
				break;
		}
			
		//String newWord = lex.translate("food");
		//System.out.println(newWord);

		//String word = decode("Hoenttingy.");
		//System.out.println(word);
		
		/*
		 * String message =
		 * decodeMessage("");
		 * System.out.println(message);
		 */
		scan.close();
	}

	/*
	 * This method decodes a single word.
	 * 
	 * @param word The single word to be decoded.
	 */
	
	public static String decode(String word) {
		String dWord = "";
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == 'e' && word.charAt(i + 1) == 'n' && word.charAt(i + 2) == 't') {
				i += 2;
			}else if(word.charAt(i) == 'i' && word.charAt(i + 1) == 'n' && word.charAt(i + 2) == 'g' && word.charAt(i + 3) == 'y') {
				if(word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1) == ',') {
					dWord += word.charAt(word.length() - 1);
				}
				return dWord;
			}else if(i == word.length()) {
				return dWord;
			}else {
				dWord += word.charAt(i);
			}
		}
		return dWord;
	}

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
	public static String decodeMessage(String message) {
		System.out.println(message.lastIndexOf(" "));
		String dMessage = "";
		int lastSpace = 0;
		for(int i = 0; i < message.length() - 1; i++) {
			System.out.println(lastSpace);
			if(message.charAt(i + 1) == ' ' && lastSpace == 0) { // first word
				System.out.print("1 ");
				String messageWord = message.substring(0, i + 1);
				dMessage += decode(messageWord) + ' ';
				lastSpace = i + 1;
				System.out.println(dMessage);
			}else if(message.charAt(i + 1) == ' ' && lastSpace > 0) {
				System.out.print("2 ");
				String messageWord = message.substring(lastSpace + 1, i + 1);
				dMessage += decode(messageWord) + ' ';
				lastSpace = i + 1;
				System.out.println(dMessage);
			}else if(message.charAt(i + 1) == '.' && message.lastIndexOf(" ") == lastSpace) { // last word 
				System.out.print("3 ");
				String messageWord = message.substring(lastSpace + 1, i + 1);
				dMessage += decode(messageWord) + message.charAt(i + 1);
				System.out.println(dMessage);
				return dMessage;
			}
		}
		return dMessage;
	}
	
	public static String encode(String word) {
		
		return "";
	}
}