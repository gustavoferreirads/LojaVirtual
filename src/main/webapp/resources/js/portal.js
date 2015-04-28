var idObject = 0;
$(document).ready(function () {
// jQuery para o menu
    $('a').each(function (index, item) {
        item.addEventListener("click", function (event) {
            var action = item.getAttribute('action');
            if (action != null) {
                $.get(action, function (resposta) {
                    setContent(resposta, action);
                    mask();
                });
            }
        });
    });

    $('#form').on('submit', function(e){
        e.preventDefault();
        unMask();
        this.submit();
    });


    CKEDITOR.replace( 'text-editor' , {
        language: 'pt-br'
    });

});


setIdObject = function (id) {
    idObject = id;
}

goBack = function (action) {
    getAjax(action);
}

newForm = function () {
    var url = $("#grid-keep-selection").attr("actionNew");
    $(window.document.location).attr('href', url);
    //getAjax(urlNew);
}

getAjax = function (url) {
    $.get(url, function (resposta) {
        setContent(resposta, url);
        mask();
    });

}
editForm = function () {
    var urlEdit = $("#grid-keep-selection").attr("actionEdit");
    var action = urlEdit + "?id=" + idObject;
//    $.get(action, function (resposta) {
//        setContent(resposta, action);
//        mask();
//    });
    $(window.document.location).attr('href', action);
}

removeForm = function () {
    //Dialog de Confirmação
    var urlRemove = $("#grid-keep-selection").attr("actionRemove");
    var action = urlRemove + "?id=" + idObject;
    $.get(action, function (resposta) {
        setContent(resposta, action);
    });
}

removeObject = function () {
    var form = $("#form");
    var action = $("#form").attr("actionRemove");
    submitAjax(action);
    gridReload();
}


submitNewForm = function () {
    submitAjax($("#form").attr("action") + "Novo")
}

submitForm = function () {
    $("#form").onSubmit(function (e) {
        e.preventDefault();
        unMask();
        $("#form").submit();
      //  submitAjax($("#form").attr("action"))
    });
}

submitAjax = function (action) {
    unMask();
    if (action != null) {
        $.ajax({
            type: "POST",
            url: action,
            data: $("#form").serialize(),
            success: function (resposta) {
                setContent(resposta, action);
                mask();
            },
            error: function (resposta) {
                setContent(resposta, action);
            }
        });
    }
}

setContent = function (resposta, action) {
    $(".content").html(resposta);
    if (action.indexOf("consulta") != -1) {
        gridReload();
    }
}


gridReload= function () {
    var action = $("#grid-keep-selection").attr("action");
    $("#grid-keep-selection").bootgrid({
        ajax: true,
        post: function () {
            /* To accumulate custom parameter with the request object */
            return {
                id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
            };
        },
        url: action,
        selection: true,
        multiSelect: false,
        rowSelect: true,
        keepSelection: true,
        rowCount: [10, 25, 50, -1],
        navigation: 3, // it's a flag: 0 = none, 1 = top, 2 = bottom, 3 = both (top and bottom)
        padding: 2, // page padding (pagination)
        formatters: {
            "link": function (column, row) {
                return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
            }
        }
    }).on("selected.rs.jquery.bootgrid", function (e, rows) {
        var rowIds = [];
        for (var i = 0; i < rows.length; i++) {
            rowIds.push(rows[i].id);
        }
        setIdObject(rowIds[0]);
        //alert("Select: " + rowIds.join(","));
        $("#btn-edit-form").toggleDisabled();
    }).on("deselected.rs.jquery.bootgrid", function (e, rows) {
        var rowIds = [];
        for (var i = 0; i < rows.length; i++) {
            rowIds.push(rows[i].id);
        }
        //    alert("Deselect: " + rowIds.join(","));
        $("#btn-edit-form").toggleDisabled();
    });

    (function ($) {
        $.fn.toggleDisabled = function () {
            return this.each(function () {
                this.disabled = !this.disabled;
            });
    };
})(jQuery);

}

unMask = function () {
    $('.phone').unmask();
    $('.cpf').unmask();
    $('.money').unmask();
    $('.weight').unmask();
}

mask = function () {
    $('.phone').mask('(00) 0000-0000');
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.money').mask("#.##0,00", {reverse: true});
    $('.weight').mask("####0,000", {reverse: true});
}


$(function () {
    $("input[format='number']").bind("keyup blur focus", function (e) {
        e.preventDefault();
        var expre = /[^0-9]/g;
        // REMOVE OS CARACTERES DA EXPRESSAO ACIMA
        if ($(this).val().match(expre))
            $(this).val($(this).val().replace(expre, ''));
    });
});

$(function () {
    $('[data-toggle="tooltip"]').tooltip();
    mask();

});

$('.navbar-toggle.lateral').click(function () {
    $('#accordian').toggle();
});



$('#textarea').textext({  plugins : 'focus tags' });