# HealthTrack - Evaluación Módulo 4: Automatización de Pruebas

Este proyecto simula una plataforma web de monitoreo de salud, centrado en el registro y actualización del peso de los usuarios. Fue desarrollado como parte de la evaluación del Módulo 4 del Bootcamp DevOps, enfocándose en detección de errores, automatización de pruebas y calidad de código.

## 🐞 Error identificado

Se detectó un error crítico en el método `actualizarPeso()` de la clase `Usuario`:

```java
public void actualizarPeso(double nuevoPeso) {
    this.peso -= 1; // Lógica defectuosa
}
```

En lugar de registrar el nuevo peso, el sistema lo disminuye en 1 kg.

## 🧪 Pruebas implementadas

### ✅ Pruebas Unitarias (JUnit 5)
- Validan la lógica del método `actualizarPeso()` para casos normales y extremos.
- Ejecutadas con Maven (`mvn test`).

### ✅ Pruebas Funcionales (Selenium)
- Simulan el flujo completo de usuario en el navegador:
  - Inicio de sesión.
  - Formulario de actualización de peso.
  - Verificación en el DOM.
- Ejecutadas en modo headless.

### ✅ Pruebas de Regresión
- Consolidación de todas las pruebas (unitarias y funcionales) para detectar fallos reincidentes.

### ✅ Pruebas de Rendimiento (JMeter)
- Archivo: `ActualizarPesoPerformance.jmx`
- 50 usuarios concurrentes.
- Resultados generados en `jmeter/reporte-html/`.

## ⚙️ Automatización CI/CD (GitHub Actions)

Se configuró un pipeline CI completo que ejecuta:

- Compilación y pruebas (`mvn clean verify`).
- Pruebas funcionales con Selenium (modo headless).
- Pruebas de rendimiento con JMeter.
- Análisis de calidad con SonarCloud.

Archivo: `.github/workflows/ci.yml`

## 📊 Análisis de Calidad (SonarCloud)

- Integración con SonarCloud para revisión automática de:
  - Bugs.
  - Cobertura de pruebas.
  - Código duplicado.
- Se excluyeron carpetas no relevantes como `jmeter/`, `docs/`, `logs/`.

## 📁 Estructura del proyecto

```
healthtrack/
├── README.md 
├── pom.xml 
├── sonar-project.properties 
├── usuario.html 

├── .github/
│   └── workflows/
│       └── ci.yml 

├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── healthtrack/
│   │               ├── Usuario.java
│   │               └── UsuarioPerformance.java
│   └── test/
│       └── java/
│           └── com/
│               └── healthtrack/
│                   ├── UsuarioTest.java
│                   └── UsuarioFlujoTest.java

├── selenium-tests/
│   └── logs/
│       └── selenium-log.txt

├── jmeter/
│   ├── ActualizarPesoPerformance.jmx 
│   └── reporte-html/
│       ├── index.html
│       ├── content/
│       └── sbadmin2-1.0.7/


```

## ✅ Resultado

- Error de negocio corregido.
- Pruebas automatizadas a nivel unitario, funcional, regresión y carga.
- Pipeline de CI/CD completamente funcional.
- Calidad del código validada con SonarCloud.
