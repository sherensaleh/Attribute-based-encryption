/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

/**
 *
 * @author ibraheem
 */
//import static invertedindex.Read2.Documents;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rc2.TestDETABE.decrypt;
//import static rc2.TestDETABE.encrypt;
import src.utilABE.Files;
import static rc2.TestDETABE.encrypt;
//import static rc2.TestDETABE.table;

/**
 *
 * @author ibraheem
 */
public class InvertedIndex2 {

  //File relativeFile=new File(getClass().getResource("/docs").toURL());     
  // static String keyword;
   //static String h="";
  
   //String keywordsearch="";
    //String encryptchar="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime1=0 ;
        long startTime2=0 ;
         long startTime8=0 ;
        double endCreateTime = 0.0;
        double  endEncryptionTime=0.0;
         double  endDecryptionTime=0.0;
        double  endEncryptionTime1=0.0;
        double  endDecryptionTime1=0.0;
        double endCreateTime1 = 0.0;
        double totalCreationTime=0.0;
      String keyword;
      ArrayList<List> h=new ArrayList<List>();
      String type = "A";
      int secLevel = 128;
     List<String> results=new ArrayList<String>();
      //AccessTree ss;
      //Vector v;
          Document2 document2=new Document2();
      Hashtable <String,List> table=new Hashtable<String , List >();
      
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
        
      Scanner s = new Scanner(System.in);
      System.out.println("Enter your keyword search:");
      keyword=s.nextLine();
      char y=keyword.charAt(0);
    String keywordsearch=RC2.encrypt(keyword,"abcde");
    String encryptchar=RC2.encrypt((""+y),"abcde");
        // TODO code application logic here
       
       Read2 re=new Read2();

       //System.out.println("url:"+url.toString());
   // List<String> fileNames = new ArrayList<>();
     
    List<String> attributes = new LinkedList<String>();
       Scanner s1 = new Scanner(System.in);
        String attribute1 , attribute2 , attribute3;
//      attributes.add("manager");
//      attributes.add("professor");
//      attributes.add("A");"C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\
       System.out.println("Enter your attributes");
        attribute1=s1.nextLine();
        attribute2=s1.nextLine();
        attribute3=s1.nextLine();
        //attribute4=s1.nextLine();
        //attribute5=s1.nextLine();
//        attribute4=s1.nextLine();
//        attribute5=s1.nextLine();
//        attribute6=s1.nextLine();
//        attribute7=s1.nextLine();
//        attribute8=s1.nextLine();
//        attribute9=s1.nextLine();
//        attribute10=s1.nextLine();
//        attribute11=s1.nextLine();
//        attribute12=s1.nextLine();
        
        
      attributes.add(attribute1);
      attributes.add(attribute2);
      attributes.add(attribute3);
      // attributes.add(attribute4);
        //attributes.add(attribute5);
//      attributes.add(attribute4);
//      attributes.add(attribute5);
//      attributes.add(attribute6);
//      attributes.add(attribute7);
//      attributes.add(attribute8);
//      attributes.add(attribute9);
//      attributes.add(attribute10);
//      attributes.add(attribute11);
//      attributes.add(attribute12);
  
    // File folder = new File("C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\docs\\");
     File folder = new File("C:\\Users\\Alahram\\Desktop\\papers\\");
     File[] files = folder.listFiles();
   
    
            re.documentName();
      for (int i=0;i<files.length;i++){
        
     try {
                             
       startTime1 = System.currentTimeMillis();


         re.read("C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\docs\\"+ files[i].getName(), files[i].getName());
                   // fileNames.add(files[i].getName());
                    
                } catch (Exception ex) {
                    Logger.getLogger(InvertedIndex2.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.getMessage());
                }
//}
         endCreateTime= System.currentTimeMillis();
          endCreateTime1+= endCreateTime - startTime1; 
            // for (int i = 0; i < files.length; i++) {
       AES aes = new AES(files[i].getAbsolutePath(),files[i].getName());
           String name=files[i].getName();
         String path = files[i].getAbsolutePath();
          
         Random rn = new Random();
         int answer = rn.nextInt(9) + 0;
          //System.out.println(answer);

         AccessTree tree = new AccessTree(policies[answer]);
        // System.out.println("Tree: \n" + tree); 
         //System.out.println("List " + attributes + " satisfy tree? " + tree.checkSatisfy(attributes)); 
       //  table.put(files[i].getName(), tree);
     
         //byte datapln[] = Files.readBytesFromFile(path);
           byte datapln[]=name.getBytes();
         // byte datapln1[] = Files..readBytesFromFile(name);
         startTime2 = System.currentTimeMillis();
         List list = encrypt(policies[answer],secLevel,type,datapln,1);
          endEncryptionTime= System.currentTimeMillis();
          endEncryptionTime1+= endEncryptionTime - startTime2;
          table.put(name,list);
     // for(int u=0;u<files.length;i++){
       File file1=new File(i+".txt");
       String fileenc = "C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\ServerSide\\"+file1;
       Files.storeObject(list,fileenc, "Encryped DET-ABE data");
      
             //recover from file the CT and the encrypted data
    //  list = (LinkedList)Files.readObject(fileenc, "DET-ABE DECRYPTION MODULE: Reading encryped DET-ABE data");
        
      
      
      //  decrypt(list,attributes,1);
       
      }
      
        
            endCreateTime1 /= 1000.0;
            
            System.out.println("endCreateIndexTime is :"+endCreateTime1+""+"second");
             System.out.println("*******************************************************");  
            
        endEncryptionTime1/=1000;
        System.out.println("Time For Encryption Files with ABE:"+endEncryptionTime1);
         System.out.println("*******************************************************");  
        totalCreationTime=endCreateTime1+endEncryptionTime1;
        System.out.println("total Time For Create Index:"+totalCreationTime);
         System.out.println("*******************************************************");  
            for (Map.Entry<String, List> entry : table.entrySet()) {
               String key = entry.getKey();
               List value = entry.getValue();
               
               

  //  System.out.println ("Key: " + key + " Value: " + value);
}
//      byte datadec[] = decrypt(list, attributes,1);    
//      File file2=new File(i+".txt");
//     String filedec = "C:\\Users\\ibraheem\\Desktop\\RC2\\src\\DecryptedSide\\"+file2; 
//      Files.storeBytesInFile(datadec, filedec);     
//    //  }
//      //muestra los resultados,
//      System.out.println("\nTime in seconds:\n sym-key-gen \t sym-enc \t abe-enc \t pack-det \t prv-dec-key \t abe-dec \t aes-dec");
//      for(int j = 0; j < 7; j++)
//         System.out.print(DETABECipher.timing[j] + ",\t");
      //System.out.println();  
      //  }
     
      
           
       // for(Document2 d:re.Documents)
           // System.out.println(d.getArray());
       
           h= re.search(keywordsearch,encryptchar,re.sheren);
            // List array1;
          // List<String> neww;
         List<List<String>> listOfFiles=new ArrayList<List<String>>();
           Vector<String> v=new Vector<String>();
           for(int yy=0;yy<h.size();yy++){
         startTime8 = System.currentTimeMillis();
               List array1=h.get(yy);
           //  String array1[]= h;
            
//       for (String temp: array1){
//          List<String>  neww=new ArrayList<String>(Arrays.asList(temp.split(",")));
//            listOfFiles.add(neww);
//          System.out.println("ARRAY IS: "+ temp);
//          
//       }
          
      // for( int index = 0; index < array1.length; index += 2) {
//              for( int index = 0; index < array1.length; index ++) {
//              System.out.println("FILES NAME IS :"+array1[index]);
//              //v=new Vector();
//            v.add(array1[index]);
//        
//       }
       
  // re.delete("t12.txt",re.Documents);
   
   //}

       // }
      // for(int e=0;e<listOfFiles.size();e++){
       //   List fileName=listOfFiles.get(e);
         // List<String>myList=new ArrayList<String>(Arrays.asList(fileName));
     //    List ss= table.get(fileName);
        // LinkedList linkedlist = (LinkedList)ss.get(2);
    // AccessTree tree = (AccessTree)linkedlist.get(2);
       
          byte datadec[] = decrypt(array1, attributes,1);  
           endDecryptionTime= System.currentTimeMillis();
          endDecryptionTime1+= endDecryptionTime - startTime8;
         
          
        String shs = new String(datadec);
       results.add(shs);
      
        // List list = encrypt(policies[answer],secLevel,type,datapln,1);
       
           
       //   if(tree.checkSatisfy(attributes))
         //  System.out.println("files contained searched keyword is:"+v.get(e));
         //  else
         //      System.out.println("your attributes not satisfy access ploicy for that files:"+v.get(e));
           
    }
               endDecryptionTime1/=1000;
        System.out.println("Time For Decryption Files with ABE:"+endDecryptionTime1);
         System.out.println("*******************************************************");  
           for(int m=0;m<results.size();m++){
     System.out.println("files contain keyword search are:"+results.get(m));
      System.out.println("*******************************************************");  
           }
          // System.out.println("shereensaleh");
       System.exit(0);
    }
}

