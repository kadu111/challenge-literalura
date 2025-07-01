package br.com.projeto.literalura.principal;

import br.com.projeto.literalura.dto.GutendexResponse;
import br.com.projeto.literalura.model.Autor;
import br.com.projeto.literalura.model.Livro;
import br.com.projeto.literalura.service.ConsumoApi;
import br.com.projeto.literalura.service.LivroMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final List<Livro> catalogoLivros = new ArrayList<>();
    private final List<Autor> autoresBuscados = new ArrayList<>();
    private final ConsumoApi consumoApi;

    public Principal(ConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Buscar livros por título ou autor");
            System.out.println("2 - Listar todos os livros salvos no catálogo");
            System.out.println("3 - Listar livros por idioma");
            System.out.println("4 - Listar autores dos livros buscados");
            System.out.println("5 - Listar autores vivos em um determinado ano");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o termo de busca: ");
                        String termo = scanner.nextLine();
                        GutendexResponse resposta = consumoApi.buscarLivros(termo);
                        if (resposta != null && resposta.results() != null && !resposta.results().isEmpty()) {
                            var dadosLivro = resposta.results().get(0);
                            Livro livro = LivroMapper.fromDados(dadosLivro);
                            catalogoLivros.add(livro);

                            Autor autor = livro.getAutor();
                            if (autoresBuscados.stream().noneMatch(a -> a.getNome().equalsIgnoreCase(autor.getNome()))) {
                                autoresBuscados.add(autor);
                            }

                            System.out.println("Livro adicionado ao catálogo:\n" + livro);
                        } else {
                            System.out.println("Nenhum livro encontrado.");
                        }
                        break;

                    case 2:
                        if (catalogoLivros.isEmpty()) {
                            System.out.println("Catálogo vazio.");
                        } else {
                            System.out.println("Livros no catálogo:");
                            catalogoLivros.forEach(System.out::println);
                        }
                        break;

                    case 3:
                        System.out.print("Digite o idioma (ex: 'en', 'pt'): ");
                        String idioma = scanner.nextLine();
                        List<Livro> filtrados = catalogoLivros.stream()
                                .filter(l -> l.getIdioma().equalsIgnoreCase(idioma))
                                .toList();

                        if (filtrados.isEmpty()) {
                            System.out.println("Nenhum livro encontrado nesse idioma.");
                        } else {
                            filtrados.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        if (autoresBuscados.isEmpty()) {
                            System.out.println("Nenhum autor registrado.");
                        } else {
                            System.out.println("Autores encontrados:");
                            autoresBuscados.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.print("Digite o ano desejado: ");
                        int ano = Integer.parseInt(scanner.nextLine());

                        List<Autor> vivos = autoresBuscados.stream()
                                .filter(a -> a.getNascimento() != null && a.getNascimento() <= ano &&
                                        (a.getFalecimento() == null || a.getFalecimento() > ano))
                                .toList();

                        if (vivos.isEmpty()) {
                            System.out.println("Nenhum autor encontrado vivo nesse ano.");
                        } else {
                            System.out.println("Autores vivos no ano " + ano + ":");
                            vivos.forEach(System.out::println);
                        }
                        break;


                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }

        scanner.close();
    }
}
