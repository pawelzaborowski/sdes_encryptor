package encryptor;

public class Sbox {


    private int[] sbox1;
    private int[] sbox2;
    private int version;

    public Sbox(int ver){
        this.sbox1 = new int[2];
        this.sbox2 = new int[2];
        this.version = ver;
    }

    public int[] Decrypt(int[] in) {

        StringBuilder in_s = new StringBuilder();

        for (int anIn : in) {
            if (anIn == 0) {
                in_s.append("0");
            } else {
                in_s.append("1");
            }
        }


        if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 0;
            }


        } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 0;
            }

        } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 0;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 1;
            }

        } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 0;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox1[0] = 1;
                this.sbox1[1] = 0;
            }

        }


        if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 0;
            }


        } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 1;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 1;
            }

        } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 1;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 1;
            }

        } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {

            if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 1;
            } else if (in_s.toString().charAt(0) == '0' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '0') {
                this.sbox2[0] = 0;
                this.sbox2[1] = 0;
            } else if (in_s.toString().charAt(0) == '1' & in_s.toString().charAt(1) == '1') {
                this.sbox2[0] = 1;
                this.sbox2[1] = 1;
            }

        }

        if (version == 1) {
            return sbox1;
        } else {
            return sbox2;
        }


    }
}
