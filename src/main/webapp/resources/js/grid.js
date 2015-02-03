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


