/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import src.utilABE.Files;
import src.utilABE.Utils;

public class PublicKey
{

    private byte params[];
    public Pairing e;
    public Element g0;
    public Element g1;
    public Element h;
    public Element g_hat_alpha;

    public PublicKey(int i, String s)
    {
        String s1 = Utils.fileNameParams(i, s);
        File file = new File((new StringBuilder()).append("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/params/").append(s1).toString());
        if(!file.exists())
        {
            e = null;
            return;
        }
        params = Files.readBytesFromFile((new StringBuilder()).append("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/params/").append(s1).toString());
        e = PairingFactory.getPairing((new StringBuilder()).append("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/params/").append(s1).toString());
        ArrayList arraylist = (ArrayList)Files.readObject((new StringBuilder()).append("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/bsw/keys/").append(s1).append("_pubKey.data").toString(), "Reading public key for this ABE scheme");
          // ArrayList arraylist = (ArrayList)Files.readObject((new StringBuilder()).append("src/bsw/keys/").append(s1).append("_pubKey.data").toString());
        if(arraylist == null)
        {
            e = null;
            return;
        }
        g0 = e.getG1().newElement().setToRandom();
        g1 = e.getG2().newElement().setToRandom();
        h = g0.duplicate();
        g_hat_alpha = e.getGT().newElement();
        g0.setFromBytes((byte[])(byte[])arraylist.get(0));
        if(e.isSymmetric())
        {
            g1 = g0.duplicate();
            h.setFromBytes((byte[])(byte[])arraylist.get(1));
            g_hat_alpha.setFromBytes((byte[])(byte[])arraylist.get(2));
        } else
        {
            g1.setFromBytes((byte[])(byte[])arraylist.get(1));
            h.setFromBytes((byte[])(byte[])arraylist.get(2));
            g_hat_alpha.setFromBytes((byte[])(byte[])arraylist.get(3));
        }
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("g0 = ").append(g0).append("\n").append("g1 = ").append(g1).append("\n").append("h = ").append(h).append("\n").append("e(g0,g1^alpha) = e(g0,g1)^alpha = ").append(g_hat_alpha).append("\n").toString();
        return s;
    }
}

