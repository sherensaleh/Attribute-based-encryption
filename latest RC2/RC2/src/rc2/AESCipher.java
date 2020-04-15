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
import java.io.PrintStream;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher
{
  public static byte[] iv = null;
  public static double[] timing = new double[3];
  public static SecretKey skey = null;
  public static byte[] key = null;
  private static KeyGenerator kgen;
  private static Cipher cipher;
  
  static
  {
    try
    {
      kgen = KeyGenerator.getInstance("AES");
      cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
    catch (Exception localException)
    {
      kgen = null;
      cipher = null;
//      System.out.println("AES MODULE: EXCEPTION WHEN INITIALIZING MODULE");
    }
  }
  
  public static boolean genSymmetricKey(int paramInt)
  {
    if ((paramInt != 128) && (paramInt != 192) && (paramInt != 256)) {
      return false;
    }
    key = null;
    try
    {
      kgen.init(paramInt);
      
      long l1 = System.nanoTime();
      skey = kgen.generateKey();
      long l2 = System.nanoTime();
      timing[0] = ((l2 - l1) / 1.0E9D);
      
      key = skey.getEncoded();
    //  System.out.println("AES MODULE: " + paramInt + "-bit AES-key generated.\n");
      return true;
    }
    catch (Exception localException)
    {
  //    System.out.println("AES MODULE: EXCEPTION when generating the " + paramInt + "-bit AES-key...");
      localException.printStackTrace();
      System.out.println("---- END -----");
    }
    return false;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte)
  {
    if (key == null) {
      return null;
    }
    byte[] arrayOfByte = null;
    try
    {
      long l1 = System.nanoTime();
      cipher.init(1, skey);
      arrayOfByte = cipher.doFinal(paramArrayOfByte);
      long l2 = System.nanoTime();
      
      timing[1] = ((l2 - l1) / 1.0E9D);
      
      iv = cipher.getIV();
      
//      System.out.println("   DONE! " + paramArrayOfByte.length + " bytes encrypted with \n\t key = " + new BigInteger(1, key) + "\n\t iv = " + new BigInteger(1, iv) + "  \n\t" + arrayOfByte.length + " bytes produced as ciphertext.\n");
    }
    catch (Exception localException)
    {
      System.out.println("AES MODULE: EXCEPTION");
      localException.printStackTrace();
      System.out.println("---------------------------");
    }
    return arrayOfByte;
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = null;
   // System.out.println("AES MODULE: DEcrypting " + paramArrayOfByte1.length + ", with key: \n\t" + new BigInteger(1, paramArrayOfByte3) + ",\n\t and IV = " + new BigInteger(1, paramArrayOfByte2) + ",\n\t  wait...");
    try
    {
      long l1 = System.nanoTime();
      
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramArrayOfByte2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte3, "AES");
      cipher.init(2, localSecretKeySpec, localIvParameterSpec);
      arrayOfByte = cipher.doFinal(paramArrayOfByte1);
      
      long l2 = System.nanoTime();
      timing[2] = ((l2 - l1) / 1.0E9D);
      
//      System.out.println("   DONE!. " + arrayOfByte.length + " bytes produced from DEcryption.");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfByte;
  }
}

