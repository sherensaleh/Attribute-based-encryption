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
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

public class Files
{
    public static byte[] readBytesFromFile(final String s) {
        try {
            final byte[] b = new byte[(int)new File(s).length()];
            final FileInputStream fileInputStream = new FileInputStream(s);
            fileInputStream.read(b);
            fileInputStream.close();
            return b;
        }
        catch (Exception obj) {
            System.out.println("IOFiles MODULE: Exception : " + obj);
            return null;
        }
    }
    
    public static void storeBytesInFile(final byte[] b, final String name) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(name);
            fileOutputStream.write(b);
            fileOutputStream.close();
        }
        catch (Exception obj) {
            System.out.println("IOFiles MODULE: Exception : " + obj);
        }
    }
    
    public static boolean storeObject(final Object obj, final String s, final String s2) {
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(s));
            objectOutputStream.writeObject(obj);
          //  System.out.println("IOFiles MODULE: " + s2 + " stored in file " + s);
            objectOutputStream.close();
            return true;
        }
        catch (Exception ex) {
            System.out.println("IOFiles MODULE: " + s2 + " don't stored, an IO error ocurred:\t" + ex.toString());
            return false;
        }
    }
    
    public static Object readObject(final String str, final String s) {
        try {
            final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(str));
            final Object object = objectInputStream.readObject();
            objectInputStream.close();
           // System.out.println("IOFiles MODULE: " + s + " recovered from file " + str);
            return object;
        }
        catch (Exception ex) {
            System.out.println("IOFiles MODULE: " + s + " don't found in file " + str + ".\t" + ex.toString());
            return null;
        }
    }
    
    public static boolean testIfExistsFile(final String pathname) {
        return new File(pathname).exists();
    }
    
    public static boolean isFileBinaryEqual(final String pathname, final String pathname2) throws IOException {
        final File file = new File(pathname);
        final File file2 = new File(pathname2);
        boolean b = false;
        if (file.exists() && file2.exists() && file.isFile() && file2.isFile()) {
            if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                b = true;
            }
            else {
                BufferedInputStream bufferedInputStream = null;
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    final FileInputStream in = new FileInputStream(file);
                    final FileInputStream in2 = new FileInputStream(file2);
                    bufferedInputStream = new BufferedInputStream(in, 65536);
                    bufferedInputStream2 = new BufferedInputStream(in2, 65536);
                    while (true) {
                        int read;
                        int read2;
                        do {
                            read = bufferedInputStream.read();
                            read2 = bufferedInputStream2.read();
                            if (read != read2) {
                                try {}
                                finally {}
                                return b;
                            }
                        } while (read >= 0 || read2 >= 0);
                        b = true;
                        continue;
                    }
                }
                finally {
                    try {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    }
                    finally {
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                    }
                }
            }
        }
        return b;
    }
}
