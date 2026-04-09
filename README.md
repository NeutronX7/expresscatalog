# Catalogo Express

Aplicación Android nativa en Kotlin que consume una API pública para mostrar un catálogo de productos con pantalla de listado y detalle.

## Creación de proyecto
- Kotlin
- Fragments
- Jetpack Compose
- ViewModel
- Repository
- Retrofit
- OkHttp
- Coil

## Arquitectura
El proyecto está organizado en capas:
- data
- domain
- presentation
- core

Se utiliza ViewModel para manejo de estado y Repository para acceso a datos.

## Funcionalidades
- Listado de productos
- Detalle de producto
- Cálculo de score
- Ordenamiento descendente por score
- Estados loading / success / error
- Manejo básico de errores de red
- Reintento manual
- Timeout HTTP configurado

## API usada
- DummyJSON Products

## Configuración
El proyecto usa:
- Gradle Kotlin DSL
- Version Catalog (`libs.versions.toml`)
- buildTypes debug y release

## Versiones
- compileSdk: 35
- targetSdk: 35
- minSdk: 24
- versionCode: 1
- versionName: 1.0

## Compilación
```bash
./gradlew assembleDebug
./gradlew assembleRelease
