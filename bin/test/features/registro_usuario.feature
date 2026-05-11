# language: es

Característica: Registro de usuario en Demo Web Shop

  @RegistroExitoso
  Escenario: Registro exitoso de un nuevo cliente
    Dado que el usuario navega a la página de registro
    Cuando ingresa los datos requeridos
    Entonces el usuario debería ver el mensaje de bienvenida




  @Compra
  Escenario: Compra exitosa de un producto con tarjeta de crédito
    Dado que el usuario inicia sesión con sus credenciales
    Cuando selecciona un producto de una categoría y lo agrega al carrito
    Y completa el proceso de checkout con tarjeta Visa
    Entonces debería ver el mensaje "Your order has been successfully processed!"
    