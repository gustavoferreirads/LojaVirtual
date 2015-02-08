var idObject = 0;

// jQuery para o menu
$('a').each(function (index, item) {
    item.addEventListener("click", function (event) {
        var action = item.getAttribute('action');
        if (action != null) {
            $.get(action, function (resposta) {
                setContent(resposta,action);
            });
        }
    });
});

function setIdObject(id) {
    idObject = id;
}
function goBack(action) {
    $.get(action, function (resposta) {
        setContent(resposta,action);
    });
}

function newForm() {
    var urlNew = $("#grid-keep-selection").attr("actionNew");
    $.get(urlNew, function (resposta) {
        setContent(resposta,urlNew);
    });
}

function editForm() {
    var urlEdit = $("#grid-keep-selection").attr("actionEdit");
    var action = urlEdit + "?id=" + idObject;
    $.get(action, function (resposta) {
        setContent(resposta,action);
    });
    addMask();
}

function removeForm() {
    //Dialog de Confirmação
    var urlRemove = $("#grid-keep-selection").attr("actionRemove");
    var action = urlRemove + "?id=" + idObject;
    $.get(action, function (resposta) {
        setContent(resposta,action);
    });
}

function removeObject() {
    var form = $("#form");
    var action  = $("#form").attr("actionRemove");
    submitAjax(form, action);
    gridReload();
}


function submitNewForm() {
    var actionComplement = "Novo"
    var form = $("#form");
    var action = form.attr("action") + actionComplement;
    submitAjax(form, action)
}

function submitForm(){
    $("#form").submit(function(e) {
        e.preventDefault();
        var action =   $("#form").attr("action");
        if (action != null) {
            $.ajax({
                type: "POST",
                url: action,
                data: $("#form").serialize(),
                success: function (resposta) {
                    setContent(resposta,action);
                },
                error: function (resposta) {
                    setContent(resposta,action);
                }
            });
        }
    });
}
function submitAjax(form, action) {
    unMask();
    if (action != null) {
        $.ajax({
            type: "POST",
            url: action,
            data: form.serialize(),
            success: function (resposta) {
                setContent(resposta,action);
            },
            error: function (resposta) {
                setContent(resposta,action);
            }
        });
    }
}

function setContent(resposta,action){
    $(".content").html(resposta);
    if (action.indexOf("consulta") != -1) {
        gridReload();
    }
}


function  gridReload() {
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
    }).on("selected.rs.jquery.bootgrid",function (e, rows) {
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


$(function () {
    $("input[format='number']").bind("keyup blur focus", function (e) {
        e.preventDefault();
        var expre = /[^0-9]/g;
        // REMOVE OS CARACTERES DA EXPRESSAO ACIMA
        if ($(this).val().match(expre))
            $(this).val($(this).val().replace(expre, ''));
    });
});

function addMask(){
    $('.phone').mask('(00) 0000-0000');
    $('.cpf').mask('000.000.000-00', {reverse: true});
    $('.money').mask("#.##0,00", {reverse: true});
}

function unMask(){
    $('.phone').unmask();
    $('.cpf').unmask();
    $('.money').unmask();
}