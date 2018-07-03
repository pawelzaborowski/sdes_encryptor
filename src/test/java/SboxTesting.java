
import encryptor.Sbox;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SboxTesting {

    @Test
    public void ifSboxContainsOnlyZerosAndOnes(){

        Sbox sbox = new Sbox(1);
        assertThat(sbox.Decrypt(new int[]{1,1,0,0})).doesNotContain(3);
    }
}
