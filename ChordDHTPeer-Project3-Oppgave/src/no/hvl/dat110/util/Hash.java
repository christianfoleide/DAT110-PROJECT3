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
		
		try {
			
			MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
			int digestLength = md.getDigestLength() * 8;
			return digestLength;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
