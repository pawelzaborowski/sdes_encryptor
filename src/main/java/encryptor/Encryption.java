package encryptor;

import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;

public class Encryption {


    public static void main(String[] args) throws IOException {

        int[] key_p = new int[10];
        int[] text = new int[8];
        Scanner scanner = new Scanner(System.in);
        int j = 0;

        while (j < 10) {

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
             else{
                 break;
             }
        }


        for(int i = 0; i < text.length; i++){
            if(text[i] != 0 && text[i] != 1){
                text[i] = 0;
            }
        }


        KeyController keyController = new KeyController(key_p);
        Object keys[] = keyController.encrypt();


        TextController textController = new TextController(text, (int[])keys[0], (int[])keys[1]);
        int[] result = textController.encrypt();

        System.out.print(Arrays.toString(result));
    }


}
