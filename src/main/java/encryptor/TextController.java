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


        // PW
        int[] permutated_text = textController.PW(this.text);


        int[] last_4_text = new int[4];
        int[] first_4_text = new int[4];
        for (int j = 0; j < 4; j++) {
            first_4_text[j] = permutated_text[j];
            last_4_text[j] = permutated_text[j + 4];
        }

        // after PW
        System.out.print(Arrays.toString(permutated_text) + '\n');

        //split given text into 2
        Object obj[] = textController.split(permutated_text);

        // xor second part of text with first level key
        int[] xored_with_first_key = textController.xor(this.k1, textController.P4w8((int[]) obj[1]));

        // split xored text and key into 2 and run sboxs
        obj = textController.split(xored_with_first_key);

        Sbox sbox1 = new Sbox(1);
        Sbox sbox2 = new Sbox(2);

        // merge results from sboxs
        int[] to_permutate = textController.merge(sbox1.Decrypt((int[])obj[0]), sbox2.Decrypt((int[])obj[1]));

        // P4
        int[] after_permutation = textController.P4(to_permutate);

        int[] xored = textController.xor(after_permutation, first_4_text);

        // final result after first layer
        int[] after_first_round = textController.merge(xored, last_4_text);


        System.out.print(Arrays.toString(after_first_round) + '\n');

        // swap 4 first bits with 4 last
        after_first_round = textController.swapBits(after_first_round);

        Object[] obj_after_first_round = textController.split(after_first_round);

        // xor after P4w8 with second level key
        int[] xored_with_second_key = textController.xor(this.k2, textController.P4w8((int[]) obj_after_first_round[1]));

        // prepare to sbox
        obj = textController.split(xored_with_second_key);

        sbox1 = new Sbox(1);
        sbox2 = new Sbox(2);

        // merge and p4
        to_permutate = textController.merge(sbox1.Decrypt((int[])obj[0]), sbox2.Decrypt((int[])obj[1]));
        after_permutation = textController.P4(to_permutate);

        // xor first 4 bits of data after first level with P4 product
        xored = textController.xor(after_permutation, (int[])obj_after_first_round[0]);

        // result after second level
        int[] after_second_round = textController.merge(xored, (int[])obj_after_first_round[1]);

        System.out.print(Arrays.toString(after_second_round) + '\n');


        // final result
        this.result = textController.PO(after_second_round);

        return this.result;
    }


}
