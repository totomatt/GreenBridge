package com.greenbridge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Prodotto {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String descrizione;
    private int quantita;

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                '}';
    }

    private float prezzo;
    public Prodotto(String nome, String descrizione, int quantita, float prezzo){
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita= quantita;
        this.prezzo = prezzo;
    }
}
