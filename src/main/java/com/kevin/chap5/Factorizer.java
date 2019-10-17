package com.kevin.chap5;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 类名: Factorizer<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/17 18:43<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Factorizer extends GenericServlet {

    private final Computable<BigInteger, BigInteger[]> c =
            new Computable<BigInteger, BigInteger[]>() {
                public BigInteger[] compute(BigInteger arg) {
                    return factor(arg);
                }
            };
    private final Computable<BigInteger, BigInteger[]> cache
            = new Memorizer<>(c);

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    void encodeError(ServletResponse resp, String errorString) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
