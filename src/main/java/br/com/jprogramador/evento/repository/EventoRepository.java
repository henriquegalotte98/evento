package br.com.jprogramador.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jprogramador.evento.entity.Evento;
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
