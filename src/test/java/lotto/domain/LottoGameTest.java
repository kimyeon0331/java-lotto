package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class LottoGameTest {

    private LottoGame game;

    @Before
    public void setup() {
        game = new LottoGame();
    }

    @Test
    public void generateTest() {
        assertEquals(2, game.generate(2000).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputExceptionTest() {
        game.generate(999);
    }


    @Test
    public void collectionShuffleStudyTest() {
        List<Integer> testCase = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(testCase);
        assertThat(expected, not(testCase));
    }

    @Test
    public void getWinnersTest() {
        List<Lotto> testCase = new ArrayList<>(Arrays.asList(
                Lotto.valueOf(1, 2, 3, 4, 5, 6),
                Lotto.valueOf(1, 2, 3, 4, 5, 7),
                Lotto.valueOf(1, 9, 8, 7, 11, 12)
        ));

        game.setWinLotto(Lotto.valueOf(1, 2, 3, 4, 5, 6));
        List<LottoState> winners = game.getWinners(testCase);
        assertEquals(2, winners.size());
    }

    @Test
    public void createLottoGame(){
        List<Lotto> lottos = Arrays.asList(
                Lotto.valueOf(1,2,3,4,5,6),
                Lotto.valueOf(1,2,3,4,5,7),
                Lotto.valueOf(1,2,3,4,5,8)
        );
        GenerateLotto autoGenerateLotto = new AutoGenerateLotto(5);
        GenerateLotto manualGenerateLotto = new ManualGenerateLotto(lottos);

        List<GenerateLotto> generateLottos = new ArrayList<>();
        generateLottos.add(autoGenerateLotto);
        generateLottos.add(manualGenerateLotto);

        LottoGame lottoGame = new LottoGame(generateLottos);
        assertEquals(8, lottoGame.generate().size());
    }
}