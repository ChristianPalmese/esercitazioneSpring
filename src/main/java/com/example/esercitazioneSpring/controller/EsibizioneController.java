package com.example.esercitazioneSpring.controller;

import com.example.esercitazioneSpring.modello.Esibizione;
import com.example.esercitazioneSpring.service.EsibizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("/esibizione")
public class EsibizioneController {

    @Autowired
     private EsibizioneService esibizioneService;

    @PostMapping("/add")
    private ResponseEntity<String> inserimento(@RequestBody Esibizione esibizione) {
        esibizioneService.inserimento(esibizione);
        // Restituisci una risposta "200 OK"
        return new ResponseEntity<>("Inserimento eseguito con successo", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private ResponseEntity<List<Esibizione>> findAll() {
        List<Esibizione> esibizioni = esibizioneService.findAllEsibizione();
        // Restituisci una risposta "200 OK" con la lista delle esibizioni
        return new ResponseEntity<>(esibizioni, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<Esibizione> findById(@PathVariable Integer id) {
        Esibizione esibizione = esibizioneService.findById(id);
        if (esibizione != null) {
            // Restituisci una risposta "200 OK" con l'oggetto esibizione
            return new ResponseEntity<>(esibizione, HttpStatus.OK);
        } else {
            // Restituisci una risposta "404 Not Found" se l'esibizione non è stata trovata
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        esibizioneService.delete(id);
        // Restituisci una risposta "200 OK" con un messaggio di successo
        return new ResponseEntity<>("Eliminazione eseguita con successo", HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    private ResponseEntity<String> patch(@PathVariable("id") Integer id, @RequestBody Esibizione esibizione) {
        esibizioneService.update(id, esibizione);
        // Restituisci una risposta "200 OK" con un messaggio di successo
        return new ResponseEntity<>("Aggiornamento eseguito con successo", HttpStatus.OK);
    }


}
