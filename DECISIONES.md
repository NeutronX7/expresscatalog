## Errores y resiliencia
- Timeouts configurados en OkHttp
- Logging HTTP habilitado en debug
- Manejo de errores de red en repository
- Reintento manual desde UI

## Estrategia de release
La build para QA se entregaría como APK release firmada para pruebas internas.
Debug mantiene logs y herramientas de desarrollo; release reduce exposición de logs y se orienta a validación final.

## Mejoras futuras
- Persistencia local con Room
- Deep links
- Pull to refresh
- Tests unitarios y de UI
- Inyección de dependencias con Hilt