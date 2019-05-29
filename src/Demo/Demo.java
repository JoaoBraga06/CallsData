/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;
import CallsData.*;
/**
 *
 * @author joaop
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CallsData c = new CallsData();
        
        c.calculateAverageMinutesPerArea("415", "HEYY");
        c.calculateAverageMinutesPerNumber();
    }
    
}
