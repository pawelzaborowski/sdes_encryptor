package encryptor;


public class KeyController {

    private int[] key_p;
    private int[] text;
    private int[] k1;
    private int[] k2;

    public KeyController(int[] key_p, int[] text){
        this.k1 = new int[8];
        this.k2 = new int[8];
        this.key_p = key_p;
        this.text = text;
    }

    public Object[] Encrypt(){

        Controller keyController = new Controller(this.key_p, this.text);

        int[] array_after_P10 = keyController.P10();

        Object obj[] = keyController.Split(array_after_P10);

        int[] k1_0 = keyController.ShiftLeft((int[]) obj[0], 1);;
        int[] k2_0 = keyController.ShiftLeft((int[]) obj[1], 1);;


        int[] to_merge = keyController.Merge(k1_0, k2_0);
        to_merge = keyController.P10w8(to_merge);
        this.k1 = to_merge;

        int[] k1_temp = keyController.ShiftLeft((int[]) obj[0], 2);
        int[] k2_temp  = keyController.ShiftLeft((int[]) obj[1], 2);

        this.k2 = keyController.Merge(k1_temp, k2_temp);

        return new Object[]{this.k1, this.k2};

    }
}
