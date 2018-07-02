package encryptor;


public class KeyController {

    private byte[] key_p;
    private byte[] text;
    private static byte[] k1, k2;

    public void Encrypt(){

        key_p = new byte[10];
        text = new byte[8];
        Controller keyController = new Controller(key_p, text);

        byte[] array_after_P10 = keyController.P10();

        Object obj[] = keyController.Split(array_after_P10);

        byte[] k1_0 = keyController.ShiftLeft((byte[]) obj[0], 1);;
        byte[] k2_0 = keyController.ShiftLeft((byte[]) obj[1], 1);;


        byte[] to_merge = keyController.Merge(k1_0, k2_0);
        to_merge = keyController.P10w8(to_merge);
        byte[] k1 = to_merge;

        byte[] k1_temp = keyController.ShiftLeft((byte[]) obj[0], 2);
        byte[] k2_temp  = keyController.ShiftLeft((byte[]) obj[1], 2);

        byte[] k2 = keyController.Merge(k1_temp, k2_temp);

    }
}
