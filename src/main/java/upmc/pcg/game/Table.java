/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Table {
    
    public void var_table(JTable table,Menu menu)
    {
        table.setDefaultRenderer(Object.class, new Render());
        Object[][] row = new Object[50][50];
        
        int count = 0;
        ArrayList<Card> pack = menu.getPackUser().getDeck();
        for (Card card : pack) {
        JButton btn1 = new JButton("Edit");
        btn1.setName(card.getCardName()+"edit");
        JButton btn2 = new JButton("Delete");
        btn2.setName(card.getCardName()+"delete");
            PokemonCard pokemon = (PokemonCard) card;
            row[count]=(new Object[]{card.getCardId(),card.getCardName(),pokemon.getType(),pokemon.getLevel(),pokemon.getHp(),btn1,btn2});
            count++;
        }
        
        DefaultTableModel d = new DefaultTableModel(
            row,   
            new Object[]{"id","Name","Type","Level","HP","Edit","Delete"}
        ){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(d);
        table.setRowHeight(30);
        
    }
}
