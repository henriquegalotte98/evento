package br.com.jprogramador.evento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jprogramador.evento.entity.Evento;
import br.com.jprogramador.evento.exception.RecursoNaoEncontradoException;
import br.com.jprogramador.evento.repository.EventoRepository;

@Service
public class EventoService {
    public final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento salvar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Evento com id" + id + "não encontrado"));
    }

    public Evento atualizar(Long id, Evento eventoAtualizado) {
        Evento eventoExistente = buscarPorId(id);
        eventoExistente.setNome(eventoAtualizado.getNome());
        eventoExistente.setLocal(eventoAtualizado.getLocal());
        eventoExistente.setData(eventoAtualizado.getData());
        eventoExistente.setDescricao(eventoAtualizado.getDescricao());

        return eventoRepository.save(eventoExistente);

    }
    public void deletar(Long id){
        Evento eventoExistente = buscarPorId(id);
        eventoRepository.delete(eventoExistente);
    }
}
