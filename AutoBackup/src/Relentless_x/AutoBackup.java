package Relentless_x;

import java.io.*;
import java.util.Timer;


public class AutoBackup {
    static int i = 1;
    public static void main(String[] args)
	throws IOException, InterruptedException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	BackupAgent ba = new BackupAgent();

	String strDirectoy = "Autobackup//";

	boolean success = new File(strDirectoy).mkdir();

	if (success) {
	    System.out.println("Directory: " + strDirectoy + " created");
	}

	System.out.println("Thank you for using AutoBackup by Relentless_x");
	System.out.println(
		"Enter the path of directory you want to be backed up:");

	String source = in.readLine();
	System.out.println(
		"Enter the name of the directory you want to be backed up:");

	String name = in.readLine();
	System.out.println("Enter the desired delay between backups:");
	String time = in.readLine();
	long delay = Integer.parseInt(time) * 6000;
	File fName = new File(name);
	File src = new File(source);
	ba.set(fName, src, source);
	System.out.println("Autobackup started!");
	Timer tmr = new Timer();
	tmr.schedule(ba, delay);

    }
}