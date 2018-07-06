package lotto.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int A_LOTTO_COUNT = 6;

    private Set<LottoNo> numbers;

    public Lotto(Set<LottoNo> numbers) {
        this.numbers = numbers;
        if (!isValidLottoNumbers())
            throw new IllegalArgumentException("로또 번호가 잘못됐습니다.");

    }

    public Set<LottoNo> getNumbers() {
        return numbers;
    }

    public static Lotto valueOf(Integer... values) {
        Set<LottoNo> numbers = new LinkedHashSet<>();
        for (Integer value : values) {
            numbers.add(LottoNo.valueOf(value));
        }
        return new Lotto(numbers);
    }

    public static Lotto valueOf(String text) {
        Set<LottoNo> numbers = new LinkedHashSet<>();
        String[] values = text.split(", ");
        for (String value : values) {
            numbers.add(LottoNo.valueOf(value));
        }
        return new Lotto(numbers);
    }

    public boolean isWinner(Lotto winLotto) {
        return LottoState.isWinner(getMatchCount(winLotto));
    }


    public String buildLottoString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Iterator<LottoNo> itr = numbers.iterator();
        result.append(itr.next().getNumber());
        while (itr.hasNext()) {
            result.append(", " + itr.next().getNumber());
        }
        result.append("]");
        return result.toString();
    }

    boolean isValidLottoNumbers() {

        if (!isValidSize())
            return false;

        return true;
    }

    private boolean isValidSize() {
        if (numbers == null)
            throw new IllegalArgumentException();

        if (Lotto.A_LOTTO_COUNT != numbers.size())
            return false;
        return true;
    }

    public int getMatchCount(Lotto winLotto) {
        return winLotto.getNumbers().stream()
                .filter(number -> numbers.contains(number))
                .collect(Collectors.toList()).size();
    }
}
