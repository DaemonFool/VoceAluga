package com.cefet.VoceAluga.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "maintenances")
public class maintenance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name= "idveiculo")
    private vehicle idveiculo;
    @ManyToOne
    @JoinColumn(name= "idmecanico")
    private employee idmecanico;
    private String sitveiculo;
    private String valor;

    public maintenance(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public vehicle getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(vehicle idveiculo) {
        this.idveiculo = idveiculo;
    }

    public employee getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(employee idmecanico) {
        this.idmecanico = idmecanico;
    }

    public String getSitveiculo() {
        return sitveiculo;
    }

    public void setSitveiculo(String sitveiculo) {
        this.sitveiculo = sitveiculo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        maintenance that = (maintenance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
