package try3_for_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;

public class Execute_command 
{
	private DataInputStream dis;
	private Socket s;
	private DataOutputStream dos;
	
	public Execute_command(Socket s1 , DataInputStream dis1)
	{
		s = s1;
		dis = dis1;
	}
	
	public void Execute()
	{
		try{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		dos = new DataOutputStream(s.getOutputStream());
		
		String str2= dis.readUTF();
		String str1="";
		
		String command[] ={"/bin/bash" , "-c" , str2 , ";"};
		StringBuffer output = new StringBuffer();
		Process P;
		P = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(P.getInputStream()));
		
		while((str1 = reader.readLine()) != null)
		{
			output.append(str1 + "\n");
		}
	
		dos.writeUTF(output.toString());
		br.close();
		}catch(Exception e){System.out.println(e);}
	}
}
