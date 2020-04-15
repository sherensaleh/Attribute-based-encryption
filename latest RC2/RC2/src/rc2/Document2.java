/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Document2
{
    String[][] x=new String[30][4];
  
 //  x[0]=new String[500];
   
  // Main m=new Main();
    int i=0;
    boolean flag = false; 
    public String name;
    public char plaintextName;
    public String word;
    public String fileId;
    public int documentId;
    //Read2 rrr=new Read2();
//Hashtable <String,String[][]> sheren = new Hashtable<String, String[][]>();
    public Document2(){
        // perhaps add some defaults here
    }
    
    public Document2(String w ,String fileName){
      this.word=w;
      this.fileId=fileName;
    }
//  public void documentName(){
// 
//   String[][] a=new String[500][4];
//   String[][] b=new String[500][4];
//   String[][] c=new String[500][4];
//   String[][] d=new String[500][4];
//   String[][] e=new String[500][4];
//   String[][] f=new String[500][4];
//   String[][] g=new String[500][4];
//   String[][] h=new String[500][4];
//   String[][] i=new String[500][4];
//   String[][] j=new String[500][4];
//   String[][] k=new String[500][4];
//   String[][] l=new String[500][4];
//   String[][] m=new String[500][4];
//   String[][] n=new String[500][4];
//   String[][] o=new String[500][4];
//   String[][] p=new String[500][4];
//   String[][] q=new String[500][4];
//   String[][] r=new String[500][4];
//   String[][] s=new String[500][4];
//   String[][] t=new String[500][4];
//   String[][] u=new String[500][4];
//   String[][] v=new String[500][4];
//   String[][] w=new String[500][4];
//   String[][] x=new String[500][4];
//   String[][] y=new String[500][4];
//   String[][] z=new String[500][4];                  
//     
//   
//   String encrypta=RC2.encrypt((""+'a'),"abcde");
//   String encryptb=RC2.encrypt((""+'b'),"abcde");
//   String encryptc=RC2.encrypt((""+'c'),"abcde");
//   String encryptd=RC2.encrypt((""+'d'),"abcde");
//   String encrypte=RC2.encrypt((""+'e'),"abcde");
//   String encryptf=RC2.encrypt((""+'f'),"abcde");
//   String encryptg=RC2.encrypt((""+'g'),"abcde");
//   String encrypth=RC2.encrypt((""+'h'),"abcde");
//   String encrypti=RC2.encrypt((""+'i'),"abcde");
//   String encryptj=RC2.encrypt((""+'j'),"abcde");
//   String encryptk=RC2.encrypt((""+'k'),"abcde");
//   String encryptl=RC2.encrypt((""+'l'),"abcde");
//   String encryptm=RC2.encrypt((""+'m'),"abcde");
//   String encryptn=RC2.encrypt((""+'n'),"abcde");
//   String encrypto=RC2.encrypt((""+'o'),"abcde");
//   String encryptp=RC2.encrypt((""+'p'),"abcde");
//   String encryptq=RC2.encrypt((""+'q'),"abcde");
//   String encryptr=RC2.encrypt((""+'r'),"abcde");
//   String encrypts=RC2.encrypt((""+'s'),"abcde");
//   String encryptt=RC2.encrypt((""+'t'),"abcde");
//   String encryptu=RC2.encrypt((""+'u'),"abcde");
//   String encryptv=RC2.encrypt((""+'v'),"abcde");
//   String encryptw=RC2.encrypt((""+'w'),"abcde");
//   String encryptx=RC2.encrypt((""+'x'),"abcde");
//   String encrypty=RC2.encrypt((""+'y'),"abcde");
//   String encryptz=RC2.encrypt((""+'z'),"abcde");
//                    
//   sheren.put(encrypta, a);
//   sheren.put(encryptb, b);
//   sheren.put(encryptc, c);
//   sheren.put(encryptd, d);
//   sheren.put(encrypte, e);
//   sheren.put(encryptf, f);
//   sheren.put(encryptg, g);
//   sheren.put(encrypth, h);
//   sheren.put(encrypti, i);
//   sheren.put(encryptj, j);
//   sheren.put(encryptk, k);
//   sheren.put(encryptl, l);
//   sheren.put(encryptm, m);
//   sheren.put(encryptn, n);
//   sheren.put(encrypto, o);
//   sheren.put(encryptp, p);
//   sheren.put(encryptq, q);
//   sheren.put(encryptr, r);
//   sheren.put(encrypts, s);
//   sheren.put(encryptt, t);
//   sheren.put(encryptu, u);
//   sheren.put(encryptv, v);
//   sheren.put(encryptw, w);
//   sheren.put(encryptx, x);
//   sheren.put(encrypty, y);
//   sheren.put(encryptz, z);
// }
    public void setName(char n){
       plaintextName=n;
      name=RC2.encrypt((""+n),"abcde");
    }
    public void setPlaintextName(char h){
        plaintextName= h;
    }

    public String getName(){
        return name;
    }
    
    public char getPlaintextName(){
        return plaintextName;
    }

    public void setWord(String a,ArrayList<List> name,double f,double inverse, Object [][]kj){
          // List ff=new ArrayList<>();
        
         String encryptionWord=RC2.encrypt(a,"abcde");
           for(int j=0;j<kj.length;j++)
       // String encryptionWord=RC2.encrypt(a,"abcde");
       // for(int j=0;j<x.length;j++)
        {   
       if(kj[j][0]!=null){
       if(kj[j][0].equals(encryptionWord)){
         //for(int u=0;u<name.size();u++)
         //ArrayList<List> ff;
         //ff.add((List)kj[j][1]);
         ArrayList<List> ff=(ArrayList<List>)kj[j][1];
         List nname=name.get(0);
        // ff.add(nname);
         // ff.add(name);
           //name.add(ff);
             //   if (!(kj[j][1].equals(name))) {
                    //kj[j][1]=new ArrayList<List>();
                 //  List lliisst=new ArrayList<>();
                 //  lliisst.add(name);
              // ff=   (ArrayList<List>)kj[j][1]; 
                 // ff=(ArrayList) kj[j][1];
                  for(int o=0;o<ff.size();)
                  // List gg= ff.get(o);
                      if(!ff.get(o).equals(nname))
                          o++;
//ff.add((List) kj[j][1]);
                      ff.add(nname);
                 // ff.add((List)kj[j][1]);
                // ff.add(lliisst);
                 //ff.add(name);
                   // kj[j][1]=kj[j][1]+";"+name;
                   // kj[j][1].add(name);
                    kj[j][1]=ff;
                    kj[j][2]=f;
                    kj[j][3]=inverse;
                    
                   // kj[j][2].add(""+f);
                  //  kj[j][3]=""+inverse;
                   
               // }
                flag=true;
       }
       }
       // else
          // break;
        }
     
     if(flag==false){
           kj[i][0]=encryptionWord;
          // ArrayList<List> mew=new ArrayList<List>();
          // mew.add(name);
         //  kj[i][1]=new ArrayList<List>();
            kj[i][1]=name;
           
           kj[i][2]=f;
           kj[i][3]=inverse;
           i++;
        }
      // break;
   // }
       
        flag=false;
    }
    public int getWord(String a){
         int k=-1;
     for(int j=0;j<x.length;j++)
        {    
       if(x[j][0]==a){
        k=j;
       }
    }
     return k;
    }
    
    public void setTermFrequency(String v){
        fileId=v;
    }
    
    public String[][] getArray(){
        for(int u=0;u<x.length;u++){
            for(int y=0;y<x[u].length;y++){
                System.out.print("\t"+x[u][y]);
            }
            System.out.println();
        }
        return x;
    }

       public int getId() {
        return documentId;
    }
 
    public void setId(int id) {
        this.documentId = id;
    }
//    public String search(String a)
//    {
//      char t=a.charAt(0);
//        for(Document2 d:Read2.Documents)
//    
//            if(t==d.getPlaintextName());
//      int index=getWord(a);
//      
//        return "word: " + x[index][0] + ",fileName: " + x[index][1]+ 
//               ", fileId: " + x[index][2]+ ", documentId: " + x[index][3];
//    }
}


