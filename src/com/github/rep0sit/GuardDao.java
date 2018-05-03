package com.github.rep0sit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class GuardDao {
	private static String FILE_NAME = "guards.dat";
	@SuppressWarnings("unchecked")
	public void register(Guard guard){
		Set<Guard> guardSet = null;
		
		try {
			File file = new File(FILE_NAME);
			if (!file.exists()) {

				guardSet = new HashSet<Guard>();
				guardSet.add(guard);
				saveguardList(guardSet);
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				guardSet = (Set<Guard>) ois.readObject();
				ois.close();

				guardSet.add(guard);
				saveguardList(guardSet);
			}

		} 
		
		catch (IOException e) {e.printStackTrace();} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Set<Guard> getAllguards(){
		
		Set<Guard> guardSet = null;
		
		try {
			//File file = new File(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			guardSet = (Set<Guard>) ois.readObject();
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return guardSet;
	}

	private void saveguardList(Set<Guard> guardList){
		try {
			File file = new File(FILE_NAME);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(guardList);
			oos.close();
		}
		
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		
	}


	public Guard getGuard(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int addGuard(Guard guard) {
		// TODO Auto-generated method stub
		return 0;
	}
}
