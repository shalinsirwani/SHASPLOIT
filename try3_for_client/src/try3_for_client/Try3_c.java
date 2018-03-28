package try3_for_client;

import java.net.*;
import java.util.*;
import java.io.*;

public class Try3_c 
{
	public void starting(Socket s , DataOutputStream dos , int choice)
	{
		try
		{		
			dos.writeInt(choice);
			
			try{
			System.out.println(choice);
			switch(choice)
			{
			case 2:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Singlestore_proc ssp = new Singlestore_proc(s  , dos);
				ssp.single_store();
				break;
				
			case 1:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Store_dir sd = new Store_dir(s , dos);
				sd.store_proc();
				break;
				
			case 3:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Explore_dir edsh = new Explore_dir(s , dos);
				edsh.Exploring();
				break;
				
			case 4:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Send_dir sfd = new Send_dir(s);
				sfd.send_proc();
				break;
				
			case 5:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Send_file ssss = new Send_file(s);
				ssss.single_send();
				break;
				
			case 6:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Chat c = new Chat(s , dos);
				c.chating();
				break;
				
			case 7:
				System.out.print("Contacting to server");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print("......");
				Thread.sleep(1000);
				System.out.print("...........");
				Thread.sleep(1000);
				System.out.println("\ndone\n");
				Thread.sleep(2000);
				Scanner strdv = new Scanner(System.in);
				
				Execute_command qwe = new Execute_command(s , dos);
				
				System.out.println("Enter the command you want to execute on the remote host...");
				
				String comm = strdv.nextLine();
				
				qwe.Execute(comm);
				strdv.close();
				break;
				
			default:
				System.out.println("wrong choice..");
				break;
			}
			}catch(Exception e){System.out.println("from dsfsdfsdftry3_c");}
			
//			sc.close();
//			ss.close();
//			s.close();
//			dos.close();
		}catch(IOException e){System.out.println(e+"wwwwwwwwwwwwwwwfrom try3_c");}
		
	}
}
