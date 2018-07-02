package encryptor;

public class TextController {

    private byte[] key_p;
    private byte[] text, k1;

    public void Encrypt(){

        Controller textController = new Controller(key_p, text);

        Object obj[] = textController.Split(this.text);

        byte[] double_second = textController.P4w8((byte[]) obj[1]);
        byte[] xor_with_key_first_round = new byte[5];

        int i = 0;
        for (byte b : double_second){
            xor_with_key_first_round[i] = (byte) (b ^ k1[i++]);
        }

        obj = textController.Split(xor_with_key_first_round);
        SBOX sbox1 = new SBOX(1);
        SBOX sbox2 = new SBOX(2);

        byte[] sbox1_a = sbox1.Decrypt((byte[])obj[0], 1);
        byte[] sbox2_a = sbox1.Decrypt((byte[])obj[1], 2);

        byte[] to_permutate = new byte[4];
        to_permutate = textController.Merge(sbox1_a, sbox2_a);

        byte[] after_permutation = textController.P4(to_permutate);

        byte[] xored = new byte[4];
        i = 0;
        for (byte b : text){
            xored[i] = (byte) (b ^ after_permutation[i++]);
        }

        byte[] last_4_text = new byte[4];
        for (int j = 0; j < 4; j++) {
            last_4_text[i] = text[i+4];
        }

        byte[] result = textController.Merge(xored, last_4_text);


    }


}
