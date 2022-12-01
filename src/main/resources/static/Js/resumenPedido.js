$('.btn-minus').on('click', function () {
    let val = $(this).val();

    $.ajax(
        window.location.origin + '/product/delete-cart/' + val
    ).done(function (data) {
        location.reload()
    }).fail(function (error) {
        console.log(error.statusText);
    });
})


$('.btn-plus').on('click', function () {
    let val = $(this).val();

    $.ajax(
        window.location.origin + '/product/add-cart/' + val
    ).done(function (data) {
        location.reload()
    }).fail(function (error) {
        console.log(error.statusText);
    });
})


$('#btn-comprar').on('click', function () {

    let dia = new Date().getDate();
    let mes = new Date().getMonth();
    let año = new Date().getFullYear();
    let hora = new Date().getHours();
    let minutos = new Date().getMinutes();
    let segundos = new Date().getSeconds();
    let entrega = dia + 5
    let envio = dia + 2

    let diaActual = año + '-' + mes + '-' + dia + ' ' + hora + ':' + minutos + ':' + segundos
    let diaEnvio = año + '-' + mes + '-' + envio+ ' ' + hora + ':' + minutos + ':' + segundos
    let diaEntrega = año + '-' + mes + '-' + entrega + ' ' + hora + ':' + minutos + ':' + segundos
    let sede=$('#idSede').val()
    let direccionval=$('#direccion')

    let json={
        idSede:sede,
        fechaPedido:diaActual,
        fechaAproxEntrega:diaEntrega,
        fechaEnvio:diaEnvio,
        destinatario:$('#nombre').text(),
        direccion:direccionval
    }

    $.ajax({
        url: window.location.origin+'/product/shop',
        data: JSON.stringify(json),
        async: true,
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        beforeSend: function () {
            $('.btn-minus').attr('disabled',true)
            $('.btn-plus').attr('disabled',true)
        },
        error: function (res) {

        },
        success: function (res) {
            $('.btn-minus').attr('disabled',false)
            $('.btn-plus').attr('disabled',false)
            alert('Su compra se ha registrado con exito')
        }
    })
})




