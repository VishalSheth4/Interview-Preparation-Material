package org.example;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
        	File file = new File("abc.jpg");
        	String content = "This is my Goal";
            ByteArrayOutputStream opStream = QRCode.from(content).to(ImageType.JPG).stream();
            FileOutputStream out = new FileOutputStream(file);
            out.write(opStream.toByteArray());
            out.close();
            System.out.println("Successfully complete...!");
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
}