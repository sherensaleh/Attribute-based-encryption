/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
//import src.cpabe.bsw.common.ABEPrivateKey;
//import src.cpabe.bsw.common.PublicKey;
//import src.hash.Hash;
import src.utilABE.Files;
import src.utilABE.Pair;
import src.utilABE.Utils;

public class ABETrustedAuthority
{
  public static double timing = 0.0D;
  static String pathKeys = "bsw/keys/";
  
  public static void bswSetup(int paramInt, String paramString)
  {
    String str = Utils.fileNameParams(paramInt, paramString);
    
    Pairing localPairing = PairingFactory.getPairing("params/" + str);
    
    Element localElement1 = localPairing.getZr().newElement().setToRandom();
    Element localElement2 = localPairing.getZr().newElement().setToRandom();
    
    Element localElement3 = localPairing.getG1().newElement().setToRandom();
    Element localElement4 = null;
    if (localPairing.isSymmetric()) {
      localElement4 = localElement3.duplicate();
    } else {
      localElement4 = localPairing.getG2().newElement().setToRandom();
    }
    Element localElement5 = localElement3.duplicate();
    localElement5.powZn(localElement2);
    
    Element localElement6 = localElement4.duplicate();
    localElement6.powZn(localElement1);
    
    Element localElement7 = localPairing.getGT().newElement();
    localElement7 = localPairing.pairing(localElement3, localElement6);
    
    ArrayList localArrayList = new ArrayList();
    
    localArrayList.add(localElement3.toBytes());
    if (!localPairing.isSymmetric()) {
      localArrayList.add(localElement4.toBytes());
    }
    localArrayList.add(localElement5.toBytes());
    localArrayList.add(localElement7.toBytes());
    
    File localFile = new File(pathKeys);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    Files.storeObject(localArrayList, pathKeys + str + "_pubKey.data", "Storing public key for this ABE scheme");
    
    localArrayList = new ArrayList();
    localArrayList.add(localElement2.toBytes());
    localArrayList.add(localElement6.toBytes());
    
    Files.storeObject(localArrayList, pathKeys + str + "_prvKey.data", "Storing private key for this ABE scheme");
  }
  
  public static ABEPrivateKey keyGen(PublicKey paramPublicKey, MasterKey paramMasterKey, List<String> paramList)
  {
//    System.out.println("\n\tPrivate key generation starts!");
    
    Pairing localPairing = paramPublicKey.e;
    
    //long l1 = System.nanoTime();
     double l1 = System.currentTimeMillis();
    Element localElement1 = localPairing.getG2().newElement();
    localElement1 = paramMasterKey.g_alpha.duplicate();
    
    Element localElement2 = localPairing.getZr().newElement();
    localElement2.setToRandom();
    
    Element localElement3 = localPairing.getG2().newElement();
    localElement3 = paramPublicKey.g1.duplicate();
    localElement3.powZn(localElement2);
    
    localElement1.mul(localElement3);
    
    Element localElement4 = localPairing.getZr().newElement();
    localElement4 = paramMasterKey.beta.duplicate();
    localElement4.invert();
    localElement1.powZn(localElement4);
    
    ABEPrivateKey localABEPrivateKey = new ABEPrivateKey(localElement1);
    
    int i = 0;
    for (String str : paramList)
    {
      Element localElement5 = localPairing.getG2().newElement();
      Element localElement6 = localPairing.getG1().newElement();
      Element localElement7 = localPairing.getG2().newElement();
      Element localElement8 = localPairing.getZr().newElement();
      
      localElement8.setToRandom();
      byte[] arrayOfByte = Hash.getStringMessageDigest(str.getBytes(), "SHA-1");
      localElement7.setFromBytes(arrayOfByte);
      
      localElement7.powZn(localElement8);
      localElement5 = localElement3.duplicate();
      localElement5.mul(localElement7);
      
      localElement6 = paramPublicKey.g0.duplicate();
      localElement6.powZn(localElement8);
      
      localABEPrivateKey.put(str, new Pair(localElement5, localElement6));
      i++;
    }
    //long l2 = System.nanoTime();
    double l2 = System.currentTimeMillis();
    
   // timing = (l2 - l1) / 1.0E9D;
    timing = (l2 - l1) / 1000;
      System.out.println("endCreatePrivateKeyTime"+timing);
    return localABEPrivateKey;
  }
}
