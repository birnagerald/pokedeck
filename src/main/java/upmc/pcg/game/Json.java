/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import com.google.gson.Gson;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Json {
    
    public void saveDeck(Deck deck,String name){
       
        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(deck);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter(name+".json")) {

            gson.toJson(deck, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Deck fetchDeck(String name){
       
        Gson gson = new Gson();
        Deck deck = null;

        try (Reader reader = new FileReader(name+".json")) {

	// Convert JSON to Java Object
            deck = gson.fromJson(reader, Deck.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return deck;
    }
    
}
