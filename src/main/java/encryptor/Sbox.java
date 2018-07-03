package encryptor;

import java.util.Arrays;

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

//        StringBuilder in_s = new StringBuilder();
//
//        for (int anIn : in) {
//            if (anIn == 0) {
//                in_s.append("0");
//            } else {
//                in_s.append("1");
//            }
//        }
//
//        char first = in_s.toString().charAt(0); // in_s.toString().charAt(1);
//        char second = in_s.toString().charAt(1);
//        char thirs = in_s.toString().charAt(2);
//        char fourth = in_s.toString().charAt(3);
//
//        String first_two = first + second;
//        String last_two = String.valueOf(in_s.toString().charAt(2) + in_s.toString().charAt(3) - 97);

        String ee = Arrays.toString(in);
        String first_two = ee.substring(1,2) + ee.substring(4,5);
        String last_two = ee.substring(7,8) + ee.substring(10,11);

        switch (first_two) {
            case "00":

                switch (last_two) {

                    case "00":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;

                    case "01":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;

                    case "10":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 1;
                        break;

                    default:
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;
                }
                break;
            case "01":

                switch (last_two) {

                    case "00":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 0;
                        break;

                    case "01":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 1;
                        break;

                    case "10":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 1;
                        break;

                    default:
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 1;
                        break;
                }

                break;
            case "10":

                switch (last_two) {

                    case "00":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 1;
                        break;

                    case "01":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 0;
                        break;

                    case "10":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;

                    default:
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 1;
                        break;
                }
                break;
            default:

                switch (last_two) {

                    case "00":
                        this.sbox1[0] = 0;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 1;
                        break;

                    case "01":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;

                    case "10":
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 1;
                        this.sbox2[0] = 0;
                        this.sbox2[1] = 0;
                        break;

                    default:
                        this.sbox1[0] = 1;
                        this.sbox1[1] = 0;
                        this.sbox2[0] = 1;
                        this.sbox2[1] = 1;
                        break;
                }
                break;
        }


        if (version == 1) {
            return sbox1;
        } else {
            return sbox2;
        }


    }
}
