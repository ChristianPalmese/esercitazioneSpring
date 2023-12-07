package com.example.esercitazioneSpring.modello;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Dipinto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titolo;
    private Integer annoDiProduzione;
    private String autore;


    @ManyToOne
    private Stanza stanza;

    @OneToMany(mappedBy = "dipintoRelazione", cascade = CascadeType.ALL)
    private List<RelazioneDipintoEsibizione> dipintoRelazione = new ArrayList<>();

    public Dipinto(String titolo, Integer annoDiProduzione, String autore, Stanza stanza){
        this.titolo=titolo;
        this.annoDiProduzione=annoDiProduzione;
        this.autore=autore;
        this.stanza=stanza;
    }

    public void addRelazioneDipintoRelazione(RelazioneDipintoEsibizione relazioneDipintoEsibizione){
        dipintoRelazione.add(relazioneDipintoEsibizione);
    }

    @Override
    public String toString() {
        return "Dipinto{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoDiProduzione=" + annoDiProduzione +
                ", autore='" + autore +
                '}';
    }
}
