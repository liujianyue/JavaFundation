package com.example.AllTest;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class NetworkInterfaceTest {
	public static void main(String[] args) {
		getNetInfo();
	}
	
    public static String getNetInfo()  
    {  
        String current = "";  
        StringBuilder builder = new StringBuilder();  
        try  
        {  
            List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface  
                    .getNetworkInterfaces());  
      
            for (NetworkInterface networkInterface : networkInterfaces)  
            {  
                String displayName = networkInterface.getDisplayName()  
                        + networkInterface.getInterfaceAddresses().toString();  
                builder.append(displayName + "\n");  
            }  
        }  
        catch (SocketException e)  
        {  
            e.printStackTrace();  
        }  
        current = builder.toString();  
        System.out.println(current);  
        return current;  
    }  
}
