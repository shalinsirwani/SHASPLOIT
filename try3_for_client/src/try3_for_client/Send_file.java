package try3_for_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Send_file 
{
private Socket s;
	
	public Send_file(Socket s1)
	{
		s = s1;
	}
	
	public void single_send()
	{
		try
		{
			
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(bos);	
			
			Scanner strd = new Scanner(System.in);
			
			System.out.println("Enter the file with its directory ....");
			
			String fil = strd.nextLine();
			
			System.out.println("Now enter the directory in which you have to save file");
			
			String directory = strd.nextLine();
			
			dos.writeUTF(directory);
			
			File file = new File(fil);
				
			FileInputStream fis = new FileInputStream(file);
			
			long length = file.length();
			
			dos.writeLong(length);
					
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			dos.writeUTF(file.getName());
					
			int bytes = 0;
					
			while((bytes = bis.read()) > -1)
			{
				bos.write(bytes);
			}
			System.out.println("Transferred");
			Thread.sleep(900);
			bis.close();
			bos.close();
		}catch(Exception e){System.out.println(e);}
	}
}
