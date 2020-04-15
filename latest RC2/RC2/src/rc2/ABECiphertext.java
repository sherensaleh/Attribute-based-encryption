/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.*;
import java.io.PrintStream;
import java.util.*;
//import src.cpabe.bsw.accessStructure.AccessTree;
import src.utilABE.Pair;

public class ABECiphertext
{

    Element cp;
    Element c;
    AccessTree tree;
    Map cipherStructure;

    public List toBytes()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(cp.toBytes());
        linkedlist.add(c.toBytes());
        linkedlist.add(tree);
        LinkedList linkedlist1;
        for(Iterator iterator = cipherStructure.keySet().iterator(); iterator.hasNext(); linkedlist.add(linkedlist1))
        {
            String s = (String)iterator.next();
            linkedlist1 = new LinkedList();
            Pair pair = (Pair)cipherStructure.get(s);
            linkedlist1.add(s);
            linkedlist1.add(pair.toBytes());
        }

        return linkedlist;
    }

    public ABECiphertext(Element element, Element element1, AccessTree accesstree)
    {
        c = element;
        cp = element1;
        cipherStructure = new HashMap();
        tree = accesstree;
    }

    public ABECiphertext(Pairing pairing, List list)
    {
        c = pairing.getG1().newElement();
        cp = pairing.getGT().newElement();
        cp.setFromBytes((byte[])(byte[])list.get(0));
        c.setFromBytes((byte[])(byte[])list.get(1));
        tree = (AccessTree)list.get(2);
        cipherStructure = new HashMap();
        for(int i = 3; i < list.size(); i++)
        {
            LinkedList linkedlist = (LinkedList)list.get(i);
            String s = (String)linkedlist.get(0);
            LinkedList linkedlist1 = (LinkedList)linkedlist.get(1);
            Element element = pairing.getG1().newElement();
            Element element1 = pairing.getG2().newElement();
            element.setFromBytes((byte[])(byte[])linkedlist1.get(0));
            element1.setFromBytes((byte[])(byte[])linkedlist1.get(1));
            Pair pair = new Pair(element, element1);
            cipherStructure.put(s, pair);
        }

    }

    public AccessTree getAccessStructure()
    {
        return tree;
    }

    public void add(String s, Pair pair)
    {
        cipherStructure.put(s, pair);
    }

    public Pair getPair(String s)
    {
        if(cipherStructure.containsKey(s))
        {
            return (Pair)cipherStructure.get(s);
        } else
        {
            return null;
        }
    }

    public Element getCp()
    {
        return cp;
    }

    public Element getC()
    {
        return c;
    }

    public void show()
    {
      //  System.out.println("-------- ABE ciphertext ----------");
        //System.out.println((new StringBuilder()).append("C: ").append(c).toString());
       // System.out.println((new StringBuilder()).append("C': ").append(cp).toString());
        Pair pair;
        for(Iterator iterator = cipherStructure.keySet().iterator(); iterator.hasNext(); 
                System.out.println((new StringBuilder()).append("            cy': ").append(pair.getEp()).toString()))
        {
            String s = (String)iterator.next();
//           System.out.println((new StringBuilder()).append("   attrb: ").append(s).toString());
            pair = (Pair)cipherStructure.get(s);
  //          System.out.println((new StringBuilder()).append("            cy: ").append(pair.getE()).toString());
        }

    }
}


