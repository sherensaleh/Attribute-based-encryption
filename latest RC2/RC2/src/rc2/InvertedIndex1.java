/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

/**
 *
 * @author Alahram
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import src.utilABE.Files;
import static rc2.TestDETABE.encrypt;

/**
 *
 * @author ibraheem
 */
public class InvertedIndex1 {

    //Read1 re = new Read1();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        long startTime1 = 0;
         long startTime11 = 0;
        long startTime2 = 0;
        long startTime8 = 0;
        double endCreateTime = 0.0;
        double endEncryptionTime = 0.0;
        double endDecryptionTime = 0.0;
        double endEncryptionTime1 = 0.0;
        double endDecryptionTime1 = 0.0;
        double endCreateTime1 = 0.0;
        double endCreateTime11 = 0.0;
        double endCreateTime12 = 0.0;
        double totalCreationTime = 0.0;
        long startTime5 = 0;
        double endSearchTime = 0.0;
        String keyword;
        List h = new ArrayList<>();
        String type = "A";
        int secLevel = 128;
        List<String> results = new ArrayList<String>();
        Document2 document1 = new Document2();
        Hashtable<String, List> table = new Hashtable<String, List>();
         double startTime13=0.0;
         double endCreateTime13=0.0;
         double endCreateTimee13=0.0;
//         String policy1 = "A B 1of2";
//    String policy3 = "A";
//    String policy5 = "A C 2of2";
//    String policy7 = "A D 2of2";
//    String policy2 = "A B 2of2";
//    String policy4 = "A B 1of2 C D 1of2 1of2";
//    String policy6 = "A B 1of2 C D 1of2 E F 1of2 1of2 1of2";
//    String policy8 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 1of2";
//    String policy9 = "A C 2of2 A B 1of2 1of2";
//    String policy10 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 I J 1of2 1of2 1of2";
//        String[] policies = {policy1, policy2, policy4, policy6, policy8, policy10, policy3, policy5, policy7, policy9};

        Read1 re = new Read1();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your keyword search:");
        keyword = s.nextLine();
        char y = keyword.charAt(0);
        String yy = y + "";
        String newWord = RC2.encrypt(yy, "abcde");

        List<String> attributes = new LinkedList<String>();
        Scanner s1 = new Scanner(System.in);
      //  String attribute1, attribute2, attribute3,attribute4, attribute5, attribute6, attribute7, attribute8, attribute9, attribute10, attribute11, attribute12,attribute13, attribute14, attribute15;
       // String attribute1, attribute2, attribute3,attribute4, attribute5, attribute6;
        String attribute1, attribute2, attribute3, attribute4;
        System.out.println("Enter your attributes");
        attribute1 = s1.nextLine();
        attribute2 = s1.nextLine();
        attribute3 = s1.nextLine();
        attribute4 = s1.nextLine();
        
        attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
       attributes.add(attribute4);
//        attribute5 = s1.nextLine();
//        attributes.add(attribute5);
//        attribute6 = s1.nextLine();
//        attributes.add(attribute6);
//        attribute7 = s1.nextLine();
//        attributes.add(attribute7);
//        attribute8 = s1.nextLine();
//        attributes.add(attribute8);
//         attribute9 = s1.nextLine();
//        attributes.add(attribute9);
//        attribute10 = s1.nextLine();
//        attributes.add(attribute10);
//         attribute11 = s1.nextLine();
//        attributes.add(attribute11);
//        attribute12 = s1.nextLine();
//        attributes.add(attribute12);
//        attribute13 = s1.nextLine();
//        attributes.add(attribute13);
//         attribute14 = s1.nextLine();
//        attributes.add(attribute14);
//        attribute15 = s1.nextLine();
//        attributes.add(attribute15);

        File folder = new File("C:\\Users\\Alahram\\Desktop\\Docs\\");
        File[] files = folder.listFiles();

        re.documentNamee();
        for (int i = 0; i < files.length; i++) {

            try {

                re.readWordsFromFiles("C:\\Users\\Alahram\\Desktop\\Docs\\" + files[i].getName());

            } catch (Exception ex) {
                Logger.getLogger(InvertedIndex2.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
        re.setIntegerForEachWord(re.llllist);
        re.generateMatrix();

        List<double[]> trapdoor = re.encryptQuery(keyword);

        startTime1 = System.currentTimeMillis();
        for (int ii = 0; ii < files.length; ii++) {
            re.creatIndex("C:\\Users\\Alahram\\Desktop\\Docs\\" + files[ii].getName(), files[ii].getName());
            Set<Object> rede = re.shereen.keySet();
            endCreateTime = System.currentTimeMillis();
            endCreateTime1 += endCreateTime - startTime1;

        }

        endCreateTime1 /= 1000.0;

        System.out.println("endCreateIndexTime is :" + endCreateTime1 + "" + "second");
        System.out.println("*******************************************************");

        re.encryptLetters();

        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        

        startTime11 = System.nanoTime();
        re.update("C:\\Users\\Alahram\\Desktop\\Docs\\t8.txt", "t8");
        endCreateTime11 = System.nanoTime();
        endCreateTime12 = endCreateTime11 - startTime11;
        endCreateTime12 /= 1000000000;
        System.out.println("endUpdataFile is :" + endCreateTime12 + "" + "second");
        System.out.println("*******************************************************");

      List<String> listOfFileName=new ArrayList<String>();
      listOfFileName.add("t3");
      listOfFileName.add("t4");
      listOfFileName.add("t5");
//
//      listOfFileName.add("t9");
//      listOfFileName.add("t10");
//      listOfFileName.add("t8");
//      listOfFileName.add("t12");
//      listOfFileName.add("t13");
//      listOfFileName.add("t14");
//      listOfFileName.add("t15");
//      listOfFileName.add("t16");
//      listOfFileName.add("t17");
//      listOfFileName.add("t18");
//      listOfFileName.add("t19");
//      listOfFileName.add("t20");
//      listOfFileName.add("t21");
//      listOfFileName.add("t22");
//      listOfFileName.add("t23");
        
        for(String fil:listOfFileName){
             startTime13 = System.currentTimeMillis();
        //re.update("C:\\Users\\Alahram\\Desktop\\Docs\\t22.txt", "t22");
        re.delete(fil, re.shereen);
        endCreateTime13 = System.currentTimeMillis();
        endCreateTimee13 += endCreateTime13 - startTime13;
        }
        endCreateTimee13 /= 1000;
        System.out.println("enddeleteFile is :" + endCreateTimee13 + "" + "second");
        System.out.println("*******************************************************");
        
        double startTime88 = System.currentTimeMillis();
        re.encryptIndex(re.shereen);
        double endEncryptIndex = System.currentTimeMillis();
        double endEncryptIndex1 = endEncryptIndex - startTime88;
        endEncryptIndex1 /= 1000.0;
        double endEncryptIndex2 = endEncryptIndex1 + endCreateTime1;

        System.out.println("end Create and Encrypt Index:" + endEncryptIndex2);
        double encryptABE = DETABECipher.endTime1;
        double createPK = DETABECipher.endTime2;
        double time9 = encryptABE + createPK;
        encryptABE /=1000.0;
        //  time/=1000;
        //double time1 = re.endEncryptionTime11 - time9;
       // time1 /= 1000;
        time9 /=1000;
        TestDETABE.endEncryptionTime11/=1000.0;
        System.out.println("total Time For encrypt Files:" +  encryptABE);
       // System.out.println("total Time For encrypt words:" + re.endEncryptionTime1);
       // double result = re.endEncryptionTime11 + re.endEncryptionTime1 + endCreateTime1;
       double result = encryptABE+ re.endEncryptionTime1 + endCreateTime1;
       System.out.println("total Time For create and encrypt Index:" + result);

        startTime5 = System.nanoTime();
        h = re.search(trapdoor, newWord, re.shereen);
        endSearchTime = System.nanoTime() - startTime5;
        endSearchTime /= 1000000000.0;
        System.out.println("search Time is :" + endSearchTime + "" + "second");

        List<List<String>> listOfFiles = new ArrayList<List<String>>();
        Vector<String> v = new Vector<String>();
        for (int yyy = 0; yyy < h.size(); yyy++) {

           // startTime8 = System.currentTimeMillis();

            List fh = (List) h.get(yyy);
            for (int uu = 0; uu < fh.size(); uu++) {
               LinkedList fgh = (LinkedList) fh.get(uu);
               // List fgh =  fh.get(uu);
                byte datadec[] = decrypt(fgh, attributes, 1);
               // endDecryptionTime = System.currentTimeMillis();
              //  endDecryptionTime1 += endDecryptionTime - startTime8;
           
                String shs = new String(datadec);
                results.add(shs);

            }
        }
        DETABECipher.endGeneratekey1 /= 1000;
        System.out.println("Time For Decryption Files with ABE: is :"+DETABECipher.endGeneratekey1 +""+"second");
        //endDecryptionTime1 /= 1000;
        //System.out.println("Time For Decryption Files with ABE:" + endDecryptionTime1);
        System.out.println("*******************************************************");
        for (int m = 0; m < results.size(); m++) {
            System.out.println("files contain keyword search are:" + results.get(m));
            System.out.println("*******************************************************");
        }
        System.exit(0);
    }
}
