

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package upmc.pcg.game;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationMain {
    
    public void saveDeck(Deck deck,String name){
        try {
			FileOutputStream fos = new FileOutputStream(name+".serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(deck);
				oos.flush();
			} finally {
				oos.close();
				fos.close();
			}
		}  catch(IOException ioe) {
			ioe.printStackTrace();
		}
    }
    
   public Deck fetchDeck(String name){
        Deck deck = null;
        try {
			FileInputStream fis = new FileInputStream(name+".serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				deck = (Deck) ois.readObject();
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
                        return deck;
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
        return deck;
    }
    
}
