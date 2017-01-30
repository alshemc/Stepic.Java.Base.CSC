/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepic.java.base.fifth;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alesha
 */
public class StreamBytes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //System.out.println("1"+2+3);
        System.setIn(new java.io.FileInputStream(args[0]));
        bytesInHex();
        
    }

    enum Types {A,B,C}

    public static int maxLandSize(double[][] map) {
        int mLandSize = 0;
        return mLandSize; // your implementation here
    }
    
    @SuppressWarnings("empty-statement")
    public static void bytesInHex (){
        //Reader reader = new InputStreamReader(System.in, charset);
        //BufferedReader bReader = new BufferedReader(reader);
        //InputStream is;
        //ByteArrayInputStream ba = new ByteArrayInputStream();
        //byte[] bytes = IOUtils.toByteArray(is);
        //java.nio.ByteBuffer bb = java.nio.ByteBuffer()
        
        int BSIZE = 1024;
        //java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream();
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream(BSIZE);
        byte[] tmp = new byte[BSIZE];
        while (true) {
            try {
                int e = System.in.read(tmp);
                if (e == -1) break;
                
                baos.write(tmp,0,e);
            } catch (IOException ex) {
                Logger.getLogger(StreamBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        java.nio.ByteBuffer bbuf = java.nio.ByteBuffer.wrap(baos.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bbuf.array()) {
            sb.append(String.format("%02X ", b));
        }
        System.out.println(sb.toString());
    }
    
    public static <T> boolean isSymmetric(Map<T, List<T>> graph) {
        boolean isSymm = true;
        Iterator entries = graph.entrySet().iterator();
        java.util.Map.Entry<T, List<T>> curEntry;
        while (entries.hasNext()) {
            curEntry = (java.util.Map.Entry<T, List<T>>) entries.next();
            T nodeFrom = curEntry.getKey();
            List<T> valueFrom = curEntry.getValue();
            for (int k = 0; k < valueFrom.size(); k++) {
                T nodeTo = valueFrom.get(k);
                if (graph.containsKey(nodeTo)) {
                    List<T> valueTo = graph.get(nodeTo);
                    if (!valueTo.contains(nodeFrom)){
                        isSymm = false;
                        break;                        
                    }
                } else {
                    isSymm = false;
                    break;
                }
            }          
        }
        return isSymm;
    }
}
