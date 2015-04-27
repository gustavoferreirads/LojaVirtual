//var files;
//function handleFileSelect(evt) {
//    files = evt.target.files;
//    // FileList object
//    // Loop through the FileList and render image files as thumbnails.
//    for (var i = 0, f; f = files[i]; i++) {
//        // Only process image files.
//        if (!f.type.match('image.*')) {
//            continue;
//        }
//        var reader = new FileReader();
//        // Closure to capture the file information.
//        reader.onload = (function (theFile) {
//            return function (e) {
//                // Render thumbnail.
//        div     var span = document.createElement('div');
//                span.className  = 'photo';
//                span.innerHTML = ['<img class="thumb" src="', e.target.result, '" title="', escape(theFile.name), '"/>'].join('');
//                document.getElementById("list").insertBefore(span, null);
//            };
//        })(f);
//        // Read in the image file as a data URL.
//        reader.readAsDataURL(f);
//        files[i] = f;
//    }
//}

$(document).ready(function() {

    $('#empty').click(getFile);

    function getFile() {
        document.getElementById("files").click();
    }

    function handleFileSelect(evt) {
        var oMyForm = new FormData();
        oMyForm.append("file", evt.target.files[0]);
        $.ajax({
            url: 'upload',
            data: oMyForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                var div = document.createElement('div');
                div.className = 'photo';
                div.innerHTML = data;
                document.getElementById("list").insertBefore(div, null);
                div.addEventListener("click", function (event) {
                    document.getElementById("preview").innerHTML = data;
                    $('.modalPreview').modal('show');
                    document.getElementById('btRemoveImg').addEventListener('click', removeImg, false);
                });
                $('[data-toggle="tooltip"]').tooltip();
            }
        });
    }

    document.getElementById('files').addEventListener('change', handleFileSelect, false);


    function removeImg(evt) {
        var id = document.querySelector('#preview img').id;
        $.get("removeImg?id=" + id, function (resposta) {
            document.getElementById(id).remove();
        });
    }


    $('.photo').each(function (index, item) {
        item.addEventListener("click", function (event) {
            document.getElementById("preview").innerHTML = item.innerHTML;
            document.getElementById('btRemoveImg').addEventListener('click', removeImg, false);
            $('.modalPreview').modal('show');
        });
    });

});