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
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Document1 {

    String[][] x = new String[30][4];
    int i = 0;
    boolean flag = false;
    public String name;
    public char plaintextName;
    public String word;
    public String fileId;
    public int documentId;
    Vector<Integer> s;
    double[][] value1;
    double[][] value2;
    double[][] a2;
    double[][] b2;
    int size;
    Matrix matrix2;
    Matrix matrix3;
    int j;

    public Document1() {

    }

    public Document1(String w, String fileName) {
        this.word = w;
        this.fileId = fileName;
    }

    public void setName(char n) {
        plaintextName = n;
        name = RC2.encrypt(("" + n), "abcde");
    }

    public void setPlaintextName(char h) {
        plaintextName = h;
    }

    public String getName() {
        return name;
    }

    public char getPlaintextName() {
        return plaintextName;
    }

    public Object[][] setWord(String a, List< String> name, double f, double inverse, Object[][] kj) {

        for (int j = 0; j < kj.length-1; j++) {
            if (kj[j][0] != null) {

                if (kj[j][0].equals(a)) {
                    List<String> ff = (ArrayList<String>) kj[j][1];
                    String nname = name.get(0);

                    for (int o = 0; o < ff.size()-1;) {
                        if (!ff.get(o).equals(nname)) {
                            o++;
                        } else {
                            return kj;

                        }
                    }

                    ff.add(nname);
                    kj[j][1] = ff;
                    kj[j][2] = f;
                    kj[j][3] = inverse;

                    flag = true;
                    break;
                }

            }
        }

        if (flag == false) {
            for (int l = 0; l < kj.length-1; l++) {
                if (kj[l][0] == null) {
                    kj[l][0] = a;
                    kj[l][1] = name;
                    kj[l][2] = f;
                    kj[l][3] = inverse;
                    break;
                    // i++;
                }
            }
        }
        flag = false;
        return kj;
    }

    public int getWord(String a) {
        int k = -1;
        for (int j = 0; j < x.length; j++) {
            if (x[j][0] == a) {
                k = j;
            }
        }
        return k;
    }

    public void setTermFrequency(String v) {
        fileId = v;
    }

    public String[][] getArray() {
        for (int u = 0; u < x.length; u++) {
            for (int y = 0; y < x[u].length; y++) {
                System.out.print("\t" + x[u][y]);
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


}






