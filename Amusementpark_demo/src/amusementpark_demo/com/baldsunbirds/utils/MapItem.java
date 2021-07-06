/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusementpark_demo.com.baldsunbirds.utils;

/**
 *
 * @author Arbab Ali
 */
public enum MapItem {
    BUILDING(2), GUEST(1), PATH(3), EMPTY(0);
    MapItem(int rep){ representation = rep; }
    public final int representation;
}
