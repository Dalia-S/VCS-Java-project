/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.game;

import java.util.Random;
import lt.vilnius.coding.topsport.action.TopSportAction;

/**
 *
 * @author Dalia
 */
public class CoinToss implements TopSportAction {

    @Override
    public boolean start() {
        Random rand = new Random();
        if (rand.nextInt(100) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
