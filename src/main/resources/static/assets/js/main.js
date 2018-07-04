
function apiGetSingleTable(id, api){

    apiPath = String(api +"/"+ id);
    alert(apiPath);
    $.get(apiPath, function(data){
        if (data){
            fillUpdateDiv(data, api);
        }
    });
}

function fillUpdateDiv(record, api){

    console.log(record);
    console.log(api);

    $("#btndelete").attr('onclick', 'submitDelete(' + record.id +', "' + api +'");');
    $("#btnsubmit").attr('onclick', 'submitEdit(' + record.id +', "' + api +'");');



    document.getElementById("modal-title").innerHTML="Edit";
    fillModal(record);
    $("#confirmbutton").css('display', 'inline-block');
    deleteID = record.id;
    var elem = '<button type="button" class="btn btn-danger" onclick="submitDelete('+record.id+', \'' +api+'\');">Confirm delete</button>';
    $('#confirmbutton').popover({
        animation:true,
        content:elem,
        html:true,
        container: modal
    });
}

function fillModal(record){
    var path = String(window.location.pathname);

    switch(path) {
        case "/tables":
            $("#id").val(record.id);
            $("#capacity").val(record.capacity);
            break;
        case "/guests":
            $("#id").val(record.id);
            $("#firstName").val(record.firstName);
            $("#lastName").val(record.lastName);
            $("#phoneNumber").val(record.phoneNumber);
    }
}



function deselect(){
    $('#dataTable tr.selected').removeClass('selected');
    // rloman TODO dit moet straks terug. ik denk dat dit het modal form is
    document.getElementById("modalForm").reset();
}

function submitEdit(id, api){
// shortcut for filling the formData as a JavaScript object with the fields in the form
    console.log("Formdata");
    var formData = $("#modalForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    console.log(formData);
    var id = formData.id;
    for(var key in formData){
        if(formData[key] == "" || formData == null) delete formData[key];
    }
    $.ajax({
        url: api + "/" + id,
        type:"put",
        data: JSON.stringify(formData),
        contentType: "application/json; charset=utf-8",
        success: getData(api),
        error: function(erro){
            console.log(error);
        }
    });

    deselect();
    $('#modal').modal('toggle');
}

function getData(api) {
      //var api = "http://localhost:8080/api/tables";
        alert(api);
        api = String(api);
        $.get(api, function(data){
            if (data){
                setData(data);
                window.location.reload(); // TODO clean up
            }
        });
}

function setData(data){
    $("#dataTable").DataTable().clear();
    $("#dataTable").DataTable().rows.add(data);
    $("#dataTable").DataTable().columns.adjust().draw();
}


function submitDelete(id, api){
    console.log("Deleting");
    var formData = $("#modalForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
    $.ajax({
        url:api + "/" + id,
        type:"delete",
        data: JSON.stringify(formData),
        success: getData(api),
        contentType: "application/json; charset=utf-8"
    });

    $('#myModal').modal('toggle');
    deselect();
}

// function setApiPath(currentPath){
//
//     switch(currentPath) {
//         case "/tables":
//         return 'http://localhost:8080/api/tables';
//     }
// }
//
// function setColumns(currentPath){
//
//     switch(currentPath) {
//         case "/tables":
//         var columns = [
//             { "data": "id" },
//             { "data": "capacity" },
//             {  "render": function(data, type, full){
//                     return '<a title="view this table" class="btn btn-default btn-sm "> <i class="fa fa-search"></i> </a><a title="edit this table" class="btn btn-default btn-sm "> <i class="fa fa-edit"></i> </a><a title="delete this table" class="btn btn-default btn-sm "> <i class="fa fa-trash-alt"></i> </a>';
//                 } },
//         ]
//         return columns;
//     }
//
// }


$( document ).ready(function() {

    var path = String(window.location.pathname);
    alert(path);
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
            apiGetSingleTable(data.id, api);
            $('#modal').modal('toggle');
        }
    });

});





