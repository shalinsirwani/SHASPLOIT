package try3_for_client;

import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class SIDE_1 
{
	private static int ask()
	{
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		return ch;
	}
	
	public static void main(String[] args)
	{
		try
		{
		
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("WelCOME ENTER A KEY TO START $ H @ $ P L O I T\n press any number to kickoff");
			
			ask();
			ServerSocket ss = new ServerSocket(4455);
			System.out.println("SOCKET CONFIGURATION INITIALIZING.. \n");
			System.out.print("L");
			Thread.sleep(2000);
			System.out.print("OOO");
			Thread.sleep(2000);
			System.out.print("AAA");
			Thread.sleep(2000);
			System.out.print("DDD");
			Thread.sleep(2000);
			System.out.print("III");
			Thread.sleep(2000);
			System.out.print("NNN");
			Thread.sleep(2000);
			System.out.print("GGG");
			Thread.sleep(3000);
			System.out.print("\n\n Completed...............:)");
			Thread.sleep(3000);
			System.out.print("\n\n Initializes Successfully \n\n\n\n");
			Thread.sleep(4000);
			for(int i=0;i<100;i++)
			{
			
				System.out.print("(finding server) Loading");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print("...");
				Thread.sleep(1000);
				System.out.print(".....");
				Thread.sleep(1000);
				System.out.print(".......");
				Thread.sleep(1000);
				System.out.print(".........");
				
				Socket s = ss.accept();
				
				System.out.println("\nConnection created successfully :)\n");
				System.out.println("\nSuccessfully entered into your targeted IP computer...\n");
				
				System.out.println("\n################################################\n");
		
				System.out.println("CREATED BY D.A.S");
				
				System.out.println("ASSIGNMENT FOR ADVANCED JAVA");
				
				System.out.println("VERSION 0.3");
				
				System.out.println("FOR MORE DETAILS visit cyberweather.blogspot.com ");
				
				System.out.println("OR EMAIL ME AT SHALINSIRWANI@GMAIL.COM");
				
				System.out.println("\n#################################################\n\n\n");
				
				Thread.sleep(5000);
				
				System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
				
				System.out.println("1. To Copy a directory from a remote host........................");
				
				System.out.println("2. To copy a particular file from the remote host................");
				
				System.out.println("3. To Check or explore a particular directory in remote directory");
				
				System.out.println("4. To store directory to the remote host.........................");
				
				System.out.println("5. To store file to the remote host..............................");
				
				System.out.println("6. To start $h@ch@t .............................................");
				
				System.out.println("7. To Execute Commands on the remote PC..........................");
				
				System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
				
				System.out.println("enter your choice : ");
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				int ch = ask();
				
			Try3_c tc ;
			
			tc = new Try3_c();
				
			tc.starting(s, dos, ch);
			
			s.close();
			//ss.close();
			dos.flush();
			}
			
		}catch(Exception e){System.out.println(e+"ddd");}
	}
}
