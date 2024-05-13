package se.hkr.cipher;

import se.hkr.cipher.Cipher;

public class ReplacementCipher implements Cipher
{

    private String originalMessage;
    private String cypher;
    private String encryptedMessage;
    private String decryptedMessage;

    public ReplacementCipher(String originalWord, String cypher)
    {
        this.originalMessage  = originalWord;
        this.cypher           = cypher;
        this.encryptedMessage = "";
        this.decryptedMessage = "";
    }

    @Override
    public void encrypt()
    {
        // Cypher made into a char to know each character's index:
        char[] cypherCharArray    = cypher.toCharArray();
        // The message in only uppercase
        char[] upCaseOriginalWord = this.originalMessage.toUpperCase().toCharArray();
        // The original message
        char[] originalWordArr    = this.originalMessage.toCharArray();
        // The result of an encrypted message as a char array
        char[] encryptedMsgArr    = new char[100];

        // Encrypts a message with only uppercase letters
        for(int i = 0; i<this.originalMessage.length(); i++)
        {
            // If characters are uppercase letters:
            if(upCaseOriginalWord[i] >= 'A' && upCaseOriginalWord[i] <= 'Z')
            {
                // Each letter, when removing 65, gives the index of the cyphered alphabet
                encryptedMsgArr[i] += cypherCharArray[upCaseOriginalWord[i]-65];
            }
            // If characters are not uppercase letters, but other (like spaces,numbers, etc...)
            else
            {
                // Add the character from the original word array
                encryptedMsgArr[i] += originalWordArr[i];
            }
        }

        // Changes the message characters to lowercase letters
        for (int i = 0; i<this.originalMessage.length(); i++)
        {
            // If the character in the original word array is lowercase
            if(originalWordArr[i] >= 'a' && originalWordArr[i] <= 'z')
            {
                // Turn it to lowercase, since Uppercase and lowercase letter values
                // are separated by 32
                encryptedMsgArr[i] += 32;
            }
            // Concatenate the converted character to the encryptedMessage
            this.encryptedMessage += String.valueOf(encryptedMsgArr[i]);
        }
    }

    @Override
    public void decrypt()
    {
        // Cypher char array
        char[] cypherCharArray    = cypher.toCharArray();
        // Decrypted message
        char[] decryptedMsgArr    = new char[100];
        // Encrypted message
        char[] encryptedMsgArr    = this.encryptedMessage.toCharArray();
        // Encrypted message with uppercase letters
        char[] encryptedMsgCaps   = this.encryptedMessage.toUpperCase().toCharArray();

        // Goes through each character in the encrypted message
        for(int i = 0; i<this.encryptedMessage.length(); i++)
        {
            // If the encrypted message character is not a letter
            if(encryptedMsgCaps[i] < 'A' || encryptedMsgCaps[i] > 'Z')
            {
                decryptedMsgArr[i] = encryptedMsgCaps[i];
            }
            // Otherwise, search the letter in the ciphered alphabet
            else
            {
                // Goes through the ciphered alphabet
                for(int j=0; j<26; j++)
                {
                    // If it finds a character match between the encrypted character and the cypher character
                    if(encryptedMsgCaps[i] == cypherCharArray[j])
                    {
                        // 'j' is the index in the cyphered and the original alphabet
                        // The 'j' value is added to the char 'A', and a decrypted uppercase
                        // letter is received
                        decryptedMsgArr[i] = (char) ('A'+j);
                    }
                }
            }
        }

        for (int i = 0; i<this.encryptedMessage.length(); i++)
        {
            // If the character inside the encrypted array is lowercase
            if(encryptedMsgArr[i] >= 'a' && encryptedMsgArr[i] <= 'z')
            {
                // Turns the letter into a lowercase, by increasing the ascii value to 32
                decryptedMsgArr[i] += 32;
            }
            // Concatenate the converted character to the decryptedMessage
            this.decryptedMessage += String.valueOf(decryptedMsgArr[i]);
        }
    }

    public String getEncryptedMessage()
    {
        return encryptedMessage;
    }

    public String getDecryptedMessage()
    {
        return decryptedMessage;
    }
}
