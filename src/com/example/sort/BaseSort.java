package com.example.sort;

import java.util.Comparator;

public interface BaseSort {
	/**
    * 排序
    * @param list 待排序的数组
    */
	public <T extends Comparable<T>> void sort(T[] list);
	
   /**
    * 排序
    * @param list 待排序的数组
    * @param comp 比较两个对象的比较器
    */
	public <T> void sort(T[] list,Comparator<T> mComparator);
	
	
}
