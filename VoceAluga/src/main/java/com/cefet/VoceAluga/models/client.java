package com.cefet.VoceAluga.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;
    private String Dt_nasc;
    private Long CPF;
    private String Endereco;
    private Long Telefone;
    @OneToMany(mappedBy = "idcliente")
    private List<rental> rentals = new ArrayList<>();

    public client(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDt_nasc() {
        return Dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        Dt_nasc = dt_nasc;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public Long getTelefone() {
        return Telefone;
    }

    public void setTelefone(Long telefone) {
        Telefone = telefone;
    }

    public List<rental> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        client client = (client) o;
        return Objects.equals(id, client.id) && Objects.equals(CPF, client.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CPF);
    }
}
