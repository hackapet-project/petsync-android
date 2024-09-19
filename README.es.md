# PetSync Android
[English](README.md) | [Español](README.es.md)
![Logo de PetSync](readme/thumbnail.png)
Fase 1 del proyecto Hackapet para Android.
## Índice
1. [Propósito del Proyecto](#propósito-del-proyecto)
2. [Configuración del Entorno](#configuración-del-entorno)
   - [Git](#git)
   - [Cuenta de GitHub](#cuenta-de-github)
   - [Android Studio](#android-studio)
3. [Instrucciones por Sistema Operativo](#instrucciones-por-sistema-operativo)
   - [Linux](#linux)
   - [Mac](#mac)
   - [Windows](#windows)
4. [Verificación](#verificación)
5. [Recursos Adicionales](#recursos-adicionales)
## Propósito del Proyecto
PetSync Android es la Fase 1 del proyecto Hackapet para dispositivos Android. Esta aplicación tiene como objetivo optimizar la gestión de refugios de animales mediante un sistema eficiente de mantenimiento de registros que agiliza las operaciones diarias.
Características principales:
- Seguimiento de animales en el refugio
- Inventario de suministros
- Generación de informes
## Configuración del Entorno
### Git
Git es esencial para el control de versiones. Permite realizar un seguimiento de los cambios en el código, colaborar con otros y gestionar los repositorios de código.
### Cuenta de GitHub
Necesitarás una cuenta en GitHub para colaborar en el proyecto y acceder a los repositorios.
### Android Studio
Android Studio es el IDE oficial para el desarrollo de Android y es necesario para trabajar en este proyecto.
## Instrucciones por Sistema Operativo
### Linux
1. **Instalar Git:**
   ```
   sudo apt-get update
   sudo apt-get install git
   ```
2. **Configurar Git:**
   ```
   git config --global user.name "Tu Nombre"
   git config --global user.email "tu_email@ejemplo.com"
   ```
3. **Instalar Android Studio:**
   - Descarga Android Studio desde [la página oficial](https://developer.android.com/studio).
   - Extrae el archivo descargado y muévelo a tu directorio de aplicaciones.
   - Ejecuta el script `studio.sh` en la carpeta `bin` para iniciar Android Studio.
### Mac
1. **Instalar Git:**
   ```
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   brew install git
   ```
2. **Configurar Git:**
   ```
   git config --global user.name "Tu Nombre"
   git config --global user.email "tu_email@ejemplo.com"
   ```
3. **Instalar Android Studio:**
   - Descarga Android Studio desde [la página oficial](https://developer.android.com/studio).
   - Mueve la aplicación Android Studio a tu carpeta de Aplicaciones.
   - Abre Android Studio y sigue el asistente de configuración.
### Windows
1. **Instalar Git:**
   - Descarga Git desde [git-scm.com](https://git-scm.com/download/win).
   - Ejecuta el instalador y sigue el asistente de configuración.
2. **Configurar Git:**
   ```
   git config --global user.name "Tu Nombre"
   git config --global user.email "tu_email@ejemplo.com"
   ```
3. **Instalar Android Studio:**
   - Descarga Android Studio desde [la página oficial](https://developer.android.com/studio).
   - Ejecuta el instalador y sigue el asistente de configuración.
## Verificación
Después de la instalación, verifica que todo funcione correctamente:
1. **Comprobar la instalación de Git:**
   ```
   git --version
   ```
2. **Verificar el acceso a GitHub:**
   Intenta clonar un repositorio:
   ```
   git clone git@github.com:nombredeusuario/repositorio.git
   ```
3. **Probar Android Studio:**
   Crea un nuevo proyecto de Android y ejecútalo en un emulador.
## Recursos Adicionales
- [Wiki del Proyecto](https://github.com/hackapet-project/petsync-android/wiki)
- [Documentación para Desarrolladores de Android](https://developer.android.com/docs)
- [Documentación de Git](https://git-scm.com/doc)
Para más información o si encuentras algún problema, consulta nuestra [wiki](https://github.com/hackapet-project/petsync-android/wiki) o abre un issue en el repositorio.
