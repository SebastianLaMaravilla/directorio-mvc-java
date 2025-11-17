# Diagramas (ASCII)

## Diagrama de 4 capas (vertical)
---------------------------------------
|           Presentación (UI)         |
---------------------------------------
|      Lógica de Negocio / Domain    |
---------------------------------------
|        Acceso a Datos / DAO        |
---------------------------------------
|         Persistencia / DBMS        |
---------------------------------------

**Regla típica:** La capa i sólo interactúa con i-1 o i+1 (restricción de comunicación).

## Diagrama MVC (flujo simple)
+--------+     eventos      +-------------+     llamadas     +--------+
| Usuario| ---------------> |  Controlador| ---------------> | Modelo |
+--------+                  +-------------+ <--------------- +--------+
                              |  actualiza
                              v
                            +-------+
                            | Vista |
                            +-------+
(Vista muestra datos provenientes del Modelo; las acciones de usuario van al Controlador.)

## Diagrama de despliegue lógico (capas + MVC)
[Cliente/Terminal] -> (MVC en la capa de Presentación)
                      |
                      v
                [Capa de Negocio]
                      |
                      v
                [Capa de Persistencia / DB]
