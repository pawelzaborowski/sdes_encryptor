package encryptor;

public class TextController {

    private byte[] key_p;
    private byte[] text, k1, result;

    public TextController(byte[] key_p, byte[] text, byte[] k1){
        this.result = new byte[8];
        this.key_p = key_p;
        this.text = text;
        this.k1 = k1;
    }

    public byte[] Encrypt(){

        Controller textController = new Controller(key_p, text);

        Object obj[] = textController.Split(this.text);

        byte[] double_second = textController.P4w8((byte[]) obj[0]);
        byte[] xor_with_key_first_round = new byte[8];

        int i = 0;
        for (byte b : double_second){
            xor_with_key_first_round[i] = (byte) (b ^ this.k1[i++]);
        }

        obj = textController.Split(xor_with_key_first_round);
        Sbox sbox1 = new Sbox(1);
        Sbox sbox2 = new Sbox(2);

        byte[] sbox1_a = sbox1.Decrypt((byte[])obj[0]);
        byte[] sbox2_a = sbox2.Decrypt((byte[])obj[1]);

        byte[] to_permutate = textController.Merge(sbox1_a, sbox2_a);

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

        this.result = textController.Merge(xored, last_4_text);
        return this.result;
    }


}
