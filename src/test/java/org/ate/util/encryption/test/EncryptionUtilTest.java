package org.ate.util.encryption.test;

import org.ate.util.encryption.IEncryptionUtil;
import org.ate.util.test.BaseUtilTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EncryptionUtilTest extends BaseUtilTest {

	// Instance of IEncryptionUtil
	private IEncryptionUtil encryptionUtil;

	@Before
	public void setup() {

		// get/set the IEncryptionUtil instance from Spring
		this.encryptionUtil = (IEncryptionUtil) context.getBean( "encryptionUtil" );
	}

	@Test
	public void encryptDecrypt() {

		String plainText = "Are you the gate keeper?";

		// Encrypt
		String cipherText = encryptionUtil.encryptString( plainText );
		Assert.assertNotNull( "Encryption failed, the cipher text is null.", cipherText );
		Assert.assertFalse( "Encryption failed, the plain text and cipher text are equal.", plainText.equals( cipherText ) );
		Assert.assertFalse( "Encryption failed, the plain text and cipher text are the same length.", plainText.length() == cipherText.length() );
		Assert.assertFalse( "Encryption failed, the plain text is shorter than the cipher text.", plainText.length() > cipherText.length() );

		// Decrypt
		String decryptedCipherText = encryptionUtil.decryptString( cipherText );
		Assert.assertNotNull( "Decryption failed, the decrypted text is null.", decryptedCipherText );
		Assert.assertNotSame( "Decryption failed, the decrypted text and plain text are the same Object.", decryptedCipherText, plainText );
		Assert.assertTrue( "Decryption failed, the plain text does not equal the decrypted cipher text.", plainText.equals( decryptedCipherText ) );
	}

	@Test
	public void testDigest() {

		String strongPassword = "51Xyz450";
		String digest = encryptionUtil.digestString( strongPassword );
		Assert.assertNotNull( "Digest failed, the result is null.", digest );
	}

	@Test
	public void testMatches() {

		String strongPassword = "51Xyz450";
		String digest = encryptionUtil.digestString( strongPassword );
		String otherPassword = new String( "51Xyz450" );
		Assert.assertNotSame( "Can not test digest matching, both strings are the same Object", otherPassword, digest );
		Assert.assertTrue( "Digest matching failed.", encryptionUtil.matches( otherPassword, digest ) );
	}

	@Test
	public void digestNull() {

		String digest = encryptionUtil.digestString( null );
		Assert.assertEquals( null, digest );
	}

	@Test
	public void matchNull() {

		String strongPassword = "51Xyz450";
		String digest = encryptionUtil.digestString( strongPassword );
		String otherPassword = null;
		Assert.assertFalse( encryptionUtil.matches( digest, otherPassword ) );
		Assert.assertFalse( encryptionUtil.matches( otherPassword, digest ) );
	}
}
