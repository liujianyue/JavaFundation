package com.example.AllTest;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println("main , i = " + testBasic());
	}
	
	@SuppressWarnings("finally")
	public static  int testBasic(){
        int i = 1; 
        try{
            i++;
            int n = i / 0 ;
            System.out.println("try block, i = "+i);
            //return i;
        }catch(Exception e){
            i ++;
            //int m = i / 0 ;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i ++;
            //int P = i / 0 ;
            System.out.println("finally block i = "+i);
            //return i;
        }
        System.out.println("testBasic i = "+i);
        return i;
	}
}
