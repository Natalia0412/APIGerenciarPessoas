package com.example.GerenciarPessoas.dto;

import com.example.GerenciarPessoas.entities.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;




}
