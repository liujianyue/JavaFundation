package com.example.sort;

import java.util.Comparator;

public class ShellSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		int gap = 1,length = list.length;
		while(gap < length/3){
			gap = gap * 3 + 1;
		}
		while(gap > 0){
			T temp;
			int j;
			for(int i = gap; i < length; ++i){
				temp = list[i];
				j = i - gap;
				while(j >= 0 && list[j].compareTo(temp) > 0){
					list[i] = list[j];
					j -= gap;
				}
				list[j + gap] = temp;
			}
			gap /= gap;
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		int gap = 1,length = list.length;
		while(gap < length/3){
			gap = gap * 3 + 1;
		}
		while(gap > 0){
			T temp;
			int j;
			for(int i = gap; i < length; ++i){
				temp = list[i];
				j = i - gap;
				while(j >= 0 && mComparator.compare(list[j], temp) > 0){
					list[i] = list[j];
					j -= gap;
				}
				list[j + gap] = temp;
			}
			gap /= gap;
		}
	}

}
