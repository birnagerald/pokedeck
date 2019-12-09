/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;
import java.util.ArrayList;

public class EnergyCard extends Card {
	public String Type;
	
	public EnergyCard(int Id, String Type ) {
		super(Id, "Energy", "");
		this.Type = Type;
	}
        
        public void edit(String Type){
            this.Type = Type;
        }

	@Override
	public String cardDescrition() {
		String CardParams = "Card ID : " + this.getCardId() + " Card Type : " + this.getCardType() + " Type : " + this.Type;
		if(this.CardDescription != null ) {
			CardParams += "\n" + this.CardDescription;
			return CardParams;
		}
		return CardParams;
	}
}
