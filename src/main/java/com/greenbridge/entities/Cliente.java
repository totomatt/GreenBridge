
package com.greenbridge.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cognome;
    private Date dataDiNascita;
    private String email;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String nome;
    private String password;

    public Cliente(String cognome, Date dataDiNascita, String email, String nome, String password) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.nome = nome;
        this.password = password;
    }




}