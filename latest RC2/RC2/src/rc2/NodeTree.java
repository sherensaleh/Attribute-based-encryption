/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import java.io.Serializable;

public class NodeTree
    implements Serializable
{

    int k;
    String attr;
    NodeTree children[];
    boolean satisfiable;
    int index;

    public NodeTree[] getChilds()
    {
        return children;
    }

    public int getIndex()
    {
        return index;
    }

    public String getAttr()
    {
        return attr;
    }

    public boolean isSatisfiable()
    {
        return satisfiable;
    }

    public NodeTree childAt(int i)
    {
        return children[i];
    }

    public boolean isSatisfiable(int i)
    {
        return children[i].isSatisfiable();
    }

    public void setChild(int i, NodeTree nodetree)
    {
        children[i] = nodetree;
    }

    public int getK()
    {
        return k;
    }

    public NodeTree[] getChildren()
    {
        return children;
    }

    public NodeTree()
    {
        attr = null;
        children = null;
        satisfiable = false;
        index = -1;
    }

    public NodeTree(NodeTree nodetree)
    {
        attr = (new StringBuilder()).append("").append(nodetree.attr).toString();
        satisfiable = nodetree.satisfiable;
        index = nodetree.index;
        k = nodetree.k;
        children = null;
    }

    public NodeTree(int i, int j)
    {
        k = i;
        attr = (new StringBuilder()).append(i).append("_of_").append(j).toString();
        children = new NodeTree[j];
        satisfiable = false;
        index = -1;
    }

    public NodeTree(String s)
    {
        k = 1;
        attr = s;
        children = null;
        satisfiable = false;
        index = -1;
    }

    public void setIndex(int i)
    {
        index = i;
    }

    public String toString()
    {
        return attr;
    }

    public void newChilds(int i)
    {
        children = new NodeTree[i];
    }
}

