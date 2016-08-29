package com.hdsx.zhglpt.xtgl.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Encoder;

public class TEST {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md5;
		String temp="";
		String sKey="zkrhdsxjx_";
		md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base = new BASE64Encoder();
		temp = base.encode(md5.digest("1".getBytes()));
		System.out.println(temp);
		String NewPW = DigestUtils.md5Hex(sKey+temp);
		System.out.println("::"+NewPW+":::");
		System.out.println("852d342244c118e03afd90740cfb7449".equals(NewPW));
	}

}
