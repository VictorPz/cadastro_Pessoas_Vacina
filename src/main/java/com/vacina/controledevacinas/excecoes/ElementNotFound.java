package com.vacina.controledevacinas.excecoes;

public class ElementNotFound extends RuntimeException {

    public ElementNotFound(String msg){
        super(msg);
    }
}
