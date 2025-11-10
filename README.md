# 🚗 Simulación de Aparcamiento Concurrente con Semaphore

Este proyecto simula el acceso concurrente de varios coches a un aparcamiento con plazas limitadas, utilizando la clase `Semaphore` de Java para controlar el acceso a los recursos compartidos. El objetivo es demostrar cómo gestionar correctamente la sincronización entre hilos en un entorno multihilo.

## 🛠️ Estructura del proyecto

- **Aparcamiento.java**: Gestiona el semáforo y controla el número de plazas ocupadas.
- **Coche.java**: Representa cada coche como un hilo que intenta entrar, aparcar un tiempo aleatorio y salir.
- **PrincipalParking.java**: Punto de entrada del programa, crea el aparcamiento y lanza los hilos.

## ▶️ Cómo ejecutar

1. Compila los tres archivos Java.
2. Ejecuta `PrincipalParking`.
3. Observa en consola cómo los coches compiten por las plazas y se sincronizan correctamente.
