package try3_for_client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Store_dir 
{
	private Socket s;
	private DataOutputStream dos;
	
	
	public Store_dir(Socket s1 , DataOutputStream dos1)
	{
		s = s1; dos = dos1;
	}
	
	public void store_proc()
	{
	
	try
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the directory to store data : ");
		String dirpath = sc.nextLine();
		
		System.out.println("enter the directory of remote computer to fetch ...");
		String r_dir = sc.nextLine();
		
		BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
		
		DataInputStream dis = new DataInputStream(bis);
		
		dos.writeUTF(r_dir);
		
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
			System.out.println("Transferred");
			Thread.sleep(900);
		}
	}catch(Exception e){System.out.println(e);}
	}
}
