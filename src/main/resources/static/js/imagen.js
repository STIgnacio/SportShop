/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

var seleccionado = false;
var seleccionadocarro = false;

function cambiarImagen(imagen) {
    if (seleccionado) {
        imagen.src = 'img/favorito.png';
        seleccionado = false;
    } else {
        imagen.src = 'img/favorito_hover.png';
        seleccionado = true;
    }
    imagen.onmouseover = null;
    imagen.onmouseout = null;
}

function cambiarImagencarro(imagen) {
    if (seleccionadocarro) {
        imagen.src = 'img/carrito.png';
        seleccionadocarro = false;
    } else {
        imagen.src = 'img/carrito_hover.png';
        seleccionadocarro = true;
    }
    imagen.onmouseover = null;
    imagen.onmouseout = null;
}
