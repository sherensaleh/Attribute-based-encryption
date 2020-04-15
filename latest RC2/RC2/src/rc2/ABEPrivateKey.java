/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.*;
import java.io.PrintStream;
import java.util.*;
import src.utilABE.Pair;

public class ABEPrivateKey
{

    protected Element D;
    Map prvKeyStructure;

    public Element getD()
    {
        return D;
    }

    public Pair getPair(String s)
    {
        if(prvKeyStructure.containsKey(s))
        {
            return (Pair)prvKeyStructure.get(s);
        } else
        {
            return null;
        }
    }

    public List getAttrs()
    {
        return new LinkedList(prvKeyStructure.keySet());
    }

    public ABEPrivateKey(Pairing pairing, List list)
    {
        D = pairing.getG2().newElement();
        D.setFromBytes((byte[])(byte[])list.get(0));
        prvKeyStructure = new HashMap();
        for(int i = 1; i < list.size(); i++)
        {
            LinkedList linkedlist = (LinkedList)list.get(i);
            String s = (String)linkedlist.get(0);
            LinkedList linkedlist1 = (LinkedList)linkedlist.get(1);
            Element element = pairing.getG2().newElement();
            Element element1 = pairing.getG1().newElement();
            element.setFromBytes((byte[])(byte[])linkedlist1.get(0));
            element1.setFromBytes((byte[])(byte[])linkedlist1.get(1));
            Pair pair = new Pair(element, element1);
            prvKeyStructure.put(s, pair);
        }

    }

    public ABEPrivateKey(Element element)
    {
        prvKeyStructure = new HashMap();
        D = element;
    }

    public void show()
    {
//        System.out.println(D);
        Set set = prvKeyStructure.keySet();
        Pair pair;
        for(Iterator iterator = set.iterator(); iterator.hasNext(); System.out.println((new StringBuilder()).append("            d': ").append(pair.getEp()).toString()))
        {
            String s = (String)iterator.next();
//            System.out.println((new StringBuilder()).append("   attrb: ").append(s).toString());
            pair = (Pair)prvKeyStructure.get(s);
//           System.out.println((new StringBuilder()).append("            d: ").append(pair.getE()).toString());
        }

    }

    public void put(String s, Pair pair)
    {
        prvKeyStructure.put(s, pair);
    }

    public List toBytes()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(D.toBytes());
        LinkedList linkedlist1;
        for(Iterator iterator = prvKeyStructure.keySet().iterator(); iterator.hasNext(); linkedlist.add(linkedlist1))
        {
            String s = (String)iterator.next();
            linkedlist1 = new LinkedList();
            Pair pair = (Pair)prvKeyStructure.get(s);
            linkedlist1.add(s);
            linkedlist1.add(pair.toBytes());
        }

        return linkedlist;
    }
}

