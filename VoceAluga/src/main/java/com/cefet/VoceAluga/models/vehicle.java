package com.cefet.VoceAluga.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
public class vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private String cor;
    private String tipo;
    private Character categoria;
    @ManyToOne
    @JoinColumn(name= "filial")
    private franchise filial;
    @JsonIgnore
    @OneToMany(mappedBy = "idveiculo")
    private List<rental> rentals = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "idveiculo")
    private List<maintenance> maintenances = new ArrayList<>();

    public vehicle(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public franchise getFilial() {
        return filial;
    }

    public void setFilial(franchise filial) {
        this.filial = filial;
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
        vehicle vehicle = (vehicle) o;
        return id == vehicle.id && Objects.equals(placa, vehicle.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa);
    }
}
