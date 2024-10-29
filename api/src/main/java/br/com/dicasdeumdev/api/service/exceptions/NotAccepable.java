package br.com.dicasdeumdev.api.service.exceptions;

import org.springframework.web.server.NotAcceptableStatusException;

public class NotAccepable extends NotAcceptableStatusException {

    public NotAccepable(String reason) {
        super(reason);
    }
}
