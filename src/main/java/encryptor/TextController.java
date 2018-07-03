package encryptor;

public class TextController {

    private int[] text;
    private int[] k1;
    private int[] result;

    public TextController(int[] text, int[] k1){
        this.result = new int[8];
        this.text = text;
        this.k1 = k1;
    }

    public int[] Encrypt(){

        Controller textController = new Controller();

        Object obj[] = textController.Split(this.text);

        int[] double_second = textController.P4w8((int[]) obj[1]);
        int[] xor_with_key_first_round = new int[8];

        for(int j = 0; j < xor_with_key_first_round.length; j++) {
            xor_with_key_first_round[j] = textController.xor(this.k1[j], double_second[j]);

        }

        obj = textController.Split(xor_with_key_first_round);
        Sbox sbox1 = new Sbox(1);
        Sbox sbox2 = new Sbox(2);

        int[] sbox1_a = sbox1.Decrypt((int[])obj[0]);
        int[] sbox2_a = sbox2.Decrypt((int[])obj[1]);

        int[] to_permutate = textController.Merge(sbox1_a, sbox2_a);

        int[] after_permutation = textController.P4(to_permutate);

        int[] xored = new int[4];


        for(int j = 0; j < xored.length; j++){
            xored[j] = textController.xor(this.text[j], after_permutation[j]);
        }

        int[] last_4_text = new int[4];
        for (int j = 0; j < 4; j++) {
            last_4_text[j] = text[j + 4];
        }

        this.result = textController.Merge(xored, last_4_text);
        return this.result;
    }


}
