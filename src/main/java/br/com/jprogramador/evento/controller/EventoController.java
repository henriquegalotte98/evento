package br.com.jprogramador.evento.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jprogramador.evento.entity.Evento;
import br.com.jprogramador.evento.service.EventoService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/eventos")
@Validated
public class EventoController {

    private final EventoService eventoService;
    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<List<Evento>> listarTodos(){
        List<Evento> eventos = eventoService.listarTodos();
        return ResponseEntity.ok(eventos);
    }
    @GetMapping
    public ResponseEntity<List<Evento>> listarTodos(){
        List<Evento> eventos = eventoService.listarTodos();
        return ResponseEntity.ok(eventos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Evento>atualizar(@PathVariable Long id, @Valid @RequestBody Evento evento){
        Evento eventoAtualizado = eventoService.atualizar(id,evento);
        return ResponseEntity.ok(eventoAtualizado);
    }
    @DeleteMapping("/{id")
    public ResponseEntity<MensagemResponse> deletar(@PathVariable Long id){
        eventoService.deletar(id);
        return ResponseEntity.ok(new MensagemResponse("Evento removido com sucesso"));
    }
}
