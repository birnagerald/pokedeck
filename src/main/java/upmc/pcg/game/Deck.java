/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.util.ArrayList;
import java.lang.*;
import java.io.Serializable;

public class Deck implements Serializable {
    
        static private final long serialVersionUID = 7L;
	private ArrayList<Card> Deck = new ArrayList<Card>();
        
	public Deck() {
	}

	public ArrayList<Card> getDeck() {
		return Deck;
	}
	
	public void AddCard(Card c) {
		Deck.add(c);
	}
	
	public boolean DeleteCard(int Id) {
		for (Card c : Deck) {
			if(c.getCardId() == Id) {
				return Deck.remove(c);
			}
		}
		return false;
	}
	
	public int DeckSize() {
		return Deck.size();
	}
        
        public Card LastCardInDeck() {
                return Deck.get(this.DeckSize() - 1);
	}
	
	public void DisplayDeck() {
		for (Card card : Deck) {
			System.out.println(card.cardDescrition());
		}
	}
	
	public boolean IdInDeck(int Id) {
		for (Card card : Deck) {
			if( card.getCardId() == Id) {
				return true;
			}
		}
		return false;
	}
	
	public Card retrieveCard(int Id) {
		for(Card card : Deck) {
			if(card.getCardId() == Id) {
				return card;
			}
		}
		return null;
		
	}
	
	public void CardByType(String Type) {
		for (Card card : Deck) {
			if(card.getCardType().equals(Type)) {
				System.out.println(card.cardDescrition());
			}
			
		}
	}
	
	public void CardByName(String Name) {
		String CardName;
		
		for( Card card : Deck) {
			CardName = card.getCardName();
			if(CardName.toLowerCase().contains(Name.toLowerCase())) {
				System.out.println(card.cardDescrition());
			}
		}
	}

}
