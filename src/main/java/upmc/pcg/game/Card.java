/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.io.Serializable;

 
public abstract class Card implements Serializable {

        static private final long serialVersionUID = 7L;
	public int CardId;
	public String CardName;
	public String CardType;
	public String CardDescription;
       
	
	public Card(int cardId, String cardType, String cardName) {
		this.CardId = cardId;
		this.CardName = cardName;
		this.CardType = cardType;
	}

	public int getCardId() {
		return CardId;
	}
        
        public String getCardType() {
		return CardType;
	}

	public String getCardName() {
		return CardName;
	}

        public void setCardName(String CardName) {
            this.CardName = CardName;
        }

        public void setCardType(String CardType) {
            this.CardType = CardType;
        }
	
	public abstract String cardDescrition();
	
}
