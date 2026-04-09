## Errores y resiliencia
- Timeouts configurados en OkHttp
- Logging HTTP habilitado en debug
- Manejo de errores de red en repository
- Reintento manual desde UI

## Autenticación
No se implementó autenticación en esta prueba, pero si el backend utilizara JWT o un esquema similar, manejaría el token de la siguiente forma:

El token se recibiría después de login o refresh.
Se enviaría en cada request mediante un interceptor de OkHttp usando el header Authorization: Bearer <token>.
No se almacenaría en texto plano.

Para almacenamiento seguro, usaría EncryptedSharedPreferences, idealmente respaldado por Android Keystore, ya que ofrece una solución práctica y suficientemente segura para una app Android nativa.
En un proyecto más grande también contemplaría refresh token, expiración de sesión y limpieza segura al cerrar sesión.

## Estrategia de release
La build para QA se entregaría como APK release firmada para pruebas internas.
Debug mantiene logs y herramientas de desarrollo; release reduce exposición de logs y se orienta a validación final.

## Mejoras futuras
- Persistencia local con Room
- Deep links
- Pull to refresh
- Tests unitarios y de UI
- Inyección de dependencias con Hilt