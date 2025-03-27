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
public class SobreNosotrosContoller {

    @GetMapping("sobreNosotros/sobre-nosotros")
    public String mostrarSobreNosotros() {
        return "sobreNosotros/sobre-nosotros"; 
    }
}

