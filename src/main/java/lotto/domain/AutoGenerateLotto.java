package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class AutoGenerateLotto implements GenerateLotto {

    private int count;
    public AutoGenerateLotto(int count) {
        this.count = count;
    }

    @Override
    public List<Lotto> generate() {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

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
