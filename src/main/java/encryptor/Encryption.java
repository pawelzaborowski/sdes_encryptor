package encryptor;

import java.io.IOException;
import java.util.Arrays;

public class Encryption {

    private byte[] key_p, text;

    public Encryption() throws IOException {

        this.key_p = new byte[10];
        this.text = new byte[8];

        System.in.read(this.key_p);
        System.in.read(this.text);

        if(this.key_p.length < 10){
            for(int i = this.key_p.length; i < 10; i++){
                this.key_p[i] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        byte[] key_p = new byte[10];
        byte[] text = new byte[8];

        System.in.read(key_p);
        System.in.read(text);

        for(int i = 0; i < key_p.length; i++){
            if(key_p[i] != 0 || key_p[i] != 1){
                key_p[i] = 0;
            }
        }


        KeyController keyController = new KeyController(key_p, text);
        Object keys[] = keyController.Encrypt();


        TextController textController = new TextController(key_p, text, (byte[])keys[0]);
        byte[] result = textController.Encrypt();

        System.out.print(Arrays.toString(result));
    }


}
