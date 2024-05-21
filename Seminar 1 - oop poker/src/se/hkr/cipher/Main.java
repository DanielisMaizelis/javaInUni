package se.hkr.cipher;

public class Main
{
    public static void main(String[] args)
    {
        String originalMessage = "Hello world!";

        int shiftNumber = 4;
        String cypher   = "QWERTYUIOPASDFGHJKLZXCVBNM";

        ShiftCipher shiftCipher             = new ShiftCipher(originalMessage,shiftNumber);
        ReplacementCipher replacementCipher = new ReplacementCipher(originalMessage, cypher);

        shiftCipher.encrypt();
        shiftCipher.decrypt();

        replacementCipher.encrypt();
        replacementCipher.decrypt();

        menu(shiftCipher,replacementCipher,originalMessage);
    }

    public static void menu(ShiftCipher shiftCipher, ReplacementCipher replacementCipher, String originalMessage)
    {
        System.out.println("--- Encryption and Decryption Application ---\n");
        System.out.printf("Original Text: \"%s\"\n\n", originalMessage);
        System.out.printf("Encrypted Text (Shift Cipher): \"%s\"\n",shiftCipher.getEncryptedMessage());
        System.out.printf("Encrypted Text (Replacement Cipher): \"%s\"\n\n",replacementCipher.getEncryptedMessage());
        System.out.printf("Decrypted Text (Shift Cipher): \"%s\"\n",shiftCipher.getDecryptedMessage());
        System.out.printf("Decrypted Text (Replacement Cipher): \"%s\"\n",replacementCipher.getDecryptedMessage());
    }
}
