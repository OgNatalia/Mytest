package numbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Numbers {

    public static void main(String[] args) {
        String FILE_NAME_INPUT = "INPUT.txt"; 
        String FILE_NAME_OUTPUT = "OUTPUT.txt";
        ArrayList<String> list = new ArrayList<>();        
        try {
            Files.lines(Paths.get(FILE_NAME_INPUT), StandardCharsets.UTF_8).forEach(list::add);
            int size = Integer.parseInt(list.get(0));            
            int a, b, c, d, e, j = 0;            
            for (int i=10; i-j<=size; i++){
                String number = Integer.toString(i);
                int longN = number.length();
                switch (longN){                    
                    case 2: {a = number.charAt(0);
                             b = number.charAt(1);
                            if (a==b) {j+=1;} break;}
                    case 3: {a = number.charAt(0);
                            b = number.charAt(1);
                            c = number.charAt(2);
                            if (a==b || a==c || b==c) {j+=1;}break;}
                    case 4: {a = number.charAt(0);
                             b = number.charAt(1);
                             c = number.charAt(2);
                             d = number.charAt(3);
                             if (a==b || a==c || a==d || b==c || b==d || c==d){j+=1;}break;}
                    case 5: {a = number.charAt(0);
                             b = number.charAt(1);
                             c = number.charAt(2);
                             d = number.charAt(3);
                             e = number.charAt(4);
                             if (a==b || a==c || a==d || a==e || b==c || b==d || b==e || c==d || c==e || d==e){j+=1;}break;}
                }   
            }  
            File file = new File(FILE_NAME_OUTPUT);            
            try(FileWriter out = new FileWriter(file.getAbsolutePath())){
                out.write(Integer.toString(size+j));
            }             
        } catch (IOException ex) {
            Logger.getLogger(Numbers.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
