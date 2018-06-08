package com.example.sort;

import java.util.Comparator;

public class QuickSork extends AbstractBaseSort implements BaseSort {
	private static final int MAX_LIMIT = 4;
	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		QuickSortRecursive(list, 0, list.length - 1);
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub

	}
	
	private <T extends Comparable<T>> void QuickSortRecursive(T[] list, int start, int end){
		if(end - start <= MAX_LIMIT){
			insertSort(list, start, end);
		}
		while(start < end){
			int pivot = partition(list, start, end);
			QuickSortRecursive(list, start, pivot - 1);
			start = pivot + 1;
		}
	}
	
	private <T extends Comparable<T>> int partition(T[] list, int start, int end){
		T pivotkey = list[end];
		int left = start ,right = end - 1;
		while(start < end){
			while(list[left].compareTo(pivotkey) <= 0 && left < right) left++;
			while(list[right].compareTo(pivotkey) >= 0 && left < right) right++;
			
			if(left < right) {
				swap(list, left, right);
			}
			if(list[left].compareTo(pivotkey) >= 0){
				swap(list, left, end);
			}else{
				left++;
			}	
		}
		return left;
	}
	
	//插入排序
    private <T extends Comparable<T>> void insertSort(T[] list, int start, int end) {
    	T temp;
        for (int i = start + 1, j; i <= end; ++i) {
            temp = list[i];
            j = i - 1;

            while (j >= start && list[j].compareTo(temp) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }

    }
	
	
	
	
	
	
	
}
