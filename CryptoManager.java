/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: Computer Science class where we study object oriented design using Java programming language
 * Due: 10/21/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ivan Sergiyovych Dmytriiev
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (char charecter : plainText.toCharArray()) {
			if (charecter < LOWER_RANGE || charecter > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		// Check if the string is within bounds
	    for (int i = 0; i < plainText.length(); i++) {
	        char plainChar = plainText.charAt(i);
	        
	        // If any character is outside the range, return an error message
	        if (plainChar < LOWER_RANGE || plainChar > UPPER_RANGE) {
	            return "The selected string is not in bounds, Try again.";
	        }
	    }

	    StringBuilder encrypted = new StringBuilder();

	    for (int i = 0; i < plainText.length(); i++) {
	        char plainChar = plainText.charAt(i);
	        
	        // Shift the character by 'shift' amount
	        int encryptedChar = plainChar + key;

	        // Wrap the encryption within the printable ASCII range (32-126)
	        while (encryptedChar > UPPER_RANGE) {
	            encryptedChar -= RANGE;
	        }

	        encrypted.append((char) encryptedChar);
	    }

	    return encrypted.toString();
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		StringBuilder encrypted = new StringBuilder();
	    for (int i = 0; i < plainText.length(); i++) {
	        char plainChar = plainText.charAt(i);
	        char keyChar = bellasoStr.charAt(i % bellasoStr.length());

	        // Shift the plain character by the key character
	        int encryptedChar = plainChar + keyChar;

	        // Wrap around the range (LOWER_RANGE to UPPER_RANGE)
	        while (encryptedChar > UPPER_RANGE) {
	            encryptedChar -= RANGE;
	        }

	        encrypted.append((char) encryptedChar);
	    }

	    return encrypted.toString();
	}

	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
	    StringBuilder decrypted = new StringBuilder();
	    
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char encryptedChar = encryptedText.charAt(i);
	        // Shift characters back by 'key' amount
	        int decryptedChar = (encryptedChar - key);

	        // Wrap the decryption within the printable ASCII range (32-126)
	        while (decryptedChar < LOWER_RANGE) {
	            decryptedChar += RANGE;
	        }

	        decrypted.append((char) decryptedChar);
	    }

	    return decrypted.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		StringBuilder decrypted = new StringBuilder();
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char encryptedChar = encryptedText.charAt(i);
	        char keyChar = bellasoStr.charAt(i % bellasoStr.length());

	        // Shift the encrypted character by the key character in reverse
	        int decryptedChar = encryptedChar - keyChar;

	        // Wrap around the range (LOWER_RANGE to UPPER_RANGE)
	        while (decryptedChar < LOWER_RANGE) {
	            decryptedChar += RANGE;
	        }

	        decrypted.append((char) decryptedChar);
	    }

	    return decrypted.toString();
	}
}
