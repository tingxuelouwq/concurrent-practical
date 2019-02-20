package com.kevin.chap2;

import com.kevin.annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 类名: CountingFactorizer<br/>
 * 包名：com.kevin.chap2<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/20 15:16<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@ThreadSafe
public class CountingFactorizer extends GenericServlet implements Servlet {

    private final AtomicLong count = new AtomicLong(0);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    public long getCount() {
        return count.get();
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
