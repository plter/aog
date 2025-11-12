/*
@author https://yunp.top
 */
package top.yunp.asws.http;

public interface IHttpResponse {

    void setStatus(int code);

    void write(String message);

    void setContentType(String contentType);
}
