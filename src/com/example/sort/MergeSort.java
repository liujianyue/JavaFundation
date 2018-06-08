package com.example.sort;

import java.util.Comparator;

public class MergeSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length < 2) return;
		InnerMergeSort(list,0 , list.length);
	}
	
	private <T extends Comparable<T>> void InnerMergeSort(T[] list,
			int start, int end){
		if(end - start < 1) return;
		int middle = start + (end - start) >>1;
		
		InnerMergeSort(list, start, middle);
		InnerMergeSort(list, middle + 1, end);
		
		int i = start,j = middle + 1;
		T temp = list[middle + 1];
		while(i <= middle && j <= end){//直接插入排序
			if(list[i].compareTo(list[j]) > 0){
				i++;
				for(int ii = middle;ii >= i; --i){
					list[ii + 1]  = list[ii];
				}
				//System.arraycopy(list, i, list, i + 1, middle - i + 1);
				list[i] = temp;
			}else{
				j++;
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub

	}

}
