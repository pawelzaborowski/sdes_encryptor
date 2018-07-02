package encryptor;

public class Controller implements encryptionInterface{

    private byte[] key_p;
    private byte[] text;

    public Controller(byte[] key_p, byte[] text){
        this.key_p = key_p;
        this.text = text;
    }

    @Override
    public Object[] Split(byte[] array_to_split) {

        byte[] k1_0 = new byte[5];
        byte[] k2_0 = new byte[5];

        for (int i = 0; i < array_to_split.length; i++){
            k1_0[i] = array_to_split[i];
            k2_0[i] = array_to_split[i+ 5];
        }

        return new Object[]{k1_0, k2_0};
    }

    @Override
    public byte[] ShiftLeft(byte[] array_to_shift, int cycles) {

        byte[] temp = new byte[array_to_shift.length];

        for (int i = 0; i < array_to_shift.length - 1; i++){
            byte first_value = array_to_shift[0];
            array_to_shift[i] = array_to_shift[i+1];
            array_to_shift[array_to_shift.length - 1] = first_value;
        }

        return temp;
    }

    @Override
    public byte[] Merge(byte[] array_to_merge1, byte[] array_to_merge2) {

        byte[] merged = new byte[10];
        for(int i = 0; i < array_to_merge1.length; i++){

            merged[i] = array_to_merge1[i];
            merged[i+5] = array_to_merge2[i];
        }
        return merged;
    }

    public byte[] P10(){

        byte[] temp = new byte[10];
        temp[0] = this.key_p[2];
        temp[1] = this.key_p[4];
        temp[2] = this.key_p[1];
        temp[3] = this.key_p[6];
        temp[4] = this.key_p[3];
        temp[5] = this.key_p[9];
        temp[6] = this.key_p[0];
        temp[7] = this.key_p[8];
        temp[8] = this.key_p[7];
        temp[9] = this.key_p[5];

        return temp;
    }

       public byte[] P10w8(byte[] to_perm){

        byte[] temp = new byte[8];
        temp[0] = to_perm[5];
        temp[1] = to_perm[2];
        temp[2] = to_perm[6];
        temp[3] = to_perm[3];
        temp[4] = to_perm[7];
        temp[5] = to_perm[4];
        temp[6] = to_perm[9];
        temp[7] = to_perm[8];

        to_perm = temp;

//        temp[8] = to_perm[7];
//        temp[9] = to_perm[5];

        return temp;
    }

    public byte[] P4w8(byte[] to_perm){

        byte[] temp = new byte[8];
        temp[0] = to_perm[3];
        temp[1] = to_perm[0];
        temp[2] = to_perm[1];
        temp[3] = to_perm[2];
        temp[4] = to_perm[1];
        temp[5] = to_perm[2];
        temp[6] = to_perm[3];
        temp[7] = to_perm[0];

        return temp;
    }

     public byte[] P4(byte[] to_perm){

        byte[] temp = new byte[4];
        temp[0] = to_perm[1];
        temp[1] = to_perm[3];
        temp[2] = to_perm[2];
        temp[3] = to_perm[0];

        return temp;
    }

}