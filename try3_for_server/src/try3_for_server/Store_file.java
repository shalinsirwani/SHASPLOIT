package try3_for_server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class Store_file 
{
private Socket s;
	
	public Store_file(Socket s1)
	{
		s = s1;
	}
	
	public void single_store()
	{
		try
		{
				
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			
			DataInputStream dis = new DataInputStream(bis);
			
			String directory = dis.readUTF();
			
			File file = new File(directory);
			
			long filelength = dis.readLong();
			
			String filename = dis.readUTF();
				
			file = new File(directory + "/" + filename);
				
			FileOutputStream fos = new FileOutputStream(file);
				
			BufferedOutputStream bos = new BufferedOutputStream(fos);
				
			for(int j = 0; j<filelength; j++)
			{
				bos.write(bis.read());
			}
			bos.close();
			dis.close();
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}
