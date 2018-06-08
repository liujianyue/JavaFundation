package com.example.sort;

import java.util.Comparator;

public class SimpleSelectionSort extends AbstractBaseSort implements BaseSort{

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		for(int i = 0,length = list.length; i<length ; ++i){
			int maxIndex = i;
			for(int j = i + 1;j<length;++j){
				if(list[j].compareTo(list[maxIndex]) > 0){
					maxIndex = j;
				}
			}
			if(maxIndex != i) swap(list, maxIndex, i);
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		for(int i = 0,length = list.length; i<length ; ++i){
			int maxIndex = i;
			for(int j = i + 1;j<length;++j){
				if(mComparator.compare(list[j],list[maxIndex]) > 0){
					maxIndex = j;
				}
			}
			if(maxIndex != i) swap(list, maxIndex, i);
		}
	}
	
}
