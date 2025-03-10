# Ajedrez con Java y POO
Este fue un **Proyecto Universitario**. El objetivo del proyecto fue desarrollar **únicamente la estructura** de algún **juego de mesa** a elección personal. No era necesario que funcionara, ya que el propósito del proyecto era identificar en dicho juego los elementos de la **Programación Orientada a Objetos** y representarlos en sus debidas clases, métodos y/o interfaces.

Para este proyecto, decidí construir un **Ajedrez**, logrando obtener un juego funcional a manera de un **Tablero de Ajedrez Digital**, con las siguientes características:

## Funciones Implementadas
- **Turnos** intercalados entre piezas negras y blancas, comenzando por las blancas.  
- **Restricción de Movimientos** según las reglas del Ajedrez, detalladas más adelante.  
- **Detección de Jaque** (Funcionalidad en desarrollo, quedó incompleta por límite de tiempo).  
- **Captura de Piezas**: Se pueden eliminar piezas enemigas, respetando las reglas del Ajedrez (ejemplo: los peones solo capturan en diagonal).  

<br><br>![Tablero Nuevo](assets-git/p1.jpeg)  


## Funcionamiento
La clase principal es `Partida.java`, la cual inicializa el tablero usando una interfaz gráfica y una matriz de 8x8 enteros.

Posteriormente, se crean dos instancias de `Jugador` (para piezas blancas y negras) y se generan objetos para cada una de las 32 piezas del juego, asignándoles sus coordenadas iniciales y asociándolas a cada jugador mediante el método `setPieza`.


## Las Piezas
Para la gestión de piezas, se creó una clase general llamada `Pieza`, de la cual heredan todas las demás. Esta clase contiene los atributos y métodos fundamentales para el funcionamiento de las piezas de ajedrez.

### **Atributos**
- Coordenadas en el tablero `(X, Y)`.
- Valor (pensado para futuros modos de juego que involucren puntuaciones).
- Estado **"Viva"** (determina si la pieza sigue activa en el tablero).
- Casilla actual (utilizada para calcular movimientos y capturas de piezas).
- Color de la pieza.
- Ruta del ícono (imagen o sprite de la pieza en el proyecto).

### **Métodos**
- **`piezaEnTrayectoria`**  
  *Método abstracto* que recibe una pieza como parámetro y devuelve `true` o `false` dependiendo de si la pieza se encuentra en su trayectoria.  
  Considera si hay piezas bloqueando el camino (retorna `false` en ese caso). No aplica para el **Caballo**, ya que este puede saltar piezas.

- **`movimiento`**  
  *Método abstracto* que evalúa si las coordenadas de destino `(X, Y)` son válidas con base en las reglas del Ajedrez.  
  Compara las coordenadas actuales con las de destino y llama a `piezaEnTrayectoria` para verificar si hay bloqueos.  
  Algunas piezas tienen reglas especiales, como:
  - **Peón**: Puede moverse dos casillas en su primer turno, pero no puede retroceder.  
  - **Caballo**: Puede saltar otras piezas.  

- **`comerPiezas`**  
  Verifica si la casilla de destino contiene una pieza enemiga. Retorna `true` si la captura es válida o `false` si no lo es.  
  Este método se usa dentro de `movimiento`, con reglas específicas para cada tipo de pieza.



## Capturas del Juego
![Captura 1](assets-git/p2.jpeg)<br><br>
![Captura 2](assets-git/p3.jpeg)<br><br>
![Captura 3](assets-git/p4.jpeg) 


## ¿Cómo probar el proyecto?  

1. Clonar o descargar el repositorio:  
   ```bash
   git clone`https://github.com/MiguelDotDev/java-chess.git
   ```

2. Importar el proyecto en algún IDE de Java y ejecutar la clase ```Partida.java```

## Notas
- Este proyecto fue desarrollado únicamente con fines educativos.
- Se pueden hacer mejoras futuras en el diseño, jugabilidad e implementación de funcionalidades adicionales.