/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alahram
 */
public class NewClass {
     //  Random r2 = new Random();
       Hashtable<String, Integer> wordsIndex = new Hashtable<String, Integer>();
     static  List <String>lllist=new ArrayList<String>();
       Sha256 sha = new Sha256();
       Random r11 = new Random();
         public Hashtable<String, Object[][]> sheren = new Hashtable<String, Object[][]>(); 
       
    public static void main(String[] args) {
        NewClass re=new NewClass();
        
        File folder = new File("C:\\Users\\Alahram\\Desktop\\Docs\\");
        File[] files = folder.listFiles();
         for (int i = 0; i < files.length; i++) {

            try {

                re.readd("C:\\Users\\Alahram\\Desktop\\Docs\\" + files[i].getName());
             

            } catch (Exception ex) {
                Logger.getLogger(InvertedIndex2.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        
         }
         re.reead(lllist);
          for (int i = 0; i < files.length; i++) {
         re.creatIndex("C:\\Users\\Alahram\\Desktop\\Docs\\" + files[i].getName(), files[i].getName());
       
    }
//    Vector vc=new Vector();
//        vc.add(0, 'a');
//        vc.add(1, 'b');
//        vc.add(2, 'c');
//        vc.add(3, 'd');
//        vc.add(4, 'e');
//        vc.add(5, 'f');
//        vc.add(6, 'g');
//        vc.add(7, 'h');
//        vc.add(8, 'i');
//        vc.add(9, 'j');
//        vc.add(10, 'k');
//        vc.add(11, 'l');
//        vc.add(12, 'm');
//        vc.add(13, 'n');
//        vc.add(14, 'o');
//        vc.add(15, 'p');
//        vc.add(16, 'q');
//        vc.add(17, 'r');
//        vc.add(18, 's');
//        vc.add(19, 't');
//        vc.add(20, 'u');
//        vc.add(21, 'v');
//        vc.add(22, 'w');
//        vc.add(23, 'x');
//        vc.add(24, 'y');
//        vc.add(25, 'z');
//     for (int i=0;i<vc.size();i++){
//        if (vc.get(i).equals('x')) {
//            int r=i;
//            System.out.println("sum is:"+i); 
//        }
//     }
//        Hashtable<String, Integer> index = new Hashtable<String, Integer>();
//        List<String> fg = new ArrayList<String>();
//        fg.add("ahmed");
//        fg.add("shereen");
//        fg.add("ali");
//        fg.add("ayman");
//        fg.add("amal");
//        fg.add("adham");
//     
//      //  Set<String> words = tabe.keySet();
//                // int ctr = 1;
//                int y = fg.size();
//                for (String word1 : fg) {
//                   
//                    Random r11 = new Random();
//                    int dd = r11.nextInt(y)+0;
//                }
              //  UUID FGH=    UUID.randomUUID();
                    
//                    if (!index.contains(dd)) {
//                    while(!index.contains(r11.nextInt(y))){   
//                      index.put(word1,UUID.randomUUID());
//                       }
//               }else{
//                          int ddd = r11.nextInt(y); 
                          
                 
              //  }
//     for (int u=0;u<9;u++){
//        Random r1 = new Random();
//        int dd=r1.nextInt(20);
//        if(!fg.contains(dd)){
//        fg.add(dd);
//            System.out.println("dd is"+dd);
//        }  
//     }
     // public static void main(String[] args) {
//      NewClass nn=new NewClass();
//       for (int u = 0; u < 9; u++) {
//                Random r11 = new Random();
//                int dd = r11.nextInt(10)+0;
//       }
//                if (!fg.contains(dd)) {
//                    
//                fg.add(dd);
//                    System.out.println("the uniqe number:"+dd);
//                }
//       }
//       
//      Vector c=new Vector();
//   int fds=   c.toString().getBytes().length;
//        
//        Float cd=r1.nextFloat();
//      //  Float dd=r2.nextFloat();
//        System.out.println(cd);
//        System.out.println(dd);
//        System.out.println(r1);
//    
//        //System.out.println(r2.nextFloat());
//       // System.out.println(r2.nextFloat());
//       
//        String d="heba";
//       
//       int g=Integer.parseInt(d.trim());
//          System.out.println("string into int"+g);
//          byte [] bytes={1,7,-39,-47};
//        System.out.println("string is:"+ ByteBuffer.wrap(bytes).getInt());
//          
//    
//      //Object result=ClassHelper.convertPrimitive(Integer.class,"");    
//}
}
    public void readd(String file) {
        Scanner s = null;
        List<String> list = new ArrayList<String>();
        try {
            s = new Scanner(new File(file));
            while (s.hasNext()) {
                list.add(s.next());
            }
            for (int h = 0; h < list.size(); h++) {
                String f = list.get(h);
                lllist.add(f);
            }
          
          

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public void reead(List <String> j){
//          String j=lllist.get(0);
//                 wordsIndex.put(j, 0);
            for (int i = 0; i < j.size();i++ ) {
                String y=j.get(i);
                wordsIndex.put(y, i);
               // i++;
            }
    }
    
    public void creatIndex(String file, String fileName) {
        Scanner s = null;
        int index = 0;
        List<String> list = new ArrayList<String>();

        try {
            s = new Scanner(new File(file));
            while (s.hasNext()) {
                list.add(s.next());
            }
            for (int u = 0; u < list.size(); u++) {
                String word = list.get(u);
                 char t = word.charAt(0);
                Set<String> words = wordsIndex.keySet();
                for (String w : words) {
                    if (word.equals(w)) {
                        index = wordsIndex.get(w);
                    }
                }
                Vector wrd = new Vector();
                int hj = lllist.size();
               
                int ho = hj + 1;
                int i = index;
                //  for (int i = index; i < lllist.size(); i++) {
                for (int j = 1; j <= ho; j++) {
                    //if(j==0)
                    //    j=1;
                    if (j <= i) {
                        byte[] nhash = sha.hash(word.getBytes());
                        int fg = new BigInteger(nhash).intValue();
                        // wrd.add(j, fg);
                        wrd.add(fg);
                        //wrd.insertElementAt(fg, j);
                    } else if ((i < j) && (j <= lllist.size())) {

                        int dd = r11.nextInt();
                        // wrd.add(j, dd);
                        wrd.add(dd);
                    } else if (j == ho) {
                        // wrd.add(j, 1);
                        wrd.add(1);
                        // wrd.insertElementAt(1, j);
                        //  pi,j=1;
                    }
                    
                    
                }
                // }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}