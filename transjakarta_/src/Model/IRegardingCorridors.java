/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public interface IRegardingCorridors {
    public final String[] arrCorridorsList = {"1", "2", "4C", "8", "10", "12"}; 
    
    // checks whether the two corridors has intersecting bus stops
    public boolean doWeHaveSameStops(String corridorA, String corridorB);
    
    // finds all other corridors that intersects with 'this' corridor
    public ArrayList<String> findPossibleCorridors(String corridorX);
    
}
