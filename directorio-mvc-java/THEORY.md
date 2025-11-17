# Parte Teórica (respuestas concisas — basada en Sommerville)

**Referencia principal sugerida:** Ian Sommerville, *Software Engineering* (ediciones recientes). Las respuestas que siguen son resúmenes didácticos basados en los conceptos tratados por Sommerville.

## Arquitectura en Capas

**Principio fundamental:** Separación por niveles de responsabilidad técnica, estableciendo restricciones en la comunicación entre capas (por ejemplo: cada capa sólo puede comunicarse con la capa inmediatamente inferior o superior). Esta restricción reduce acoplamiento y mejora mantenibilidad y escalabilidad.

**Diagrama genérico de 4 capas (texto):**
- Capa de Presentación (UI)
- Capa de Lógica de Negocio (Domain / Services)
- Capa de Acceso a Datos (DAO, Repositorios)
- Capa de Persistencia / Base de Datos

**Propósito principal:** Encapsular responsabilidades, permitir cambios locales (p. ej. cambiar forma de persistencia) sin afectar otras capas, y facilitar pruebas y despliegues.

**Ventajas:** Bajo acoplamiento, fácil localización de responsabilidades, escalabilidad por capas, facilita pruebas unitarias por capa.  
**Desventajas:** Posible sobreingeniería en sistemas pequeños y mayor latencia por múltiples saltos entre capas.

## Patrón Modelo–Vista–Controlador (MVC)

**Responsabilidades:**
- **Modelo:** Contiene la representación de datos y la lógica de negocio relacionada (estado del sistema). Notifica cambios al resto si hay un mecanismo de observadores.
- **Vista:** Presentación al usuario; su única función es mostrar datos y recibir entrada del usuario (I/O). No contiene lógica de negocio.
- **Controlador:** Intermediario que recibe acciones de la vista, invoca operaciones en el modelo y decide qué vista mostrar o qué respuesta dar.

**Flujo clásico (simplificado):**
Usuario -> Vista -> Controlador -> Modelo -> (Modelo actualiza) -> Vista

**¿Son mutuamente excluyentes MVC y Capas?**
No. MVC es un patrón de interacción centrado en la UI y el flujo entre roles; la Arquitectura en Capas es un patrón estructural por niveles. MVC puede situarse dentro de la capa de Presentación (por ejemplo) mientras que la Lógica de Negocio y Acceso a Datos permanecen en capas separadas. Pueden coexistir y complementarse.

## Tabla comparativa (resumen)

- **Tipo de separación**
  - Capas: Horizontal / por niveles técnicos (UI / Negocio / Datos).
  - MVC: Triangular / por roles en interacción con usuario (Modelo / Vista / Controlador).

- **Flujo de comunicación**
  - Capas: Normalmente restricción vertical (cada capa comunica con la adyacente).
  - MVC: Eventos/acciones de la Vista pasan al Controlador → Controlador actualiza Modelo → Modelo notifica Vista.

- **Caso de uso principal**
  - Capas: Aplicaciones empresariales con distintas responsabilidades y persistencia.
  - MVC: Aplicaciones con interfaces de usuario complejas y múltiples vistas del mismo modelo.

- **Principal ventaja**
  - Capas: Mantenibilidad y reemplazo de tecnologías por capa.
  - MVC: Claridad en la interacción UI y facilidad para múltiples vistas.

- **Principal desventaja**
  - Capas: Puede introducir latencia/overhead.
  - MVC: Si no se disciplina, lógica puede “filtrarse” a la vista o controlador.

- **Facilidad para pruebas**
  - Capas: Alta (cada capa se prueba por separado si se hace inyección de dependencias).
  - MVC: Alta para lógica y modelo; la vista requiere pruebas de integración o tests de UI.

