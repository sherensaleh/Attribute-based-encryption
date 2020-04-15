/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
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
import static rc2.TestDETABE.encrypt;
//import static rc2.TestDETABE.encrypt;

/**
 *
 * @author ibraheem
 */
public class Read2 {
    boolean flag = false; 
    Hashtable <String,List<String>> tabllle=new Hashtable<String , List<String>>();
   public Hashtable <String,Object[][]> sheren = new Hashtable<String,Object[][]>();
    //InvertedIndex2 v=new InvertedIndex2();
    ArrayList<ArrayList<String>> listOfList = new ArrayList<ArrayList<String>>();
    //static  ArrayList<Document2> Documents = new ArrayList<Document2>();
      //File folder = new File("C:\\Users\\ibraheem\\Desktop\\latest\\SearchEncryptedMaster\\src\\papers\\");
      // File[] files = folder.listFiles();
       //Main main=new Main();

    ArrayList<String[][]>listOfArray=new ArrayList<String[][]>();
    int ii=0;
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
       String type = "A";
      int secLevel = 128;
    Document2 document1=new Document2();
//    Document2 document2=new Document2();
//    Document2 document3=new Document2();
//    Document2 document4=new Document2();
//    Document2 document5=new Document2();
//    Document2 document6=new Document2();
//    Document2 document7=new Document2();
//    Document2 document8=new Document2();
//    Document2 document9=new Document2();
//    Document2 document10=new Document2();
//    Document2 document11=new Document2();
//    Document2 document12=new Document2();
//    Document2 document13=new Document2();
//    Document2 document14=new Document2();
//    Document2 document15=new Document2();
//    Document2 document16=new Document2();
//    Document2 document17=new Document2();
//    Document2 document18=new Document2();
//    Document2 document19=new Document2();
//    Document2 document20=new Document2();
//    Document2 document21=new Document2();
//    Document2 document22=new Document2();
//    Document2 document23=new Document2();
//    Document2 document24=new Document2();
//    Document2 document25=new Document2();
//    Document2 document26=new Document2();
//    
  
 
    
   
   public void documentName(){
 
   Object[][] a=new Object[5000][4];
   Object[][] b=new Object[5000][4];
   Object[][] c=new Object[5000][4];
   Object[][] d=new Object[5000][4];
   Object[][] e=new Object[5000][4];
   Object[][] f=new Object[5000][4];
   Object[][] g=new Object[5000][4];
   Object[][] h=new Object[5000][4];
   Object[][] i=new Object[5000][4];
   Object[][] j=new Object[5000][4];
   Object[][] k=new Object[5000][4];
   Object[][] l=new Object[5000][4];
   Object[][] m=new Object[5000][4];
   Object[][] n=new Object[5000][4];
  // Object[][] n=new Object[500][4];
   Object[][] o=new Object[5000][4];
   Object[][] p=new Object[5000][4];
   Object[][] q=new Object[5000][4];
   Object[][] r=new Object[5000][4];
   Object[][] s=new Object[5000][4];
   Object[][] t=new Object[5000][4];
   Object[][] u=new Object[5000][4];
   Object[][] v=new Object[5000][4];
   Object[][] w=new Object[5000][4];
   Object[][] x=new Object[5000][4];
   Object[][] y=new Object[5000][4];
   Object[][] z=new Object[5000][4];                  
     
   
   String encrypta=RC2.encrypt((""+'a'),"abcde");
   String encryptb=RC2.encrypt((""+'b'),"abcde");
   String encryptc=RC2.encrypt((""+'c'),"abcde");
   String encryptd=RC2.encrypt((""+'d'),"abcde");
   String encrypte=RC2.encrypt((""+'e'),"abcde");
   String encryptf=RC2.encrypt((""+'f'),"abcde");
   String encryptg=RC2.encrypt((""+'g'),"abcde");
   String encrypth=RC2.encrypt((""+'h'),"abcde");
   String encrypti=RC2.encrypt((""+'i'),"abcde");
   String encryptj=RC2.encrypt((""+'j'),"abcde");
   String encryptk=RC2.encrypt((""+'k'),"abcde");
   String encryptl=RC2.encrypt((""+'l'),"abcde");
   String encryptm=RC2.encrypt((""+'m'),"abcde");
   String encryptn=RC2.encrypt((""+'n'),"abcde");
   String encrypto=RC2.encrypt((""+'o'),"abcde");
   String encryptp=RC2.encrypt((""+'p'),"abcde");
   String encryptq=RC2.encrypt((""+'q'),"abcde");
   String encryptr=RC2.encrypt((""+'r'),"abcde");
   String encrypts=RC2.encrypt((""+'s'),"abcde");
   String encryptt=RC2.encrypt((""+'t'),"abcde");
   String encryptu=RC2.encrypt((""+'u'),"abcde");
   String encryptv=RC2.encrypt((""+'v'),"abcde");
   String encryptw=RC2.encrypt((""+'w'),"abcde");
   String encryptx=RC2.encrypt((""+'x'),"abcde");
   String encrypty=RC2.encrypt((""+'y'),"abcde");
   String encryptz=RC2.encrypt((""+'z'),"abcde");
                    
  // List l=new ArrayList();
   sheren.put(encrypta, a);
   sheren.put(encryptb, b);
   sheren.put(encryptc, c);
   sheren.put(encryptd, d);
   sheren.put(encrypte, e);
   sheren.put(encryptf, f);
   sheren.put(encryptg, g);
   sheren.put(encrypth, h);
   sheren.put(encrypti, i);
   sheren.put(encryptj, j);
   sheren.put(encryptk, k);
   sheren.put(encryptl, l);
   sheren.put(encryptm, m);
   sheren.put(encryptn, n);
   sheren.put(encrypto, o);
   sheren.put(encryptp, p);
   sheren.put(encryptq, q);
   sheren.put(encryptr, r);
   sheren.put(encrypts, s);
   sheren.put(encryptt, t);
   sheren.put(encryptu, u);
   sheren.put(encryptv, v);
   sheren.put(encryptw, w);
   sheren.put(encryptx, x);
   sheren.put(encrypty, y);
   sheren.put(encryptz, z);
   
   
               
//      Documents.add(document1);
//      Documents.add(document2);
//      Documents.add(document3);
//      Documents.add(document4);
//      Documents.add(document5);
//      Documents.add(document6);
//      Documents.add(document7);
//      Documents.add(document8);
//      Documents.add(document9);
//      Documents.add(document10);
//      Documents.add(document11);
//      Documents.add(document12);
//      Documents.add(document13);
//      Documents.add(document14);
//      Documents.add(document15);
//      Documents.add(document16);
//      Documents.add(document17);
//      Documents.add(document18);
//      Documents.add(document19);
//      Documents.add(document20);
//      Documents.add(document21);
//      Documents.add(document22);
//      Documents.add(document23);
//      Documents.add(document24);
//      Documents.add(document25);
//      Documents.add(document26);
      
//      document1.setName('a'); 
//      document2.setName('b'); 
//      document3.setName('c'); 
//      document4.setName('d'); 
//      document5.setName('e'); 
//      document6.setName('f'); 
//      document7.setName('g'); 
//      document8.setName('h'); 
//      document9.setName('i'); 
//      document10.setName('j'); 
//      document11.setName('k'); 
//      document12.setName('l'); 
//      document13.setName('m'); 
//      document14.setName('n'); 
//      document15.setName('o'); 
//      document16.setName('p'); 
//      document17.setName('q'); 
//      document18.setName('r'); 
//      document19.setName('s'); 
//      document20.setName('t'); 
//      document21.setName('u'); 
//      document22.setName('v'); 
//      document23.setName('w'); 
//      document24.setName('x'); 
//      document25.setName('y'); 
//      document26.setName('z'); 
      
//      listOfArray.add(a);
//      listOfArray.add(b);
//      listOfArray.add(c);
//      listOfArray.add(d);
//      listOfArray.add(e);
//      listOfArray.add(f);
//      listOfArray.add(g);
//      listOfArray.add(h);
//      listOfArray.add(i);
//      listOfArray.add(j);
//      listOfArray.add(k);
//      listOfArray.add(l);
//      listOfArray.add(m);
//      listOfArray.add(n);
//      listOfArray.add(o);
//      listOfArray.add(b);
//      listOfArray.add(q);
//      listOfArray.add(r);
//      listOfArray.add(s);
//      listOfArray.add(t);
//      listOfArray.add(u);
//      listOfArray.add(v);
//      listOfArray.add(w);
//      listOfArray.add(x);
//      listOfArray.add(y);
//      listOfArray.add(z);
      
      
    }
     
    public void read(String file, String fileName) throws FileNotFoundException, MalformedURLException, IOException {
     Hashtable<String,Object[][]> sr=new Hashtable<String,Object[][]>();
        //  Document2 document=new Document2();    
        //ArrayList<Document2> listt=new ArrayList();
       //  document= readWordsFromFile(file,fileName);
         sr= readWordsFromFile(file,fileName);
     }
     
     
    public Hashtable<String,Object[][]> readWordsFromFile(String file,String fileName) {
         Object [][]e=new Object[500][4];
         
      //  Hashtable hj=new Hashtable<String,String[][]>();
        Scanner s = null;
          ArrayList<String> lllist = new ArrayList<String>(); 
          ArrayList<String> list = new ArrayList<String>();
          Random rn = new Random();
         int answer = rn.nextInt(9) + 0;
          //System.out.println(answer);

         AccessTree tree = new AccessTree(policies[answer]);
        // byte datapln[]=fileName.getBytes();
        //  List lisst = encrypt(policies[answer],secLevel,type,datapln,1);
        //  String newName=lisst.toString();
     
        try {
            s = new Scanner(new File(file));
            while (s.hasNext()) {
                list.add(s.next());
            }
           
           // for(int u=0;u<list.size();u++){
                for(String worrd:list){
            String newWord=RC2.encrypt(worrd,"abcde"); 
                 // ArrayList<String> lllist = new ArrayList<String>(); 
                  lllist.add(newWord);
            }
                
            tabllle.put(fileName, lllist);
            
            listOfList.add(list);
        for(int i=0;i<list.size();i++){
           
           String word=list.get(i);
           String wwword=lllist.get(i);
           double termFrequency= tf(lllist,wwword);
           double documentFrequency=idf(tabllle,wwword);
           double inverseDocumentFrequency=tfIdf(lllist,tabllle,wwword);
           String concatinateFileWithTf = fileName+termFrequency;
           byte datapln[]=concatinateFileWithTf.getBytes();
         List lisst =  encrypt(policies[answer],secLevel,type,datapln,1);
        ArrayList<List> lliisst=new ArrayList<List>();
//List lliisst=new ArrayList<>();
        lliisst.add(lisst);
          //lisst.get(0);
      //    String newName=lisst.toString();
           char t=word.charAt(0);
           String encryptionChar=RC2.encrypt(""+t,"abcde");
           String encryptionWord=RC2.encrypt(word,"abcde");
           Set<String> ff=sheren.keySet();
         // for(int h=0;h<ff.size();h++)
             for(String bb:ff)
             if(encryptionChar.equals(bb)){
               
                e=sheren.get(bb);
//          
//            char t=word.charAt(0);
//        String encryptionChar=RC2.encrypt(""+t,"abcde");
//           Set<String> ff=sheren.keySet();
//         // for(int h=0;h<ff.size();h++)
//             for(String bb:ff)
//             if(encryptionChar.equals(bb)){
//                //String encryptionWord=RC2.encrypt(a,"abcde");
//             String [][]e=sheren.get(bb); 
//           for(int j=0;j<e.length;j++)
//        {   
//       if(e[j][0]!=null){
//       if(e[j][0].equals(wwword)){
//         
//                if (!(e[j][1]).contains(fileName)) {
//                    e[j][1]=e[j][1]+","+concatinateFileWithTf;
//                 
//                    e[j][2]=""+documentFrequency;
//                    e[j][3]=""+inverseDocumentFrequency;
//                   
//                }
//                flag=true;
//       }}
//        else
//           break;
//        }
//     
//        if(flag==false){
//           e[ii][0]=wwword;
//           e[ii][1]=concatinateFileWithTf;
//           e[ii][2]=""+documentFrequency;
//           e[ii][3]=""+inverseDocumentFrequency;
//            ii++;
//        }
//       
//        flag=false;
//    }
              //  String f=""+lisst;
     document1.setWord(word,lliisst,documentFrequency,inverseDocumentFrequency,e);
     
             }
            // }break;
            // }
//                 for(String[][] dd:listOfArray) {
//                   if(dd.equals('t')){
//                  for(int j=0;j<dd.length;j++)
//                  System.out.println("content of array is:"+dd[0][0]);
//      }
//  } 
//              if(t==d.getPlaintextName()){
//              d.setWord(word,concatinateFileWithTf,documentFrequency,inverseDocumentFrequency);
//              break;
//              }
//         
             }
         }catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
           }
            // }
          return sheren;
        } 


  // System.out.println("INDEX FOR ALL FILES:"+Arrays.toString(Documents.toArray()));

       // return Documents;
    //} 
     
    public ArrayList<List> search(String wword,String word2,Hashtable<String,Object[][]> ll){
          long startTime=0 ;
        double endSearchTime = 0.0;
         String fileName="";
         ArrayList<List> fileNName=new ArrayList<List>();
      //  String[][] array=new String[500][4];
        int c=0;
//         char tt=wword.charAt(0);
//        String encryptionWord=RC2.encrypt(wword, "abcde");
//        String keywordSearch=RC2.encrypt((""+tt),"abcde");
        startTime = System.currentTimeMillis();
        Set<String> fff=ll.keySet();
             for(String bbb:fff)
             if(word2.equals(bbb)){
           Object [][]ee=ll.get(bbb); 
        for(c=0;c<ee.length;c++){
         //for(Document2 d:ll){
             // char n=d.getName();
              //if(word2.equals(d.getName())){
               // array=d.getArray();
              // for(c=0;c<array.length;c++)  {
                 if(wword.equals(ee[c][0])){
                     fileNName=(ArrayList<List>) ee[c][1];
                     
                     System.out.println("fileName with ID :"+fileName);
                     break;
                 }
              //else
                   // System.out.println("words not found in dataset");
                  } 
             }
        // }
            endSearchTime = System.currentTimeMillis() - startTime;
            endSearchTime /= 1000.0;
            System.out.println("search Time is :"+endSearchTime+""+"second");
         return fileNName;
    }
      
    
    
    public double tf(List<String> file, String term) {
        double result = 0;
        for (String word : file) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return (result / file.size());
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
   // public double idf(ArrayList<ArrayList<String>> docs, String term) {
    
    public double idf(Hashtable<String,List<String>> kk, String term) {
            double n = 0;
            List< List<String>> docs =new ArrayList <List<String>>(kk.values());
          // List<List<String>> docs=kk..values();
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return  Math.log(docs.size() / n);

    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc,Hashtable<String,List<String>>  docs, String term) {
        return (tf(doc, term) * idf(docs, term));

}
  public void delete (List fileN, Hashtable<String,Object[][]> index){
      double documentFrequencyy=0.0;
    //  double inverseDocumentFrequencyy=0.0;
     tabllle.remove(fileN);
     for (Map.Entry<String,Object[][]> entry : sheren.entrySet()) {
               //String key = entry.getKey();
               Object[][] value = entry.getValue();
               for(int h=0;h<value.length;h++){
               Object f= value[h][1];
                       int e=0;
             Vector<String> v=new Vector<String>();       
            ArrayList<List> array2= (ArrayList<List>)f;
         if(Arrays.asList(array2).contains(fileN))
             array2.remove(fileN);
             
            documentFrequencyy=idf(tabllle,(String)value[h][0]);
//          for( int indexx = 0; indexx < array2.size(); indexx ++) {
////           if(array2[indexx]==fileN)
//             // System.out.println("FILES NAME IS :"+array2[index]);
//              //v=new Vector();
//            
//            v.add(array2[indexx]);
//        
//       }
//            for(int b=0;b<v.size();b++){
//             String ff=v.get(b);
//             if(ff.equals(fileN))
//             {
//                e=v.indexOf(ff);
//                v.remove(e+1);
//                 v.remove(ff);
//             }
              // String vv=v.toString();
                value[h][1]=array2;
                value[h][2]=""+documentFrequencyy;
                value[h][3]=""+0.0;
         // }
         // }
      }
  }
      
}    
             
    // }
     
//       Set<String> fff=sheren.keySet();
//       List<String[][]> sho=sheren.values();
//         for(String bbb:fff)
//          if(bbb==word2){
//           String [][]ee=sheren.get(bbb); 
//        for(int j=0;j<ee.length;j++){
//      //for(Document2 i:index){
//          for(int h=0;h<i.x.length;h++){
//             String f= i.x[h][1];
//             int e=0;
//             Vector<String> v=new Vector<String>();       
//            String array2[]= f.split(",");
//         if(Arrays.asList(array2).contains(fileN))
//            documentFrequencyy=idf(tabllle,i.x[h][0]);
//           // inverseDocumentFrequencyy=tfIdf(tabllle.get(fileN),tabllle,i.x[h][0]);
//           // for (String temp: array2)
//        //  System.out.println("ARRAY IS: "+ temp);
//          
//      // }
////          for(String d:array2)
//      for( int indexx = 0; indexx < array2.length; indexx ++) {
////           if(array2[indexx]==fileN)
//             // System.out.println("FILES NAME IS :"+array2[index]);
//              //v=new Vector();
//            
//            v.add(array2[indexx]);
//        
//       }
//       // for(String b:v){
//         for(int b=0;b<v.size();b++){
//             String ff=v.get(b);
//             if(ff.equals(fileN))
//             {
//                e=v.indexOf(ff);
//                v.remove(e+1);
//                 v.remove(ff);
//             }
//               String vv=v.toString();
//                i.x[h][1]=vv;
//                i.x[h][2]=""+documentFrequencyy;
//                i.x[h][3]=""+0.0;
//         // }
//          }
//      }
//  }
//      
//} 
  public void add(String filee, String fileNname) throws FileNotFoundException, MalformedURLException, IOException {
      Scanner s = null;
        ArrayList<String> lllisst = new ArrayList<String>(); 
        ArrayList<String> lisst = new ArrayList<String>();
            Object [][]e=new Object[500][4];
         
      //  Hashtable hj=new Hashtable<String,String[][]>();
       // Scanner s = null;
          ArrayList<String> lllist = new ArrayList<String>(); 
          ArrayList<String> list = new ArrayList<String>();
          Random rn = new Random();
         int answer = rn.nextInt(9) + 0;
          //System.out.println(answer);

         AccessTree tree = new AccessTree(policies[answer]);
       
        try {
            s = new Scanner(new File(filee));
            while (s.hasNext()) {
                lisst.add(s.next());
            }
           // for(int u=0;u<list.size();u++){
                for(String worrd:lisst){
            String newWord=RC2.encrypt(worrd,"abcde"); 
                 // ArrayList<String> lllist = new ArrayList<String>(); 
                  lllisst.add(newWord);
            }
                
            tabllle.put(fileNname, lllisst);
            
            listOfList.add(lisst);
        for(int i=0;i<lisst.size();i++){
           
           String word=lisst.get(i);
           String wwword=lllisst.get(i);
           double termFrequency= tf(lllisst,wwword);
           double documentFrequency=idf(tabllle,wwword);
           double inverseDocumentFrequency=tfIdf(lllisst,tabllle,wwword);
           String concatinateFileWithTf=fileNname+termFrequency;
            
           byte datapln[]=concatinateFileWithTf.getBytes();
         List lissst =  encrypt(policies[answer],secLevel,type,datapln,1);
        ArrayList<List> lliisst=new ArrayList<List>();
//List lliisst=new ArrayList<>();
        lliisst.add(lissst);
          //lisst.get(0);
      //    String newName=lisst.toString();
           char t=word.charAt(0);
           String encryptionChar=RC2.encrypt(""+t,"abcde");
           String encryptionWord=RC2.encrypt(word,"abcde");
           Set<String> ff=sheren.keySet();
         // for(int h=0;h<ff.size();h++)
             for(String bb:ff)
             if(encryptionChar.equals(bb)){
               
                e=sheren.get(bb);
            document1.setWord(word,lliisst,documentFrequency,inverseDocumentFrequency,e);
         // setWord(word,concatinateFileWithTf,documentFrequency,inverseDocumentFrequency);   
//           char t=word.charAt(0);
//             for(Document2 d:Documents){
//                 
//              if(t==d.getPlaintextName()){
//              d.setWord(word,concatinateFileWithTf,documentFrequency,inverseDocumentFrequency);
//              break;
//              }
//         
//             }
//             }
        }
        } 
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  public void update(String fiilee, String fileNnaame) throws FileNotFoundException, MalformedURLException, IOException {
      this.add(fiilee, fileNnaame);
  } 
     

//public void setWord(String a,String name,double f,double inverse){
//  
//     
////         char t=a.charAt(0);
////        String encryptionChar=RC2.encrypt(""+t,"abcde");
//
//          // String stri=""+t;
//           //  for(Document2 d:Documents){
//            // for(int h=0;h<ff.size();h++)
////          Set<String> ff=sheren.keySet();
////          for(String bb:ff)
////           if(bb.equals(encryptionChar)){
////           String [][]e=sheren.get(bb); 
//        String encryptionWord=RC2.encrypt(a,"abcde");
//         for(int j=0;j<e.length;j++)
//        {   
//       if(e[j][0]!=null){
//       if(e[j][0].equals(encryptionWord)){
//         
//                if (!(e[j][1]).contains(name)) {
//                    e[j][1]=e[j][1]+","+name;
//                 
//                    e[j][2]=""+f;
//                    e[j][3]=""+inverse;
//                   
//                }
//                flag=true;
//       }}
//        else
//           break;
//        }
//     
//        if(flag==false){
//           e[ii][0]=encryptionWord;
//           e[ii][1]=name;
//           e[ii][2]=""+f;
//           e[ii][3]=""+inverse;
//            ii++;
//        }
//       
//        flag=false;
//    }
            // return sheren;
//}  
}
