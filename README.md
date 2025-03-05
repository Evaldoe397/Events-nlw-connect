# Sistema de Gerenciamento de Inscrições 📝

## Sobre o Projeto
Sistema desenvolvido durante o NLW Connect da RocketSeat, sob orientação do professor Isidro. O projeto consiste em uma plataforma de gerenciamento de inscrições com funcionalidade de indicação entre usuários.

## 🚀 Funcionalidades

- Gerenciamento de inscrições
- Sistema de indicação entre usuários
- Tratamento robusto de erros
- Interface intuitiva e segura
- Código otimizado utilizando records

## 🛠️ Tecnologias Utilizadas

- Java 21
- MySQL 8.0.36
- Postman (Para testes de API)
- Claude.ai (Auxílio no desenvolvimento)
- Sistema de Records
- Tratamento de Exceções
- Modelagem de Dados

## 💻 Pré-requisitos

Para executar o projeto, você precisará ter instalado:
- Java JDK 21
- MySQL 8.0.36
- Postman para testes de API
- IDE de sua preferência
- Git para versionamento

## 🔧 Instalação

1. Clone o repositório
```bash
git clone [url-do-seu-repositorio]
```

2. Entre no diretório do projeto
```bash
cd [nome-do-diretorio]
```

3. Configure o banco de dados MySQL
```sql
CREATE DATABASE nome_do_banco;
```

4. Configure as credenciais do banco de dados em:
```
src/main/resources/application.properties
```

5. Execute o projeto
```bash
./mvnw spring-boot:run
```

## 📦 Estrutura do Banco de Dados

O projeto utiliza MySQL 8.0.36 com as seguintes características:
- Modelagem eficiente de dados
- Relacionamentos otimizados
- Índices para melhor performance
- Constraints de integridade

## 🎯 Estrutura do Projeto

O projeto foi desenvolvido com foco em:
- Modelagem eficiente de dados
- Tratamento de erros robusto
- Código limpo e elegante usando records do Java 21
- Sistema de indicação entre usuários

## 🔍 Testando a API

Utilize o Postman para testar os endpoints:

1. Importe a collection disponível em `postman/collection.json`
2. Configure o ambiente no Postman
3. Execute os requests para testar cada funcionalidade

## 🤝 Contribuições

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## ✨ Agradecimentos

- Professor Isidro pela excelente exposição do conteúdo
- RocketSeat pela organização do NLW Connect
- Todos os participantes que contribuíram com o projeto

## 📝 Licença

Este projeto está sob a licença [SUA LICENÇA]. Veja o arquivo `LICENSE` para mais detalhes.

---

⌨️ com ❤️ por [Evaldoe397](https://github.com/Evaldoe397)
