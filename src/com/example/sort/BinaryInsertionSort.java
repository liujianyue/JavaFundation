package com.example.sort;

import java.util.Comparator;

public class BinaryInsertionSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		int left,right,middle;
		T temp;
		for(int i = 1,length = list.length;i < length;++i){
			temp = list[i];
			left = 0;
			right = i + 1;
			while(left <= right){
				middle = left + (left - right)>>1;
				//middle = left + (left - right)/2;
				//middle = (left + right)>>>1;
				if(list[middle].compareTo(temp) > 0){
					right = middle - 1;
				}else{
					left = middle + 1;
				}
			}
			System.arraycopy(list, left, list, left + 1, i - left);
			list[left] = temp;
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		
		int left,right,middle;
		T temp;
		for(int i = 1,length = list.length;i < length;++i){
			temp = list[i];
			left = 0;
			right = i + 1;
			while(left <= right){
				middle = left + (left - right)>>1;
				//middle = left + (left - right)/2;
				//middle = (left + right)>>>1;
				if(mComparator.compare(list[middle],temp) > 0){
					right = middle - 1;
				}else{
					left = middle + 1;
				}
			}
			System.arraycopy(list, left, list, left + 1, i - left);
			list[left] = temp;
		}
	}
}
