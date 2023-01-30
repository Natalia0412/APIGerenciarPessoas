package com.example.GerenciarPessoas.entities.enums;

import lombok.Getter;


@Getter
public enum EnderecoEnum {
    PRINCIPAL(1,"Principal"),

    SECUNDARIO(2,"Secundario");

    private int code;

    private String descricao;

    EnderecoEnum(int code, String descricao){
        this.code=code;
        this.descricao=descricao;
    }

    public static EnderecoEnum valueOf(int code){
        for(EnderecoEnum value: EnderecoEnum.values()){
            if(value.getCode()== code) {
                return value;
            }
        }
        throw new IllegalArgumentException("opções inválidas");
    }

}
