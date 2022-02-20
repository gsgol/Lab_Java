import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FileReader {
    public static void main(String[] args) 
    {
        int size;
        String filename_input;
        String filename_output;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) 
        {
            try {
                System.out.println("Введите имя файла для чтения");
                filename_input = sc.next();
                System.out.println("Введите имя файла для записи");
                filename_output = sc.next();
                InputStream fp = new FileInputStream(filename_input);
                Writer op = new FileWriter(filename_output);
                size = fp.available();
                int ans = 0;
                byte b[] = new byte[size];
                for(int i = 0; i < size; ++i)
                {
                    fp.read(b);
                }
                for(int i = 0; i < size; ++i)
                {
                    char temp = (char)(b[i]);
                    if((temp >= 'A' & temp <= 'Z') | (temp >= 'a' & temp <= 'z'))
                    {
                        ans += 1;
                    }
                }
                op.write(Integer.toString(ans));
                flag = false;
                fp.close();
                op.close();
            } catch (IOException | SecurityException ex) {
                System.out.println("Файл не найден, либо к нему нет доступа");
            }

        }
    }
}
