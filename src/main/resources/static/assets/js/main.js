


$( document ).ready(function() {

    var path = String(window.location.pathname);
    var api;
    var columns;


    switch(path) {
        case "/tables":
            api = 'http://localhost:8080/api/tables';
            columns = [
                { "data": "id" },
                { "data": "capacity" },
                {  "render": function(data, type, full){
                    return '<a title="view this table" class="btn btn-default btn-sm "> <i class="fa fa-search"></i> </a><a title="edit this table" class="btn btn-default btn-sm "> <i class="fa fa-edit"></i> </a><a title="delete this table" class="btn btn-default btn-sm "> <i class="fa fa-trash-alt"></i> </a>';
                } },
            ];
            break;

        case "/guests":
            api = 'http://localhost:8080/api/guests';
            columns = [
                { "data": "id" },
                { "data": "firstName" },
                { "data": "lastName" },
                { "data": "phoneNumber" },
                {  "render": function(data, type, full){
                        return '<a title="view this table" class="btn btn-default btn-sm "> <i class="fa fa-search"></i> </a><a title="edit this table" class="btn btn-default btn-sm "> <i class="fa fa-edit"></i> </a><a title="delete this table" class="btn btn-default btn-sm "> <i class="fa fa-trash-alt"></i> </a>';
                    } },
            ];
            break;
    }

    //alter addButton
    $("#addButton").click(function() {

                var jsonObject = {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    phoneNumber: $("#phoneNumber").val()
                };
                 $.ajax({
                        contentType : "application/json",
                         // waar moet hij de request op uitvoeren
                         url : baseUrl+"persons",
                         // type actie
                         type : "post",
                         data: JSON.stringify(jsonObject),
                         // als de actie lukt, voer deze functie uit
                         success: function(data){ // so the data is the bulb of the response of the Spring Boot REST controller

                                $("#newId").html(data.id);
                                $("#newFirstName").html(data.firstName);
                                $("#newLastName").html(data.lastName);

                                $("#addedPerson").show(1000);

                                $("#addedPerson").hide(1000);

                              console.log(data);
                         }
                     });
              });
    });

    $('#dataTable').DataTable( {
        "order": [[ 0, "asc" ]],
        "ajax": {
            url: api,
            dataSrc: ''
        },
        "columns": columns
    } );


    $('#dataTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            deselect();
            $(this).addClass('selected');
            var table = $('#dataTable').DataTable();
            var data = table.row(this).data();
            getSingleRecord(data.id, api);
            $('#modal').modal('toggle');
        }
    });

});





