package com.example.AllTest;

import java.lang.invoke.MethodHandle;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodType;

public class MethodHandleTest {

	static class classA{
		public void println(String s){
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable{
		Object obj = /*System.currentTimeMillis() % 2 == 0 ? System.out:*/new classA();
		
		((MethodHandle) getPrintlnMH(obj)).invokeExact("tests");
		
	}

	private static Object getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
		// TODO Auto-generated method stub
		MethodType mt = MethodType.methodType(void.class,String.class);
		return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
	}
}
