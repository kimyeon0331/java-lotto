package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNoTest {

    @Test
    public void isBoundaryTest() {
        assertEquals(true, LottoNo.isBoundary(1));
        assertEquals(true, LottoNo.isBoundary(45));
        assertEquals(false, LottoNo.isBoundary(0));
        assertEquals(false, LottoNo.isBoundary(46));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createLottoNoTest() {
        LottoNo lottoNo = LottoNo.valueOf(46);
    }

    @Test
    public void valueOfTest() {
        assertEquals(LottoNo.valueOf(3), LottoNo.valueOf(3));
    }
}