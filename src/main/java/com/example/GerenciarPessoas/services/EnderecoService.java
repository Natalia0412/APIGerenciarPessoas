package com.example.GerenciarPessoas.services;

import com.example.GerenciarPessoas.dto.EnderecoDTO;
import com.example.GerenciarPessoas.entities.Endereco;
import com.example.GerenciarPessoas.entities.Pessoa;
import com.example.GerenciarPessoas.maps.EnderecoConvert;
import com.example.GerenciarPessoas.repositories.EnderecoRepository;
import com.example.GerenciarPessoas.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id) {
        Optional<Endereco> opt=enderecoRepository.findById(id);
        return opt.get();
    }

    public EnderecoDTO insertEndereco(EnderecoDTO obj){
        Endereco endereco = EnderecoConvert.enderecoDTOToEndereco(obj);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(obj.getPessoaId());
        if(pessoaOptional.isPresent()){
            endereco.setPessoa(pessoaOptional.get());
        } else {
            throw new RuntimeException("Pessoa não foi encontrada!");
        }
        return EnderecoConvert.enderecoToEnderecoDTO(enderecoRepository.save(endereco)) ;
    }

    public EnderecoDTO update(Long id, EnderecoDTO obj) {
        Optional<Pessoa> pessoaId = pessoaRepository.findById(obj.getPessoaId());
        boolean existeId=pessoaRepository.existsById(id);
        if(existeId && pessoaId.isPresent()){
            Endereco endereco=EnderecoConvert.enderecoDTOToEndereco(obj);
            endereco.setId(id);
           // endereco.setPessoa(endereco.getPessoa().getId());
            endereco.setPessoa(pessoaId.get());
            return EnderecoConvert.enderecoToEnderecoDTO(enderecoRepository.save(endereco));
        }else{
            throw  new RuntimeException("Endereço não encontrado");
        }
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
