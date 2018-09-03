package com.example.AllTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
	private String root;
	
	public CustomClassLoader(String root){
		this.root = root;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		byte[] classData = loadClassData(name);
		if(classData == null){
			throw new  ClassNotFoundException();
		}else{
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
	private byte[] loadClassData(String name){
		String fileName = root + File.separatorChar
				+ name.replace('.', File.separatorChar)
				+ ".class";
		try{
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int lenght;
			while((lenght = ins.read(buffer)) != -1){
				baos.write(buffer, 0, lenght);
			}
			return baos.toByteArray();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader("C:\\Users\\PC\\Desktop");
        try {
            Class clazz = customClassLoader.loadClass("com.xiao.U");
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
	
}
