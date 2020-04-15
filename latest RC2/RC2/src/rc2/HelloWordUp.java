/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc2;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static javax.lang.model.SourceVersion.latest;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;
/**
* This class looks up word senses in JWordnet, and finds holonyms.
*/
public class HelloWordUp {

public static void main(String[] args) throws JWNLException {
   
configureJWordNet();
Dictionary dictionary = Dictionary.getInstance();
IndexWord word = dictionary.lookupIndexWord(POS.VERB, "search");
System.out.println("Senses of the word ‘search’:");
Synset[] senses = word.getSenses();
for (int i=0; i<senses.length; i++) {
Synset sense = senses[i];

//System.out.println(sense.toString());
//System.out.println((i+1) + “. ” + sense.getGloss());
List<String> jw=new ArrayList<>();
Pointer[] holo = sense.getPointers(PointerType.HYPERNYM);
for (int j=0; j<holo.length; j++) {
  // System.out.println("jkjgjg"+holo[i]); 
Synset synset = (Synset) (holo[j].getTarget());
Word synsetWord = synset.getWord(0);
//System.out.println(synsetWord.getLemma());
jw.add(synsetWord.getLemma());
System.out.println(Arrays.toString(jw.toArray()));
//System.out.println(” = ” + synset.getGloss());
}
}
}


public static void configureJWordNet() {
// WARNING: This still does not work in Java 5!!!
try {
// initialize JWNL (this must be done before JWNL can be used)
// See the JWordnet documentation for details on the properties file
JWNL.initialize(new FileInputStream("C:\\Users\\Alahram\\Desktop\\latest RC2\\latest RC2\\RC2\\src\\file_properties.xml"));
} catch (Exception ex) {
ex.printStackTrace();
System.exit(-1);
}
}

}