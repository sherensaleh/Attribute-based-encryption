/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.*;
import java.util.ArrayList;

public class LagrangeCalculator
{

    public LagrangeCalculator()
    {
    }

    public static Element compute(int i, ArrayList arraylist, Pairing pairing)
    {
        Element element = pairing.getZr().newElement();
        Element element1 = pairing.getZr().newElement();
        element.setToOne();
        for(int k = 0; k < arraylist.size(); k++)
        {
            int j = ((Integer)arraylist.get(k)).intValue();
            if(j != i)
            {
                element1.set(-j);
                element.mul(element1);
                element1.set(i - j);
                element1.invert();
                element.mul(element1);
            }
        }

        return element;
    }
}

