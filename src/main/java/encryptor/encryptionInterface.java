package encryptor;

public interface encryptionInterface {

    Object[] Split(int[] array_to_split);
     int[] ShiftLeft(int[] array_to_shift, int cycles);
    int[] Merge(int[] array_to_merge1, int[] array_to_merge2);

}
