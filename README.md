# LixeiraInteligente — MVC

Projeto acadêmico em Java utilizando arquitetura MVC.

## Funcionalidades

- Listagem de todos os materiais (60 pré-cadastrados)
- Busca por nome exato (case-insensitive)
- Busca por categoria (Plástico, Metal, Papel, Vidro, Orgânico, Rejeito)
- Busca por palavra-chave parcial (overload)
- CRUD completo com autenticação de administrador
  - Cadastrar novo material
  - Editar material existente
  - Remover material

## Conceitos POO aplicados

- Encapsulamento (atributos private + getters/setters)
- Herança (MaterialReciclavel, MaterialOrganico, MaterialRejeito → Material)
- Polimorfismo — sobrescrita toString() em cada subclasse
- Sobrecarga — 3 construtores em Material; 2 métodos buscarPorNome em MaterialService
- ArrayList para armazenamento dinâmico
- Iterator para remoção segura (evita ConcurrentModificationException)
- try/catch para validação de entradas

## Estrutura MVC

```
src/
├── model/      → classes de dados (Material, subclasses, Categoria)
├── service/    → regras de negócio e CRUD (MaterialService)
└── view/       → interface/menu (Main)
```

## Compilar

```bash
javac model/*.java service/*.java view/*.java
```

## Executar

```bash
java view.Main
```

## Credenciais de administrador

- ID: adm
- Senha: 12345
