package com.tut.projectWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	// 1) ------ save() -------
    	
    	Student s = new Student(102,"JOHN","DELHI");
    	ProjectConfig projConfig = new ProjectConfig();
    	
//    	projConfig.projectConfiguration(s);
    	    	
    	// 2) ------ Image Address ---------
//    	String path="";
//    	FileInputStream fis = new FileInputStream(path);
//    	byte[] data = new byte[fis.available()];
    	
    	Address ad = new Address();
    	ad.setStreet("street1");
    	ad.setCity("City1");
    	ad.setOpen(true);
    	ad.setAddedDate(new Date());
    	ad.setX(1234.234);
//    	ad.setImage(data);
//    	projConfig.saveObject(ad);

    	// 3) ----------- get Student Object -------------
    	projConfig.getStudentObject();
    	
    	projConfig.getAddressObject();
    	


    }
}
