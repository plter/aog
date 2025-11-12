/*
@author https://yunp.top
 */
package top.yunp.asws.http.impl;

import jakarta.servlet.http.HttpServletResponse;
import top.yunp.asws.http.IHttpResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletResponseWrapper implements IHttpResponse {
    private HttpServletResponse res;
    private PrintWriter writer;

    public HttpServletResponseWrapper(HttpServletResponse res) throws IOException {
        this.res = res;
        writer = res.getWriter();
    }

    @Override
    public void setStatus(int code) {
        res.setStatus(code);
    }

    @Override
    public void write(String message) {
        writer.write(message);
    }

    @Override
    public void setContentType(String contentType) {
        res.setContentType(contentType);
    }
}
