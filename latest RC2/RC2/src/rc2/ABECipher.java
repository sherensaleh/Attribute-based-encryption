/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import java.io.PrintStream;
import java.util.List;
//import src.cpabe.bsw.accessStructure.AccessTree;
//import src.cpabe.bsw.accessStructure.ReducedTree;
//import src.cpabe.bsw.accessStructure.ShamirDistributionThreaded;
//import src.cpabe.bsw.common.ABEPrivateKey;
//import src.cpabe.bsw.common.PublicKey;
//import src.cpabe.bsw.ct.ABECiphertext;

public class ABECipher
{
  public static double[] timing = new double[6];
  
  public static Element decrypt(ABECiphertext paramABECiphertext, ABEPrivateKey paramABEPrivateKey, Pairing paramPairing)
  {
    List localList = paramABEPrivateKey.getAttrs();
    AccessTree localAccessTree = paramABECiphertext.getAccessStructure();
    if (!localAccessTree.checkSatisfy(localList))
    {
//      System.err.println("CP-ABE MODULE (DECrypt): Cannot continue decrypting, attributes in key do not satisfy policy");
      
      return null;
    // System.exit(0);
    }
//    System.err.println("CP-ABE MODULE (DECrypt): Generating reduced tree...");
    
    ReducedTree localReducedTree = new ReducedTree(localAccessTree.root, paramPairing);
    timing[0] = ReducedTree.timing[0];
    
    localReducedTree.show();
    
    Element localElement1 = localReducedTree.recoverSecret(paramABECiphertext, paramABEPrivateKey);
    
    timing[1] = ReducedTree.timing[1];
    
//    System.out.println("\nREDUCED TREE MODULE: Starting ABE decryption s...\n");
    
    double d1 = System.nanoTime();
    
    Element localElement2 = paramABECiphertext.getCp().duplicate();
    
    localElement2.mul(localElement1);
    
    Element localElement3 = paramPairing.getGT().newElement();
    localElement3 = paramPairing.pairing(paramABECiphertext.getC(), paramABEPrivateKey.getD());
    localElement3.invert();
    localElement2.mul(localElement3);
    
    double d2 = System.nanoTime();
    timing[2] = ((d2 - d1) / 1.0E9D);
    
//    System.out.println("     Done!. Data decrypted is: " + localElement2.toString());
    
    return localElement2;
  }
  
  public static ABECiphertext encrypt(PublicKey paramPublicKey, byte[] paramArrayOfByte, AccessTree paramAccessTree)
  {
    Pairing localPairing = paramPublicKey.e;
    
    Element localElement1 = localPairing.getGT().newElement();
    
   // long l1 = System.nanoTime();
    localElement1.setFromBytes(paramArrayOfByte);
    //long l2 = System.nanoTime();
    //timing[3] = ((l2 - l1) / 1.0E9D);
    
//   System.out.println("\nCP-ABE MODULE (Encryption): Encrypting M (key) = " + localElement1.toString());
    
   // l1 = System.nanoTime();
    Element localElement2 = localPairing.getZr().newElement().setToRandom();
    Element localElement3 = localPairing.getGT().newElement();
    localElement3 = paramPublicKey.g_hat_alpha.duplicate();
    localElement3.powZn(localElement2);
    localElement3.mul(localElement1);
    Element localElement4 = localPairing.getG1().newElement();
    localElement4 = paramPublicKey.h.duplicate();
    localElement4.powZn(localElement2);
   // l2 = System.nanoTime();
    //timing[4] = ((l2 - l1) / 1.0E9D);
    
    ABECiphertext localABECiphertext = new ABECiphertext(localElement4, localElement3, paramAccessTree);
    
    ShamirDistributionThreaded localShamirDistributionThreaded = new ShamirDistributionThreaded();
    
    localShamirDistributionThreaded.execute(paramAccessTree, localElement2, localABECiphertext, paramPublicKey);
    
   // timing[5] = ShamirDistributionThreaded.timing;
    
//    System.out.println("CP-ABE MODULE(Encryption): DONE!!\n");
    
    return localABECiphertext;
  }
}

