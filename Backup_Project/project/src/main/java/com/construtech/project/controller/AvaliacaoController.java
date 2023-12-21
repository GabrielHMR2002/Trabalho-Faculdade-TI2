package com.construtech.project.controller;

import com.construtech.project.models.Avaliacao;
import com.construtech.project.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("/{cpf}")
    public Avaliacao buscarAvaliacaoPorCpf(@PathVariable String cpf) {
        return avaliacaoService.buscarAvaliacaoPorCpf(cpf);
    }

    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.criarAvaliacao(avaliacao);
    }
/* 
@PostMapping
public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
    Avaliacao novaAvaliacao = avaliacaoService.criarAvaliacao(avaliacao);
    return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaliacao);
}
*/
    @DeleteMapping("/{cpf}")
    public void excluirAvaliacao(@PathVariable String cpf) {
        avaliacaoService.excluirAvaliacao(cpf);
    }

    @GetMapping("/porcentagem/nivel")
    public Map<String, Object> calcularPorcentagemAvaliacoes() {
        Map<String, Object> porcentagens = new HashMap<>();

        // Obtenha a lista de avaliações
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();

        // Calcule as porcentagens das opções de avaliação
        int totalAvaliacoes = avaliacoes.size();
        long bomCount = avaliacoes.stream().filter(a -> "Bom".equals(a.getEscolha())).count();
        long excelenteCount = avaliacoes.stream().filter(a -> "Excelente".equals(a.getEscolha())).count();
        long regularCount = avaliacoes.stream().filter(a -> "Regular".equals(a.getEscolha())).count();
        long insatisfatorioCount = avaliacoes.stream().filter(a -> "Insatisfatório".equals(a.getEscolha())).count();

        double porcentagemBom = (double) (bomCount * 100) / totalAvaliacoes;
        double porcentagemExcelente = (double) (excelenteCount * 100) / totalAvaliacoes;
        double porcentagemRegular = (double) (regularCount * 100) / totalAvaliacoes;
        double porcentagemInsatisfatorio = (double) (insatisfatorioCount * 100) / totalAvaliacoes;

        // Calcule a porcentagem de votos por sexo
        Map<String, Double> porcentagemSexo = new HashMap<>();
        porcentagemSexo.put("Masculino", calcularPorcentagemSexo(avaliacoes, "Masculino"));
        porcentagemSexo.put("Feminino", calcularPorcentagemSexo(avaliacoes, "Feminino"));

        // Calcule a porcentagem de pessoas que recomendariam e não recomendariam
        Map<String, Double> porcentagemIndicacao = new HashMap<>();
        porcentagemIndicacao.put("Sim", calcularPorcentagemIndicacao(avaliacoes, "Sim"));
        porcentagemIndicacao.put("Não", calcularPorcentagemIndicacao(avaliacoes, "Não"));

        porcentagens.put("Bom", porcentagemBom);
        porcentagens.put("Excelente", porcentagemExcelente);
        porcentagens.put("Regular", porcentagemRegular);
        porcentagens.put("Insatisfatório", porcentagemInsatisfatorio);
        porcentagens.put("PorcentagemSexo", porcentagemSexo);
        porcentagens.put("PorcentagemIndicacao", porcentagemIndicacao);
        porcentagens.put("TotalVotos", totalAvaliacoes);

        return porcentagens;
    }

    private double calcularPorcentagemSexo(List<Avaliacao> avaliacoes, String sexo) {
        long sexoCount = avaliacoes.stream().filter(a -> sexo.equals(a.getSexo())).count();
        return (double) (sexoCount * 100) / avaliacoes.size();
    }

    private double calcularPorcentagemIndicacao(List<Avaliacao> avaliacoes, String indicacao) {
        long indicacaoCount = avaliacoes.stream().filter(a -> indicacao.equals(a.getIndicacao())).count();
        return (double) (indicacaoCount * 100) / avaliacoes.size();
    }

    @GetMapping("/porcentagem")
    public Map<String, Object> calcularPorcentagensAvaliacoes() {
        Map<String, Object> porcentagens = new HashMap<>();
        List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();

        // Porcentagem de homens e mulheres que avaliaram
        double porcentagemHomens = calcularPorcentagemSexo(avaliacoes, "Masculino");
        double porcentagemMulheres = calcularPorcentagemSexo(avaliacoes, "Feminino");

        // Porcentagem de cada faixa etária que avaliou
        Map<String, Double> porcentagemFaixaEtaria = calcularPorcentagemFaixaEtaria(avaliacoes);

        // Porcentagem de indicação do site ou não
        Map<String, Double> porcentagemIndicacao = calcularPorcentagemIndicacao(avaliacoes);

        porcentagens.put("PorcentagemHomens", porcentagemHomens);
        porcentagens.put("PorcentagemMulheres", porcentagemMulheres);
        porcentagens.put("PorcentagemFaixaEtaria", porcentagemFaixaEtaria);
        porcentagens.put("PorcentagemIndicacao", porcentagemIndicacao);

        return porcentagens;
    }

    private Map<String, Double> calcularPorcentagemFaixaEtaria(List<Avaliacao> avaliacoes) {
        Map<String, Double> porcentagens = new HashMap<>();
        Map<String, Long> contagemPorFaixaEtaria = avaliacoes.stream()
                .collect(Collectors.groupingBy(Avaliacao::getIdade, Collectors.counting()));

        for (String faixaEtaria : contagemPorFaixaEtaria.keySet()) {
            double porcentagem = (contagemPorFaixaEtaria.get(faixaEtaria) * 100.0) / avaliacoes.size();
            porcentagens.put(faixaEtaria, porcentagem);
        }

        return porcentagens;
    }

    private Map<String, Double> calcularPorcentagemIndicacao(List<Avaliacao> avaliacoes) {
        Map<String, Double> porcentagens = new HashMap<>();
        Map<String, Long> contagemPorIndicacao = avaliacoes.stream()
                .collect(Collectors.groupingBy(Avaliacao::getIndicacao, Collectors.counting()));

        for (String indicacao : contagemPorIndicacao.keySet()) {
            double porcentagem = (contagemPorIndicacao.get(indicacao) * 100.0) / avaliacoes.size();
            porcentagens.put(indicacao, porcentagem);
        }

        return porcentagens;
    }
    @GetMapping("/porcentagem/votos")
public Map<String, Double> calcularPorcentagemVotos() {
    Map<String, Double> porcentagens = new HashMap<>();
    List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();

    // Filtrar avaliações de homens e mulheres
    List<Avaliacao> avaliacoesHomens = avaliacoes.stream().filter(a -> "Masculino".equals(a.getSexo())).collect(Collectors.toList());
    List<Avaliacao> avaliacoesMulheres = avaliacoes.stream().filter(a -> "Feminino".equals(a.getSexo())).collect(Collectors.toList());

    // Calcular porcentagem de votos "Sim" e "Não" para homens
    double porcentagemHomensSim = calcularPorcentagemVotos(avaliacoesHomens, "Sim");
    double porcentagemHomensNao = calcularPorcentagemVotos(avaliacoesHomens, "Não");

    // Calcular porcentagem de votos "Sim" e "Não para mulheres
    double porcentagemMulheresSim = calcularPorcentagemVotos(avaliacoesMulheres, "Sim");
    double porcentagemMulheresNao = calcularPorcentagemVotos(avaliacoesMulheres, "Não");

    porcentagens.put("PorcentagemHomensSim", porcentagemHomensSim);
    porcentagens.put("PorcentagemHomensNao", porcentagemHomensNao);
    porcentagens.put("PorcentagemMulheresSim", porcentagemMulheresSim);
    porcentagens.put("PorcentagemMulheresNao", porcentagemMulheresNao);

    return porcentagens;
}

private double calcularPorcentagemVotos(List<Avaliacao> avaliacoes, String voto) {
    long votoCount = avaliacoes.stream().filter(a -> voto.equals(a.getIndicacao())).count();
    return (double) (votoCount * 100) / avaliacoes.size();
}


}
