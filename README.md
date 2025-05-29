# Simulación de Cobro en Supermercado 🛒

Este proyecto implementa una simulación del proceso de cobro en un supermercado utilizando concurrencia en Java, como parte de la actividad EA2 de la Universidad Digital de Antioquia.

## 🧩 Estructura del Proyecto

- `Producto.java`: representa un producto con nombre y precio.
- `Cliente.java`: cliente con una lista aleatoria de productos.
- `Cajera.java`: hilo que atiende a los clientes procesando productos uno por uno.
- `Supermercado.java`: clase principal que gestiona el flujo de ejecución y lanza cajeras.

## 🚀 Tecnologías Usadas

- Lenguaje: Java 21
- Librerías: `java.util.concurrent`
- IDE: IntelliJ IDEA Community Edition

## ▶️ Cómo Ejecutar

1. Clona este repositorio o descarga los archivos.
2. Abre el proyecto en IntelliJ IDEA.
3. Asegúrate de tener configurado JDK 21.
4. Ejecuta `Supermercado.java`.

## 🧪 Resultado Esperado

- Tres cajeras atienden a clientes en paralelo.
- Cada cajera procesa productos uno por uno.
- La salida en consola muestra:
  - Productos procesados
  - Tiempo total por cliente
  - Asignación dinámica de cajeras

## 👥 Integrantes

- [Adrianys Maria Saumeth Padilla]


## 📚 Referencias

- Oracle Docs: https://docs.oracle.com/javase/
- Caso de Estudio IUDigital
