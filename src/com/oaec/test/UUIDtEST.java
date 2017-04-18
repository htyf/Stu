package com.oaec.test;

import java.util.UUID;

public class UUIDtEST {
public static void main(String[] args) {
	UUID uuid = UUID.randomUUID();
	String s = uuid.toString();
	s = s.replaceAll("-", "");
	System.out.println(s);
}
}
