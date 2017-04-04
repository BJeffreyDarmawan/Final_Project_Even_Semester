/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transjakarta_;

import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public interface IRegardingCorridors {
    public final String[] arrCorridorsList = {"1", "2", "4C", "8", "10", "12"}; 
    //public final ArrayList<String> arrCorridorsList = new ArrayList();
    
    public boolean doWeHaveSameStops(String corridorA, String corridorB);
    public ArrayList<String> findPossibleCorridors(String corridorX);
    
}
