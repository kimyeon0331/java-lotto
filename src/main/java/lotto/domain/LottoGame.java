package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    public static final int LOTTO_COST = 1000;

    private final LottoShuffle shuffle;
    private Lotto winLotto;
    private List<GenerateLotto> generateLottos;

    public  LottoGame(){
        this.shuffle = new LottoShuffle();
    }
    public LottoGame(List<GenerateLotto> generateLottos) {
        this.shuffle = new LottoShuffle();
        this.generateLottos = generateLottos;
    }

    public List<Lotto> generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (GenerateLotto generateLotto : generateLottos) {
            lottos.addAll(generateLotto.generate());
        }
        return lottos;
    }



    public void setWinLotto(Lotto winLotto , int bonusNumber) {
        this.winLotto = winLotto;
    }

    List<LottoState> getWinners(List<Lotto> lottos) {
        return lottos.stream()
                .filter(lotto -> lotto.isWinner(winLotto))
                .map(lotto -> LottoState.valueOf(lotto.getMatchCount(winLotto)))
                .collect(Collectors.toList());
    }


    public LottoResult getLottoResult(List<Lotto> lottos) {
        return new LottoResult(getWinners(lottos), (lottos.size() * LOTTO_COST));
    }


}
