package me.com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
	
	 public static String key = "001";
	 
	 public static String correct_msg = "Server: Input is correct!";
	 public static String wrong_msg = "Server: Input is wrong!";
	 
	 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  BufferedWriter bw;
		  BufferedReader my;
		  try {
		   Socket sk = new Socket("127.0.0.1",5050);    //建立Socket物件，並設定ip(127.0.0.1是自己的主機)和埠號
		   System.out.println("Connected Server");
		   
		   InputStream in = sk.getInputStream();
		   bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));   //利用sk來取得輸出串流
		   my = new BufferedReader(new InputStreamReader(in));
		   
		   
		   while(sk.isConnected()){
		    BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));  //透過輸入串流來取得Client的輸入
		    System.out.println("Client:");            
		    
		    System.out.println("Name");
		    bw.write(RC4Util.encry_RC4_string(br.readLine(), key) +  "\n");   //寫入輸出串流
		    bw.flush();
		    if(my.readLine().equals(wrong_msg)) {
		    	System.out.println(wrong_msg);
		    	System.out.println("Service is shutdown! please relogin");
		    	System.exit(0);
		    } else {
		    	System.out.println(correct_msg);
		    }
		    
		    System.out.println("Password:");
		    bw.write(RC4Util.encry_RC4_string(br.readLine(), key) +  "\n");   //寫入輸出串流
		    bw.flush();
		    //System.out.println(my.readLine());
		    if(my.readLine().equals(wrong_msg)) {
		    	System.out.println(wrong_msg);
		    	System.out.println("Service is shutdown! please relogin");
		    	System.exit(0);
		    } else {
		    	System.out.println(correct_msg);
		    }
		    
		    System.out.println("CheckCode:");
		    bw.write(RC4Util.encry_RC4_string(br.readLine(), key) +  "\n");   //寫入輸出串流
		    bw.flush();
		    //System.out.println(my.readLine());
		    if(my.readLine().equals(wrong_msg)) {
		    	System.out.println(wrong_msg);
		    	System.out.println("Service is shutdown! please relogin");
		    	System.exit(0);
		    } else {
		    	System.out.println(correct_msg);
		    }
		    
		    System.out.println("Money:");
		    bw.write(RC4Util.encry_RC4_string(br.readLine(), key) +  "\n");   //寫入輸出串流
		    bw.flush();
		    System.out.println(my.readLine());
		    System.exit(0);
		   
		    
		   }
		   
		  }catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 }
}
