package try3_for_server;

import java.io.*;
import java.net.*;

public class Explore_dir 
{
	private Socket s;
	private DataOutputStream dos;
	
	public Explore_dir(Socket s1)
	{
		s = s1;
	}
	
	public void Exploring(String dir)
	{
		
		try 
		{
			File directory = new File(dir);
		
			File[] contentsOfDirectory = directory.listFiles();
		
			long len = contentsOfDirectory.length;
		
			dos = new DataOutputStream(s.getOutputStream());
			
			dos.writeLong(len);
			
			for(File object : contentsOfDirectory)
			{
				if(object.isFile())
				{
					String str = "File name " + object.getName();
					dos.writeUTF(str);
				}
				else if(object.isDirectory())
				{
					String str = "Directory name " + object.getName();
					dos.writeUTF(str);
				}
			}
		}catch(Exception e){System.out.println(e);}
	}
}