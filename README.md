# 🐂 CapatazTech - Gestão Inteligente de Fazenda

> 🌾 **Sistema Web para Gerenciamento de Rebanho, Vacinação e Vendas.**

## 🚀 Acesse o Projeto Online
O sistema está hospedado na nuvem e pode ser acessado por qualquer dispositivo através do link abaixo:

👉 **[Clique aqui para acessar o CapatazTech](https://capataztech.onrender.com/)**

> *Nota: Por estar no plano gratuito do Render, a primeira página pode levar até 50 segundos para carregar se o servidor estiver inativo. Após carregar a primeira vez, a navegação fica rápida.*

---

## 📖 Sobre o Projeto

O **CapatazTech** foi desenvolvido para resolver os desafios diários do agronegócio. O sistema permite o cadastro de animais, o controle de estoque de vacinas, o histórico de aplicações e a gestão de vendas, tudo em um ambiente centralizado e visualmente amigável.

O grande diferencial do projeto é a implementação de **Regras de Negócio Automatizadas** e a criação de uma **API REST documentada com Swagger**.

## 🛠️ Tecnologias Utilizadas

*   **Java 25** e **Spring Boot 4**
*   **Spring Data JPA** (Persistência de dados e relacionamentos)
*   **H2 Database** (Banco de dados em memória)
*   **Thymeleaf** (Motor de templates)
*   **Bootstrap 5** (Design responsivo e moderno)
*   **Lombok** (Código limpo e enxuto)
*   **Swagger / Springdoc** (Documentação da API)

## ⚙️ Funcionalidades e Regras de Negócio

O sistema vai muito além do CRUD básico:
1. **Relacionamentos Fortes:** Um Animal possui várias Aplicações de Vacinas e várias Vendas (`@OneToMany`, `@ManyToOne`).
2. **Processamento Automático de Idade:** Ao registrar uma venda, o sistema calcula a idade do animal em meses com base na data de nascimento.
3. **Cálculo Inteligente de Valor:** Se o campo "Valor" for deixado em branco na venda, o sistema calcula o preço automaticamente (Peso do animal × R$ 15,00).
4. **Bloqueio de Venda Dupla:** Ao ser vendido, o animal muda para o status "Vendido" e não aparece mais na lista de disponíveis para novas negociações.
5. **Dashboard Interativo:** Tela inicial com contadores em tempo real de Animais, Vacinas e Vendas.

## 🔌 Documentação da API (Swagger)
O projeto conta com uma API REST para futuras integrações com aplicativos móveis. Para visualizar e testar os endpoints, acesse:

👉 **[Swagger UI do CapatazTech](https://capataztech.onrender.com/swagger-ui.html)**

## 💻 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/julyaneric8/capataztech.git
   ```
2. Abra na sua IDE (IntelliJ IDEA recomendado).
3. Execute a classe principal `CapataztechApplication`.
4. Acesse no navegador: `http://localhost:8080/`
5. O banco H2 pode ser acessado localmente em: `http://localhost:8080/h2-console`
   * **JDBC URL:** `jdbc:h2:mem:capataztechdb`
   * **User:** `sa`
   * **Senha:** *(em branco)*

---
*Desenvolvido como projeto de avaliação (Seminário TecWeb) focado em Inovação e Regras de Negócio.* 🐂✨
