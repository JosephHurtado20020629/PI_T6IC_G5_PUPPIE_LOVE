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

    alert('Gracias por su compra Nro de pedido es 4')
})




