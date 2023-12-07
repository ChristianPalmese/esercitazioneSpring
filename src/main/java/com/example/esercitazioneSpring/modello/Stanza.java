package com.example.esercitazioneSpring.modello;

import com.example.esercitazioneSpring.repos.DipintoRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Stanza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    public Stanza(String nome){
        this.nome=nome;
    }

    @OneToMany(mappedBy = "stanza", cascade = CascadeType.ALL)
    private List<Dipinto> dipinti = new ArrayList<>();



    public void addDipinto(Dipinto dipinto){
        dipinti.add(dipinto);
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
