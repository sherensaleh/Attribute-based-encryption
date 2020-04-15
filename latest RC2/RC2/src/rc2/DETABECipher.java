/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
//import src.cpabe.bsw.ABECipher;
//import src.cpabe.bsw.accessStructure.AccessTree;
//import src.cpabe.bsw.common.ABEPrivateKey;
//import src.cpabe.bsw.common.PublicKey;
//import src.cpabe.bsw.ct.ABECiphertext;
//import src.symmetric.AESCipher;
//import src.trustedAuth.bsw.ABETrustedAuthority;
//import src.trustedAuth.bsw.MasterKey;

public class DETABECipher
{
    long startTime16=0;
   
    static double endGeneratekey1 = 0.0;
    public static double timing[] = new double[8];
    static double endTime1 = 0.0;
    static double endTime2 = 0.0;

    public DETABECipher() {
    }

    public List encrypt(byte abyte0[], int i, String s, String s1) {
        double startTime = 0.0;
        double endTime = 0.0;
        double startTime1 = 0.0;
        double endTime3 = 0.0;
        AccessTree accesstree = new AccessTree(s1);
        if (!accesstree.isValid())
        {
//            System.out.println("DET-ABE ENCRYPTION LOCAL MODULE: Given policy is not valid (bad boolean equation" +"). Program ends.");
            System.exit(0);
        }
           startTime1 = System.currentTimeMillis();
        PublicKey publickey = new PublicKey(i, s);
        endTime3 = System.currentTimeMillis();
         endTime2+=endTime3-startTime1;
        if(publickey == null)
        {
//            System.out.println((new StringBuilder()).append("DET-ABE ENCRYPTION MODULE: Unable to get the PUBLIC KEY from raw data for the se" +
//"curity level "
//).append(i).append("...\nDecryption process failed.").toString());
            System.exit(0);
        }
     //  startTime = System.currentTimeMillis();
        AESCipher.genSymmetricKey(i);
       // timing[0] = AESCipher.timing[0];
        if(AESCipher.key == null)
        {
//            System.out.println("DET-ABE ENCRYPTION MODULE: Invalid AES-key... Unable to continue.");
            System.exit(0);
        }
        byte abyte1[] = AESCipher.encrypt(abyte0);
        // endTime = System.currentTimeMillis();
        // endTime1+=endTime-startTime;
        // endTime1/=1000;
        startTime = System.currentTimeMillis();
        ABECiphertext abeciphertext = ABECipher.encrypt(publickey, AESCipher.key, accesstree);
         endTime = System.currentTimeMillis();
         endTime1+=endTime-startTime;
       // timing[1] = AESCipher.timing[1];
       // timing[2] = ABECipher.timing[3] + ABECipher.timing[4] + ABECipher.timing[5];
       // long l = System.nanoTime();
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(abyte1);
        linkedlist.add(AESCipher.iv);
        linkedlist.add(abeciphertext.toBytes());
        linkedlist.add(new Integer(i));
        linkedlist.add(s);
       // long l1 = System.nanoTime();
        //timing[3] = (double)(l1 - l) / 1000000000D;
        return linkedlist;
    }

    public byte[] decrypt(List list, List list1)
    {
         double endGeneratekey=0.0;
        if(list == null)
        {
   //         System.out.println("DET-ABE DECRYPTION MODULE: Cannot open input encrypted file...");
            return null;
        }
        byte abyte0[] = (byte[])(byte[])list.get(0);
        byte abyte1[] = (byte[])(byte[])list.get(1);
        LinkedList linkedlist = (LinkedList)list.get(2);
        int i = ((Integer)list.get(3)).intValue();
        String s = (String)list.get(4);
        PublicKey publickey = new PublicKey(i, s);
        MasterKey masterkey = new MasterKey(i, s);
        if(publickey == null || masterkey == null)
        {
            return null;
        }
        Pairing pairing = publickey.e;
        ABECiphertext abeciphertext = new ABECiphertext(pairing, linkedlist);
  //   System.out.println((new StringBuilder()).append("DET-ABE DECRYPTION MODULE: CT read!\n\t c = ").append(abeciphertext.getC()).append(".\n\t cp = ").append(abeciphertext.getCp()).toString());
  //      System.out.println("DET-ABE DECRYPTION MODULE: Asking the Trusted Authority de private key for the g" +
 //"iven set of attributes...");
        // startTime16 = System.currentTimeMillis();
        ABEPrivateKey abeprivatekey = ABETrustedAuthority.keyGen(publickey, masterkey, list1);
        // endGeneratekey= System.currentTimeMillis();
        //   endGeneratekey1= endGeneratekey - startTime16;
           
        timing[4] = ABETrustedAuthority.timing;
        if(abeprivatekey == null)
        {
//           System.out.println("DET-ABE DECRYPTION MODULE: Unable to generate the private key from TA...\nDecryp" +
//"tion process failed.");
            return null;
        }
//        System.out.println("DET-ABE DECRYPTION MODULE: Private key GENERATED from trusted party");
        startTime16 = System.currentTimeMillis();
        Element element = ABECipher.decrypt(abeciphertext, abeprivatekey, pairing);
        endGeneratekey = System.currentTimeMillis();
        endGeneratekey1 += endGeneratekey - startTime16;
        
        timing[5] = ABECipher.timing[0] + ABECipher.timing[1] + ABECipher.timing[2];
        BigInteger biginteger = element.toBigInteger();
        byte abyte2[];
        abyte2 = abyte2 = biginteger.toByteArray();
        if(i / 8 != abyte2.length)
        {
            byte abyte3[] = new byte[abyte2.length - 1];
            System.arraycopy(abyte2, 1, abyte3, 0, abyte3.length);
            abyte2 = abyte3;
        }
        Object obj = null;
        if(abyte2 != null)
        {
//            System.out.println("DET-ABE DECRYPTION MODULE: Starting AES decryption");
            byte abyte4[] = AESCipher.decrypt(abyte0, abyte1, abyte2);
            timing[6] = AESCipher.timing[2];
            return abyte4;
        } else
        {
        //    System.out.println("DET-ABE DECRYPTION LOCAL MODULE: Cryptographic key was not recovered.\n   Decryp" +
//"tion process failed.");
            return null;
        }
//           endGeneratekey1 /= 1000.0;
//           
//     System.out.println("endCreateGenerationKeyTime is :"+endGeneratekey1+""+"second");
    }
      

}

