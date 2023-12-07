package com.example.esercitazioneSpring.modello;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.AjAttribute;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Esibizione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titolo;
    private String dataApertura;
    private Integer durataGiorni;

    @OneToMany(mappedBy = "esibizioneRelazione", cascade = CascadeType.ALL)
    private List<RelazioneDipintoEsibizione> esibizioneRelazione = new ArrayList<>();



    public Esibizione(String titolo, String dataApertura, Integer durataGiorni){
        this.titolo=titolo;
        this.dataApertura=dataApertura;
        this.durataGiorni=durataGiorni;
    }

    public void addRelazioneDipintoRelazione(RelazioneDipintoEsibizione relazioneDipintoEsibizione){
        esibizioneRelazione.add(relazioneDipintoEsibizione);
    }


    @Override
    public String toString() {
        return "Esibizione{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataApertura=" + dataApertura +
                ", durataGiorni=" + durataGiorni +
                '}';
    }
}
