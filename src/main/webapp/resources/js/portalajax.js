// jQuery para o menu
$('a').each(function (index, item) {
    item.addEventListener("click", function (event) {
        var link = item.getAttribute('action') == null ? "link#" : item.getAttribute('action');
        $.get(link, function (resposta) {
            $(".content").html(resposta);
        });
    }, false);
});
