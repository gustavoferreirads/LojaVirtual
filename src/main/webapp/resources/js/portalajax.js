var idObject = 0;

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

function setIdObject(id) {
    idObject = id;
}
function goBack(action){
    $.get(action, function (resposta) {
        $(".content").html(resposta);
    });
}

function newForm() {
    var urlNew = $("#grid-keep-selection").attr("actionNew");
    $.get(urlNew, function (resposta) {
        $(".content").html(resposta);
    });
}

function editForm() {
    var urlEdit = $("#grid-keep-selection").attr("actionEdit");
    $.get(urlEdit + "?id=" + idObject, function (resposta) {
        $(".content").html(resposta);
    });
}

function removeForm() {
    //Dialog de Confirmação
    var urlEdit = $("#grid-keep-selection").attr("actionRemove");
    $.get(urlEdit + "?id=" + idObject, function (resposta) {
        $(".content").html(resposta);
    });
}

function removeObject(){
    $("#form").attr("actionRemove");
}


function submitForm() {
    var form = $("#form");
    var action = form.attr("action");
    submit(form, action)
}

function submitNewForm() {
    var actionComplement = "Novo"
    var form = $("#form");
    var action = form.attr("action") + actionComplement;
    submit(form, action)
}

function submit(form, action) {
    form.on('submit', function (ev) {
        ev.preventDefault();
        if (action != null) {
            $.ajax({
                type: "POST",
                url: action,
                data: $("#form").serialize(),
                success: function (resposta) {
                    $(".content").html(resposta);
                },
                error: function (resposta) {
                    $(".content").html(resposta);
                }
            });
        }
    });
}


//if ($("#submit").length) {
//    $("#submit").click(function () {
//        $("#form").on('submit', function (ev) {
//            var action = $("#form").attr("action");
//            ev.preventDefault();
//            if (action != null) {
//                $.ajax({
//                    type: "POST",
//                    url: action,
//                    data: $("#form").serialize(),
//                    success: function (resposta) {
//                        $(".content").html(resposta);
//                    },
//                    error: function (resposta) {
//                        $(".content").html(resposta);
//                    }
//                });
//            }
//        });
//        $("#form").submit();
//    })
//}


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


$(function(){
    $("input[format='number']").bind("keyup blur focus", function(e) {
        e.preventDefault();
        var expre = /[^0-9]/g;
        // REMOVE OS CARACTERES DA EXPRESSAO ACIMA
        if ($(this).val().match(expre))
            $(this).val($(this).val().replace(expre,''));
    });
});