package com.example.GerenciarPessoas.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EnderecoEnum {
    PRINCIPAL(1),
    SECUNDARIO(2);
    private int code;
    public static EnderecoEnum valueOf(int code){
        for(EnderecoEnum value: EnderecoEnum.values()){
            if(value.getCode()== code) {
                return value;
            }
        }
        throw new IllegalArgumentException("opções inválidas");
    }

}
