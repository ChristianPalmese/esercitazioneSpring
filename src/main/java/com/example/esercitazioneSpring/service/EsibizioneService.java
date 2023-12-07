package com.example.esercitazioneSpring.service;

import com.example.esercitazioneSpring.modello.Esibizione;
import com.example.esercitazioneSpring.repos.EsibizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EsibizioneService {

    @Autowired
    private EsibizioneRepository esibizioneRepository;


    public void inserimento(Esibizione esibizione){
        esibizioneRepository.save(esibizione);
    }

    public List<Esibizione> findAllEsibizione (){
        return esibizioneRepository.findAll();
    }

    public Esibizione findById (Integer id){
        return esibizioneRepository.findById(id).get();
    }

    public void delete (Integer id){
        esibizioneRepository.deleteById(id);
    }

    public void update (Integer id, Esibizione esibizione){
        Esibizione esibizioneUpdate = esibizioneRepository.findById(id).get();
        esibizioneUpdate.setDataApertura(esibizione.getDataApertura());
        esibizioneUpdate.setTitolo(esibizione.getTitolo());
        esibizioneUpdate.setDurataGiorni(esibizione.getDurataGiorni());
        esibizioneRepository.save(esibizioneUpdate);

    }

}
