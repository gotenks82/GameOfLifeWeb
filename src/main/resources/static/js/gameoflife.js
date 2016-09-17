$(document).ready(function(){

    $('button#generate').click(function() {
        var universe = $('#universe')
        universe.empty();
        universe.append('<table id="universeTable" class="center"></table>');
        var x = $('#sizeX').val();
        var y = $('#sizeY').val();
        if (!x || !y) {
            alert("Missing dimensions!");
        }
        for (var i = 0; i < x; i++) {
            $('#universeTable').append('<tr id="row_'+i+'"></tr>');
            for (var j = 0; j < y; j++) {
                $('#row_'+i).append('<td data-x="'+i+'" data-y="'+j+'" class="cell dead"></td>')
            }
        }
        $('button#evolve').removeClass('hidden');

    });

    $(document).on('click', "td.cell", function() {
        if ($(this).hasClass("dead")) {
            $(this).removeClass("dead");
            $(this).addClass("alive");
        } else {
            $(this).removeClass("alive");
            $(this).addClass("dead");
        }
    });

    $("#evolve").click(function() {
        var aliveCells = [];
        $(".alive").each(function () {
            aliveCells.push({x: $(this).data('x'), y: $(this).data('y')});
        });
        $.ajax({
            type: 'POST',
            url: '/evolve/',
            data: JSON.stringify({
                sizeX: $('#sizeX').val(),
                sizeY: $('#sizeY').val(),
                aliveCells: aliveCells
            }),
            success: function(data) {
                $('button#generate').click()
                data.aliveCells.forEach(function(element) {
                    $('td[data-x='+element.x+'][data-y='+element.y+']').click();
                });
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });
});