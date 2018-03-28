package try3_for_client;

import java.net.*;
import java.io.*;

public class Chat 
{
	private Socket s;
	
	private DataOutputStream dos;
	
	public Chat(Socket s1 , DataOutputStream dos1)
	{
		s = s1;
		dos = dos1;
	}
	
	public void chating()
	{
		try
		{
			dos = new DataOutputStream(s.getOutputStream());
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str = "" , str2 = "";
			
			while(!str.equals("stop"))
			{
				str = dis.readUTF();
				
				System.out.println("client says : " +str);
				
				str2 = br.readLine();
				
				dos.writeUTF(str2);
				
				dos.flush();
			}
		}catch(Exception e){System.out.println(e);}
	}
	
}
