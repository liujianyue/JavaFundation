package com.example.sort;

import java.util.Comparator;

import com.example.utils.CommonUtil;

public class HeapSort extends AbstractBaseSort implements BaseSort {

	@Override
	public <T extends Comparable<T>> void sort(T[] array) {
		// TODO Auto-generated method stub
		if (array == null || array.length == 0 || array.length == 1) return;

        int i, size = array.length;

        /*
            1. 从末端子节点开始作调整，使得子节点永远小于父节点。
            2. 构造大顶堆
        */

        // i = (lastLeftIndex - 1) / 2 = (size -2) /2即堆的末端子节点，
        // 从末子节点往上开始调整堆，使得子节点永远小于父节点。
        for (i = (size - 2) >> 1; i >= 0; --i) {
            //maxHeapify(array, i, size);
            maxHeapify3(array, i, size);
        }

        /*
            3. 交换堆顶元素和末尾元素，重新调整剩下元素为大顶堆
         */
        for (i = size - 1; i > 0; --i) {
            CommonUtil.swap(array, 0, i);//将堆顶元素和末尾元素交换

            //maxHeapify(array, 0, i);//将剩下的元素调整为大顶堆
            maxHeapify3(array, 0, i);//将剩下的元素调整为大顶堆
        }
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> mComparator) {
		// TODO Auto-generated method stub

	}
	
	static void heapSort(Integer[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        int i, size = array.length;

        /*
            1. 从末端子节点开始作调整，使得子节点永远小于父节点。
            2. 构造大顶堆
        */

        // i = (lastLeftIndex - 1) / 2 = (size -2) /2即堆的末端子节点，
        // 从末子节点往上开始调整堆，使得子节点永远小于父节点。
        for (i = (size - 2) >> 1; i >= 0; --i) {
            //maxHeapify(array, i, size);
            maxHeapify3(array, i, size);
        }

        /*
            3. 交换堆顶元素和末尾元素，重新调整剩下元素为大顶堆
         */
        for (i = size - 1; i > 0; --i) {
            CommonUtil.swap(array, 0, i);//将堆顶元素和末尾元素交换

            //maxHeapify(array, 0, i);//将剩下的元素调整为大顶堆
            maxHeapify3(array, 0, i);//将剩下的元素调整为大顶堆
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 使array[index...len]成为大顶堆
     *
     * 使用递归
     *
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度,注意处理下标
     */
    private static <T extends Comparable<T>> void maxHeapify(T [] array, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if (li > len - 1) { // 左子节点索引超出计算范围(数组长度)，直接返回。
            // 这种情况是指已经进入到叶子节点了，非叶子节点必定是有左孩子的。
            return;
        }

        //选择最大的节点的下标
        if (ri < len && array[ri].compareTo(array[li]) > 0) { // 右子节点在数组内 && 并先判断左右子节点，哪个较大。
            cMax = ri; //两个子节点哪个大
        }

        if (array[cMax].compareTo(array[index]) > 0) { //子节点大于跟节点，不大顶堆的定义，调换
            CommonUtil.swap(array, cMax, index);      // 如果父节点被子节点调换，

            maxHeapify(array, cMax, len);  // cMax已被换为最大子节点的下标，需要继续判断换下后的父节点是否符合堆的特性。这样就可以不断调整
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 使array[index...len]成为大顶堆
     *
     * 使用循环，好理解的写法
     *
     * @param index 需要堆化处理的数据的索引。
     * 构造大顶堆时，挨个传入进来的就是末尾非叶子节点的index，开始调整此index到length间的数组，使其成为大顶堆
     * 进行堆排序时，传入进来的始终是0，len传入的却是length- 1 - i，调整从0到length- 1 - i间的数组，使成为大顶堆
     * <br />
     * @param len 未排序的堆（数组）的长度，始终传的是要排序数组的length。
     */
    private static <T extends Comparable<T>>  void maxHeapify3(T[] array, int index, int len) {
        int li, ri, iMax;

        while (true) {
            li = (index << 1) + 1;//找到左孩子
            ri = li + 1;//找到右孩子
            iMax = index;

            if (li < len && array[li].compareTo(array[iMax]) > 0) {
                iMax = li;
            }

            if (ri < len && array[ri].compareTo(array[iMax]) > 0) {
                iMax = ri;
            }

            if (iMax == index) {
                // 说明当前小树就是堆，不用重排
                break;
            } else {
                CommonUtil.swap(array, iMax, index);
                index = iMax;
            }
        }
    }
}
