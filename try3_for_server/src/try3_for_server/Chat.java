package try3_for_server;

import java.net.*;
import java.io.*;

public class Chat 
{
	private Socket s;
	private DataInputStream dis;
	
	public Chat(Socket s1 , DataInputStream dis1)
	{
		s = s1;
		dis = dis1;
	}
	
	public void chating()
	{
		try
		{
			dis = new DataInputStream(s.getInputStream());
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = "" , str2 = "";
			
			while(!str.equals("stop"))
			{
				str = br.readLine();
				
				dos.writeUTF(str);
				
				dos.flush();
				
				str2 = dis.readUTF();
				
				System.out.println("Server says : "+str2);
			}
			System.out.println("nooo");
		}catch(Exception e){System.out.println("from chat.java"+e);}
		
	}
}
