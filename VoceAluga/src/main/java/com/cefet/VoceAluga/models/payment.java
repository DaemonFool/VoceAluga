package com.cefet.VoceAluga.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class payment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Instant data;
    private rental Rental;
    private Boolean paid;

    public payment(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public rental getRental() {
        return Rental;
    }

    public void setRental(rental rental) {
        Rental = rental;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        payment payment = (payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
