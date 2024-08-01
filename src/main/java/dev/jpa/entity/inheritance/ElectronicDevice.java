package dev.jpa.entity.inheritance;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ElectronicDevice extends ProductInSale {

    private String model;

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "id='" + id + '\'' +
                ", model=" + model +
                '}';
    }
}
