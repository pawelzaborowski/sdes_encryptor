package encryptor;

public interface encryptionInterface {

    Object[] Split(byte[] array_to_split);
     byte[] ShiftLeft(byte[] array_to_shift, int cycles);
    byte[] Merge(byte[] array_to_merge1, byte[] array_to_merge2);

}
