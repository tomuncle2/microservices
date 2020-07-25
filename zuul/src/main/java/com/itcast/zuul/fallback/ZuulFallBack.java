package com.itcast.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: 蔡迪
 * @date: 17:47 2020/7/25
 * @description: zuul fallback
 */

@Slf4j
@Component
public class ZuulFallBack implements FallbackProvider {


        @Override
        public String getRoute() {
            //return "microservice-provider-user";
            //微服务配了路由的话，就用配置的名称
            //return "customers";
            //如果要为所有路由提供默认回退，可以创建FallbackProvider类型的bean并使getRoute方法返回*或null
            return "*";
        }

        @Override
        public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
            if (cause instanceof HystrixTimeoutException) {
                return response(HttpStatus.GATEWAY_TIMEOUT);
            } else {
                return response(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        private ClientHttpResponse response(final HttpStatus status) {
            return new ClientHttpResponse() {
                @Override
                public HttpStatus getStatusCode() throws IOException {
                    //return status;
                    return HttpStatus.BAD_REQUEST;
                }

                @Override
                public int getRawStatusCode() throws IOException {
                    //return status.value();
                    return HttpStatus.BAD_REQUEST.value();
                }

                @Override
                public String getStatusText() throws IOException {
                    //return status.getReasonPhrase();
                    //return HttpStatus.BAD_REQUEST.name();
                    return HttpStatus.BAD_REQUEST.getReasonPhrase();
                }

                @Override
                public void close() {
                }

                @Override
                public InputStream getBody() throws IOException {
                    return new ByteArrayInputStream(("fallback:"+ZuulFallBack.this.getRoute()).getBytes());
                }

                @Override
                public HttpHeaders getHeaders() {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    return headers;
                }
            };
        }


}