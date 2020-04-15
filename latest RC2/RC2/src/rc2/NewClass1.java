/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Alahram
 */
public class NewClass1 {
// static   public Hashtable<Integer,Integer> shereen = new Hashtable<Integer,Integer>();
    public Hashtable<Object, Object[][]> shereen = new Hashtable<Object, Object[][]>();
    Sha256 sha = new Sha256();
    Random r11 = new Random(9);
    double[][] value1;
    double[][] value2;
    double[][] a2;
    double[][] b2;
    int size;
    Matrix matrix2;
    Matrix matrix3;
    Vector<Integer> s;
    
        public static void main(String[] args) {
  NewClass1 n=new NewClass1();
  n.documentNamee();
Set<Object>m=  n.shereen.keySet();
            System.out.println("shereen");
      
  }
//             Random rn = new Random(9);
//        double answer = Math.round(rn.nextDouble()) ;
//            System.out.println("answer"+answer);

           public void documentNamee() {
        String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int charSize = characters.length;
        Vector wrd1 = null;
        String cchar = null;
        int characterIndex = 0;
        int loopSize = charSize + 1;

        Object[][] a = new Object[3][4];
        Object[][] b = new Object[3][4];
        Object[][] c = new Object[3][4];
        Object[][] d = new Object[3][4];
        Object[][] e = new Object[3][4];
        Object[][] f = new Object[3][4];
        Object[][] g = new Object[3][4];
        Object[][] h = new Object[3][4];
        Object[][] i = new Object[3][4];
        Object[][] j = new Object[3][4];
        Object[][] k = new Object[3][4];
        Object[][] l = new Object[3][4];
        Object[][] m = new Object[3][4];
        Object[][] n = new Object[3][4];
        Object[][] o = new Object[3][4];
        Object[][] p = new Object[3][4];
        Object[][] q = new Object[3][4];
        Object[][] r = new Object[3][4];
        Object[][] s = new Object[3][4];
        Object[][] t = new Object[3][4];
        Object[][] u = new Object[3][4];
        Object[][] v = new Object[3][4];
        Object[][] w = new Object[3][4];
        Object[][] x = new Object[3][4];
        Object[][] y = new Object[3][4];
        Object[][] z = new Object[3][4];

        shereen.put("a", a);
        shereen.put("b", b);
        shereen.put("c", c);
        shereen.put("d", d);
        shereen.put("e", e);
        shereen.put("f", f);
        shereen.put("g", g);
        shereen.put("h", h);
        shereen.put("i", i);
        shereen.put("j", j);
        shereen.put("k", k);
        shereen.put("l", l);
        shereen.put("m", m);
        shereen.put("n", n);
        shereen.put("o", o);
        shereen.put("p", p);
        shereen.put("q", q);
        shereen.put("r", r);
        shereen.put("s", s);
        shereen.put("t", t);
        shereen.put("u", u);
        shereen.put("v", v);
        shereen.put("w", w);
        shereen.put("x", x);
        shereen.put("y", y);
        shereen.put("z", z);
        


        for (int hh = 0; hh <= characters.length - 1; hh++) {
            wrd1 = new Vector();
            cchar = characters[hh];
            characterIndex = hh;
            for (int jj = 1; jj < loopSize; jj++) {

                if (jj <= characterIndex) {
                    byte[] nhash = sha.hash(((String) cchar).getBytes());
                    double fg = new BigInteger(nhash).doubleValue();
                    double fgg = Math.round(fg);
                    wrd1.add(fgg);

                } else if ((characterIndex < jj) && (jj <= charSize)) {
                    double dd = Math.round(r11.nextDouble());
                    wrd1.add(dd);

                } else if (jj == loopSize) {
                    wrd1.add(1.0);
                }
            }

            List<double[]> oo = encryptt(wrd1);
            
            Set<Object> letters = shereen.keySet();
            List hg=new ArrayList<Object>(letters);
            for(int yu=0;yu<hg.size();yu++){
                 if (cchar.equals(hg.get(yu))) {
                    Object[][] oldValue = shereen.get(hg.get(yu));
                    shereen.remove(hg.get(yu));
                    shereen.put(oo, oldValue);
                 }
            }
        }
        //    Iterator<Object> iterator = letters.iterator(); 
         //   while(iterator.hasNext()){
            //    Object book = iterator.next(); 
               // listOfBooks.remove(book); 
           // }

            //Set<Object> letters = shereen.keySet();
         //   for (Iterator<Object> ks = shereen.keySet().iterator(); ks.hasNext(); ) {
              //   Object next = ks.next();
           //// }
         //   Iterator <Object> kj=letters.iterator();
            //for (Object let : letters) {
              //  if (cchar.equals(let)) {
                       
               // }
           // }
           // }

     //  }

    }
          public List<double[]> encryptt(Vector rr){
         List<double[]> ress = new ArrayList<>();
        size = rr.size();
        generateMatrix();

        Matrix matrix = new Matrix(size, size);
        Matrix matrix1 = new Matrix(size, size);
        matrix.setMat(value1);
        matrix1.setMat(value2);

        Matrix x = matrix.inverseMatrix();
        Matrix r = matrix1.inverseMatrix();
        double[][] a1 = x.getMat();
        double[][] b1 = r.getMat();

        matrix2 = new Matrix(size, size);
        matrix3 = new Matrix(size, size);

        matrix2.setMat(value1);
        matrix3.setMat(value2);

        a2 = matrix2.transpose();
        b2 = matrix3.transpose();
        Vector<Double> w = new Vector<Double>(size);
        Vector<Double> p = new Vector<Double>(size);
        Random r1 = new Random();
        double g1 = r1.nextDouble();
        double m11 = (double) ((double) Math.round(g1 * 10) / 10.0);

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 0) {
             double rt= (double)  rr.get(i);
             
                w.add(rt);
                p.add(rt);
            } else {
                double rt=(double)   rr.get(i);
               double t=(double)(0.5*(rt));
               double tt=(0.5*(rt));
                w.add(t % (m11));
                p.add(tt% m11);
            }
        }
//        System.out.println("vector1 of encrypt query" + w);
//        System.out.println("vector2 of encrypt query" + p);
        double[] e = new double[size];
        double[] k = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                e[i] += (a1[i][j]) * (w.get(j));
                k[i] += (b1[i][j]) * (p.get(j));

            }
        }
            ress.add(e);
            ress.add(k);
            return ress;
    }
    
 public void generateMatrix() {
        s = new Vector<Integer>(size);
        for (int i = 0; i < size; i++) {
            int random0Or1 = (int) Math.round(Math.random());
            s.add(random0Or1);
        }
        //  System.out.println("**************************************************************************");
        //System.out.println("split vector s :"+s);

        value1 = new double[size][size];
        value2 = new double[size][size];

        Random ra = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                double g = ra.nextFloat();
                double h = ra.nextFloat();

                double m = (double) ((double) Math.round(g * 10) / 10.0);
                double n = (double) ((double) Math.round(h * 10) / 10.0);

                value1[i][j] = m;
                value2[i][j] = n;

            }
        }

    }
            
                 }

