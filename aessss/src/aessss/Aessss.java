/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aessss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.spec.IvParameterSpec;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import static sun.text.normalizer.UTF16.append;



/**
 *
 * @author omkarzende
 */
public class Aessss {
    
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";
    
    public static String encrypt(String value) {
    try {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
 
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
 
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    
    
    
    
    
    public static String decrypt(String encrypted) {
    try {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
 
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
 
        return new String(original);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
 
    return null;
}
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        
        
        
        
        
        
        
        
        

        
        
        Scanner reader1 = new Scanner(System.in);

        System.out.print("To Store a new Message Press 1 and To Retrieve your stored message press 2: ");
        int num = reader1.nextInt();
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        
        if(num == 1){
            
            // TODO code application logic here
            
            System.out.println("Create Username:  ");

            String usernameString = reader.readLine();

            System.out.println("Create Password:  ");

            String passwordString = reader.readLine();
            
            System.out.println("Enter Your Message:  ");

            String originalString = reader.readLine();

            

            String encryptedString = encrypt(originalString);
            System.out.println("Press 1 to view your encrypted message and exit or Press 2 to save and exit");
            int vieworexit = reader1.nextInt();
            
            if(vieworexit == 1 ){
                System.out.println("Encrypted String - " + encryptedString);
            }
            else if (vieworexit == 2 ){
                
                System.out.println("Your message is succesfully encrypted and saved!");
            }

            

            
            
            
            

            


    //        try {
    //            BufferedWriter writer =
    //                    new BufferedWriter(new FileWriter(   "passwords.txt"));
    //            
    //
    //            writer.write(usernameString + "," + passwordString);
    //
    //            writer.close();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }

//            try
//            {
//                String filename= "passwords.txt";
//                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
//                fw.write(usernameString + "," + passwordString);//appends the string to the file
//                fw.close();
//            }
//            catch(IOException ioe)
//            {
//                System.err.println("IOException: " + ioe.getMessage());
//            }




            try {
                
                BufferedWriter writer =
                        new BufferedWriter(new FileWriter( usernameString + passwordString + ".txt"));


                writer.write(encryptedString);

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                
            }
        }
                
        
            else if (num == 2){
                System.out.println("Enter Your Username: ");
                 
                
                BufferedReader veriuser =  new BufferedReader(new InputStreamReader(System.in));
                
                String veriusername = veriuser.readLine();
                
                System.out.println("Enter Your Password: ");
 
                String veripassword = veriuser.readLine();
                
//                Veri(veriusername,veripassword);



//                String desktop = System.getProperty ("user.home") + "/NetBeansProjects/aessss/";
////
//                File myFile = new File (desktop + ".txt");


                String fileName = veriusername + veripassword + ".txt";
                 if (fileName.equals(veriusername + veripassword + ".txt") ){
                     
                     File file = new File(fileName);
                     FileReader fr = new FileReader(file);
                     BufferedReader br = new BufferedReader(fr);
                     String line;
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     while((line = br.readLine()) != null){
                         
                         
                         
                         String decryptedString = decrypt(line);
                         
                         System.out.println("Your Secret Message is " + "'" + decryptedString + "'"   );}
                     
                     
                 } 
                 else {
                     
                     System.out.println("Wrong Password!");
                     
                 }

                
                
                
                
             
                
                
                
                
                
            }
        else {


            System.out.println("Enter a valid input!");


        }    
                
                
               
                
            










    }
    
    
    
    
    
    
//    public static void Veri(String veriusername, String veripassword){
//        
//        
//        boolean found = false;
//        String tempUsername ="";
//        String tempPassword ="";
//    
//    
//    try {
//        
//        
//        String desktop = System.getProperty ("user.home") + "/NetBeansProjects/aessss/";
//
//        File myFile = new File (desktop + "passwords.txt");
//        Scanner x = new Scanner (myFile);
//        x.useDelimiter("[,\n]");
//        
//        while(x.hasNext() && !found)
//        {
//            tempUsername = x.next();
//            tempPassword = x.next();
//            
//            if (tempUsername.trim().equals(veriusername.trim()) && tempPassword.trim().equals(veripassword.trim()))
//            {
//                found = true;
//            }
//        }
//        x.close();
//        System.out.print(found);
//        
//    }
//    catch(Exception e) {
//        System.out.print("error");
//        
//    }
//}

}

