package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNo {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;
    static Map<Integer, LottoNo> lottoNoPool = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNoPool.put(i, new LottoNo(i));
        }
    }

    private LottoNo(int number) {
        this.number = number;

    }

    public static boolean isBoundary(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER)
            return true;
        return false;
    }

    public static LottoNo valueOf(int number) {
        if (!isBoundary(number))
            throw new IllegalArgumentException();
        return lottoNoPool.get(number);
    }

    public static LottoNo valueOf(String text) {
        return valueOf(Integer.parseInt(text));
    }

    public int getNumber() {
        return this.number;
    }
}
