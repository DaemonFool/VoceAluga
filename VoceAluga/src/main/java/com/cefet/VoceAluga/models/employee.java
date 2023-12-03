package com.cefet.VoceAluga.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;
    private String Dt_nasc;
    private Long CPF;
    private String Endereco;
    private Long Telefone;
    private String horario;
    private String senha;
    @ManyToOne
    @JoinColumn(name= "funcao")
    private funcao Funcao;
    @ManyToOne
    @JoinColumn(name= "filial")
    private franchise filial;
    @OneToMany(mappedBy = "idatendimento")
    private List<rental> rentals = new ArrayList<>();
    @OneToMany(mappedBy = "idmecanico")
    private List<maintenance> maintenances = new ArrayList<>();

    public employee(){
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public funcao getFuncao() {
        return Funcao;
    }

    public void setFuncao(funcao funcao) {
        Funcao = funcao;
    }

    public franchise getFilial() {
        return filial;
    }

    public void setFilial(franchise filial) {
        this.filial = filial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<rental> getRentals() {
        return rentals;
    }

    public List<maintenance> getMaintenances() {
        return maintenances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(CPF, employee.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CPF);
    }
}
