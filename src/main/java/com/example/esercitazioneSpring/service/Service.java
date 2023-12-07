package com.example.esercitazioneSpring.service;

import com.example.esercitazioneSpring.modello.Dipinto;
import com.example.esercitazioneSpring.modello.Esibizione;
import com.example.esercitazioneSpring.modello.RelazioneDipintoEsibizione;
import com.example.esercitazioneSpring.modello.Stanza;
import com.example.esercitazioneSpring.repos.DipintoRepository;
import com.example.esercitazioneSpring.repos.EsibizioneRepository;
import com.example.esercitazioneSpring.repos.StanzaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private EsibizioneRepository esibizioneRepository;
    @Autowired
    private StanzaRepository stanzaRepository;
    @Autowired
    private DipintoRepository dipintoRepository;

    /*
    @PostConstruct
    public void inserimentoDati(){
        Stanza stanzaArcobaleno= new Stanza("Arcobaleno");
        Stanza stanzaPrimavera= new Stanza("Primavera");
        Stanza stanzaDeiFiori= new Stanza("Dei Fiori");
        Stanza stanzaParadiso= new Stanza("Paradiso");
        Stanza stanzaEstasi= new Stanza("Estasi");

        Dipinto dipintoMaternita = new Dipinto("Maternita",1985,"Luca Gremisi", stanzaArcobaleno);

        Dipinto dipintoDonna = new Dipinto("Donna alla finestra",1988,"Luca Gremisi", stanzaPrimavera);

        Dipinto dipintoGirasoli = new Dipinto("Girasoli",1990,"Salvatori Alisi", stanzaDeiFiori);

        Dipinto dipintoNaturaMorta = new Dipinto("Natura Morta",1990,"Marco Andrisani", stanzaPrimavera);

        Dipinto dipintoAngeli = new Dipinto("Angeli",2000,"Miriam Losasso", stanzaParadiso);

        Dipinto dipintoPaesaggioMarino = new Dipinto("Paesaggio marino",1900,null, stanzaArcobaleno);

        Dipinto dipintoCampiDiGrano = new Dipinto("Campi di grano",2000,"Marco Andrisani", stanzaParadiso);



        Esibizione esibizioneArteNatura = new Esibizione("Arte e Natura", "2 Luglio 2006",2);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione = new RelazioneDipintoEsibizione(dipintoGirasoli,esibizioneArteNatura);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione1 = new RelazioneDipintoEsibizione(dipintoNaturaMorta,esibizioneArteNatura);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione2= new RelazioneDipintoEsibizione(dipintoCampiDiGrano,esibizioneArteNatura);

        Esibizione esibizioneLaDonnaNellaPittura = new Esibizione("La donna nella pittura", "12 Luglio 2006",3);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione3= new RelazioneDipintoEsibizione(dipintoMaternita,esibizioneLaDonnaNellaPittura);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione4 = new RelazioneDipintoEsibizione(dipintoDonna,esibizioneLaDonnaNellaPittura);



        Esibizione esibizioneArte= new Esibizione("Arte 2000", "12 Agosto 2006",2);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione5 = new RelazioneDipintoEsibizione(dipintoAngeli,esibizioneArte);
        RelazioneDipintoEsibizione relazioneDipintoEsibizione6 = new RelazioneDipintoEsibizione(dipintoCampiDiGrano,esibizioneArte);




        stanzaRepository.save(stanzaEstasi);
        stanzaRepository.save(stanzaArcobaleno);
        stanzaRepository.save(stanzaParadiso);
        stanzaRepository.save(stanzaPrimavera);
        stanzaRepository.save(stanzaDeiFiori);

        esibizioneRepository.save(esibizioneArteNatura);
        esibizioneRepository.save(esibizioneLaDonnaNellaPittura);
        esibizioneRepository.save(esibizioneArte);

        dipintoRepository.save(dipintoAngeli);
        dipintoRepository.save(dipintoGirasoli);
        dipintoRepository.save(dipintoDonna);
        dipintoRepository.save(dipintoMaternita);
        dipintoRepository.save(dipintoCampiDiGrano);
        dipintoRepository.save(dipintoNaturaMorta);
        dipintoRepository.save(dipintoPaesaggioMarino);

        esibizioneArte.addRelazioneDipintoRelazione(relazioneDipintoEsibizione5);
        dipintoAngeli.addRelazioneDipintoRelazione(relazioneDipintoEsibizione5);
        esibizioneArte.addRelazioneDipintoRelazione(relazioneDipintoEsibizione6);
        dipintoCampiDiGrano.addRelazioneDipintoRelazione(relazioneDipintoEsibizione6);

        esibizioneArteNatura.addRelazioneDipintoRelazione(relazioneDipintoEsibizione3);
        dipintoMaternita.addRelazioneDipintoRelazione(relazioneDipintoEsibizione3);
        esibizioneArteNatura.addRelazioneDipintoRelazione(relazioneDipintoEsibizione4);
        dipintoDonna.addRelazioneDipintoRelazione(relazioneDipintoEsibizione4);

        esibizioneArteNatura.addRelazioneDipintoRelazione(relazioneDipintoEsibizione);
        dipintoGirasoli.addRelazioneDipintoRelazione(relazioneDipintoEsibizione);
        esibizioneArteNatura.addRelazioneDipintoRelazione(relazioneDipintoEsibizione1);
        dipintoNaturaMorta.addRelazioneDipintoRelazione(relazioneDipintoEsibizione1);
        esibizioneArteNatura.addRelazioneDipintoRelazione(relazioneDipintoEsibizione2);
        dipintoCampiDiGrano.addRelazioneDipintoRelazione(relazioneDipintoEsibizione2);
        stanzaParadiso.addDipinto(dipintoCampiDiGrano);
        stanzaArcobaleno.addDipinto(dipintoPaesaggioMarino);
        stanzaParadiso.addDipinto(dipintoAngeli);
        stanzaPrimavera.addDipinto(dipintoNaturaMorta);
        stanzaDeiFiori.addDipinto(dipintoGirasoli);
        stanzaPrimavera.addDipinto(dipintoDonna);
        stanzaArcobaleno.addDipinto(dipintoMaternita);

        esibizioneRepository.save(esibizioneArteNatura);
        esibizioneRepository.save(esibizioneLaDonnaNellaPittura);
        esibizioneRepository.save(esibizioneArte);

        dipintoRepository.save(dipintoAngeli);
        dipintoRepository.save(dipintoGirasoli);
        dipintoRepository.save(dipintoDonna);
        dipintoRepository.save(dipintoMaternita);
        dipintoRepository.save(dipintoCampiDiGrano);
        dipintoRepository.save(dipintoNaturaMorta);
        dipintoRepository.save(dipintoPaesaggioMarino);

    }*/


}
