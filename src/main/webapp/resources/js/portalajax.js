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

$(":button").each(function (index, item) {
    item.addEventListener("click", function (event) {
        var action = $("#form").getAttribute('action');
        if (action != null) {
            var dados = $("#form").serialize();
            $.ajax({
                type: "POST",
                url: action,
                data: dados,
                success: function( msg ){
                    alert( "OIIIIII sucesso" );
                }
            });
        }
    });
});

