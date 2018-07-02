package encryptor;

public class Sbox {


    private byte[] sbox1;

    public Sbox(int ver){
        this.sbox1 = new byte[2];
    }

    public byte[] Decrypt(byte[] in, int version){

        StringBuilder in_s = new StringBuilder();

        for (byte anIn : in) {
            if (anIn == 0) {
                in_s.append("0");
            } else {
                in_s.append("1");
            }
        }


        if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0'){

            if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 0; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 1; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 0; sbox1[1] = 0;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 1; sbox1[1] = 0;
            }


        }else if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1'){

            if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 1; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 0; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 1; sbox1[1] = 0;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 0; sbox1[1] = 0;
            }

        }else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {

            if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 0; sbox1[1] = 0;
            }
            else if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 1; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 0; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 0; sbox1[1] = 1;
            }

        }else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {

            if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 0; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 1; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0'){
                sbox1[0] = 1; sbox1[1] = 1;
            }
            else if(in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1'){
                sbox1[0] = 1; sbox1[1] = 0;
            }

        }

        return sbox1;

    }


}
