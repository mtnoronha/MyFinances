package model.parceiro;

import java.sql.Date;
import java.util.ArrayList;

public class ParceiroComercial {

    private int id;
    private boolean fisica,funcionario, fornecedor, cliente;
    private String dadosAdicionais;
    private String nome, rg, cpf;
    private Date dataNascimento;
    boolean deletado;
    private String cnpj, razaoSocial, nomeFantasia;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    //pessoa física
    public ParceiroComercial(boolean funcionario, boolean fornecedor, boolean cliente, String dadosAdicionais, String nome, String rg, String cpf, Date dataNascimento) {
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        this.dadosAdicionais = dadosAdicionais;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        contatos = new ArrayList<Contato>();
        enderecos = new ArrayList<Endereco>();
        this.setFisica(true);
        this.setDeletado(false);
    }

    //pessoa juridica
    public ParceiroComercial(boolean funcionario, boolean fornecedor, boolean cliente, String dadosAdicionais, String cnpj, String razaoSocial, String nomeFantasia) {
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.cliente = cliente;
        this.dadosAdicionais = dadosAdicionais;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        contatos = new ArrayList<Contato>();
        enderecos = new ArrayList<Endereco>();
        this.setFisica(false);
        this.setDeletado(false);
    }
    
    

    public void addContato(Contato c) {
        contatos.add(c);
    }

    public void retContato(Contato c) {
        contatos.remove(c);
    }

    public void addEndereco(Endereco e) {
        enderecos.add(e);
    }

    public void remEndereco(Endereco e) {
        enderecos.remove(e);
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    
    public boolean isFisica() {
        return fisica;
    }

    public void setFisica(boolean fisica) {
        this.fisica = fisica;
    }
    
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(String dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

    public boolean isFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(boolean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
