# directorio-mvc-java

Proyecto de laboratorio: Aplicación de consola para gestión de inventario usando patrón MVC (Java).

## Contenido del paquete
- Código fuente Java (paquetes `modelo`, `vista`, `controlador`)
- `pom.xml` (Maven) y `build.gradle` (Gradle) como alternativas de build
- Documentación: `THEORY.md`, `DIAGRAMS.md`
- `.gitignore`
- Instrucciones para pruebas, Git y sustentación (`README.md` contiene un apartado 'Sustentación' y 'Evidencias').

## Requisitos
- Java 11+ recomendado.
- Maven (si usa `pom.xml`) o Gradle (si usa `build.gradle`).
- Git (para historial).

## Compilar y ejecutar (Maven)
1. Compilar:
   ```bash
   mvn clean package
   ```
2. Ejecutar (jar generado en `target/`):
   ```bash
   java -cp target/directorio-mvc-java-1.0-SNAPSHOT.jar App
   ```
(También puede ejecutar directamente desde el IDE.)

## Compilar y ejecutar (Gradle)
1. Compilar:
   ```bash
   gradle clean build
   ```
2. Ejecutar:
   ```bash
   java -cp build/libs/directorio-mvc-java.jar App
   ```

## Estructura del proyecto
```
directorio-mvc-java/
├─ .gitignore
├─ README.md
├─ THEORY.md
├─ DIAGRAMS.md
├─ pom.xml
├─ build.gradle
└─ src/
   ├─ App.java
   └─ modelo/
   │  ├─ Producto.java
   │  └─ BaseDeDatos.java
   └─ vista/
   │  └─ InventarioVista.java
   └─ controlador/
      └─ ControladorInventario.java
```

## Flujo Git recomendado (resumido)
1. Inicializar repo y primer commit:
   ```bash
   git init
   git add .
   git commit -m "feat(setup): Estructura inicial del proyecto MVC y .gitignore"
   ```
2. Crear ramas y commits atómicos:
   ```bash
   git checkout -b feature/modelo
   git add src/modelo/Producto.java src/modelo/BaseDeDatos.java
   git commit -m "feat(modelo): Implementa Producto y BaseDeDatos"
   git push origin feature/modelo
   git checkout main
   git merge feature/modelo
   git push origin main
   ```
   Repetir para `feature/vista` y `feature/controlador`.

## Sustentación y evidencias
- Durante la sustentación, muestra:
  1. El repositorio en GitHub con las ramas y commits (usa `git log --oneline --graph --all`).
  2. Ejecuta `App` y demuestra el flujo CRUD.
  3. Explica la separación de responsabilidades (Modelo sin I/O, Vista con Scanner/I/O, Controlador con orquestación).
- Comandos útiles para la sustentación (muestra en consola):
  ```bash
  git log --pretty=format:"%h %an %s" --graph --all --decorate -n 20
  mvn -v
  java -version
  mvn clean package
  java -cp target/directorio-mvc-java-1.0-SNAPSHOT.jar App
  ```

## Cómo simular 3 autores (si es necesario)
```bash
git commit --author="Ana Pérez <ana@example.com>" -m "feat(modelo): Implementa Producto"
git commit --author="Juan Rodriguez <juan@example.com>" -m "feat(vista): Implementa InventarioVista"
git commit --author="Luis Gómez <luis@example.com>" -m "feat(controlador): Implementa ControladorInventario"
```

