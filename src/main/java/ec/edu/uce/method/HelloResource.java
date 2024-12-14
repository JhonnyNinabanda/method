package ec.edu.uce.method;

import ec.edu.uce.method.clases.Card;
import ec.edu.uce.method.clases.Pay;
import ec.edu.uce.method.clases.Product;
import ec.edu.uce.method.clases.User;
import ec.edu.uce.method.service.CrudService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/hello-world")
public class HelloResource {
    private CrudService crudService = new CrudService(); // Instancia del servicio CRUD

    // Método GET para obtener todos los usuarios
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return crudService.getAllUsers(); // Llama al servicio CRUD para obtener todos los usuarios
    }

    // Método GET para obtener un usuario por ID
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id) {
        User user = crudService.getUserById(id);
        if (user != null) {
            return Response.ok(user).build(); // Si existe, se retorna el usuario
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build(); // Si no existe
        }
    }

    // Método POST para crear un nuevo usuario
    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        crudService.createUser(user); // Llama al servicio CRUD para crear el usuario
        return Response.status(Response.Status.CREATED).entity(user).build(); // Devuelve el usuario creado
    }

    // Método PUT para actualizar un usuario existente
    @PUT
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, User user) {
        User existingUser = crudService.getUserById(id);
        if (existingUser != null) {
            user.setId(id); // Establece el ID para que el servicio lo actualice correctamente
            crudService.updateUser(user); // Llama al servicio CRUD para actualizar el usuario
            return Response.ok(user).build(); // Devuelve el usuario actualizado
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build(); // Si no existe
        }
    }

    // Método para eliminar un usuario
    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        User user = crudService.getUserById(id);
        if (user != null) {
            crudService.deleteUser(id); // Llama al servicio CRUD para eliminar el usuario
            return Response.status(Response.Status.NO_CONTENT).build(); // Respuesta de éxito
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build(); // Si no existe
        }
    }

    // Método para obtener todos los productos
    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return crudService.getAllProducts(); // Llama al servicio CRUD para obtener todos los productos
    }

    // Método para obtener un producto por ID
    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") Long id) {
        Product product = crudService.getProductById(id);
        if (product != null) {
            return Response.ok(product).build(); // Si existe, se retorna el producto
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build(); // Si no existe
        }
    }

    // Método para crear un producto
    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        crudService.createProduct(product); // Llama al servicio CRUD para crear el producto
        return Response.status(Response.Status.CREATED).entity(product).build(); // Devuelve el producto creado
    }

    // Método para actualizar un producto existente
    @PUT
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        Product existingProduct = crudService.getProductById(id);
        if (existingProduct != null) {
            product.setId(id); // Establece el ID para que el servicio lo actualice correctamente
            crudService.updateProduct(product); // Llama al servicio CRUD para actualizar el producto
            return Response.ok(product).build(); // Devuelve el producto actualizado
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build(); // Si no existe
        }
    }

    // Método  para eliminar un producto
    @DELETE
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") Long id) {
        Product product = crudService.getProductById(id);
        if (product != null) {
            crudService.deleteProduct(id); // Llama al servicio CRUD para eliminar el producto
            return Response.status(Response.Status.NO_CONTENT).build(); // Respuesta de éxito
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Producto no encontrado").build(); // Si no existe
        }
    }

    // Método para obtener todos los pagos
    @GET
    @Path("/pays")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pay> getAllPays() {
        return crudService.getAllPays(); // Llama al servicio CRUD para obtener todos los pagos
    }

    // Método para crear un pago
    @POST
    @Path("/pay")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPay(Pay pay) {
        crudService.createPay(pay); // Llama al servicio CRUD para crear el pago
        return Response.status(Response.Status.CREATED).entity(pay).build(); // Devuelve el pago creado
    }

    // Método para eliminar un pago
    @DELETE
    @Path("/pay/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePay(@PathParam("id") Long id) {
        Pay pay = crudService.getPayById(id);
        if (pay != null) {
            crudService.deletePay(id); // Llama al servicio CRUD para eliminar el pago
            return Response.status(Response.Status.NO_CONTENT).build(); // Respuesta de éxito
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Pago no encontrado").build(); // Si no existe
        }
    }

    // Método para obtener todas las tarjetas
    @GET
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getAllCards() {
        return crudService.getAllCards(); // Llama al servicio CRUD para obtener todas las tarjetas
    }

    // Método para crear una tarjeta
    @POST
    @Path("/card")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCard(Card card) {
        crudService.createCard(card); // Llama al servicio CRUD para crear la tarjeta
        return Response.status(Response.Status.CREATED).entity(card).build(); // Devuelve la tarjeta creada
    }

}