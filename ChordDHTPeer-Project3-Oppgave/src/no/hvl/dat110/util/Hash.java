package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	private static final String HASH_ALGORITHM = "MD5";
	
	public static BigInteger hashOf(String entity) {		
		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		
		MessageDigest md;
		String hex = "";
		
		try {
			
			md = MessageDigest.getInstance(HASH_ALGORITHM);
			md.update(entity.getBytes());
			byte [] digest = md.digest();
			hex = toHex(digest);
				
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		hashint = new BigInteger(hex, 16);
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		try {
			
			
			MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
			int digestLength = md.getDigestLength() * 8;
			BigInteger size = (new BigInteger("2").pow(digestLength));
			return size;
			
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
