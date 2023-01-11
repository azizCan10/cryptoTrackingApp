package com.test.cryptotrackapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.Scanner;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
        || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            //
        }
        else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            //
            if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
                Scanner s = new Scanner(response.getBody()).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";

                throw new SymbolNotFoundException(result);
            }
        }
    }
}
