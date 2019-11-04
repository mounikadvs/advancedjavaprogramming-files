package com.sg.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantExample {

	public static void main(String[] args) {
		
		List<Integer> iList = Arrays.asList(2,78,789,34,122,33);
		List<String> sList = Arrays.asList("Hello","World","Java","World");
		print(iList);
		print(sList);
		
		List<String> copystr=new ArrayList<>();
		List<Integer> copyint=new ArrayList<>();
		
		copy(copyint,iList);
		copy(copystr,sList);

	}
	private static <T> void copy(List<T> dest,List<T> source) {
		for(T o :source) {
			dest.add(o);
		}
	}
	/*private static <T> void copy(List<? super T> dest,List<? extends T> source) {
		for(T o :source) {
			dest.add(o);
		}
	}*/
	private static void print(List<?> list) {
		for(Object o :list) {
			System.out.println(o);
		}
	}

}
