package lotto.domain;

import java.util.List;

public class ManualGenerateLotto implements GenerateLotto {

    private List<Lotto> lottos;

    public ManualGenerateLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public List<Lotto> generate() {
        return this.lottos;
    }
}
