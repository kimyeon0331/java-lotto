package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int money = inputView.inputMoney();
        int manualCount = inputView.inputManualLottoCount();
        List<Lotto> manualLottos = inputView.inputManualLotto(manualCount);

        GenerateLotto manualGenerateLotto = new ManualGenerateLotto(manualLottos);
        GenerateLotto autoGenerateLotto = new AutoGenerateLotto(getLottoCount(money)-manualCount);
        List<GenerateLotto> generateLottos = new ArrayList<>();
        generateLottos.add(manualGenerateLotto);
        generateLottos.add(autoGenerateLotto);
        LottoGame lottoGame = new LottoGame(generateLottos);

        List<Lotto> lottos = lottoGame.generate();
        outputView.printLottoList(lottos,manualCount);

        lottoGame.setWinLotto(new Lotto(inputView.inputWinNumbers()), inputView.inputBonusNumber());


        outputView.printResult(lottoGame.getLottoResult(lottos));
    }

    private static int getLottoCount(int cost) {
        if (cost < LottoGame.LOTTO_COST)
            throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요.");

        return cost / LottoGame.LOTTO_COST;
    }
}
