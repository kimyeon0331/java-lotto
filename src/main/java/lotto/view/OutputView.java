package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public void printLottoList(List<Lotto> lottos, int manualCount) {

        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (lottos.size() - manualCount) + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.buildLottoString());
        }
    }


    public void printResult(LottoResult lottoResult) {
        System.out.println(lottoResult.getStatistics());
    }
}
