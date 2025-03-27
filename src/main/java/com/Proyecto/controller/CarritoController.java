/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author pablo
 */
@Controller
public class CarritoController {

    @GetMapping("carrito/carrito")
    public String mostrarCarrito() {
        return "carrito/carrito"; 
    }
}

