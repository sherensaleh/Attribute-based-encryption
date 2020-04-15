/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package src.cpabe.bsw.accessStructure:
//            NodeTree

public class AccessTree
    implements Serializable
{

    public NodeTree root;
    public int numAtributes;

    public AccessTree(String s)
    {
        root = null;
        numAtributes = 0;
        generate(s);
    }

    public boolean isValid()
    {
        return root != null;
    }

    public NodeTree getRoot()
    {
        return root;
    }

    private void generate(String s)
    {
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        String as[] = s.split(" ");
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s1 = as[j];
            if(!s1.contains("of"))
            {
                NodeTree nodetree = new NodeTree(s1);
                arraylist.add(nodetree);
                numAtributes++;
                continue;
            }
            String as1[] = s1.split("of");
            int l = Integer.parseInt(as1[0]);
            int i1 = Integer.parseInt(as1[1]);
            if(l < 1 || l > i1 || i1 == 1 || i1 > arraylist.size())
            {
                root = null;
                break;
            }
            NodeTree nodetree1 = new NodeTree(l, i1);
            for(int k = i1 - 1; k >= 0; k--)
            {
                nodetree1.children[k] = (NodeTree)arraylist.remove(arraylist.size() - 1);
                nodetree1.children[k].setIndex(k + 1);
            }

            arraylist.add(nodetree1);
        }

        if(arraylist.size() != 1)
        {
            root = null;
        } else
        {
            root = (NodeTree)arraylist.get(0);
        }
    }

    public boolean checkSatisfy(List list)
    {
        if(!isValid())
        {
            return false;
        } else
        {
            checkSatisfy(root, list);
            return root.satisfiable;
        }
    }

    private int checkSatisfy(NodeTree nodetree, List list)
    {
        if(nodetree.children == null)
        {
            for(int i = 0; i < list.size(); i++)
            {
                String s = (String)list.get(i);
                if(s.compareTo(nodetree.getAttr()) == 0)
                {
                    nodetree.satisfiable = true;
                    return 1;
                }
            }

            return 0;
        }
        int k = 0;
        for(int j = 0; j < nodetree.children.length; j++)
        {
            k += checkSatisfy(nodetree.children[j], list);
        }

        if(k >= nodetree.k)
        {
            nodetree.satisfiable = true;
            return 1;
        } else
        {
            return 0;
        }
    }

    public String toString()
    {
        if(!isValid())
        {
            return "This tree is not valid, the policy is wrong.";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            asText(stringbuilder);
            return stringbuilder.toString();
        }
    }

    private void asText(StringBuilder stringbuilder)
    {
        asText(root, 0, stringbuilder);
    }

    private void asText(NodeTree nodetree, int i, StringBuilder stringbuilder)
    {
        for(int j = 0; j < i; j++)
        {
            stringbuilder.append(" ");
        }

        stringbuilder.append((new StringBuilder()).append(nodetree).append("\n").toString());
        if(nodetree.children == null)
        {
            return;
        }
        for(int k = 0; k < nodetree.children.length; k++)
        {
            asText(nodetree.children[k], i + 3, stringbuilder);
        }

    }
}
