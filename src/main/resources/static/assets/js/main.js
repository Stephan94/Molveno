$( document ).ready(function() {

   var path = String(window.location.pathname);
   var api;
   var columns;

   navbarHighlight(path);

   // deduce API path from url, Build JSON for dataTable
   switch(path) {
       case "/tables":
           api = 'http://localhost:8080/api/tables';
           columns = [
               { "data": "id" },
               { "data": "capacity" },
               {  "render": function(data, type, full){
                   return '<a title="Delete this table" class="btn btn-default btn-sm"> <i class="fa fa-pencil-alt"></i> </a>';
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
                   return '<a title="Delete this table" <i class="fa fa-pencil-alt"></i> </a>';
               } },
           ];
           break;

            case "/bookings":
                        api = 'http://localhost:8080/api/bookings';
                        columns = [
                           { "data": "id" },
                           { "data": "table.id" },
                           { "data": "date" },
                           { "data": "timeSlot" },
                           { "data": "guest.lastName" },
                           { "data": "guest.phoneNumber" },
                           { "render": function(data, type, full){
                               return '<a title="Delete this table" class="btn btn-default btn-sm"> <i class="fa fa-pencil-alt"></i> </a>';
                            }},
                        ];
            break;


        case "/addBooking":
            api = 'http://localhost:8080/api/bookings'
            break;
      }

    //    alert("api: " +api)
    //    alert("columns: "+columns);


   $('#dataTable').DataTable( {
       "order": [[ 0, "asc" ]],
       "ajax": {
           url: api,
           dataSrc: ''
       },
       "columns": columns
   } );

   $('#dataTable').on( 'click', 'tr', function () {
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


   $("#addBtn").on( 'click', function (){
        $("#btnsubmit").attr('onclick', 'submitNew("' + api +'");');
        $('#modal').modal('toggle');
        document.getElementById("modalForm").reset();
  });

  $("#deleteBtn").on( 'click', function (){
        $("#btnsubmit").attr('onclick', 'submitDelete("' + api +'");');
    });

//       $("#submitNewBooking").on( 'click', function (){
//            console.log(api);
//           submitNewBooking(api);
//      });

});
