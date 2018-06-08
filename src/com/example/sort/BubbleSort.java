package com.example.sort;

import java.util.Comparator;

/**
 * 冒泡排序
 * @author liujianyue
 *
 */
public class BubbleSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		boolean hasSwapped = true;
		for(int i = 0;i < list.length && hasSwapped ;++i){
			for(int j = 0;j< list.length - i; j++){
				if(list[j].compareTo(list[j+1]) > 0){
					swap(list, j, j + 1);
					hasSwapped = true;
				}
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub
		if(list == null || list.length == 1) return;
		boolean hasSwapped = true;
		for(int i = 0;i < list.length && hasSwapped ;++i){
			for(int j = 0;j< list.length - i; j++){
				if(mComparator.compare(list[j] ,list[j+1]) > 0){
					swap(list, j, j + 1);
					hasSwapped = true;
				}
			}
		}
	}

}
