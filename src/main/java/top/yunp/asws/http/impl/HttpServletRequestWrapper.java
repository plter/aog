package top.yunp.asws.http.impl;

import jakarta.servlet.http.HttpServletRequest;
import top.yunp.asws.http.IHttpRequest;

public class HttpServletRequestWrapper implements IHttpRequest {

    private final HttpServletRequest req;

    public HttpServletRequestWrapper(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public String getUri() {
        return req.getRequestURI();
    }

    @Override
    public String getMethod() {
        return req.getMethod();
    }
}
