/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaprojeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author wolfi
 */
public class Util {
    
    public static void copiaArquivo(String origem, String destino) {
        copiaArquivo(new File(origem), new File(destino));
    }
    
    public static void copiaArquivo(File origem, File destino) {
        try {
            InputStream in = new FileInputStream(origem);
            OutputStream out = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void copiaArquivoInterno(InputStream origem, String destino) {
        try {
            
            File f = new File(destino);
            OutputStream out = new FileOutputStream(f);
            
            byte[] buf = new byte[1024];
            int len;
            while ((len = origem.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            origem.close();
            
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
