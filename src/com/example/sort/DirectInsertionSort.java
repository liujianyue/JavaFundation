package com.example.sort;

import java.util.Comparator;

public class DirectInsertionSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		for(int i= 1,length = list.length; i < length;++i){
			T temp = list[i];
			int j;
			for(j = i + 1;j >= 0; --j){
				if(list[j].compareTo(temp) > 0){
					list[j + 1] = list[j];
				}else{
					break;
				}
			}
			list[j + 1] = temp;
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		for(int i= 1,length = list.length; i < length;++i){
			int markIndex = i;
			int j;
			for(j = i + 1;j >= 0; --j){
				if(mComparator.compare(list[j], list[markIndex]) > 0){
					list[j + 1] = list[j];
				}else{
					break;
				}
			}
			list[j + 1] = list[markIndex];
		}
	}

}
