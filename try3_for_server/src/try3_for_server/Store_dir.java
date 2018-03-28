package try3_for_server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class Store_dir 
{
	private Socket s;
	private DataInputStream dis;
	
	public Store_dir(Socket s1)
	{
		s = s1; 
	}
	
	public void store_proc()
	{
		try
		{
			
			
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			
			dis = new DataInputStream(bis);
			
			String dirpath = dis.readUTF();
			
			int filescount = dis.readInt();
			
			File[] files = new File[filescount];
			
			for(int i=0; i<filescount; i++)
			{
				long filelength = dis.readLong();
				
				String filename = dis.readUTF();				
				
				files[i] = new File(dirpath + "/" + filename);
				
				FileOutputStream fos = new FileOutputStream(files[i]);
				
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				
				for(int j = 0; j<filelength; j++)
				{
					bos.write(bis.read());
				}
				bos.close();
			}
			
			dis.close();
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}
