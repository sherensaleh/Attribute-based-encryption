/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;

public class Polynomial
{

    int deg;
    Element coef[];

    public Polynomial(int i, Element element)
    {
        deg = i;
        coef = new Element[i + 1];
        for(int j = 0; j < i + 1; j++)
        {
            coef[j] = element.duplicate();
        }

        coef[0].set(element);
        for(int k = 1; k < i + 1; k++)
        {
            coef[k].setToRandom();
        }

    }

    public void evalPoly(Element element, Element element1)
    {
        Element element3 = element.duplicate();
        element.setToZero();
        element3.setToOne();
        for(int i = 0; i < deg + 1; i++)
        {
            Element element2 = coef[i].duplicate();
            element2.mul(element3);
            element.add(element2);
            element3.mul(element1);
        }

    }

    public Element evalPoly()
    {
        return coef[0].duplicate();
    }
}


