/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.utilABE.*;

import src.cpabe.bsw.accessStructure.*;
import src.cpabe.bsw.ct.*;

import src.cpabe.bsw.common.*;
import src.detabe.*;

/**
 * For encryption, a security level, curve type and policy must be selected.
 * The content is encryted with AES and the AES-key is encrypted with CP-ABE.
 * When decrypting, the AES-key is first decrypted using the ABE decryption key 
 * that matches the encryption policy. Then the content is decrypted using that
 * AES-key.
 */
public class TestDETABE{
static double endEncryptionTime11=0.0;
  static Hashtable <String,AccessTree> table=new Hashtable<String , AccessTree >(); 
   public static void main(String args[]){
   
      String policy1 = "A B 1of2";
      String policy3 = "A";
      String policy5 = "A C 2of2";
      String policy7 = "A D 2of2";
      String policy2 = "A B 2of2";
      String policy4 = "A B 1of2 C D 1of2 1of2";
      String policy6 = "A B 1of2 C D 1of2 E F 1of2 1of2 1of2";
      String policy8 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 1of2";
      String policy9 = "A C 2of2 A B iof2 1of2";
      String policy10 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 I J 1of2 1of2 1of2";
      
      String[] policies = {policy1,policy2,policy4,policy6,policy8,policy10,policy3,policy5,policy7,policy9};
      
    // for(int g=0;g<policies.length;g++)
      
     // AccessTree tree1 = new AccessTree(policy2); 
      //System.out.println("Tree: \n" + tree);   
      
      //check for satisfisibility
      List<String> attributes = new LinkedList<String>();
       Scanner s = new Scanner(System.in);
        String attribute1 , attribute2 , attribute3;
//      attributes.add("manager");
//      attributes.add("professor");
//      attributes.add("A");
//       System.out.println("Enter your attributes");
//        attribute1=s.nextLine();
//        attribute2=s.nextLine();
//        attribute3=s.nextLine();
//        
//      attributes.add(attribute1);
//      attributes.add(attribute2);
//      attributes.add(attribute3);
   
     // System.out.println("List " + attributes + " satisfy tree? " + tree.checkSatisfy(attributes));   
      
     // String filepln = "test/results/file.pdf";
     
      
      File folder = new File("C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\docs\\");
         File[] files = folder.listFiles();
      // boolean bool=false;
        for (int i = 0; i < files.length; i++) {
         String path = files[i].getAbsolutePath();
          
         Random rn = new Random();
         int answer = rn.nextInt(10) + 0;
          //System.out.println(answer);

        AccessTree tree = new AccessTree(policies[answer]);
         System.out.println("Tree: \n" + tree); 
         System.out.println("List " + attributes + " satisfy tree? " + tree.checkSatisfy(attributes)); 
         table.put(files[i].getName(), tree);
//          try {
//              bool=file1.createNewFile();
//          } catch (IOException ex) {
//              Logger.getLogger(TestDETABE.class.getName()).log(Level.SEVERE, null, ex);
//          }
          //boolean createNewFile createNewFile = File.createNewFile();
         
        
     // System.out.println("List " + attributes + " satisfy tree? " + tree.checkSatisfy(attributes));   
     // String filepln = "test/results/file.pdf";
     // String fileenc = "test/results/file.pdf.encABE";
     // String filedec = "test/results/file.pdf.encABE.dec.pdf";         
      
      
      byte datapln[] = Files.readBytesFromFile(path);
      //byte datapln[] = Files.readBytesFromFile(filepln);
   
      String type = "A";
      int secLevel = 128;
   
   
      List list = encrypt(policies[answer],secLevel,type,datapln,1);
      
     // for(int u=0;u<files.length;i++){
       File file1=new File(i+".txt");
       String fileenc =  "C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\ServerSide\\"+file1;
      Files.storeObject(list,fileenc, "Encryped DET-ABE data");
      
             //recover from file the CT and the encrypted data
      list = (LinkedList)Files.readObject(fileenc, "DET-ABE DECRYPTION MODULE: Reading encryped DET-ABE data");
       
      byte datadec[] = decrypt(list, attributes,1);    
      File file2=new File(i+".txt");
     String filedec = "C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\DecryptedSide\\"+file2; 
      Files.storeBytesInFile(datadec, filedec);     
    //  }
      //muestra los resultados,
//      System.out.println("\nTime in seconds:\n sym-key-gen \t sym-enc \t abe-enc \t pack-det \t prv-dec-key \t abe-dec \t aes-dec");
   //   for(int j = 0; j < 7; j++)
     //    System.out.print(DETABECipher.timing[j] + ",\t");
     // System.out.println();  
        }
        System.exit(0);
   
   }
  
   public static byte[] decrypt(List list, List attributes, int ITERS){
      double results[] = new double[ITERS];
      DETABECipher cipher = new DETABECipher();
      long startTime, endTime;
      byte[] result = null;
      
      for (int i = 0; i < ITERS; i++){
         startTime = System.nanoTime();  
         result = cipher.decrypt(list,attributes);   
         endTime = System.nanoTime();
         results[i] = (double)(endTime - startTime)/1000000000.0;   
      }
//      System.out.println("Decrypt time: ");
  //    for(double d:results)
    //     System.out.println(d);
   
      return result;
   }
   
   
   public static List encrypt(String policy, int secLevel, String type, byte[] data, int ITERS){
      // double startTime1=0.0;
     //  double  endEncryptionFileTime=0.0;
     //  startTime1 = System.currentTimeMillis();
      double results[] = new double[ITERS];
      DETABECipher cipher = new DETABECipher();
      long startTime, endTime;
      List list = null;
     
      for (int i = 0; i < ITERS; i++){
         startTime = System.nanoTime();
         list = cipher.encrypt(data, secLevel,type, policy);
         endTime = System.nanoTime();
       //  endEncryptionFileTime = System.currentTimeMillis();
         //endEncryptionTime11 += endEncryptionFileTime - startTime1;
         results[i] = (double)(endTime - startTime)/1000000000.0;
      }
   
   //   System.out.println("Encrypt time: ");
     // for(double d:results)
       //  System.out.println(d);
   
      return list;
   }

    
}
