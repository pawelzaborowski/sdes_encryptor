import encryptor.Controller;
import encryptor.KeyController;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ControllerTesting{

    @Test
    public void whenXorSimpleBits_CorrectResult(){

        Controller controller = new Controller();
        assertThat(0).isEqualTo(controller.xorBits(0,0));
        assertThat(0).isEqualTo(controller.xorBits(1,1));
        assertThat(1).isEqualTo(controller.xorBits(0,1));
        assertThat(1).isEqualTo(controller.xorBits(1,0));
    }

    @Test
    public void whenXorArrays_ifCorrectResult(){

        Controller controller = new Controller();
        assertThat(new int[]{1, 0}).isEqualTo(controller.xor(new int[]{1,1}, new int[]{0, 1}));
    }

    @Test
    public void simpleTesting(){

        KeyController keyController = new KeyController(new int[]{1, 1, 1, 1, 0, 0, 0, 0});
        assertThat(keyController.getK1()).isNotEmpty().isNotNull();

    }

    @Test
    public void whenSplitArray_ifContainSplitedElements(){

        Controller controller = new Controller();
        assertThat(controller.split(new int[]{1,1,0,1})).contains(new int[]{1,1}).doesNotContain(new int[]{1,0});
    }

    @Test
    public void whenMergeArrays_ifMergedCorrectly(){

        Controller controller = new Controller();
        assertThat(new int[]{1,1,1,1}).isEqualTo(controller.merge(new int[]{1,1}, new int[]{1,1}));

    }



}