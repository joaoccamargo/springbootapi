package io.github.joaoccamargo.springbootapi.domain.exception;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String message){
        super(message);
    }
}
