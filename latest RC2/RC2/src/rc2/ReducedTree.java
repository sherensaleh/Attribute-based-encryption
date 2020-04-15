/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.*;
import java.io.PrintStream;
import java.util.ArrayList;
//import src.cpabe.bsw.common.ABEPrivateKey;
//import src.cpabe.bsw.ct.ABECiphertext;
import src.utilABE.Pair;

// Referenced classes of package src.cpabe.bsw.accessStructure:
//            NodeTree, LagrangeCalculator

public class ReducedTree
{

    private NodeTree root;
    private Pairing pairing;
    private Element treeDecryption;
    private Element decryptedElement;
    private ABECiphertext ct;
    private ABEPrivateKey prv;
    public static double timing[];

    public ReducedTree(NodeTree nodetree, Pairing pairing1)
    {
        timing = new double[2];
        root = new NodeTree(nodetree);
        pairing = pairing1;
        treeDecryption = pairing1.getGT().newElement();
        decryptedElement = null;
        long l = System.nanoTime();
        generate(root, nodetree);
        long l1 = System.nanoTime();
        timing[0] = (double)(l1 - l) / 1000000000D;
        ct = null;
        prv = null;
    }

    private void generate(NodeTree nodetree, NodeTree nodetree1)
    {
        if(nodetree1.getChilds() == null)
        {
            return;
        }
        int i = 0;
        int j = nodetree.getK();
        nodetree.newChilds(j);
        for(int k = 0; k < nodetree1.getChilds().length && i != j; k++)
        {
            if(nodetree1.isSatisfiable(k))
            {
                NodeTree nodetree2 = new NodeTree(nodetree1.childAt(k));
                generate(nodetree2, nodetree1.childAt(k));
                nodetree.setChild(i, nodetree2);
                i++;
            }
        }

    }

    public Element recoverSecret(ABECiphertext abeciphertext, ABEPrivateKey abeprivatekey)
    {
        if(root == null)
        {
            return null;
        } else
        {
            Element element = pairing.getZr().newElement();
            treeDecryption = pairing.getGT().newElement();
            ct = abeciphertext;
            prv = abeprivatekey;
            treeDecryption.setToOne();
            element.setToOne();
//            System.out.println("\nREDUCED TREE MODULE: Starting recovering of secret...\n");
            long l = System.nanoTime();
            processNode(root, element);
            long l1 = System.nanoTime();
            timing[1] = (double)(l1 - l) / 1000000000D;
            return treeDecryption;
        }
    }

    private void processNode(NodeTree nodetree, Element element)
    {
        if(nodetree.getChilds() == null)
        {
            String s = nodetree.getAttr();
            Pair pair = ct.getPair(s);
            Pair pair1 = prv.getPair(s);
            Element element1 = pair1.getE();
            Element element2 = pair1.getEp();
            Element element3 = pair.getE();
            Element element5 = pair.getEp();
            Element element7 = pairing.getGT().newElement();
            Element element8 = pairing.getGT().newElement();
            element7 = pairing.pairing(element3, element1);
            element8 = pairing.pairing(element2, element5);
            element8.invert();
            element7.mul(element8);
            element7.powZn(element);
            treeDecryption.mul(element7);
//            System.out.println((new StringBuilder()).append("   CP-ABE MODULE (Decryption): Decryption tree evolution: ").append(treeDecryption).toString());
        } else
        {
            ArrayList arraylist = new ArrayList();
            NodeTree anodetree[] = nodetree.getChilds();
            int i = anodetree.length;
            for(int j = 0; j < i; j++)
            {
                NodeTree nodetree1 = anodetree[j];
                arraylist.add(new Integer(nodetree1.getIndex()));
            }

            anodetree = nodetree.getChilds();
            i = anodetree.length;
            for(int k = 0; k < i; k++)
            {
                NodeTree nodetree2 = anodetree[k];
                Element element4 = LagrangeCalculator.compute(nodetree2.getIndex(), arraylist, pairing);
                Element element6 = element.duplicate();
                element6.mul(element4);
                processNode(nodetree2, element6);
            }

        }
    }

    public void show()
    {
        show(root, 0);
    }

    private void show(NodeTree nodetree, int i)
    {
        for(int j = 0; j < i; j++)
        {
            System.out.print(" ");
        }

       // System.out.println(nodetree.getAttr());
        NodeTree anodetree[] = nodetree.getChilds();
        if(anodetree == null)
        {
            return;
        }
        NodeTree anodetree1[] = anodetree;
        int k = anodetree1.length;
        for(int l = 0; l < k; l++)
        {
            NodeTree nodetree1 = anodetree1[l];
            show(nodetree1, i + 3);
        }

    }
}

