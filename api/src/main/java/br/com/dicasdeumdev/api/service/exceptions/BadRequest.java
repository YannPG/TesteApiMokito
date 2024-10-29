package br.com.dicasdeumdev.api.service.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class BadRequest extends DataIntegrityViolationException {

  public BadRequest(String msg) {
    super(msg);
  }
}
