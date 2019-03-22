package com.kevin.chap3;

import com.kevin.annotation.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 类名: OneValueCache<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/20 14:26<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lasteFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lasteFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lasteFactors, lasteFactors.length);
        }
    }
}
