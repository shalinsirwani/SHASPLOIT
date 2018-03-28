package try3_for_server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Singlesend_proc 
{
	private Socket s;
	
	private DataInputStream dis;
	
	public Singlesend_proc(Socket s1 , DataInputStream dis1)
	{
		s = s1;
		dis = dis1;
	}
	
	public void single_send()
	{
		try
		{
			String fil = "";
			
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(bos);	
			
			fil = dis.readUTF();
			
			File file = new File(fil);
			
			long length = file.length();
					
			dos.writeLong(length);
					
			String name = file.getName();
			
			dos.writeUTF(name);
				
			FileInputStream fis = new FileInputStream(file);
					
			BufferedInputStream bis = new BufferedInputStream(fis);
					
			int bytes = 0;
					
			while((bytes = bis.read()) > -1)
			{
				bos.write(bytes);
			}
			
			bis.close();
			bos.close();
			dos.close();
			s.close();
			
		}catch(Exception e){System.out.println(e);}
	}
}
