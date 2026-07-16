# Sistema de Gestión de Evaluaciones (`gestion-evaluaciones`) 🚀

¡Bienvenido al proyecto **gestion-evaluaciones**! Esta es una aplicación desarrollada en Java puro, diseñada bajo los principios de **Arquitectura Limpia (Clean Architecture)** y **Diseño Guiado por el Dominio (DDD)**, asegurando un desacoplamiento total de bases de datos físicas o frameworks externos.

Este proyecto cuenta con una cobertura de pruebas automatizadas del **100% (Line & Branch Coverage)**, utilizando **JUnit 5** y **Mockito** para simular de manera dinámica las dependencias de infraestructura.

---

## 📋 Reglas de Negocio

El núcleo del sistema se encuentra en el servicio centralizador `EvaluationStatusPrinterService`. Este servicio es el encargado de validar y procesar la impresión de los exámenes bajo tres estrictas reglas de negocio:

1. **Regla del Estado**: El examen (`Evaluation`) a imprimir debe encontrarse estrictamente en estado `Pendiente`. Si está en un estado diferente, el sistema detendrá el proceso y lanzará una excepción de negocio.
2. **Regla de Copias**: Las copias solicitadas para impresión deben estar en un rango válido (mayor o igual a 1 y menor o igual que 50). En caso de recibir un número menor o igual a 0, se lanzará una excepción `InvalidCopyQuantityException`.
3. **Regla de la Fecha**: La fecha de impresión planificada debe ser **estrictamente anterior** a la fecha programada para el examen. Si es igual o posterior, el sistema lo impedirá mediante `InvalidEvaluationDateException`.

---

## 🛠️ Decisiones de Diseño y Arquitectura

* **Dominio Puro:** La clase `Evaluation` representa una entidad de dominio pura. Utiliza tipos modernos de Java (como `LocalDate` para el manejo de fechas) y encapsula su comportamiento y lógica interna sin intermediación de tecnologías externas.
* **Inyección de Dependencias por Constructor:** Para favorecer el bajo acoplamiento y la testabilidad, el servicio de impresión recibe sus dependencias directamente en el constructor.
* **Abstracción de Infraestructura:** El servicio `NotificationService` se define como una interfaz pura para el envío de alertas. No se implementaron dobles manuales (como `DummyNotificationService`), delegando la simulación interactiva completamente en **Mockito** para evitar código "basura" en el entregable.
* **Control de Excepciones Limpio:** Las excepciones de negocio heredan directamente de `RuntimeException`. Esto evita ensuciar las firmas de los métodos con cláusulas `throws` y optimiza la legibilidad del código.

---

## 🧪 Estrategia de Pruebas y Cobertura (100% Coverage)

La suite de pruebas automatizada se encuentra en `EvaluationStatusPrinterServiceTest` y ha sido diseñada meticulosamente bajo el patrón **Arrange-Act-Assert (AAA)** para asegurar la protección del software frente a regresiones:

* **Pruebas de Flujo Exitoso:** Verificación del camino feliz cuando se cumplen las tres reglas de negocio.
* **Pruebas de Límites y Excepciones:** Cobertura de caminos alternativos para las reglas de estado, rango de copias inválidas y fechas incorrectas.
* **Cobertura de Excepciones Propias:** Se incluyeron pruebas unitarias que instancian y validan el comportamiento de las excepciones personalizadas, garantizando que el motor de cobertura de IntelliJ/Maven marque un impecable **100% en verde** tanto en líneas como en ramas condicionales.

---

## 📂 Estructura Limpia del Proyecto

El proyecto está organizado bajo la estructura estándar de Maven:

```text
gestion-evaluaciones/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── institucion/
│   │           ├── exception/
│   │           │   ├── InvalidEvaluationDateException.java
│   │           │   ├── InvalidCopyQuantityException.java
│   │           │   └── InvalidEvaluationDateException.java
│   │           │── Evaluation.java
│   │           ├── NotificationService.java
│   │           └── EvaluationStatusPrinterService.java
│   └── test/
│       └── java/
│           └── institucion/
│               └── EvaluationStatusPrinterServiceTest.java
├── pom.xml
└── README.md

---

## 📈 Bitácora de Aprendizaje (Evolución del Proyecto)

[cite_start]Para evidenciar el avance lineal y la adquisición progresiva de habilidades a lo largo de este módulo, el repositorio refleja un desarrollo incremental[cite: 105, 108]. [cite_start]A continuación, se detallan los hitos clave alcanzados en cada etapa del proceso[cite: 108, 114]:

| Sesión / Hito | Enfoque de Aprendizaje | Conceptos Clave Aplicados |
| :--- | :--- | :--- |
| **Sesión 1 & 2** | Dominio y TDD | [cite_start]Creación de la entidad pura de negocio `Evaluation` [cite: 66, 67, 110][cite_start], encapsulamiento del estado (`PENDING`) [cite: 67, 110] y primeros pasos en el diseño guiado por pruebas. |
| **Sesión 3** | Robustez y Límites | [cite_start]Implementación de aserciones semánticas y control de flujo mediante excepciones de negocio (`assertThrows`)[cite: 27, 110]. |
| **Sesión 4** | Aislamiento y ID | [cite_start]Introducción de principios de desacoplamiento[cite: 110]. [cite_start]Estructuración del servicio mediante **Inyección de Dependencias por Constructor** para facilitar el testeo[cite: 72, 110]. |
| **Sesión 5** | Objetos Simulados | [cite_start]Migración de dobles de prueba manuales obsoletos a **Mocks Dinámicos** usando `@Mock` y `@InjectMocks` con Mockito[cite: 13, 25, 110]. |
| **Sesión 6** | Calidad y Cobertura | [cite_start]Incorporación de tests unitarios para constructores de excepciones personalizadas, logrando un **100% de Line & Branch Coverage**[cite: 30, 81, 110]. |

### 🛠️ Auditoría de Commits Recomendados

[cite_start]Si deseas verificar el "viaje en el tiempo" de la construcción del código, puedes ejecutar en tu terminal el comando `git log`[cite: 109, 110]. [cite_start]Encontrarás un historial de commits limpio e incremental estructurado bajo buenas prácticas[cite: 108, 110]:

* [cite_start]**`feat: agregar entidad Evaluation e inicializar estado`** [cite: 110] (Sesión 2)
* [cite_start]**`test: implementar assertThrows y pruebas paramétricas para límites`** [cite: 110] (Sesión 3)
* [cite_start]**`pattern: aislar dependencias usando inyección por constructor`** [cite: 110] (Sesión 4)
* [cite_start]**`refactor: migrar dobles manuales a mocks dinámicos con Mockito`** [cite: 110] (Sesión 5)
* [cite_start]**`quality: incorporar pruebas de excepciones para asegurar 100% code coverage`** [cite: 110] (Sesión 6)
