# Documentação de Requisitos: **Lone Beehive: Megachile's Journey**

## 1. Visão Geral do Jogo

**Lone Beehive: Megachile's Journey** é um jogo de sobrevivência em que o jogador assume o papel de uma abelha *Megachile*, buscando criar um abrigo e sobreviver em um ambiente hostil. O jogo é baseado em turnos, com uma perspectiva top-down 2D e mecânicas de coleta, construção e combate.

## 2. Requisitos Funcionais

### 2.1. Mapa
- O mapa será composto por **tiles** (blocos) representando diferentes tipos de terrenos.
- O mapa será armazenado como uma matriz de **Tiles**, onde cada Tile possui informações sobre o tipo de terreno (por exemplo, grama, pedra, água) e as entidades ou objetos nela posicionados (recursos, inimigos, etc.).
  
### 2.2. Personagem Jogável
- O personagem principal será uma **Megachile**, com atributos como pontos de vida (HP) e energia (EP).
- O personagem terá um inventário limitado, dividido em três partes: **Quick Access**, **Equipped** e **Backpack**.
  
### 2.3. Inventário
- O inventário será representado por vetores, com cada posição representando um item do tipo **Item**.
- Cada item pode ter atributos como **durabilidade** e pode ser equipado no personagem ou armazenado no inventário.
  
### 2.4. Equipamentos
- O personagem poderá usar **armas de ataque corpo a corpo**, **armas de ataque à distância**, **armaduras de defesa** e **escudos**.
- A armadura de exoesqueleto será feita com materiais coletados de inimigos.

### 2.5. Inimigos
- Os inimigos incluem predadores como **aranhas**, **formigas** e **vespas**.
- Cada inimigo terá atributos como **pontos de vida (HP)** e comportamento de ataque.

### 2.6. Construção
- O personagem poderá coletar recursos como **madeira**, **pedras**, **folhas**, **resina** e **teias de aranha** para construir sua base e se defender.

### 2.7. Interface Gráfica
- A interface gráfica será desenvolvida com **Java Swing**.
- O mapa será renderizado utilizando **JLayeredPane** e **JLabels**, onde cada **Tile** será representada por um **JLabel** com uma imagem.
- Informações do jogador, como **pontos de vida**, **energia** e **inventário**, serão exibidas em **JPanels** separados.

## 3. Requisitos Não Funcionais

### 3.1. Desempenho
- O jogo deverá ter um desempenho adequado para rodar de forma fluida em sistemas com recursos limitados.

### 3.2. Portabilidade
- O jogo deverá ser desenvolvido de forma que possa ser executado em plataformas compatíveis com **Java**.

### 3.3. Interface do Usuário
- A interface gráfica será simples, intuitiva e funcional, com foco na experiência de jogo.

## 4. Requisitos de Interface Gráfica

A interface gráfica será dividida em três áreas principais:

1. **Mapa e Ações**: Onde o jogador pode visualizar e interagir com o mundo do jogo. Será representado com **JLayeredPane** contendo **JLabels** que mostram os **Tiles**.
2. **Informações do Jogador**: Área onde serão exibidos os status do jogador, como **HP**, **EP** e **Inventário**, utilizando **JPanels** e **JLabels**.
3. **Controles**: A interface de controle pode ser feita por **teclado** e **mouse**, permitindo ao jogador mover o personagem e interagir com o ambiente.

## 5. Diagrama de Classes

### 5.1. Estrutura do Diagrama de Classes

- **Jogador** (herda de **Entidade**): Representa a abelha jogável, com atributos como **HP**, **EP** e **Inventário**.
- **Entidade**: Classe base para todas as entidades no jogo, como inimigos e o personagem jogável.
- **Inimigo** (herda de **Entidade**): Representa inimigos como **aranhas**, **formigas**, etc., com atributos como **HP**.
- **Item**: Representa um item que pode ser coletado ou usado, com atributos como **durabilidade** e **tipo** (por exemplo, arma, recurso, etc.).
- **Tile**: Representa uma tile do mapa, armazenando o tipo de terreno e objetos ou entidades que ela contém.
- **Mapa**: Representa o mapa do jogo, que é composto por uma matriz de **Tiles**.
