package encryptor;


public class KeyController {

    private int[] key_p;
    private int[] k1;
    private int[] k2;

    public KeyController(int[] key_p){
        this.k1 = new int[8];
        this.k2 = new int[8];
        this.key_p = key_p;
    }

    public Object[] encrypt(){

        Controller keyController = new Controller();

        int[] array_after_P10 = keyController.P10(this.key_p);

        Object obj[] = keyController.split(array_after_P10);

        int[] k1_0 = keyController.shiftLeft((int[]) obj[0], 1);;
        int[] k2_0 = keyController.shiftLeft((int[]) obj[1], 1);;


        int[] to_merge = keyController.merge(k1_0, k2_0);
        to_merge = keyController.P10w8(to_merge);
        this.k1 = to_merge;

        int[] k1_temp = keyController.shiftLeft((int[]) obj[0], 2);
        int[] k2_temp  = keyController.shiftLeft((int[]) obj[1], 2);

        this.k2 = keyController.merge(k1_temp, k2_temp);
        this.k2 = keyController.P10w8(this.k2);

        return new Object[]{this.k1, this.k2};

    }

    public int[] getK1(){
        return this.k1;
    }

}
