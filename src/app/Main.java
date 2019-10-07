package app;

public class Main {
	public static void main(String[] args) {
		Lexicon lex = new Lexicon();

		//String newWord = lex.translate("food");
		//System.out.println(newWord);

		//String word = decode("Hoenttingy.");
		//System.out.println(word);
		
		String message = decodeMessage("Daentrkingy deentclivityingy. Aingy sientngleingy, coentnstructoringy ruentnsingy. "
				+ "Beenttrayedingy byingy theent claentssingy.");
		System.out.println(message);
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
}