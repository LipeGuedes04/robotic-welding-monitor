# 🏢 Monitoramento de Braço Mecânico - Robotic Welding System

## 🎯 O que o projeto faz?

O sistema simula o controle e monitoramento de um robô industrial em uma linha de montagem automotiva. O usuário informa o **total de carros** a serem produzidos e, para cada veículo, insere o **modelo** e o **tempo de execução de 5 soldas obrigatórias**. O programa valida os tempos informados em tempo real (bloqueando valores negativos ou zerados), dispara **alertas visuais de lentidão** caso alguma solda passe do limite prudencial e gera um relatório consolidado com médias de produtividade industrial do turno.

### 🔄 Fluxo da Aplicação
```text
[ Definição de Meta de Carros ] ➔ [ Entrada do Modelo ] ➔ [ Coleta & Validação de 5 Soldas ] ➔ [ Monitoramento de Alertas ] ➔ [ Relatório de Eficiência ]
```

---

## 🎨 Design do Código (Como as regras conversam)

Este projeto foi construído utilizando uma estrutura de **Laços de Repetição Aninhados (For encadeados)** para iterar de forma controlada sobre coleções lógicas (Carros ➔ Soldas), combinada com um laço de checagem imediata. Veja a estrutura limpa do design:

```text
       ┌────────────────────────┐
       │   Meta de Produção     │ (Define o limite do loop externo)
       └───────────┬────────────┘
                   │
                   ▼
       ┌────────────────────────┐
       │   Loop dos Carros      │ ◄───┐ (Iterador 'i' até totalCarros)
       └───────────┬────────────┘     │
                   │                  │
                   ▼                  │ (Próximo veículo)
       ┌────────────────────────┐     │
       │   Loop de 5 Soldas     │ ◄─┐ │
       └───────────┬────────────┘   │ │
                   │                │ │
                   ▼                │ │ (Próxima solda)
       ┌────────────────────────┐   │ │
       │ Validação Compulsória  │ ──┘ │
       └───────────┬────────────┘     │
                   │                  │
                   ▼                  │
       ┌────────────────────────┐     │
       │  Emissão do Relatório  │ ────┘
       └────────────────────────┘
```

### 📋 Mapeamento de Variáveis e Estruturas

| Estrutura / Variável | O que ela faz no código? |
| :--- | :--- |
| 🚀 `main.java` | Classe principal que gerencia o fluxo de entrada via console e executa o processamento de telemetria da fábrica. |
| 🚗 `totalCarros` | Inteiro que define o limite superior do primeiro loop `for`, representando a meta diária de veículos. |
| 📝 `carro` | String que armazena temporariamente o modelo do carro atual que está na esteira de soldagem. |
| ⏱️ `tempoSolda` | Ponto flutuante (double) que capta o tempo de cada ciclo, protegido por um filtro `while`. |
| 🌡️ `tempoTotalTurno` | Variável acumuladora global que soma todos os segundos gastos em todas as soldas do dia. |
| 🔢 `totalSoldasEfetuadas`| Contador incremental que registra o volume total de operações feitas para o cálculo exato da média. |

---

## 🧠 Conceitos de Programação Praticados

* **Estrutura de Repetição Controlada `for`:** Uso de laços contados ideais para cenários onde o número de iterações é previamente conhecido (número fixo de 5 soldas por carro).
* **Enchainment (Aninhamento) de Loops:** Execução de estruturas bidimensionais onde um loop interno roda completamente para cada única rodada do loop externo.
* **Filtros de Segurança com `while`:** Uso de laços condicionais pós-captura para travar o terminal e impedir que dados corrompidos ou fisicamente impossíveis (tempo ≤ 0) afetem as métricas.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação da linha de montagem com um alerta de lentidão rodando direto no terminal:

```text
Quantos Carros o robo irá produzir hoje?
1
Digite o modelo do carro 1: 
Sedan-X
quanto tempo levou a 1° solda desse carro? (em segundos)
5.5
quanto tempo levou a 2° solda desse carro? (em segundos)
9.2
⚠️ [ALERTA] Lentidão detectada no braço mecânico durante o ciclo!

quanto tempo levou a 3° solda desse carro? (em segundos)
0
❌ Valor irregular, digite o valor novamente!
4.8
quanto tempo levou a 4° solda desse carro? (em segundos)
6.1
quanto tempo levou a 5° solda desse carro? (em segundos)
5.0

============== Solda Finalizada =============
===== RELATÓRIO ========== 
- Total de carros produtos: 1
- Total de soldas realizadas: 5
- Tempo total da solda foi: 30.60 segundos
- A média do tempo por solda foi: 6.12 segundos
```
