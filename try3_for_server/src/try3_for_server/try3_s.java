package try3_for_server;

import java.io.DataInputStream;
import java.net.*;
import java.util.Scanner;

public class try3_s 
{
	public void starting()
	{
		try
		{
			String host = "localhost";
			int port = 4455;
			Socket s = new Socket(host , port);
			
			//System.out.println("Connection created..");
			
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			int choice  = dis.readInt();
			switch(choice)
			{
			case 2:
				Singlesend_proc ssp = new Singlesend_proc(s , dis);
				ssp.single_send();
				break;
			
			case 1:
				Send_dir sd = new Send_dir(s , dis);
				sd.send_proc();
				break;
				
			case 3:
				Explore_dir ed = new Explore_dir(s);
				String dir = dis.readUTF();
				ed.Exploring(dir);
				break;
				
			case 4:
				Store_dir erf = new Store_dir(s);
				erf.store_proc();
				break;
				
			case 5:
				Store_file ssss = new Store_file(s);
				ssss.single_store();
				break;
				
			case 6:
				Chat c = new Chat(s , dis);
				c.chating();
				break;
				
			case 7:
				Execute_command qwe = new Execute_command(s , dis);
				qwe.Execute();
				break;
			}
			
			dis.close();
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}
