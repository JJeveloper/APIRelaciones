### APIRelaciones
## Api rest utilizando el framework spring boot, con tablas relacionadas

### DESCRIPCION
Este proyecto en spring boot tiene la finalidad de realizar un CRUD, a continuacion las tablas para mayor entendimiento.
![Captura de pantalla 2025-05-11 163657](https://github.com/user-attachments/assets/af4f16a6-f84f-4f5a-b9d1-eb3e5e213215)

### Tecnologías Implementadas

| Tecnologias   | Descripcion               | 
| :---          | :---                      |    
| Java          |Lenguaje de programacion   |
| Spring Boot   | Framework                 |
| Intellj IDEA  | IDE                       |
| MapStruct     |   generador de código     |
| Maven         | Gestor de proyectos       |
| JPA-Hibernate | Framework para el mapeo de objetos y persistencia en la db |
| PostMan       | Puebas de la API          |
| Mysql         | Sistema de Gestión de Bases de Datos |
| Git           | Control de versiones      |

## Metodos HTTP

**Get: mostrar todos los datos**
 ```bash
  http://localhost:8092/canciones/todaslascanciones
  http://localhost:8092/cantantes/mostrartodosloscantantes
  http://localhost:8092/genero/mostrartodoslosgeneros
```
**Get: mostrar por un id**
 ```bash
  http://localhost:8092/canciones/mostrarcancionporid/{id}
  http://localhost:8092/cantantes/mostartcantanteporid/{id}
  http://localhost:8092/genero/mostrargeneroporid/{id}
```
**Post: guardar datos**
 ```bash
  http://localhost:8092/canciones/crearcancion
  http://localhost:8092/cantantes/crearcantante
  http://localhost:8092/genero/creargenero
```
**JSON: crear cancion**
 ```bash
  {
      "titulo": "El triste",
      "duracion": "180",
      "idcantante": 2,
      "idgenero": 1
  }
```

**Put: actualizar datos**
 ```bash
  http://localhost:8092/canciones/actualizarcancion/{id}
  http://localhost:8092/cantantes/actualizarcantante/{id}
  http://localhost:8092/genero/actualizargenero/{id}
```

**Delete: eliminar datos**
 ```bash
  http://localhost:8092/canciones/eliminarcancion/{id}
  http://localhost:8092/cantantes/eliminarcantante/{id}
  http://localhost:8092/genero/eliminargenero/{id}
```




