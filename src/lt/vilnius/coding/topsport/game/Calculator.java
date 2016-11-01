/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.game;

import lt.vilnius.coding.topsport.action.TopSportAction;
import lt.vilnius.coding.topsport.gui.Calculator_gui;

/**
 *
 * @author Dalia
 */
public class Calculator implements TopSportAction {

    @Override
    public boolean start() {
        Calculator_gui calc = new Calculator_gui();
        calc.setVisible(true);
        calc.setTitle("Calculator");
        return true;
    }
}
