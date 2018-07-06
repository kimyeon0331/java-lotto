package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoShuffle {

    public Lotto getLotto() {
        List<LottoNo> shuffleLottoNoPool = LottoNo.lottoNoPool.values().stream().collect(Collectors.toList());
        Collections.shuffle(shuffleLottoNoPool);
        Set<LottoNo> result = new HashSet<>();
        for (int i = 0; i < Lotto.A_LOTTO_COUNT; i++) {
            result.add(shuffleLottoNoPool.get(i));
        }
        return new Lotto(result);

    }
}
