/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaauctionsystem;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author HP
 */
public class BackendServ {

    String str;

    public static void writeLog(String str) throws IOException {
        try (FileWriter fw = new FileWriter("log.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.append(str);
            out.append(System.getProperty("line.separator"));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
