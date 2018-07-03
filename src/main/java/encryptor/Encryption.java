package encryptor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Encryption {

    private int[] key_p, text;

    public Encryption() throws IOException {


    }


    public static void main(String[] args) throws IOException {

        int[] key_p = new int[10];
        int[] text = new int[8];
        Scanner scanner = new Scanner(System.in);
        int j = 0;

        while (scanner.hasNext() && j < 10) {

             if (scanner.hasNextInt()) {
                key_p[j] = scanner.nextInt();
                j++;
             }
        }
        j = 0;
        scanner = new Scanner(System.in);
        while (scanner.hasNext() && j < 7) {

             if (scanner.hasNextInt()) {
                text[j] = scanner.nextInt();
                j++;
             }
        }


        for(int i = 0; i < text.length; i++){
            if(text[i] != 0 && text[i] != 1){
                text[i] = 0;
            }
        }


        KeyController keyController = new KeyController(key_p, text);
        Object keys[] = keyController.Encrypt();


        TextController textController = new TextController(key_p, text, (int[])keys[0]);
        int[] result = textController.Encrypt();

        System.out.print(Arrays.toString(result));
    }


}
