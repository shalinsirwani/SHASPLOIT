package try3_for_client;

import java.io.*;
import java.net.*;

public class Execute_command 
{
	private Socket s;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public Execute_command (Socket s1 , DataOutputStream dos1)
	{
		s = s1;
		dos = dos1;
	}
	
	public void Execute(String comm)
	{
		try
		{
			dis = new DataInputStream(s.getInputStream());
			
			dos.writeUTF(comm);
			
			System.out.println(dis.readUTF());
			
			System.out.println("Command invoked");
			Thread.sleep(900);
			
			dis.close();
		}catch(Exception e){System.out.println(e);}
	}
}
