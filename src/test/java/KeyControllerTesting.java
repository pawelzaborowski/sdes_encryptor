import encryptor.KeyController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KeyControllerTesting {


    @Test
    public void whenKeyPIsNot10Elements_throwOutOfBoundsException() {

        KeyController keyController = new KeyController(new int[]{1,0,0,1});
        try {
            assertThat(keyController.encrypt()).isNull();
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void ifKey1AndKey2AreNotNull(){

        KeyController keyController = new KeyController(new int[]{1,0,0,1,1,0,0,1,0,0});
        assertThat(keyController.encrypt()).isNotNull();
    }
}
