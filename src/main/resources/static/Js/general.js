//Declarando variables
var cjbusqueda = document.getElementById("caja-busqueda");
var text = document.getElementById("buscador");

var user = document.getElementById("btn-usuario");
var username = document.getElementById("usuario");
var nom = document.getElementById("nombre");
var Producto = document.getElementsByClassName("btn-compras");
var c = document.getElementById("ncompras");
var cont = 0;
var carrito = document.getElementById("carrito")
var hombre = document.getElementById("hombre");
var mujer = document.getElementById("mujer");
var mensaje = document.getElementById("msj")

//Llamando Funciones
user.addEventListener("click", userdown);
user.addEventListener("click", Cerrar);
user.addEventListener("dblclick", userup);
carrito.addEventListener("click",carritoCompras);
productos();

//Abrir y cerrar el Buscador
function abrir() {
    btnbusqueda.style.color = "#D92109";
    btnbusqueda.style.background = "white";
    text.style.width = "300px";
    text.style.padding = "0 6px";
    cjbusqueda.style.background = "#D92109";
}

function Cerrar() {
    btnbusqueda.style.color = "";
    btnbusqueda.style.background = "";
    text.style.width = "";
    text.style.padding = "";
    cjbusqueda.style.background = "";
    resultados.style.display = "";
    text.value = "";
}

//Funcion Buscar
function buscar() {
    filter = text.value.toUpperCase();
    h2 = resultados.getElementsByTagName("div");
    for (i = 0; i < h2.length; i++) {
        a = h2[i].getElementsByTagName("h2")[0];
        textValue = a.textContent || a.innerText;
        if (textValue.toUpperCase().indexOf(filter) > -1) {
            h2[i].style.display = "";
            resultados.style.display = "block";
            if (text.value === "") {
                resultados.style.display = "none";
            }
        } else {
            h2[i].style.display = "none";
        }
    }
}

function userdown() {
    username.style.display = "block";
}

function userup() {
    username.style.display = "none";
}

function carritoCompras(){
    if(c.innerText>0){
        window.location.href=window.location.origin+"/product/cart"
    }else {
        alert('Carrito Vaci??')
    }

}

//Funcion de Suma de Productos
function productos() {
    for (let i = 0; i < Producto.length; i++) {
        Producto[i].onclick = function () {
            fetch("/product/add-cart/" + this.value).then(value => {
                return value.json()
            }).then(data => {
                    c.innerText=data.length
                }
            ).catch(reason => {

                console.log(reason)
            })
        };
    }
}


//menu con JQuery
$(".btn").click(function () {
    $(this).toggleClass("click");
    $(".sidebar").toggleClass("show");
});
$(".feat-btn").click(function () {
    $("aside ul .feat-show").toggleClass("show");
    $("aside ul .first").toggleClass("rotate");
    $("aside ul .tiendas-show").removeClass("show1");
});
$(".tiendas-btn").click(function () {
    $("aside ul .tiendas-show").toggleClass("show1");
    $("aside ul .second").toggleClass("rotate");
});
$(".mantenimiento-btn").click(function () {
    $("aside ul .mantenimiento-show").toggleClass("show1");
    $("aside ul .third").toggleClass("rotate");
});
$("aside ul li").click(function () {
    $(this).addClass("active").siblings().removeClass("active");
});
