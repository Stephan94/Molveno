
$( document ).ready(function() {

$("#dataTable").DataTable();

});


$('#tableTable').DataTable( {
    "order": [[ 0, "asc" ]],
    "ajax": {
        url: 'http://localhost:8080/api/tables',
        dataSrc: ''
    },
    "columns": [
        { "data": "id" },
        { "data": "capacity" },
        {  "render": function(data, type, full){
                return '<a title="view this table" class="btn btn-default btn-sm "> <i class="fa fa-search"></i> </a><a title="edit this table" class="btn btn-default btn-sm "> <i class="fa fa-edit"></i> </a><a title="delete this table" class="btn btn-default btn-sm "> <i class="fa fa-trash-alt"></i> </a>';
        } },
    ]
} );
