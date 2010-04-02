package org.ate.util.encryption;

/**
 * This class provides a generic interface for doing basic string encryption operations.
 *
 * @author Adam Duke
 *
 */
public interface IEncryptionUtil {

	/**
	 * Returns an encrypted String
	 *
	 * @param plainText The text to be encrypted
	 * @return The encrypted string
	 */
	public String encryptString( String plainText );

	/**
	 * Returns the decrypted plain text of a previously encrypted string
	 *
	 * @param cipherText The text to decrypt
	 * @return The decrypted string
	 */
	public String decryptString( String cipherText );

	/**
	 * Creates a message digest for the plainText. The digested string can not be retrieved. All
	 * attempts to verify that this digested message is equivalent to another message are equivalent should go through
	 * the matches method.
	 *
	 * @param plainText The message to be digested
	 * @return The string representing the digested message
	 */
	public String digestString( String plainText );

	/**
	 * Returns true if a call to the digestString method with a message produces the same result as a previously digested message, else false.
	 *
	 * @param messsage The message that should be matched to a previous digest
	 * @param digest The previously calculated digest
	 * @return {@link Boolean} value indicating that the message's digest is equivalent to a previous digest
	 */
	public Boolean matches( String messsage, String digest );

}
