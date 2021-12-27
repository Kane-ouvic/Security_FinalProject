package me.com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
	
	public static String key = "001";
	
	//Server
	public static void main(String[] args) {
		
		User usr = new User();
		LoadFile LF = new LoadFile();
		String[] st = null;
		
		  // TODO Auto-generated method stub
		  try {
		   ServerSocket svs = new ServerSocket(5050);  //建立ServerSocket物件，並設定埠號5050
		   System.out.println("Waiting for connecting");   
		   Socket sk = svs.accept();                   //Client提出請求，accept()會傳回一個Socket物件，並讓sk指向它
		   System.out.println("Connected");
		   while(sk.isConnected()){   
		   BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		   String msg = br.readLine();
		   
		   if(msg == null){                      //當Client disconnect時，readline會傳回null
		     break;
		   }
		   	OutputStream out = sk.getOutputStream();
		   	PrintWriter bufferedWriter= new PrintWriter(out,true);
		   	

		   	
		   	System.out.println("Encrypt Message: " + msg);
		    
		    if(usr.getName() == null) {
		    	
		    	usr.setName(RC4Util.decry_RC4(msg, key));
		    	
		    	if(LF.searchName(usr.getName()) == null) {
		    		
		    		bufferedWriter.println("Server: Input is wrong!");
		    		usr.defaultStats();
		    	} else {
		    		bufferedWriter.println("Server: Input is correct!");
		    		st = LF.searchName(usr.getName()).split(" ");
		    	}
		    	
		    	System.out.println("success 1");
		    	continue;
		    } else if(usr.getPassword() == null) {
		    	
		    	usr.setPassword(RC4Util.decry_RC4(msg, key));
		    	
		    	if(!usr.getPassword().equals(st[1])) {
		    		
		    		bufferedWriter.println("Server: Input is wrong!");
		    		usr.defaultStats();
		    	} else {
		    		bufferedWriter.println("Server: Input is correct!");
		    	}
		    	
		    	System.out.println("success 2");
		    	continue;
		    } else if(usr.getCheckCode() == null) {
		    	
		    	usr.setCheckCode(RC4Util.decry_RC4(msg, key));
		    	
		    	if(!usr.getCheckCode().equals(st[2])) {
		    
		    		bufferedWriter.println("Server: Input is wrong!");
		    		usr.defaultStats();
		    	} else {
		    		bufferedWriter.println("Server: Input is correct!");
		    	}
		    	
		    	System.out.println("success 3");
		    	continue;
		    } else if(usr.getMoney() == -1) {
		    	
		    	if(LF.getMoney(usr.getName()) < Integer.parseInt(RC4Util.decry_RC4(msg, key))) {
		    		
		    		bufferedWriter.println("Server: balance is not enough! failed!");
		    	} else {
		    		
		    		usr.setMoney(RC4Util.decry_RC4(msg, key));
			    	//usr.defaultStats();
			    	System.out.println("success 4");
			    	LF.changeMoney(usr.getName(), usr.getMoney());
					bufferedWriter.println("Server: you got $"+ usr.getMoney() + " successfully");
		    	}
		    	
		    	
				
		    	break;
		    }
		    //System.out.println("test");
		    
		   }
		   
		   
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		    e.printStackTrace();
		  }
		  	/*System.out.println("----------------------");
			System.out.println(usr.getName());
			System.out.println(usr.getPassword());
			System.out.println(usr.getCheckCode());
			System.out.println(usr.getMoney());
			System.out.println("----------------------");*/
		 }


}
