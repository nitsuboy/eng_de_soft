package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Service {
	
	protected static Object loadData(String path) {
		try{
	         FileInputStream fileIn = new FileInputStream(path);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Object serial = in.readObject();
	         in.close();
	         fileIn.close();
	         return serial;
	    }catch(Exception i){
	         i.printStackTrace();
	         return null;
	    }
    }
    
    protected void saveData(Object serial,String path) {
    	try{
    		FileOutputStream fileOut = new FileOutputStream(path);
    	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	    out.writeObject(serial);
    	    out.close();
    	    fileOut.close();
    	}catch(IOException i){
    		i.printStackTrace();
    	}
    }
}
