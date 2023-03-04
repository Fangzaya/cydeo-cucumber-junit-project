package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1 Create The Properties obj (creat obj)
    // make it "private ,so it's not accessible from outside the class >
    //"static" is to make sure its created and loaded before everything else
    private  static Properties properties = new Properties();


    static {


        try {
            //2 Open file using FileInputSteam(open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3 Load the "properties" obj with "file"  >> property.load(file) (load properties)

            properties.load(file);
            // close the file in the memory
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found with given path !!!");
        }
    }


    // create a method to reuse the object
    //4 use properties obj to read from file (read properties)
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
