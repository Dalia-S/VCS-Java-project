/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.object;

/**
 *
 * @author Dalia
 */
public class Dog {
    
    int number;
    String road;

    public Dog(int number, String road) {
        this.number = number;
        this.road = road;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    @Override
    public String toString() {
        return "Dog{" + "number=" + number + ", road=" + road + '}';
    } 
 
}
