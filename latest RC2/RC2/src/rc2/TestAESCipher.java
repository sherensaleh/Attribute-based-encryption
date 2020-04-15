/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.io.File;
import src.utilABE.Files;

public class TestAESCipher{
  

   
   public static void test() throws Exception{
   
      final int SEC_LEVEL = 128;
      final int MAX_ITERS = 1;
      
      double keyGen[] = new double[MAX_ITERS];
      double encrypt[] = new double[MAX_ITERS];
      double decrypt[] = new double[MAX_ITERS];
      
          File folder = new File("C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\docs\\");
         File[] files = folder.listFiles();
    
       for (int j = 0; j < files.length; j++) {
         String path = files[j].getAbsolutePath();
           
 
      for (int i = 0; i < MAX_ITERS; i++){
      
         try{
            //Open source data
            byte plaitext[] = Files.readBytesFromFile(path);   
            
            //generate key
            AESCipher.genSymmetricKey(SEC_LEVEL);
            
            //encryp data with key
            byte[] cipherText = AESCipher.encrypt(plaitext);
         
            //Store results as byte[]
            File file1=new File(j+".txt");
           String fileenc = "C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\DecryptedSide\\ServerSide\\"+file1;
            Files.storeBytesInFile(cipherText, fileenc + "" + i + ".enc");
            Files.storeBytesInFile(AESCipher.iv,fileenc + "" + i + ".iv");
           
           
           //decrypt the file
         
            byte[] cipherText2 = Files.readBytesFromFile(fileenc + "" + i + ".enc");
             
            byte iv2[] = Files.readBytesFromFile(fileenc + "" + i + ".iv");
            byte[] plaintext2 = AESCipher.decrypt(cipherText2, iv2,AESCipher.key);
             
             //store decrypted data
               File file2=new File(j+".txt");
             String filedec = "C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\DecryptedSide\\"+file2;
            Files.storeBytesInFile(plaintext2, filedec );
             
             //compares file with its decrypted version
              
            keyGen[i] = AESCipher.timing[0];
            encrypt[i] = AESCipher.timing[1];
            decrypt[i] = AESCipher.timing[2];
         
            
         }
         catch(Exception e){
            System.out.println("AES MODULE: EXCEPTION");
            e.printStackTrace();
            System.out.println("---------------------------");
         }
      
      
      }
      }
      
   //   System.out.println("\nTime (seconds)");
     // System.out.println("\n\t AES-key gen, AES-encryption time, AES-dcryption time");
         
   //   for (int i = 0; i < MAX_ITERS; i++)
     //    System.out.println(keyGen[i] + "," + encrypt[i] +  "," + decrypt[i]);
      
            
   }
   
   public static void main(String []args) throws Exception{
      test();   
   }

}
