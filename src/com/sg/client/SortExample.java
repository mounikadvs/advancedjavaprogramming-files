package com.sg.client;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		String[] names= {"Mounika","Manoj","Prachee","Sakshi","Sunitha"};
		Arrays.sort(names,(o1,o2)-> o1.length()-o2.length());
		for(String name:names) {
			System.out.println(name);
		}

	}

}
