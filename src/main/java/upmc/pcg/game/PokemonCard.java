/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;


public class PokemonCard extends Card {

    private String Type;
    private int hp;
    private String level;

    public PokemonCard(int CardId, String Type, String CardName, int hp, String level) {
            super(CardId, "Pokemon", CardName);
            this.Type = Type;
            this.hp = hp;
            this.level = level;
    }

    public String getType() {
        return Type;
    }

    public int getHp() {
        return hp;
    }

    public String getLevel() {
        return level;
    }
    
    public void edit(String Type, String CardName, int hp, String level){
        super.setCardName(CardName);
        this.Type = Type;
        this.hp = hp;
        this.level = level;
    }
    
    @Override
    public String cardDescrition() {
            String CardParams = "Card ID : " + this.getCardId() + " Card Type : " + this.getCardType() + " Name : " + this.getCardName() + " Type : " + this.Type + " Stage : " + this.level;

            if(this.CardDescription != null) {
                    CardParams += "\n"+ this.CardDescription;
                    return CardParams;
            }
            return CardParams;
    }
	
}
