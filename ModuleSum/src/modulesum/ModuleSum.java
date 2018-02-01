package modulesum;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuleSum {
    
    public static void main(String[] args) {
        String FILE_NAME_INPUT = "INPUT.txt"; 
        String FILE_NAME_OUTPUT = "OUTPUT.txt";
        ArrayList<String> list = new ArrayList<>();        
        try {
            Files.lines(Paths.get(FILE_NAME_INPUT), StandardCharsets.UTF_8).forEach(list::add);
            int size = Integer.parseInt(list.get(0));
            String st = list.get(1);
            String listMax = "", listMin = "";
            int j = -1;
            int x, n = 0, max = 0, min = 0, countMax = 0, countMin = 0;
            for (int i=0; countMax+countMin<size; i++){
                n+=1;
                 j = st.indexOf(" ", j+1);                
                if (j!=-1){
                    x = Integer.parseInt(st.substring(i, j)); 
                    i=j;
                }
                else {x = Integer.parseInt(st.substring(i, st.length())); 
                        if (x>=0){
                            max +=x;
                            countMax+=1;
                            listMax = listMax + " " + Integer.toString(n);
                        } else {
                            min +=x;
                            countMin+=1;
                            listMin = listMin + " " + Integer.toString(n);
                        }
                        break;}                
                if (x>=0){
                    max +=x;
                    countMax+=1;
                    listMax = listMax + " " + Integer.toString(n);
                } else if (x<0){
                    min +=x; 
                    countMin+=1;
                    listMin = listMin + " " + Integer.toString(n);
                }                
            }
            
            System.out.println("Сумма и номера max " + max + " " + listMax + " count " + countMax);
            System.out.println("Сумма и номера min " + min + " " + listMin + " count " + countMin);
            File file = new File(FILE_NAME_OUTPUT);            
            try(FileWriter out = new FileWriter(file.getAbsolutePath())){
                if (max>=Math.abs(min)) 
                {
                    out.write(countMax + "\r\n" + listMax.trim());
                }
                else 
                {
                    out.write(countMin + "\r\n" + listMin.trim());
                }
            }             
        } catch (IOException ex) {
            Logger.getLogger(ModuleSum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
