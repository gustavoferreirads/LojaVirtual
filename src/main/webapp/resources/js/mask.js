/**
 * Created by Gustavo Ferreira on 17/02/2015.
 */

$(function () {
    $("input[format='number']").bind("keyup blur focus", function (e) {
        e.preventDefault();
        var expre = /[^0-9]/g;
        // REMOVE OS CARACTERES DA EXPRESSAO ACIMA
        if ($(this).val().match(expre))
            $(this).val($(this).val().replace(expre, ''));
    });
});

$('.phone').mask('(00) 0000-0000');
$('.cpf').mask('000.000.000-00', {reverse: true});
$('.money').mask("#.##0,00", {reverse: true});
$('.weight').mask("####0,000", {reverse: true});

$(function () {
    $('[data-toggle="tooltip"]').tooltip();
})