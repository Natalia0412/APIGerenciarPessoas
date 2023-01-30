package com.example.GerenciarPessoas.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import com.example.GerenciarPessoas.entities.enums.EnderecoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;
    @Enumerated(EnumType.STRING)
    private EnderecoEnum enderecoEnum;
    @JsonIgnore
    //@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pessoa pessoa;

}