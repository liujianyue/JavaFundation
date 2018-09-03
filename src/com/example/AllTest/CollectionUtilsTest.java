package com.example.AllTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;

import android.R.integer;
import android.text.TextUtils;

public class CollectionUtilsTest<E> implements Collection<E> {

	@Override
	public boolean add(E object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Math.round(1);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean contains(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumbers(String content) {    
	    Pattern pattern = Pattern.compile("\\d+");    
	    Matcher matcher = pattern.matcher(content);    
	    while (matcher.find()) {    
	       return matcher.group(0);    
	    }    
	    return "";    
	}    
	
	public String getNotNumbers(String dstStr){
		Pattern mPattern = Pattern.compile("\\D+");
		Matcher matcher = mPattern.matcher(dstStr);
		while(matcher.find()){
			return matcher.group(0);
		}
		return "";
	}
	
	/**
	 * int 2 byte[]
	 */
	public static byte[] int2byte(int srcInt){
		byte[] dstByte = new byte[4];
		for(int index = 0 ;index < 4; index++){
			int offset = (32 - 8*(index+1));
			dstByte[index] = (byte)((srcInt >> offset) & 0xff);
		}	
		return dstByte;
	}
	
	/**
	 * byte[] 2 int
	 */
	public static int byte2int(byte[] srcByte){
		int dstNum = 0;
		for(int index = 0;index < 4; index++){
			dstNum |= (srcByte[index] & 0xff);
			dstNum <<= 8;
		}
		return dstNum;
	}
	
	/**
	 * int 2 one byte
	 */
	public static byte int2onebyte(int srcNum){
		byte dstByte = 0;
		dstByte = (byte) (srcNum & 0x000000ff);
		return dstByte;
	}
	
	
	/**
	 *one byte 2 int
	 */
	public static int onebyte2int(byte dstbyte){
		return 0 | (dstbyte & 0xff);
	}
	
	/**
	 * reverse String
	 */
	public static String ReverserStr(String srcStr){
		if(TextUtils.isEmpty(srcStr) || srcStr.length() == 1){
			return srcStr;
		}
		return ReverserStr(srcStr.substring(1)) + srcStr.charAt(0);
	}
	
	/**
	 * output string's all sort string 
	 * @param srcStr the char[] who's all sort string need to output
	 * @param prefix 循环累积的字符串
	 */
	public static int getAllSortStringByList(List srcStr, String prefix ){
		if(srcStr == null) return -1;
		if(prefix == null) prefix = "";
		if(prefix.length() == srcStr.size() + prefix.length()){
			//output temp
			return 0;
		}
		for(int i = 0;i < srcStr.size(); i++){
			List temp = new LinkedList(srcStr);
			prefix += temp.remove(i);
			getAllSortStringByList(temp, prefix);
		}
		return 0;
	}
	
	/**
	 * output string's all sort string
	 * @param srcChar the char[] who's all sort string need to output
	 * @param index 遍历到的节点，当为srcchar的长度时，表示遍历完一条线，输出
	 */
	public static int getAllSortStringByChar(char[] srcChar, int index){
		if(index < 0 || index >= srcChar.length) return -1;
		
		for(int i = index; i< srcChar.length ; ++i){
			char temp = srcChar[i];
			srcChar[i] = srcChar[index];
			srcChar[index] = temp;
			
			getAllSortStringByChar(srcChar,index++);
			
			temp = srcChar[i];
			srcChar[i] = srcChar[index];
			srcChar[index] = temp;
		}
		return 1;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> void findRepeatableItem(T[] srcArray) throws IndexOutOfBoundsException ,CloneNotSupportedException{
		List<T> mArrayList = (ArrayList<T>) Arrays.asList(srcArray);
		Map<T,Integer> mHashMap = new HashMap<T,Integer>();
		Iterator<T> mIterator = mArrayList.iterator();
		while(mIterator.hasNext()){
			T mT = mIterator.next();
			int count = 0;
			if(mHashMap.get(mT) != null){
				count = (int) mHashMap.get(mT) + 1;
			}
			mHashMap.put(mT, count);
			throw new IndexOutOfBoundsException();
		}
		
		Iterator<Map.Entry<T, Integer>> mIterator2 = mHashMap.entrySet().iterator();
		
		for(Map.Entry<T, Integer> entry : mHashMap.entrySet()){
			
		}
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
 
    /****************test reflect private method or field got***********/
    private String PrivateMethod(String S){
    	return S;
    }  
    
    private static final String PRIVATE_STRING = "private_string";
    
    public void PrivateMethodTest() 
    		throws ClassNotFoundException, 
    		NoSuchMethodException, 
    		IllegalAccessException, 
    		IllegalArgumentException, 
    		InvocationTargetException, 
    		NoSuchFieldException{
    	CollectionUtilsTest<String> cut = new CollectionUtilsTest<>();
    	Class<?> clazz = Class.forName("com.example.ljysignaltest.CollectionUtilsTest");
    	//method
    	Method privateMethod = clazz.getDeclaredMethod("PrivateMethod", new Class[] {String.class});
    	privateMethod.setAccessible(true);
    	String testStr = (String) privateMethod.invoke(cut, new Object[]{"test1"});
    	
    	//field
    	Field privateField = clazz.getDeclaredField("PRIVATE_STRING");
    	privateField.setAccessible(true);
    	String testStr2 = (String) privateField.get(cut);
    } 
}
	
