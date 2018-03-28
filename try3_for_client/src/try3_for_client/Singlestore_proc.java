package try3_for_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Singlestore_proc 
{
	private Socket s;
	
	private DataOutputStream dos;
	
	public Singlestore_proc(Socket s1 , DataOutputStream dos1)
	{
		s = s1;
		dos = dos1;
	}
	
	public void single_store()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter the name of the directory to store the file");
			
			String directory = sc.nextLine();
			
			System.out.println("enter the file with its directory in remote computer to fetch ...");
			String r_dir = sc.nextLine();
			
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			
			DataInputStream dis = new DataInputStream(bis);
			
			dos.writeUTF(r_dir);
			
			File file = new File(r_dir);
			
			long filelength = dis.readLong();
			
			String filename = dis.readUTF();				
				
			file = new File(directory + "/" + filename);
				
			FileOutputStream fos = new FileOutputStream(file);
				
			BufferedOutputStream bos = new BufferedOutputStream(fos);
				
			for(int j = 0; j<filelength; j++)
			{
				bos.write(bis.read());
			}
			
			System.out.println("Transferred");
			Thread.sleep(900);
		}catch(Exception e){System.out.println(e);}
	}
}
