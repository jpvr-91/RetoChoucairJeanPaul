# language: es
Característica: Flujo completo de usuario en Demo Web Shop

  @Registro
  Escenario: 1. Registro exitoso de un nuevo cliente
    Dado que el usuario navega a la página de registro
    Cuando ingresa los datos requeridos
    Entonces el usuario debería ver el mensaje de bienvenida

  @Compra
  Escenario: 2. Compra exitosa de un producto con tarjeta
    Dado que el usuario inicia sesión con sus credenciales
    Cuando selecciona un producto de una categoría y lo agrega al carrito
    Y completa el proceso de checkout con tarjeta Visa
    Entonces debería ver el mensaje "Your order has been successfully processed!"