package com.example.AllTest;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import android.R.integer;
import android.media.MediaRouter.VolumeCallback;
import android.text.TextUtils;

public class abstractClassImpl1 extends abstractClassTest implements Closeable ,Comparable<abstractClassImpl1>{
	private void executorTester() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
		ReentrantLock mLock = new ReentrantLock();
		long d =  Runtime.getRuntime().freeMemory();
	}
	
	public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
    /**
     * 统计给定文件中给定字符串的出现次数
     * 
     * @param filename  文件名
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String filename, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return counter;
    }
    
    private static abstractClassImpl1 singleton= new abstractClassImpl1();
    /**
     * 饿汉式
     */
    public static abstractClassImpl1 getSingleton(){
    	return singleton;
    }
    /********************************************************************/
    private static abstractClassImpl1 singleton2 = null;
    /**
     *懒汉式
     */
    public static synchronized abstractClassImpl1 getSingleton2(){
    	if(singleton2 == null){
    		singleton2 = new abstractClassImpl1();
    	}
    	return singleton2;
    }
    
    private abstractClassImpl1(){
    	//Empty impl
    byte a = 5;
    int b = 3;
    byte c = 4;
    b = b + c;
    
    WeakHashMap<String, String> WeakHashMap = new WeakHashMap<>();
    
    }
    /********************************************************************/
    /**
     * 静态内部类
     */
    private static class singletonHoler{
    	private static abstractClassImpl1 singleton3 = new abstractClassImpl1();
    }
    
    public abstractClassImpl1 getSingleton3() {
		return singletonHoler.singleton3;
	}
    /********************************************************************/
    /**
     * 枚举模式
     */
    EnumSingleton singleton4 = EnumSingleton.INSTANCE;
    
    /********************************************************************/
    
	@Override
	public int compareTo(abstractClassImpl1 Impl) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class SortUtils{
		public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
		      return binarySearch(x, 0, x.length- 1, key);
		   }
		 
		   // 使用循环实现的二分查找
		   public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
		      int low = 0;
		      int high = x.length - 1;
		      while (low <= high) {
		          int mid = (low + high) >>> 1;
		          int cmp = comp.compare(x[mid], key);
		          if (cmp < 0) {
		            low= mid + 1;
		          }
		          else if (cmp > 0) {
		            high= mid - 1;
		          }
		          else {
		            return mid;
		          }
		      }
		      return -1;
		   }
		 
		   // 使用递归实现的二分查找
		   private static<T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
		      if(low <= high) {
		        int mid = low + ((high -low) >> 1);
		        if(key.compareTo(x[mid])== 0) {
		           return mid;
		        }
		        else if(key.compareTo(x[mid])< 0) {
		           return binarySearch(x,low, mid - 1, key);
		        }
		        else {
		           return binarySearch(x,mid + 1, high, key);
		        }
		      }
		      return -1;
		   }		
	}
	
	/*************************remove item in arraylist***************************************/
	
	/**
	 * remove item in arraylist with reverse method
	 * @param dstList
	 * @param dstStr
	 */
	private void removeReverse(ArrayList<String> dstList ,String dstStr){
		for(int l = dstList.size();l>=0;l--){
			String node = dstList.get(l);
			if(TextUtils.equals(node, dstStr))
				dstList.remove(l);
		}
	}
	/**
	 * remove item in arraylist with method iterator
	 * @param dstList
	 * @param dstStr
	 */
	private void reomveWithIterator(ArrayList<String> dstList ,String dstStr) {
		Iterator<String> mIterator= dstList.iterator();
		while(mIterator.hasNext()){
			String node = mIterator.next();
			if(TextUtils.equals(node, dstStr))
				mIterator.remove();
		} 
	}
	
	/***********************************************************/
}
