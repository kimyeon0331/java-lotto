package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateLottoTest {


    @Test
    public void autoGenerateLotto(){
        GenerateLotto generateLotto = new AutoGenerateLotto(11);
        assertEquals(11, generateLotto.generate().size());
    }

    @Test
    public void manualGenerateLotto(){
        List<Lotto> lottos = Arrays.asList(
                Lotto.valueOf(1,2,3,4,5,6),
                Lotto.valueOf(1,2,3,4,5,7),
                Lotto.valueOf(1,2,3,4,5,8)
        );
        GenerateLotto generateLotto = new ManualGenerateLotto(lottos);
        assertEquals(3, generateLotto.generate().size());
    }


}