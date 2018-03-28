package try3_for_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Send_dir 
{
	private Socket s;
	
	public Send_dir(Socket s1)
	{
		s = s1;
	}
	
	public void send_proc()
	{
		try
		{
			
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(bos);	
			
			Scanner strd = new Scanner(System.in);
			
			System.out.println("Enter the Directory to send to remote host : ");
			String directory = strd.nextLine();
			
			System.out.println("Enter the Directory of remote host where you have to store : ");
			String s_dir = strd.nextLine();
			
			dos.writeUTF(s_dir);
			
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
				System.out.println("Transferred");
				Thread.sleep(900);
			}
		
		}catch(Exception e){System.out.println(e);}
	}
}
