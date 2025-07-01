# Projeto Literalura - Consumo da API Gutendex

Este projeto em Java utiliza Spring Boot para consumir a API pública Gutendex, que fornece dados de mais de 70 mil livros do domínio público, e persiste essas informações em banco de dados PostgreSQL.

## Status do Projeto

🚧 **Em desenvolvimento** 🚧
Este projeto ainda está em fase inicial e será aprimorado com novas funcionalidades e melhorias no código nas próximas versões.

## Funcionalidades

O sistema oferece as seguintes opções de interação via terminal:

1. **Buscar livro pelo título**
   Consulta diretamente a API Gutendex, obtém os dados do livro e os insere no banco de dados.

2. **Listar livros registrados**
   Exibe todos os livros armazenados no banco de dados com informações como título, autor, idioma e número de downloads.

3. **Listar autores**
   Mostra os autores registrados no banco, com seus dados pessoais (nome, ano de nascimento e falecimento) e seus livros associados.

4. **Listar autores vivos em determinado ano**
   Permite consultar autores que estavam vivos em um ano específico informado pelo usuário.

5. **Listar livros em determinado idioma**
   Exibe livros filtrados pelo idioma informado, entre as opções disponíveis (ex: português, inglês, espanhol, francês).

Além dessas, o projeto permite a persistência dos dados consultados e está preparado para suportar consultas exclusivas ao banco, sem necessidade de acesso contínuo à API.

---

Contribuições e sugestões são bem-vindas!

---

© 2025 - Desenvolvido por \ Carlos Eduardo
