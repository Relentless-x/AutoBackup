package Relentless_x;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

class BackupAgent extends TimerTask {
	DirectoryBackup db = new DirectoryBackup();
	File fName;
	File src;
	int i = 1;
	String source;
	boolean backup = false;


	public void set(File name, File sorc, String s) {
		fName = name;
		src = sorc;
		source = s;
	}
	
	public void run(){
		if (!(source == null)) {
			backup = true;
		} else {
			System.out.println("Incorrect information given!");
		}

		while (backup) {
			File f1 = new File("AutoBackup//" + fName + i);

			if (f1.exists()) {
				i++;
			} else if (!(f1.exists())) {
				File dst = f1;
				System.out.println("Backing up ...");
				try {
					db.backup(src, dst);
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println(e);
				}
				System.out.println("Backup Successful!");
				backup = false;
			}
		}
	}
}


