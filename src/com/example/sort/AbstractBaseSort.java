package com.example.sort;

import java.util.Comparator;

public abstract class AbstractBaseSort{
	
	public <T> void swap(T[] list,int src, int dst){
		T temp;
		temp = list[src];
		list[src] = list[dst];
		list[dst] = temp;
	}

}
