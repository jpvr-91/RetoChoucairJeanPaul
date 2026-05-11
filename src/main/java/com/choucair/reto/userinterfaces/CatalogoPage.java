package com.choucair.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CatalogoPage {
    public static final Target CATEGORIA_APPAREL = Target.the("categoría Apparel & Shoes")
            .located(By.linkText("APPAREL & SHOES"));
    
    public static final Target PRODUCTO_BLUE_JEANS = Target.the("producto Blue Jeans")
            .located(By.linkText("Blue Jeans"));
    
    public static final Target BOTON_ADD_TO_CART = Target.the("botón agregar al carrito")
            .located(By.id("add-to-cart-button-36"));
            
    public static final Target LINK_SHOPPING_CART = Target.the("enlace al carrito de compras")
            .located(By.className("ico-cart"));
}