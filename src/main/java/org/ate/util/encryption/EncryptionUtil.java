package org.ate.util.encryption;

import org.jasypt.digest.StringDigester;
import org.jasypt.encryption.StringEncryptor;

/**
 * This class provides a simple implementation of {@link IEncryptionUtil} and makes it easy to use.
 *
 * @author Adam Duke
 */
public class EncryptionUtil implements IEncryptionUtil {

	// private member for string encryption
	private StringEncryptor stringEncryptor;

	// private member for string digestion
	private StringDigester stringDigester;

	/**
	 *{@inheritDoc}
	 */
	public String encryptString( String plainText ) {

		return stringEncryptor.encrypt( plainText );
	}

	/**
	 * {@inheritDoc}
	 */
	public String decryptString( String cipherText ) {

		return stringEncryptor.decrypt( cipherText );
	}

	/**
	 * {@inheritDoc}
	 */
	public String digestString( String plainText ) {

		return stringDigester.digest( plainText );
	}

	/**
	 *{@inheritDoc}
	 */
	public Boolean matches( String messsage, String digest ) {

		return stringDigester.matches( messsage, digest );
	}

	/**
	 * Set the {@link StringEncryptor}
	 * @param stringEncryptor
	 */
	public void setStringEncryptor( StringEncryptor stringEncryptor ) {

		this.stringEncryptor = stringEncryptor;

	}

	/**
	 * Set the {@link StringDigester}
	 * @param stringDigester
	 */
	public void setStringDigester( StringDigester stringDigester ) {

		this.stringDigester = stringDigester;

	}
}
