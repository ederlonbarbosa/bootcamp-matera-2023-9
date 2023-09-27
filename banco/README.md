# bootcamp-matera-2023-9

# Microserviços

- abordagem arquitetónica de desenvolvimento de software
- independencia e desacoplamento
- responsabilidade única
- serviços autônomos -> independencia. tem sua propria base de dados

### Vantagens e Desvantagens?
- v -> independencia, nao é punto unico de falha
- v -> manutenção por serem independentes, agilidade
- d -> custo, mais complexo de manter ?
- v -> escalabilidade:
    - vertical -> aumentar os recursos da maquina
    - horizontal -> aumentar os serviços
      -v -> alta disponibilidade
- d -> comunicação entre microserviços.
- d -> infra fica mais complexa
- v -> independencia de tecnologia entre os microserviços
- d ->  dificuldade em manter a padronização entre todos os projetos sem "quebrar" a flexibiliade da equipe

# microserviço vs. monolito

## monolito:
mais de um contexto
mais de um dominio
um único serviço rodando
monolito é um sistema único que centraliza todas as funcionalidades da aplicação.
precio mais barato
ao ter uma unica linguagem, fica mais facil a manutenção.

## microserviços:
rodando em diferentes instâncias
diferentes tecnologias

depende da necessidade?

# stateless vs stateful

## stateless:
não mantem estado ou informações sobre sessões entre as chamadas.
chamadas independentes

# stateful:
mantem o estado entre as chamadas. Isso significa que ele pode armazenar informações sobre sessões ou transaçẽs e lembrar estado atual do cliente
preserva o dado durante toda execução

tipos de comunicação entre microserviços:

# Comunicação

## sincrona:
ao fazer uma chamada voce espera uma resposta. Ex: REST, SOAP,

## assincrona
nao espera uma resposta instantânea. Ex: Mensageria

MicroA -> posta uma mensagem num serviço de mensageria. <- MicroB