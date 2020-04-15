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
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
//import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
//import searchencrypted.PublicKey;
import it.unisa.dia.gas.jpbc.Pairing;
//import src.cpabe.bsw.ct.ABECiphertext;
//import src.hash.Hash;
import src.utilABE.Pair;

// Referenced classes of package src.cpabe.bsw.accessStructure:
//            AccessTree, Polynomial, NodeTree

public class ShamirDistributionThreaded
{
    class Distribute
        implements Runnable
    {

        ABECiphertext ct;
        NodeTree node;
        Element s;
        final ShamirDistributionThreaded this$0;

        public void run()
        {
            if(node.children == null)
            {
                Element element = pairing.getG1().newElement();
                Element element2 = pairing.getG2().newElement();
                Element element3 = pairing.getG2().newElement();
                byte abyte0[] = Hash.getStringMessageDigest(node.attr.getBytes(), "SHA-1");
                element3.setFromBytes(abyte0);
                element = PK.g0.duplicate();
                element2 = element3.duplicate();
                element.powZn(s);
                element2.powZn(s);
                ct.add(node.attr, new Pair(element, element2));
                countDownLatch.countDown();
                return;
            }
            Element element1 = pairing.getZr().newElement();
            Polynomial polynomial = new Polynomial(node.k - 1, s);
            for(int i = 0; i < node.children.length; i++)
            {
                element1.set(i + 1);
                Element element4 = pairing.getZr().newElement();
                polynomial.evalPoly(element4, element1);
                (new Thread(new Distribute(ct, node.children[i], element4))).start();
            }

        }

        Distribute(ABECiphertext abeciphertext, NodeTree nodetree, Element element)
        {
            super();
            this$0 = ShamirDistributionThreaded.this;
            
            ct = abeciphertext;
            node = nodetree;
            s = element;
        }
    }


    public static double timing;
    private Pairing pairing;
    private ABECiphertext ct;
    private PublicKey PK;
    CountDownLatch countDownLatch;
    final Object mutex = new Object();

    public ShamirDistributionThreaded()
    {
    }

    public void execute(AccessTree accesstree, Element element, ABECiphertext abeciphertext, PublicKey publickey)
    {
        pairing = publickey.e;
        ct = abeciphertext;
        PK = publickey;
        countDownLatch = new CountDownLatch(accesstree.numAtributes);
       // timing = 0.0D;
        double d = System.nanoTime();
        Thread thread = new Thread(new Distribute(abeciphertext, accesstree.root, element));
        thread.start();
        try
        {
     //       System.out.print("Awaiting for threads to finish...");
            countDownLatch.await();
            long l = System.nanoTime();
           // timing = ((double)l - d) / 1000000000D;
            synchronized(mutex)
            {
       //         System.out.println("All threads done!");
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }


}

