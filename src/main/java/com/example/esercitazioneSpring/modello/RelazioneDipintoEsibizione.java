package com.example.esercitazioneSpring.modello;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Relation;

@Entity
@Data
@NoArgsConstructor
public class RelazioneDipintoEsibizione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Dipinto dipintoRelazione;
    @ManyToOne
    private Esibizione esibizioneRelazione;

    public RelazioneDipintoEsibizione(Dipinto dipinto, Esibizione esibizione){
        this.dipintoRelazione=dipinto;
        this.esibizioneRelazione=esibizione;
    }




}
