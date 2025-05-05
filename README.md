# 🚀 Desafio de Programação - Itaú Unibanco
Este repositório contém a implementação do desafio proposto pelo Itaú Unibanco, no qual desenvolvi uma API para gerenciar transações e calcular estatísticas. O projeto foi desenvolvido utilizando Java 17 e Spring Boot, garantindo um código bem estruturado e eficiente.

## ✨ O que foi feito?
 - Criação da API com suporte a requisições POST, DELETE e GET.

 - Armazenamento em memória seguindo as restrições do desafio, sem uso de banco de dados ou cache externo.

 - Validação de entrada, garantindo que todas as transações tenham valores válidos e datas corretas.

 - Cálculo de estatísticas para transações feitas nos últimos 60 segundos.

## 🔧 Tecnologias Utilizadas
 - Spring Boot - Framework Java para construção da API.

 - Java - Linguagens utilizadas no desenvolvimento.
  
 - JSON - Formato de entrada e saída das requisições.

## 📌 Endpoints Implementados
Este endpoint recebe e armazena transações seguindo as regras do desafio.

Exemplo de requisição:
```
{
  "valor": 123.45,
  "dataHora": "2025-04-28T12:34:56.789-03:00"
}
```
Validações aplicadas: ✔️ Os campos valor e dataHora são obrigatórios. ❌ Transações futuras são rejeitadas. ❌ Valores negativos não são aceitos.

#### Respostas possíveis: 

201 Created ✅ Transação armazenada com sucesso.

422 Unprocessable Entity ❌ Dados inválidos (futuro, valor negativo, etc.).

400 Bad Request ❌ JSON incorreto ou mal formatado.

## 2️⃣ Limpar Transações `(DELETE /transacao)`
Remove todas as transações armazenadas.

Resposta: ✅ `200 OK` - Todas as transações foram apagadas.

## 3️⃣ Obter Estatísticas `(GET /estatistica)`
Retorna estatísticas das transações dos últimos 60 segundos.

Exemplo de resposta:
```
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```
Regras de cálculo: ✔️ Considera apenas transações nos últimos 60 segundos. ✔️ Usa `DoubleSummaryStatistics` para cálculo eficiente. ✔️ Se não houver transações, retorna valores zerados.
