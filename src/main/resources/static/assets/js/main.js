
function apiGetSingleTable(id){
    var api = "http://localhost:8080/api/tables/" + id;
    $.get(api, function(data){
        if (data){
            fillUpdateDiv(data);
        }
    });
}

function fillUpdateDiv(table){

    console.log(table);
    $("#btndelete").attr('onclick', 'submitDelete(' + table.id + ');');
    $("#btnsubmit").attr('onclick', 'submitEdit(' + table.id + ');');
    document.getElementById("modal-title").innerHTML="Edit Guest";
    $("#id").val(table.id);
    $("#capacity").val(table.capacity);
    $("#confirmbutton").css('display', 'inline-block');
    deleteID = table.id;
    var elem = '<button type="button" class="btn btn-danger" onclick="submitDelete();">Confirm delete</button>';
    $('#confirmbutton').popover({
        animation:true,
        content:elem,
        html:true,
        container: modal
    });
}

function deselect(){
    $('#dataTable tr.selected').removeClass('selected');
    // rloman TODO dit moet straks terug. ik denk dat dit het modal form is
    document.getElementById("tablesForm").reset();
}

function submitEdit(id){
// shortcut for filling the formData as a JavaScript object with the fields in the form
    console.log("Formdata");
    var formData = $("#tablesForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    console.log(formData);
    var id = formData.id;
    for(var key in formData){
        if(formData[key] == "" || formData == null) delete formData[key];
    }
    $.ajax({
        url:"/api/tables/" + id,
        type:"put",
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        success: getData,
        error: function(error){
            console.log(error);
        }
    });

    deselect();
    $('#modal').modal('toggle');
}

function getData() {
      var api = "http://localhost:8080/api/tables";
        $.get(api, function(data){
            if (data){
                setData(data);
            }
        });
}

function setData(data){
    $("#dataTable").DataTable().clear();
    $("#dataTable").DataTable().rows.add(data);
    $("#dataTable").DataTable().columns.adjust().draw();
}


$( document ).ready(function() {
//$("#dataTable").DataTable();


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
    }


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
            apiGetSingleTable(data.id);
            $('#modal').modal('toggle');
        }
    });


});





