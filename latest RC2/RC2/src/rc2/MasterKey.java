/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import java.util.ArrayList;
import java.util.List;
//import src.utilABE.Files;
import src.utilABE.Utils;

public class MasterKey
{
  public Element beta;
  public Element g_alpha;
  
  public MasterKey(int paramInt, String paramString)
  {
    String str = Utils.fileNameParams(paramInt, paramString);
    
    ArrayList localArrayList = (ArrayList)Files.readObject("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/bsw/keys/" + str + "_prvKey.data", "MASTER KEY read for this ABE scheme");
    if (localArrayList == null)
    {
      this.beta = null;
      this.g_alpha = null;
      return;
    }
    Pairing localPairing = PairingFactory.getPairing("C:/Users/Alahram/Desktop/latest RC2/latest RC2/RC2/src/params/" + str);
    
    this.beta = localPairing.getZr().newElement().setToRandom();
    this.g_alpha = localPairing.getG2().newElement().setToRandom();
    
    this.beta.setFromBytes((byte[])localArrayList.get(0));
    this.g_alpha.setFromBytes((byte[])localArrayList.get(1));
  }
  
  public String toString()
  {
    String str = "beta = " + this.beta + "\n" + "g1^alpha = " + this.g_alpha;
    
    return str;
  }
}

