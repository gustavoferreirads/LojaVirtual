// jQuery para o menu
$('a').each(function (index, item) {
    item.addEventListener("click", function (event) {
        var action = item.getAttribute('action');
        if (action != null) {
            $.get(action, function (resposta) {
                $(".content").html(resposta);
            });
        }
    });
});

function submitForm() {
    var form = $("#form");
    var action = $("#form").attr("action");
    form.on('submit', function (ev) {
        ev.preventDefault();
        if (action != null) {
            $.ajax({
                type: "POST",
                url: action,
                data: $("#form").serialize(),
                success: function (resposta) {
                    $(".content").html(resposta);
                    //      alert( "OIIIIII sucesso" );
                },
                error: function (resposta) {
                    $(".content").html(resposta);
                }
            });
        }
    });
}

//$(":button").each(function (index, item) {
//    item.addEventListener("click", function (event) {
//        var action = $("#form").getAttribute('action');
//        if (action != null) {
//            var dados = $("#form").serialize();
//            alert("GABRIELLLAAA");
//            $.ajax({
//                type: "POST",
//                url: action,
//                data: dados,
//                success: function( msg ){
//                    alert( "OIIIIII sucesso" );
//                }
//            });
//        }
//    });
//});

//$.post(action, dados, function (resposta) {
//    alert('alert');
//});


//$("form").submit(function(e){
//    e.preventDefault();
//    // do ajax submition
//    $.ajax({
//        url: "SomeURL",
//        type: "POST",
//        data: $(this).serializeArray(),
//        success: function(data, status, xhr) {
//            // do the success stuff
//        },
//        error: function(xhr, status err) {
//        // do the error stuff
//    }
//});
//});
