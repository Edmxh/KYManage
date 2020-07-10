package com.example.kymanage.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Base64;
//import android.util.Base64;

public class Base64Tool {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println(base64Decoder("MTIzNDU="));
//		System.out.println(Decoding("TEo1NTI1MDAzMDI5"));//LJ5525003029
//		System.out.println(Decoding("TEo2MDI1MDA5Mzc4"));//LJ6025009378
//		System.out.println(base64Encode("ZJ9310000007"));//Wko5MzEwMDAwMDA3
//		System.out.println(base64Encode("LJ5525003029-A01"));//TEo1NTI1MDAzMDI5LUEwMQ==
//		System.out.println(base64Encode("LJ2015000594-A01"));//TEoyMDE1MDAwNTk0LUEwMQ==
//		System.out.println(base64Encode("LJ6025009378"));
//		System.out.println(base64Encode("CL1001000029"));//Q0wxMDAxMDAwMDI5
//		System.out.println(base64Encode("LJ7015001194"));//TEo3MDE1MDAxMTk0
//		System.out.println(base64Encode("LJ5525003029-TZ2010041014"));//TEo1NTI1MDAzMDI5LVRaMjAxMDA0MTAxNA==
//		System.out.println(base64Encode("LJ2015000594-TZ2010043020"));//TEoyMDE1MDAwNTk0LVRaMjAxMDA0MzAyMA==
//		System.out.println(base64Encode("LJ6510001528-A01"));//TEo2NTEwMDAxNTI4LUEwMQ==
//		System.out.println(base64Encode("LJ6510001528-A01"));//TEo2NTEwMDAxNTI4LUEwMQ==
//		System.out.println(base64Encode("LJ6510001463-A01"));//TEo2NTEwMDAxNDYzLUEwMQ==外协半成品收货
		System.out.println(base64Encode("LJ2015002373"));//TEoyMDE1MDAyMzcz
	}

//	// Base64 加密
//	public static String base64Encoder(String str) {
//		byte[] bytes = str.getBytes();
//		return Base64.getEncoder().encodeToString(bytes);
//	}
//
//	// Base64 解密
//	public static String base64Decoder(String encoded) {
//		byte[] decoded = Base64.getDecoder().decode(encoded);
//		return new String(decoded);
//
//	}

	private final static char base64Array[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '+', '/' };

	public static String base64Encode(String string) {
		String encodedString = "";
		byte bytes[] = string.getBytes();
		int i = 0;
		int pad = 0;
		while (i < bytes.length) {
			byte b1 = bytes[i++];
			byte b2;
			byte b3;
			if (i >= bytes.length) {
				b2 = 0;
				b3 = 0;
				pad = 2;
			} else {
				b2 = bytes[i++];
				if (i >= bytes.length) {
					b3 = 0;
					pad = 1;
				} else
					b3 = bytes[i++];
			}
			byte c1 = (byte) (b1 >> 2);
			byte c2 = (byte) (((b1 & 0x3) << 4) | (b2 >> 4));
			byte c3 = (byte) (((b2 & 0xf) << 2) | (b3 >> 6));
			byte c4 = (byte) (b3 & 0x3f);
			encodedString += base64Array[c1];
			encodedString += base64Array[c2];
			switch (pad) {
			case 0:
				encodedString += base64Array[c3];
				encodedString += base64Array[c4];
				break;
			case 1:
				encodedString += base64Array[c3];
				encodedString += "=";
				break;
			case 2:
				encodedString += "==";
				break;
			}
		}
		return encodedString;
	}

	// 解码索引表
	public static int[] indexDecode = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1,
			63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31,
			32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
	public static String Decoding(String inputStr) throws UnsupportedEncodingException {
		if (inputStr.length() % 4 != 0) { // 检查Base64编码每四个字节一组
			return "Base64编码格式错误，请重新检查！";
		}
		String s = "";
		for (int i = 0; i < inputStr.length(); i++) {
			int index = inputStr.charAt(i);
			if (index == '=') { // "="为补位，遇到了即代表结束
				break;
			}
			if (index >= indexDecode.length || indexDecode[index] == -1) { // 通过ASCII值检查Base64编码合法
				return "Base64编码格式错误，请重新检查！";
			}
			String tempStr = Integer.toBinaryString(indexDecode[inputStr.charAt(i)]);
			while (tempStr.length() != 6) { // 将每个字节还原成二进制，不足6位的前面补位(编码过程中截取6位为一个字节)
				tempStr = "0" + tempStr;
			}
			s += tempStr;
		}
		byte[] b = new byte[s.length() / 8];
		for (int i = 0, j = 0; i < b.length; i++, j += 8) { // 重新按8位截取一个字节，之前为补6位而补的0将直接被舍弃
			b[i] = new BigInteger(s.substring(j, j + 8), 2).byteValue();
		}
		String outputStr = new String(b, "utf-8");
		return outputStr;
	}

}
