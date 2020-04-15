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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rc2.TestDETABE.encrypt;

/**
 *
 * @author ibraheem
 */
public class Read1 {

    boolean flag = false;
    public Hashtable<Object, Object[][]> shereen = new Hashtable<Object, Object[][]>();

    String policy1 = "A B 2of2 C D 2of2 2of2";
   // String policy3 = "A";
    String policy5 = "A C 2of2";
    String policy7 = "A D 2of2";
    String policy2 = "A B 2of2";

//    String policy4 = "A B 2of2 C D 1of2 1of2";
//    String policy6 = "A B 1of2 C D 1of2 E F 1of2 1of2 1of2";
//    String policy8 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 1of2";
//    String policy11 = "A B 1of2 C D 1of2   1of2";
//    String policy12 = "A B 1of2 C D 2of2   1of2";
//    String policy9 = "A C 2of2 D B 1of2 1of2";
//    String policy10 = "A B 2of2 C D 2of2  1of2 I J 2of2 1of2";
//    String policy13 = "A B 1of2 C D 1of2 1of2 E F 1of2 G H 1of2 1of2 1of2";
//    String policy14 = "A B 2of2 C D 2of2  1of2 I J 2of2 1of2";
//    String policy15 = "K L 2of2 M N 2of2  1of2 I O 2of2 1of2";

  // String[] policies = {policy1, policy2, policy4, policy6, policy8, policy10, policy3, policy5, policy7, policy9};
      String[] policies = {policy1, policy2, policy5, policy7};

    String type = "A";
    int secLevel = 128;
    Document1 document1 = new Document1();
    static List<String> llllist = new ArrayList<String>();
    Hashtable<String, Integer> wordsIndex = new Hashtable<String, Integer>();
    Sha256 sha = new Sha256();
    Random r11 = new Random(50);
    Vector<Integer> s;
    double[][] value1;
    double[][] value2;
    double[][] a2;
    double[][] b2;
    int size;
    Matrix matrix2;
    Matrix matrix3;
    double endEncryptionTime1;
    double endEncryptionTime11;
    double[][] a1;
    double[][] b1;

    public void documentNamee() {

        Object[][] a = new Object[10][4];
        Object[][] b = new Object[10][4];
        Object[][] c = new Object[10][4];
        Object[][] d = new Object[10][4];
        Object[][] e = new Object[10][4];
        Object[][] f = new Object[10][4];
        Object[][] g = new Object[10][4];
        Object[][] h = new Object[10][4];
        Object[][] i = new Object[10][4];
        Object[][] j = new Object[10][4];
        Object[][] k = new Object[10][4];
        Object[][] l = new Object[10][4];
        Object[][] m = new Object[10][4];
        Object[][] n = new Object[10][4];
        Object[][] o = new Object[10][4];
        Object[][] p = new Object[10][4];
        Object[][] q = new Object[10][4];
        Object[][] r = new Object[10][4];
        Object[][] s = new Object[10][4];
        Object[][] t = new Object[10][4];
        Object[][] u = new Object[10][4];
        Object[][] v = new Object[10][4];
        Object[][] w = new Object[10][4];
        Object[][] x = new Object[10][4];
        Object[][] y = new Object[10][4];
        Object[][] z = new Object[10][4];

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

    }

    public void encryptLetters() {

        String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int hh = 0; hh <= characters.length - 1; hh++) {
            String letter = characters[hh];
            String newWord = RC2.encrypt(letter, "abcde");
            Object[][] value = shereen.get(letter);
            shereen.remove(letter);
            shereen.put(newWord, value);

        }
    }

    public void readWordsFromFiles(String file) {
        Scanner s = null;
        List<String> list = new ArrayList<String>();
        try {
            s = new Scanner(new File(file));
            while (s.hasNext()) {
                list.add(s.next());
            }

            for (int h = 0; h < list.size(); h++) {
                String f = list.get(h);
                llllist.add(f);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setIntegerForEachWord(List<String> j) {
        int k = 0;
        for (int i = 0; i < j.size(); i++) {
            String y = j.get(i);
            if (!wordsIndex.containsKey(y)) {
                wordsIndex.put(y, k);
                k++;

            }
        }
    }

    public void creatIndex(String file, String fileName) {
        Object[][] e = new Object[10][4];
        Scanner s = null;
        int index = 0;
        List<String> list = new ArrayList<String>();
        Object[][] uy = null;

        try {
            s = new Scanner(new File(file));
            while (s.hasNext()) {
                list.add(s.next());
            }
            for (int u = 0; u < list.size(); u++) {
                String word = list.get(u);
                char t = word.charAt(0);
                String tt = t + "";
                double documentFrequency = idf(llllist, word);
                double termFrequency = tf(list, word);
                String concatinateFileWithTf = fileName + termFrequency;
               //String concatinateFileWithTf = fileName;
                double inverseDocumentFrequency = tfIdf(list, llllist, word);
                List<String> fileNameList = new ArrayList<String>();
                fileNameList.add(concatinateFileWithTf);

                Set<Object> ff = shereen.keySet();
                for (Object bb : ff) {
                    if (tt.equals(bb)) {
                    e = shereen.get(bb);
                     uy = document1.setWord(word, fileNameList, documentFrequency, inverseDocumentFrequency, e);
                        break;

                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void generateMatrix() {
        int size = 20;
        s = new Vector<Integer>();
        for (int i = 0; i < size; i++) {
            int random0Or1 = (int) Math.round(Math.random());
            s.add(i, random0Or1);
        }
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
        Matrix matrix = new Matrix(size, size);
        Matrix matrix1 = new Matrix(size, size);
        matrix.setMat(value1);
        matrix1.setMat(value2);

        Matrix x = matrix.inverseMatrix();
        Matrix r = matrix1.inverseMatrix();
        a1 = x.getMat();
        b1 = r.getMat();

        matrix2 = new Matrix(size, size);
        matrix3 = new Matrix(size, size);

        matrix2.setMat(value1);
        matrix3.setMat(value2);

        a2 = matrix2.transpose();
        b2 = matrix3.transpose();

    }

    public void encryptIndex(Hashtable<Object, Object[][]> opp) {
        long startTime2 = 0;
        long startTime = 0;
        double endEncryptionFileTime = 0.0;
        double endEncryptionTime = 0.0;
        int index = 0;
        Set<Entry<Object, Object[][]>> op = opp.entrySet();

        List hh;
        Set<String> words = wordsIndex.keySet();
        for (Entry<Object, Object[][]> n : op) {

            Object rr = n.getKey();
            Object[][] m = n.getValue();
            startTime2 = System.currentTimeMillis();
            for (int ii = 0; ii < m.length; ii++) {

                if (m[ii][0] != null) {
                    List<List> encryptFiles = new ArrayList<>();
                    String h = (String) m[ii][0];
                    hh = (List) m[ii][1];
                    Vector wrd = new Vector();
                    if (wordsIndex.containsKey(h)) {
                        index = wordsIndex.get(h);

                    }

                    int ho = 20;
                    int i = index;

                    for (int j = 0; j < ho; j++) {
                        if (j <= i) {
                            byte[] nhash = sha.hash(h.getBytes());
                            double fg = new BigInteger(nhash).doubleValue();
                            double fgg = Math.round(fg);
                            wrd.add(j, fgg);

                        } else if ((i < j) && (j <= wordsIndex.size())) {
                            double dd = Math.round(r11.nextDouble());
                            wrd.add(j, dd);

                        } else if (j == ho) {
                            wrd.add(j, 1.0);
                        }
                    }
                    List<double[]> o = encryptt(wrd);
                    endEncryptionTime = System.currentTimeMillis();
                    endEncryptionTime1 += endEncryptionTime - startTime2;

                   // startTime = System.currentTimeMillis();
                    encryptFiles = encryptFileName(hh);
//                    endEncryptionFileTime = System.currentTimeMillis();
//                    endEncryptionTime11 += endEncryptionFileTime - startTime;
                    m[ii][0] = o;
                    m[ii][1] = encryptFiles;
                    opp.put(rr, m);
                }
            }
        }
        endEncryptionTime1 /= 1000;
      //  endEncryptionTime11 /= 1000;
    }
    
    
    public List<double[]> encryptt(Vector rr) {
        List<double[]> ress = new ArrayList<>();
        size = rr.size();

        Vector<Double> w = new Vector<Double>(size);
        Vector<Double> p = new Vector<Double>(size);
        Random r1 = new Random();
        double g1 = r1.nextDouble();
        double m11 = (double) ((double) Math.round(g1 * 10) / 10.0);

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 0) {
                double rt = (double) rr.get(i);

                w.add(i, rt);
                p.add(i, rt);
            } else {
                double rt = (double) rr.get(i);
                double t = (double) (0.5 * (rt));
                double tt = (0.5 * (rt));

                w.add(i, (t % (m11)));
                p.add(i, (tt % m11));
            }
        }
        double[] e = new double[size];
        double[] k = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                e[i] += (a2[i][j]) * (w.get(j));
                k[i] += (b2[i][j]) * (p.get(j));

            }
        }
        ress.add(e);
        ress.add(k);
        return ress;
    }

    public List encryptFileName(List<String> jk) {
        double startTime=0.0;
        double endEncryptionFileTime=0.0;
        List<List> rsult = new ArrayList<>();
        List lisst = null;
        Random rn = new Random();
        int answer = rn.nextInt(3)+0;
        for (int i = 0; i < jk.size(); i++) {
            String fileName = jk.get(i);
            byte datapln[] = fileName.getBytes();
             // startTime = System.currentTimeMillis();
            lisst = encrypt(policies[answer], secLevel, type, datapln, 1);
          //  lisst = encrypt(policy8, secLevel, type, datapln, 1);
             // lisst = encrypt(policy1, secLevel, type, datapln, 1);
//              endEncryptionFileTime = System.currentTimeMillis();
//                    endEncryptionTime11 += endEncryptionFileTime - startTime;
            rsult.add(lisst);

        }
    //       endEncryptionTime11 /= 1000;
        return rsult;
    }

    public List<double[]> encryptQuery(String word) {

        int index = 0;
        if (wordsIndex.containsKey(word)) {
            index = wordsIndex.get(word);

        }
        Vector wrd = new Vector();
        int ho = 20;
        int i = index;
        for (int j = 0; j < ho; j++) {
            if (j <= i) {
                byte[] nhash = sha.hash(word.getBytes());
                double fg = new BigInteger(nhash).doubleValue();
                double fgg = Math.round(fg);
                wrd.add(j, fgg);

            } else if ((i < j) && (j <= wordsIndex.size())) {
                double dd = Math.round(r11.nextDouble());
                wrd.add(j, dd);

            } else if (j == ho) {
                wrd.add(j, 1.0);
            }
        }
        List<double[]> o = queryEncryption(wrd);
        return o;
    }
    
    public List<double[]> queryEncryption(Vector rr) {
        List<double[]> ress = new ArrayList<>();
        size = rr.size();

        Vector<Double> w = new Vector<Double>(size);
        Vector<Double> p = new Vector<Double>(size);
        Random r1 = new Random();
        double g1 = r1.nextDouble();
        double m11 = (double) ((double) Math.round(g1 * 10) / 10.0);

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 0) {
                     double rt = (double) rr.get(i);
                double t = (double) (0.5 * (rt));
                double tt = (0.5 * (rt));

                w.add(i, (t % (m11)));
                p.add(i, (tt % m11));
           
            } else {
                    double rt = (double) rr.get(i);

                w.add(i, rt);
                p.add(i, rt);
           
            }
        }
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
    

    public List search(List<double[]> wword, String word2, Hashtable<Object, Object[][]> ll) {
        String fileName = "";
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        double dotProduct1 = 0.0;
        double normA1 = 0.0;
        double normB1 = 0.0;
        int c = 0;
        List r = new ArrayList<>();
        int sum2 = 0;
        String sd = null;
        double siMax = 0;
        double siMini1 = 0;
        List r1 = new ArrayList<>();
        Hashtable<Double, List<List>> hashTTTTT = new Hashtable<Double, List<List>>();
        List fileResult = new ArrayList<>();

        double[] queryA = wword.get(0);
        double[] queryB = wword.get(1);

        Set<Object> fff = ll.keySet();
        for (Object bbb : fff) {
            if (word2.equals(bbb)) {
                Object[][] ee = ll.get(bbb);

                for (c = 0; c < ee.length; c++) {
                    if (ee[c][0] != null) {
                        List<double[]> j = (List<double[]>) ee[c][0];
                        double[] vectorA = j.get(0);
                        double[] vectorB = j.get(1);
                        for (int i = 0; i < vectorA.length; i++) {
                            dotProduct += vectorA[i] * queryA[i];
                            normA += Math.pow(vectorA[i], 2);
                            normB += Math.pow(queryA[i], 2);

                            dotProduct1 += vectorB[i] * queryB[i];
                            normA1 += Math.pow(vectorB[i], 2);
                            normB1 += Math.pow(queryB[i], 2);
                        }
                        double result = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
                        double result1 = dotProduct1 / (Math.sqrt(normA1) * Math.sqrt(normB1));
                        double finalResult = result + result1;

                        if (!hashTTTTT.containsKey(finalResult)) {
                            hashTTTTT.put(finalResult, (List) ee[c][1]);
                        } else {
                            hashTTTTT.get(finalResult).add((List) ee[c][1]);
                        }
                    }
                }
            }

        }
        Set<Double> si = hashTTTTT.keySet();
        siMax = Collections.max(si);
        r = hashTTTTT.get(siMax);
        fileResult.add(r);
        return fileResult;
    }

    public double tf(List<String> file, String term) {
        double result = 0;
        for (String word : file) {
            if (term.equalsIgnoreCase(word)) {
                result++;
            }
        }
        return (result / file.size());
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    // public double idf(ArrayList<ArrayList<String>> docs, String term) {
    //public double idf(Hashtable<String, List<String>> kk, String term) {
    public double idf(List<String> kk, String term) {
        double n = 0;
        for (String doc : kk) {
            if (term.equalsIgnoreCase(doc)) {
                n++;
                break;
            }
        }
        return Math.log(kk.size() / n);

    }

    /**
     * @param doc a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc, List<String> docs, String term) {
        return (tf(doc, term) * idf(docs, term));

    }

    public void delete(String fileN, Hashtable<Object, Object[][]> index) {
      
        for (Map.Entry<Object, Object[][]> entry : index.entrySet()) {
              
            Object[][] value = entry.getValue();
            
            for (int h = 0; h < value.length; h++) {
                if(value[h][0]!=null){
                double documentFrequencyy = 0.0;
                Object f = value[h][1];
                int e = 0;
               // Vector<String> v = new Vector<String>();
               // ArrayList<List> array2 = (ArrayList<List>) f;
                  List<String> array2 = (ArrayList)f;
               // String hk=(String)array2.get(0);
               for(int u=0;u<array2.size();u++){
                String n=array2.get(u);
             String []nString=n.split(".txt");
             for(String ss:nString){
                if (ss.equals(fileN)) {
                    array2.remove(n);
                }
               }
               }
                documentFrequencyy = idf(llllist, (String) value[h][0]);

                value[h][1] = array2;
                value[h][2] = "" + documentFrequencyy;
                value[h][3] = "" + 0.0;

            }
        }

    }
    }
    public void add(String filee, String fileNname) throws FileNotFoundException, MalformedURLException, IOException {
        Object[][] e = new Object[10][4];
        Scanner s = null;
        int index = 0;
        List<String> list = new ArrayList<String>();
        Object[][] uy = null;

        try {
            s = new Scanner(new File(filee));
            while (s.hasNext()) {
                list.add(s.next());
            }
            for (int u = 0; u < list.size(); u++) {
                String word = list.get(u);
                char t = word.charAt(0);
                String tt = t + "";
                double documentFrequency = idf(llllist, word);
                double termFrequency = tf(list, word);
                String concatinateFileWithTf = fileNname + termFrequency;
                double inverseDocumentFrequency = tfIdf(list, llllist, word);
                List<String> fileNameList = new ArrayList<String>();
                fileNameList.add(concatinateFileWithTf);

                Set<String> words = wordsIndex.keySet();
                for (String w : words) {
                    if (word.equals(w)) {
                        index = wordsIndex.get(w);
                    }
                }
                Vector wrd = new Vector();
                int hj = wordsIndex.size();

                int ho = 20;
                int i = index;

                for (int j = 1; j <= ho; j++) {
                    if (j <= i) {
                        byte[] nhash = sha.hash(word.getBytes());
                        double fg = new BigInteger(nhash).doubleValue();
                        double fgg = Math.round(fg);
                        wrd.add(fgg);

                    } else if ((i < j) && (j <= wordsIndex.size())) {
                        double dd = Math.round(r11.nextDouble());
                        wrd.add(dd);

                    } else if (j == ho) {
                        wrd.add(1.0);
                    }
                }
                Set<Object> ff = shereen.keySet();
                for (Object bb : ff) {
                    if (tt.equals(bb)) {

                        e = shereen.get(bb);
                        document1.setWord(word, fileNameList, documentFrequency, inverseDocumentFrequency, e);

                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String fiilee, String fileNnaame) throws FileNotFoundException, MalformedURLException, IOException {
        this.add(fiilee, fileNnaame);
    }

}
