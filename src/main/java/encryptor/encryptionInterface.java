package encryptor;

public interface encryptionInterface {

    Object[] split(int[] array_to_split);
    int[] shiftLeft(int[] array_to_shift, int cycles);
    int[] merge(int[] array_to_merge1, int[] array_to_merge2);
    int[] swapBits(int[] array_to_swap);

}
