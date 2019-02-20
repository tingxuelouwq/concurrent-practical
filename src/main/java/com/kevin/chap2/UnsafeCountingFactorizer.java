package com.kevin.chap2;

import com.kevin.annotation.NotThreadSafe;

import javax.servlet.*;
import java.math.BigInteger;

/**
 * 类名: UnsafeCountingFactorizer<br/>
 * 包名：com.kevin.chap2<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/20 15:05<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@NotThreadSafe
public class UnsafeCountingFactorizer extends GenericServlet implements Servlet {

    private long count = 0;

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }

    public long getCount() {
        return count;
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
