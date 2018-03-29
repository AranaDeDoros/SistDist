/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp4j;

import com.google.cloud.translate.*;
import com.google.cloud.translate.Translate.*;
import net.objecthunter.exp4j.*;

/**
 *
 * @author HP
 */
public class Exp4j {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
                .variables("x", "y")
                .build()
                .setVariable("x", 2.3)
                .setVariable("y", 3.14);
        double result = e.evaluate();
        System.out.println(result);
        
    ;


}
}
