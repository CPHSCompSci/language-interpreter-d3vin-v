package app;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Lexicon lex = new Lexicon();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Which function would you like to use: "); 
		System.out.println("1. Decode a word. \n2. Decode a sentence. \n3. Encode a word. \n4. Encode a sentence."); 
		int menu = scan.nextInt();
		scan.nextLine();
		  
		switch (menu) {
		  	case 1:
		  		System.out.println("Please enter the word you would like decoded: ");
		  		String decodeWord = scan.nextLine();
		  		String decodedW = decode(decodeWord);
				System.out.println(decodedW); 
				break; 
		  	case 2:
		  		System.out.println("Please enter the sentence you would like decoded: ");
		  		String decodePhrase = scan.nextLine();
		  		String decodedP = decodeMessage(decodePhrase, false);
		  		System.out.println(decodedP);
		  		break; 
		  	case 3:
		  		System.out.println("Please enter a word you would like encoded: "); 
		  		String encodeWord = scan.nextLine();
		  		String encodedW = encode(encodeWord); 
		  		System.out.println(encodedW); 
		  		break; 
		  	case 4:
		  		System.out.println("Please enter the sentence you would like encoded: "); 
		  		String encodePhrase = scan.nextLine();
		  		String encodedP = encodeMessage(encodePhrase);
		  		System.out.println(encodedP);
		  		break; 
		  	}
		 
		//String newWord = lex.translate("food");
		//System.out.println(newWord);

		//String word = decode("Hoenttingy.");
		//System.out.println(word);
		
		//String message = decodeMessage(Lexicon.getSample(2));
		//System.out.println(message);
		
		//String encodeWord = encode("Hilarious");
		//System.out.println(encodeWord);
		 
		scan.close();
	}
	
	public static String decode(String word) {
		String dWord = "";
		for(int i = 0; i < word.length(); i++) {
			if(i != word.length() - 1 && (word.charAt(i) == 'e' && word.charAt(i + 1) == 'n' && word.charAt(i + 2) == 't')) {
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

	public static String decodeMessage(String message, boolean encode) {
		String dMessage = "";
		int lastSpace = 0;
		for(int i = 0; i < message.length() - 1; i++) {
			if(message.charAt(i + 1) == ' ' && lastSpace == 0) { // first word
				String messageWord = message.substring(0, i + 1);
				if(encode = false) {
					dMessage += decode(messageWord) + ' ';
				}else {
					dMessage += encode(messageWord) + ' ';
				}
				lastSpace = i + 1;
			}else if(message.charAt(i + 1) == ' ' && lastSpace > 0) {
				String messageWord = message.substring(lastSpace + 1, i + 1);
				if(encode = false) {
					dMessage += decode(messageWord) + ' ';
				}else {
					dMessage += encode(messageWord) + ' ';
				}
				lastSpace = i + 1;
			}else if(message.charAt(i + 1) == '.' && message.lastIndexOf(" ") == lastSpace) { // last word
				String messageWord = message.substring(lastSpace + 1, i + 1);
				if(encode = false) {
					dMessage += decode(messageWord) + message.charAt(i + 1);
				}else {
					dMessage += encode(messageWord) + message.charAt(i + 1);
				}
				return dMessage;
			}
		}
		return dMessage;
	}

	public static String encode(String word) {
		String eWord = "";
		boolean firstVowel = false;
		for(int i = 0; i < word.length(); i++) {
			if(word.length() == 1) {
				eWord += word + "ingy";
				return eWord;
			}else if(firstVowel == false && (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || 
					word.charAt(i) == 'u')) {
				firstVowel = true;
				eWord += word.charAt(i) + "ent";
			}else if(i == word.length() - 1 || (i + 1 == ',' || i + 1 == '.')) {
				eWord += "ingy";
				if(word.charAt(i) == '.' || word.charAt(i) == ',') {
					eWord += word.charAt(i);
				}
				return eWord;
			}else {
				eWord += word.charAt(i);
			}
		}
		
		return eWord;
	}
	
	public static String encodeMessage(String message) {
		String eMessage = "";
		eMessage = decodeMessage(message, true);
		
		return eMessage;
	}
}