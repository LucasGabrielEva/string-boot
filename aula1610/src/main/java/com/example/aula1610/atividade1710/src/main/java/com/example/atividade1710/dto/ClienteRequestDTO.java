package com.example.atividade1710.dto;

import com.example.atividade1710.model.EnderecoModel;
import com.example.atividade1710.model.FormaPagamento;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ParameterScriptAssert;

public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatorio.")
    @Email(message = "Deve ser um e-mail válido.")
    private String email;

    @NotBlank(message = "Telefone Obrigatorio")
    private String telefone;

    @NotBlank(message = "A forma de pagamento e obrigatorio" )
    @Pattern(regexp = "CARTAO | PIX | DINHEIRO", message = "O status deve ser um dos seguintes valores:CARTAO, PIX, DINHEIRO")
    private FormaPagamento formaPagamento;


    @NotBlank(message = "O endereco e obrigatorio")
    private EnderecoModel endereco;

    @NotBlank(message = "A senha é obrigatoria.")
    @Size(min = 3, max = 20, message = "A senha deve ter entre 3 a 20 caracteres.")
    private String senha;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String email, String telefone, FormaPagamento formaPagamento, EnderecoModel endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Telefone Obrigatorio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Telefone Obrigatorio") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "A forma de pagamento e obrigatorio") @Pattern(regexp = "CARTAO | PIX | DINHEIRO", message = "O status deve ser um dos seguintes valores:CARTAO, PIX, DINHEIRO") FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(@NotBlank(message = "A forma de pagamento e obrigatorio") @Pattern(regexp = "CARTAO | PIX | DINHEIRO", message = "O status deve ser um dos seguintes valores:CARTAO, PIX, DINHEIRO") FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public @NotBlank(message = "O endereco e obrigatorio") EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank(message = "O endereco e obrigatorio") EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public @NotBlank(message = "A senha é obrigatoria.") @Size(min = 3, max = 20, message = "A senha deve ter entre 3 a 20 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatoria.") @Size(min = 3, max = 20, message = "A senha deve ter entre 3 a 20 caracteres.") String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ClienteRequestDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", formaPagamento=" + formaPagamento +
                ", endereco=" + endereco +
                ", senha='" + senha + '\'' +
                '}';
    }
}
