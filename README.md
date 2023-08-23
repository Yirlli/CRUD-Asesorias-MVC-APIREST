# CRUD-Asesorias-MVC-APIREST

El proyecto fue realizado con springboot 3 y spring security 6:

- Contiene 3 Roles diferentes como autoridades creado para cada tipo de usuario segun las funciones que este realize, como administratio, profesional o cliente.
- Se ha tomado el numero de rut como "username" para la autentificacion de los roles.
- Se implemento JPA para crear la relacion de entidades entre el objeto y la base de datos MySQL workbench
- Thymeleaf para asociar los atributos de las clases y el despliegue de los contenido en las vistas
- Patron de diseño MVC
- Se creo un controlador para manejar las API REST, en el cual se mapea en rutas publicas para sus accesos
- Tomando en cuenta las diferente relaciones entre las tables y las clases se implemento la anotacion JsonIgnore para evitar los bucles infinitos  y poder suministrar correctamente la informacion de los JSON ya que no se implemento el uso de DTO
