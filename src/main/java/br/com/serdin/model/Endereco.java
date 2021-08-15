package br.com.serdin.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String cep;

    private String numero;

    private String logradouro;

    private String localidade;

    private String bairro;

    private String uf;

    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(String nome, String cep, String numero, String logradouro, String localidade, String bairro, String uf, String complemento) {
        this.nome = nome;
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Endereco(Integer id, String nome, String cep, String numero, String logradouro, String localidade, String bairro, String uf, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
