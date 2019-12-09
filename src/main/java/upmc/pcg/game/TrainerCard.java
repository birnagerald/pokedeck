/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;


public class TrainerCard extends Card {

	private String Type;
	
	public TrainerCard(int Id, String Type, String CardName) {
		super(Id, "Trainer", CardName);
		this.Type = Type;
	}
        
        public void edit(String Type,String CardName){
            super.setCardName(CardName);
            this.Type = Type;
        }

	@Override
	public String cardDescrition() {
		String CardParams = "Card ID : " + this.getCardId() + " Card Type : " + this.getCardType() + "Name : " + this.getCardName() + " Type : " + this.Type;
	
		if(this.CardDescription != null ) {
			CardParams += "\n" + this.CardDescription;
		}
		
		return CardParams;
	}
}
