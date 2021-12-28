package br.com.cursoudemy.productapi.config.interceptor;

import static br.com.cursoudemy.productapi.config.RequestUtil.getCurrentRequest;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignClientAuthInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION = "Authorization";
    private static final String TRANSACTION_ID = "transactionid";

    @Override
    public void apply(RequestTemplate template) {
        var currentRequest = getCurrentRequest();
        template
            .header(AUTHORIZATION, currentRequest.getHeader(AUTHORIZATION))
            .header(TRANSACTION_ID, currentRequest.getHeader(TRANSACTION_ID));
    }
}
