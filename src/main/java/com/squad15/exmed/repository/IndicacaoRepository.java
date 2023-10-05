package com.squad15.exmed.repository;

import com.squad15.exmed.models.Indicacao;
import com.squad15.exmed.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicacaoRepository extends JpaRepository<Indicacao, Long> {
    Long countByUsuarioIndicador(Usuario usuarioIndicador);

    boolean existsByUsuarioIndicado(Usuario usuarioIndicado);

    Long countByUsuarioIndicador_CodigoIndicacao(String codigoIndicacao);
}
