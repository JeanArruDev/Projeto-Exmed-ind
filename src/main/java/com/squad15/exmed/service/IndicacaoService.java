package com.squad15.exmed.service;

import com.squad15.exmed.models.Indicacao;
import com.squad15.exmed.models.Usuario;
import com.squad15.exmed.repository.IndicacaoRepository;
import com.squad15.exmed.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IndicacaoRepository indicacaoRepository;

    public boolean indicarUsuario(String codigoIndicacao, Long idUsuarioIndicado) {
        Usuario usuarioIndicador = usuarioRepository.findByCodigoIndicacao(codigoIndicacao);
        if (usuarioIndicador == null) {
            return false;
        }

        Usuario usuarioIndicado = usuarioRepository.findById(idUsuarioIndicado).orElse(null);
        if (usuarioIndicado == null) {
            return false;
        }

        boolean usuarioJaIndicado = indicacaoRepository.existsByUsuarioIndicado(usuarioIndicado);
        if (usuarioJaIndicado) {
            return false;
        }

        Indicacao indicacao = new Indicacao();
        indicacao.setReceberCodIndicacao(codigoIndicacao);
        indicacao.setUsuarioIndicador(usuarioIndicador);
        indicacao.setUsuarioIndicado(usuarioIndicado);
        indicacaoRepository.save(indicacao);

        return true;
    }



}

