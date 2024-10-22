package Assigntment3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class CryptoManagerTestStudent {

    @Before
    public void setUp() throws Exception {
        // No setup required
    }

    @After
    public void tearDown() throws Exception {
        // No teardown required
    }

    @Test
    public void testStringInBounds() {
        // Valid bounds tests
        assertTrue(CryptoManager.isStringInBounds("HELLO")); // Valid characters within bounds
        assertTrue(CryptoManager.isStringInBounds("WORLD!")); // Valid characters within bounds
        
        // Invalid bounds tests
        assertFalse(CryptoManager.isStringInBounds("test")); // Invalid because of lowercase
        assertFalse(CryptoManager.isStringInBounds("{INVALID}")); // Invalid character out of bounds
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3)); // Shift right by 3
        assertEquals("WDR", CryptoManager.caesarEncryption("TAX", 3)); // Shift right by 3
        
        // Testing with a string outside the valid range
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("test", 3)); // Invalid input
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("{", 1)); // Invalid character
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3)); // Decrypting back
        assertEquals("TAX", CryptoManager.caesarDecryption("WDR", 3)); // Decrypting back
        
        // Testing decryption of invalid strings
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("test", 3)); // Invalid input
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("{", 1)); // Invalid character
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("KHOOR", CryptoManager.bellasoEncryption("HELLO", "ABCDE")); // Using ABCDE to encrypt HELLO
        assertEquals("PYS", CryptoManager.bellasoEncryption("XYZ", "ABC")); // Using ABC to encrypt XYZ
        
        // Testing with invalid input
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("test", "KEY")); // Invalid input
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("{", "KEY")); // Invalid character
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("HELLO", CryptoManager.bellasoDecryption("KHOOR", "ABCDE")); // Decrypting back to HELLO
        assertEquals("XYZ", CryptoManager.bellasoDecryption("PYS", "ABC")); // Decrypting back to XYZ
        
        // Testing decryption of invalid strings
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("test", "KEY")); // Invalid input
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("{", "KEY")); // Invalid character
    }
}
