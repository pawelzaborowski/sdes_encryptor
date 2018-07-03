package encryptor;

public class Controller implements encryptionInterface{


    @Override
    public Object[] Split(int[] array_to_split) {

        int[] k1_0 = new int[array_to_split.length / 2];
        int[] k2_0 = new int[array_to_split.length / 2];

        for (int i = 0; i < array_to_split.length / 2; i++){
            k1_0[i] = array_to_split[i];
            k2_0[i] = array_to_split[i + array_to_split.length / 2];
        }

        return new Object[]{k1_0, k2_0};
    }

    @Override
    public int[] ShiftLeft(int[] array_to_shift, int cycles) {


        while(cycles-- > 0) {
            int first_value = array_to_shift[0];
            for (int i = 0; i < array_to_shift.length - 1; i++) {
                array_to_shift[i] = array_to_shift[i + 1];
            }
            array_to_shift[array_to_shift.length - 1] = first_value;
        }

        return array_to_shift;
    }

    @Override
    public int[] Merge(int[] array_to_merge1, int[] array_to_merge2) {

        int[] merged = new int[array_to_merge1.length + array_to_merge2.length];
        for(int i = 0; i < array_to_merge1.length; i++){

            merged[i] = array_to_merge1[i];
            merged[i+array_to_merge1.length] = array_to_merge2[i];
        }
        return merged;
    }

    public int[] P10(int[] key_p){

        int[] temp = new int[10];
        temp[0] = key_p[2];
        temp[1] = key_p[4];
        temp[2] = key_p[1];
        temp[3] = key_p[6];
        temp[4] = key_p[3];
        temp[5] = key_p[9];
        temp[6] = key_p[0];
        temp[7] = key_p[8];
        temp[8] = key_p[7];
        temp[9] = key_p[5];

        return temp;
    }

       public int[] P10w8(int[] to_perm){

        int[] temp = new int[8];
        temp[0] = to_perm[5];
        temp[1] = to_perm[2];
        temp[2] = to_perm[6];
        temp[3] = to_perm[3];
        temp[4] = to_perm[7];
        temp[5] = to_perm[4];
        temp[6] = to_perm[9];
        temp[7] = to_perm[8];


        return temp;
    }

    public int[] P4w8(int[] to_perm){

        int[] temp = new int[8];
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

     public int[] P4(int[] to_perm){

        int[] temp = new int[4];
        temp[0] = to_perm[1];
        temp[1] = to_perm[3];
        temp[2] = to_perm[2];
        temp[3] = to_perm[0];

        return temp;
    }

    public int xor(int a, int b){
        if(a != b){
            return 1;
        }
        else{
            return 0;
        }

    }

}