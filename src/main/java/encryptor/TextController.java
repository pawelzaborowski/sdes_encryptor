package encryptor;

import java.util.Arrays;

public class TextController {

    private int[] text;
    private int[] k1, k2;
    private int[] result;

    public TextController(int[] text, int[] k1, int[] k2){
        this.result = new int[8];
        this.text = text;
        this.k1 = k1;
        this.k2 = k2;
    }

    public int[] encrypt(){

        Controller textController = new Controller();

        int[] last_4_text = new int[4];
        int[] first_4_text = new int[4];
        for (int j = 0; j < 4; j++) {
            first_4_text[j] = this.text[j];
            last_4_text[j] = this.text[j + 4];
        }

        Object obj[] = textController.split(this.text);

        int[] xored_with_first_key = textController.xor(this.k1, textController.P4w8((int[]) obj[1]));

        obj = textController.split(xored_with_first_key);

        Sbox sbox1 = new Sbox(1);
        Sbox sbox2 = new Sbox(2);

        int[] to_permutate = textController.merge(sbox1.Decrypt((int[])obj[0]), sbox2.Decrypt((int[])obj[1]));
        int[] after_permutation = textController.P4(to_permutate);

        int[] xored = textController.xor(after_permutation, first_4_text);
        int[] after_first_round = textController.merge(xored, last_4_text);

        after_first_round = textController.swapBits(after_first_round);

        System.out.print(Arrays.toString(xored_with_first_key));



        obj = textController.split(after_first_round);

        int[] xored_with_second_key = textController.xor(this.k2, textController.P4w8((int[]) obj[1]));

        obj = textController.split(xored_with_second_key);

        sbox1 = new Sbox(1);
        sbox2 = new Sbox(2);

        to_permutate = textController.merge(sbox1.Decrypt((int[])obj[0]), sbox2.Decrypt((int[])obj[1]));
        after_permutation = textController.P4(to_permutate);

        xored = textController.xor(after_permutation, first_4_text);
        this.result = textController.merge(xored, last_4_text);

        return this.result;
    }


}
