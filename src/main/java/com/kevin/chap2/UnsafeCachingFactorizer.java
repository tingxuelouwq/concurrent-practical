package com.kevin.chap2;

import com.kevin.annotation.NotThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类名: UnsafeCachingFactorizer<br/>
 * 包名：com.kevin.chap2<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/20 15:48<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@NotThreadSafe
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {

    private final AtomicReference<BigInteger> lastNumber =
            new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors =
            new AtomicReference<>();

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(resp, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    private BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }
}
