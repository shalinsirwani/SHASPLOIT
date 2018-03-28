package try3_for_client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Explore_dir 
{
	private Socket s;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public Explore_dir(Socket s1 , DataOutputStream dos1)
	{
		s = s1;
		dos = dos1;
	}
	
	public void Exploring()
	{
		try
		{
					
			Scanner strd = new Scanner(System.in);
			
			System.out.println("Enter the name of the directory you wish to explore.....   .:  ");
			
			String str = strd.nextLine();
			
			dos.writeUTF(str);
			
			dis = new DataInputStream(s.getInputStream());
			
			long length = dis.readLong();
			
			System.out.println(length);
			
			for(int i = 0; i < length; i++)
			{
				System.out.println(dis.readUTF());
			}
			System.out.println("Transferred");
			Thread.sleep(900);
		}catch(Exception e){System.out.println(e+"eeoeoeoeo");}
	}
}
