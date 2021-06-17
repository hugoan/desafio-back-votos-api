package br.com.cooperativa.desafiobackvotos.api.service;

import br.com.cooperativa.desafiobackvotos.api.domain.dtos.ResultadoVotacaoOutputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.dtos.VotoInputDTO;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Associado;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Sessao;
import br.com.cooperativa.desafiobackvotos.api.domain.entity.Voto;
import br.com.cooperativa.desafiobackvotos.api.domain.enumeration.TipoVoto;
import br.com.cooperativa.desafiobackvotos.api.exceptions.NegocioException;
import br.com.cooperativa.desafiobackvotos.api.exceptions.RecursoNaoEncontradoException;
import br.com.cooperativa.desafiobackvotos.api.helpers.MessageHelper;
import br.com.cooperativa.desafiobackvotos.api.repositories.AssociadoRepository;
import br.com.cooperativa.desafiobackvotos.api.repositories.SessaoRepository;
import br.com.cooperativa.desafiobackvotos.api.repositories.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
    private final AssociadoRepository associadoRepository;
    private final SessaoRepository sessaoRepository;
    private final UserInfoService userInfoService;
    private final MessageHelper messageHelper;

    public void save(VotoInputDTO inputDTO) {
        var sessao = sessaoRepository.findByPauta_id(inputDTO.getIdPauta());
        var associado = associadoRepository.findById(inputDTO.getIdAssociado());

        validarVoto(inputDTO, sessao, associado);

        Voto voto = new Voto();
        voto.setVoto(inputDTO.getVoto());
        voto.setAssociado(associado.get());
        voto.setSessao(sessao.get());

        votoRepository.save(voto);
    }

    public ResultadoVotacaoOutputDTO consultResultadoVotacao(Long idPauta) {
        var sessao = sessaoRepository.findByPauta_id(idPauta);

        if (sessao.isPresent()) {
            if (isSessaoVotacaoEncerrada(sessao)) {
                ResultadoVotacaoOutputDTO resultado = new ResultadoVotacaoOutputDTO();
                resultado.setSessao(sessao.get());
                resultado.setTotalSim(votoRepository.countVotoBySessao_idAndVoto(sessao.get().getId(), TipoVoto.SIM));
                resultado.setTotalNao(votoRepository.countVotoBySessao_idAndVoto(sessao.get().getId(), TipoVoto.NAO));
                return resultado;
            } else {
                throw new NegocioException(messageHelper.getMessage("sessao.votacao.aberta"));
            }
        }
        throw new RecursoNaoEncontradoException(messageHelper.getMessage("registro.inexistente.sessao.pauta"));
    }

    private void validarVoto(VotoInputDTO inputDTO, Optional<Sessao> sessao,
                             Optional<Associado> associado) {
        if (!sessao.isPresent()) {
            throw new NegocioException(messageHelper.getMessage("registro.inexistente.sessao.pauta"));
        }

        if (!associado.isPresent()) {
            throw new NegocioException(messageHelper.getMessage("registro.inexistente.associado"));
        }

        if (isSessaoVotacaoEncerrada(sessao)) {
            throw new NegocioException(messageHelper.getMessage("sessao.votacao.encerrada"));
        }

        if (votoRepository.existsVotoByAssociado_IdAndSessao_Pauta_Id(inputDTO.getIdAssociado(), inputDTO.getIdPauta())) {
            throw new NegocioException(messageHelper.getMessage("voto.existente.associado"));
        }

        var statusUserInfo = userInfoService.consultarStatusVotacaoAssociado(associado.get().getCpf());

        if (statusUserInfo.equals("UNABLE_TO_VOTE")) {
            throw new NegocioException(messageHelper.getMessage("voto.nao.autorizado"));
        }

    }

    private boolean isSessaoVotacaoEncerrada(Optional<Sessao> sessao) {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).isAfter(sessao.get().getDataHoraFim());
    }

}
