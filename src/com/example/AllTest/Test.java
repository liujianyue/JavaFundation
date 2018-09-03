package com.example.AllTest;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.algorithm.CommonAlgorithm;

public class Test {

	public static void main(String[] args) {
		/*int[] a = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,
		 * 9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,
		 * 1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,
		 * 5142,5437,5448,5668,5706,5725,6300,6335};
		new JianzhiOfferAlgorithm().minNumberInRotateArray(a);
		int start = 5,end = 7;
		System.out.println(start);
		System.out.println((end - start)>>1 + start);
		int[] testInt = {1,3,2,6,4};
		System.out.println("0xf0000000::" + 0x7fffffff);
		new CommonAlgorithm().StrToInt("123");
		Integer a = new Integer(5);
		Integer b = new Integer(5);
		System.out.println(a.equals(b));
		System.out.println(a == b);
		System.out.println("abdc.df.233".replaceAll("d", "/"));
		int a = 1;
		float b = 2;
		System.out.println(a/b);
		CommonAlgorithm d = null;
		d.println(52+"", 52+"");
		Integer a = 5;
		Integer b = new Integer(5);
		System.out.println(test());*/
		/*String s1 = "Programminga";
        String s2 = new String("Programming");
        String s3 = "Program" + "minga";
        String s4 = new String(s2);
		String s5 = "Programming";
        System.out.println(s1 == s2);//false
        System.out.println(s4 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s1.intern());//true
	
		
		String s1 = "abdc";
		String s2 = new String("Proing");
		String s3 = "abdc";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1 == s1.intern());
		
		ReentrantLock d = new ReentrantLock();
		
		boolean bb = false;
		Boolean B = false;
		System.out.println(bb == B);
		
		
		List<?> s;
		class A {}
		class B extends A {}
		class C extends A {}
		class D extends B {}
		List<A> a;
        List list;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b;
        a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o;
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d;
        List<? extends B> downB;
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<?extends A> downA;
        a = downA;  //E错，范围不能赋值给点
        a = o;      //F错，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
		
		System.out.println(test());
		HashMap map = new HashMap(); 
		map.put("name",null);      
		map.put("name","Jack");
		System.out.println(map.size());
		try {
			waitForSignal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(AccountType.FIXED);
		int arr[] = new int[5];

		System.out.println(arr[3]); 
		
		 String str1="hello";
		 
		 String str3 = "hello";

		 String str2="he"+ new String("llo");

		 System.out.println(str1==str2); 
		 System.out.println(str1==str3); 
		
		int i1 = 5;
		Integer i2 = new Integer(5);
		System.out.println(i1 == i2);
		int a=257;
		Integer b=257;
		Integer c=257;
		Integer b2=57;
		Integer c2=57;
		System.out.println(b==a);
		System.out.println(b.equals(257.0));
		System.out.println(b==c);
		System.out.println(b2==c2);
		System.out.println(~i1);
		
		int a = 10;
		int b = 0;
		b = a++;
		System.out.println(a);
		List  Listlist1 = new ArrayList();
	    Listlist1.add(0);
	    List Listlist2 = Listlist1;
	    System.out.println(Listlist1.get(0) instanceof Integer);
	    System.out.println(Listlist2.get(0) instanceof Integer);
		System.out.println("--dddsssssd-" +  ((0 >>> 1) | (2 & 1)));
		Object[] os = new Object[8];
		Arrays.copyOf(os, 7);
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s2.intern());
        final Map<String, String> connectedLegacyVpns;
        List<String> vpnProfiles;
        int a = 100/0;
		System.out.println(getSumN(10));*/
		
	        try {
	            try {
	                throw new Sneeze();
	            }
	            catch ( Annoyance a ) {
	                System.out.println("Caught Annoyance");
	                throw a;
	            }
	        }
	        catch ( Sneeze s ) {
	            System.out.println("Caught Sneeze");
	            return ;
	        }
	        finally {
	            System.out.println("Hello World!");
	        }
	}
	
	private static int getSumN(int N){
		try{
			int c = 1/N;
			return N + getSumN(N - 1);
		}catch(Exception e){
			System.out.println(N);
			return 0;
		}
	}
	
	private void testFinal(){
		testi = 4;
		testt.testi = 6;
	}
	
	final Test testt = new Test();
	int testi = 5;
	static void waitForSignal() throws InterruptedException
	{
	    Object obj = new Object();
	    synchronized(Thread.currentThread())
	    {
	        obj.wait();
	        obj.notify();
	    }
	}
	
	private static void test2(){
		try {
			test();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("--dddsssssd-");
		}
	}
	
	private static int test(){
		int i = 5;
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("--dddd-");
		}finally{
			i++;
			System.out.println("--dddddbbd-");
			//return i;
		}
		return i;
	}
	
	static void println(String tag,String msg){
		System.out.println("---" + tag + "---" + msg);
	}
	
	interface interfaceTest{
		public void main(String [] args);
	}
	
	private void test3(int a,long b){
		Thread.currentThread().suspend();
//		Statement 
		PreparedStatement p;
	}
	private void test3(long b,int a){}
	
	enum AccountType
	{
	    SAVING, FIXED, CURRENT;
	    private AccountType()
	    {
	        System.out.println("It is a account type");
	    }
	}
}
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}