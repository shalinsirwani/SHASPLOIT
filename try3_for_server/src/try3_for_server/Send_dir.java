package try3_for_server;
import java.io.*;
import java.net.*;

public class Send_dir 
{
	private Socket s;
	private DataInputStream dis;
	
	public Send_dir(Socket s1 , DataInputStream dis1)
	{
		s = s1;
		dis = dis1;
	}
	
	public void send_proc()
	{
		try
		{
			String directory = "";
			
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(bos);	
			
			directory = dis.readUTF();
			
			File[] files = new File(directory).listFiles();
			
			dos.writeInt(files.length);
			
			for(File file : files)
			{
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
			}
			
			bos.close();
			dos.close();
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}
