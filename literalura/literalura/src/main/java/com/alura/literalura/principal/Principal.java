package com.alura.literalura.principal;

import com.alura.literalura.model.BookData;
import com.alura.literalura.model.RawData;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/";

    private BookRepository repositorio;

    public Principal(BookRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma                                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosEmAnoEspecifico();
                    break;
                case 5:
                    listarLivrosEmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void listarLivrosEmDeterminadoIdioma() {
    }

    private void listarAutoresVivosEmAnoEspecifico() {

    }

    private void listarAutores() {

    }

    private void listarLivros() {

    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o livro a ser pesquisado");
        String nomeLivro = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        System.out.println(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        RawData rawData = conversor.obterDados(json, RawData.class);

        System.out.println(rawData.count());
    }

    private void buscarSerieWeb() {
//        DadosSerie dados = getDadosSerie();
//        Serie serie = new Serie(dados);
//        //dadosSeries.add(dados);
//        repositorio.save(serie);
//        System.out.println(dados);
    }

    private void getDadosSerie() {
//        System.out.println("Digite o nome da série para busca");
//        var nomeSerie = leitura.nextLine();
//        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//        return dados;
    }

    private void buscarEpisodioPorSerie(){
//        listarSeriesBuscadas();
//        System.out.println("Escolha uma série pelo nome");
//        var nomeSerie = leitura.nextLine();
//
//        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);
//
//        if(serie.isPresent()) {
//
//            var serieEncontrada = serie.get();
//            List<DadosTemporada> temporadas = new ArrayList<>();
//
//            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
//                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
//                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//                temporadas.add(dadosTemporada);
//            }
//            temporadas.forEach(System.out::println);
//
//            List<Episodio> episodios = temporadas.stream()
//                    .flatMap(d -> d.episodios().stream()
//                            .map(e -> new Episodio(d.numero(), e)))
//                    .collect(Collectors.toList());
//
//            serieEncontrada.setEpisodios(episodios);
//            repositorio.save(serieEncontrada);
//        } else {
//            System.out.println("Série não encontrada!");
//        }
    }

    private void listarSeriesBuscadas(){
//        series = repositorio.findAll();
//        series.stream()
//                .sorted(Comparator.comparing(Serie::getGenero))
//                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
//        System.out.println("Escolha um série pelo nome: ");
//        var nomeSerie = leitura.nextLine();
//        serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);
//
//        if (serieBusca.isPresent()) {
//            System.out.println("Dados da série: " + serieBusca.get());
//
//        } else {
//            System.out.println("Série não encontrada!");
//        }

    }

    private void buscarSeriesPorAtor() {
//        System.out.println("Qual o nome para busca?");
//        var nomeAtor = leitura.nextLine();
//        System.out.println("Avaliações a partir de que valor? ");
//        var avaliacao = leitura.nextDouble();
//        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);
//        System.out.println("Séries em que " + nomeAtor + " trabalhou: ");
//        seriesEncontradas.forEach(s ->
//                System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }

    private void buscarTop5Series() {
//        List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
//        serieTop.forEach(s ->
//                System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
    }

    private void buscarSeriesPorCategoria() {
//        System.out.println("Deseja buscar séries de que categoria/gênero? ");
//        var nomeGenero = leitura.nextLine();
//        Categoria categoria = Categoria.fromPortugues(nomeGenero);
//        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
//        System.out.println("Séries da categoria " + nomeGenero);
//        seriesPorCategoria.forEach(System.out::println);
    }

    private void filtrarSeriesPorTemporadaEAvaliacao(){
//        System.out.println("Filtrar séries até quantas temporadas? ");
//        var totalTemporadas = leitura.nextInt();
//        leitura.nextLine();
//        System.out.println("Com avaliação a partir de que valor? ");
//        var avaliacao = leitura.nextDouble();
//        leitura.nextLine();
//        List<Serie> filtroSeries = repositorio.seriesPorTemporadaEAValiacao(totalTemporadas, avaliacao);
//        System.out.println("*** Séries filtradas ***");
//        filtroSeries.forEach(s ->
//                System.out.println(s.getTitulo() + "  - avaliação: " + s.getAvaliacao()));
    }

    private void buscarEpisodioPorTrecho(){
//        System.out.println("Qual o nome do episódio para busca?");
//        var trechoEpisodio = leitura.nextLine();
//        List<Episodio> episodiosEncontrados = repositorio.episodiosPorTrecho(trechoEpisodio);
//        episodiosEncontrados.forEach(e ->
//                System.out.printf("Série: %s Temporada %s - Episódio %s - %s\n",
//                        e.getSerie().getTitulo(), e.getTemporada(),
//                        e.getNumeroEpisodio(), e.getTitulo()));
    }

    private void topEpisodiosPorSerie(){
//        buscarSeriePorTitulo();
//        if(serieBusca.isPresent()){
//            Serie serie = serieBusca.get();
//            List<Episodio> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
//            topEpisodios.forEach(e ->
//                    System.out.printf("Série: %s Temporada %s - Episódio %s - %s Avaliação %s\n",
//                            e.getSerie().getTitulo(), e.getTemporada(),
//                            e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
//        }
    }
    private void buscarEpisodiosDepoisDeUmaData(){
//        buscarSeriePorTitulo();
//        if(serieBusca.isPresent()){
//            Serie serie = serieBusca.get();
//            System.out.println("Digite o ano limite de lançamento");
//            var anoLancamento = leitura.nextInt();
//            leitura.nextLine();
//
//            List<Episodio> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
//            episodiosAno.forEach(System.out::println);
//        }
    }
}