package com.example.utils;

public class CommonUtil {
	static public void swap(int[] sort,int start ,int end){
		if(start == end) return;
		sort[start] = sort[start] ^ sort[end];
		sort[end] = sort[start] ^ sort[end];
		sort[start] = sort[start] ^ sort[end];
	}
	
	static public <T> void swap(T [] sort,int start ,int end){
		if(start == end) return;
		T temp = sort[start];
		sort[start] = sort[end];
		sort[end]  = temp;
	}
}
