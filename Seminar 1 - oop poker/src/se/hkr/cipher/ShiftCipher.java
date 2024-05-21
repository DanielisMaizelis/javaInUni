package se.hkr.cipher;

import se.hkr.cipher.Cipher;

public class ShiftCipher implements Cipher
{
    private String decryptedWord;
    private String originalWord;
    private String encryptedWord;
    private int shiftNumber;

    public ShiftCipher(String originalWord, int shiftNumber)
    {
        this.originalWord = originalWord;
        this.shiftNumber = shiftNumber;
        this.encryptedWord = "";
        this.decryptedWord = "";
    }

    @Override
    public void encrypt()
    {
        // Turns the word string into an array
        char[] arr = this.originalWord.toCharArray();

        // Shift number is made to be less  than 26, if it is bigger than 26
        if(shiftNumber >= 26)
        {
            this.shiftNumber %= 26;
        }
        for (int i=0; i<this.originalWord.toCharArray().length; i++)
        {
            // If the character in the array is a letter
            if (arr[i]>= 'a' && arr[i]<='z' || (arr[i] >= 'A' && arr[i] <= 'Z'))
            {
                // Of this letters shift is exceeded and it is a lowercase letter
                if(arr[i] + this.shiftNumber > 'z' && (arr[i]>= 'a' && arr[i]<='z'))
                {
                    // The lowercase letter becomes the value of the shift number minus the last letter of the alphabet
                    // minus the value of the character
                    // This is then added to the character 'a' -1

                    // If w is shifted 5 times
                    // Then (97(char 'a' value) + 5(shift number) - (122(char 'z')-119(char 'w')))-1
                    // the result is (97+5-3)-1, which is 'b'
                    arr[i]= (char) ('a'+(char)this.shiftNumber-(('z'-arr[i]))-1);
                }
                else if (arr[i] + this.shiftNumber > 'Z' && (arr[i] >= 'A' && arr[i] <= 'Z'))
                {
                    // Same principal goes with the uppercase letters
                    arr[i]= (char) ('A'+(char)this.shiftNumber-(('Z'-arr[i]))-1);
                }
                // The shifting did not approach the limits of the value of the alphabet
                else
                {
                    // Shift the value by the shift number
                    arr[i] += (char) this.shiftNumber;
                }
            }
        }
        // Converts the encrypted array into a string
        this.encryptedWord = new String(arr);
    }

    @Override
    public void decrypt()
    {
        // Turns the encrypted  word string into an array
        char[] arr = this.encryptedWord.toCharArray();

        // Goes through each encrypted character
        for (int i=0; i<this.encryptedWord.toCharArray().length; i++)
        {
            // Character is a letter
            if (arr[i]>= 'a' && arr[i]<='z' || (arr[i] >= 'A' && arr[i] <= 'Z'))
            {
                // The letter shifted has approached the limit of the lowercase alphabet
                // The value is decreasing, since it is being decrypted
                if(arr[i] - this.shiftNumber < 'a' && (arr[i]>= 'a' && arr[i]<='z'))
                {
                    // The value is decrypted the same way as it was encrypted, but just in reverse
                    arr[i]= (char) ('Z'-(char)this.shiftNumber-(('A'-arr[i]))+1);
                }
                // The letter shifted has approached the limit of the uppercase alphabet
                else if (arr[i] - this.shiftNumber < 'A' && (arr[i] >= 'A' && arr[i] <= 'Z'))
                {
                    // The value is decrypted the same way as it was encrypted, but just in reverse
                    arr[i]= (char) ('Z'-(char)this.shiftNumber-(('A'-arr[i]))+1);
                }
                // If the shifting has not approached any limits
                else
                {
                    // It will shift the character by reducing its value using the shift number
                    arr[i] -= (char) this.shiftNumber;
                }
            }
        }
        // Converts the decrypted array into a string
        this.decryptedWord = new String(arr);
    }
    public String getEncryptedMessage()
    {
        return encryptedWord;
    }

    public String getDecryptedMessage()
    {
        return decryptedWord;
    }

}
