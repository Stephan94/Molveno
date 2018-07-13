function getData(api) {
   //if(window.location.pathname == "/addBooking"){return;}
   //var api = "http://localhost:8080/api/tables";
   api = String(api);

   $.get(api, function(data){
       if (data){
            $("#dataTable").DataTable().clear();
            $("#dataTable").DataTable().rows.add(data);
            $("#dataTable").DataTable().columns.adjust().draw();
            $("#dataTable").dataTable().api().ajax.reload();
       }
   });
}


function getSingleRecord(id, api){

   apiPath = String(api +"/"+ id);
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
           break;
       case "/bookings":

           $("#guestid").val(record.guest.id);
           $("#guestFirstName").val(record.guest.firstName);
           $("#guestLastName").val(record.guest.lastName);
           $("#phoneNumber").val(record.guest.phoneNumber);
           $("#tableNumber").val(record.table.id);
           $("#tableCapacity").val(record.table.capacity);
           $("#bookingDate").val(record.date);
           $("#bookingTime").val(record.time);
           break;
       case "/addBooking":
           $("#capacity").val(record.table.capacity);
           $("#lastName").val(record.guest.lastName);
           $("#phoneNumber").val(record.guest.phoneNumber);
           break;
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


    var path = window.location.pathname;
    var JSONObjectInString;

    switch(path){

        case "/bookings":
             JSONObjectInString =
            {
                 "guest": {
                     "firstName": guestFirstName.value,
                     "lastName": guestLastName.value,
                     "phoneNumber": phoneNumber.value
                 },
                 "table": {
                     "id": tableNumber.value,
                     "capacity": tableCapacity.value
                 },
                 "date": null,
                 "time": null
            }

        break;

        case "/tables":
            JSONObjectInString = formData;
        break;

        case "/guests":
            JSONObjectInString = formData;
        break;
    }


   $.ajax({
       url: api + "/" + id,
       type:"put",
       data: JSON.stringify(JSONObjectInString),
       contentType: "application/json; charset=utf-8",
       success: getData(api),
       error: function(error){
           console.log(error);
       }
   });

   deselect();
   $('#modal').modal('toggle');
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

   $('#modal').modal('toggle');
}

function navbarHighlight(path){
   switch(path) {
       case "/tables":
         $("#navTables").addClass("active");
           break;

       case "/guests":
           $("#navGuests").addClass("active");
           break;

       case "/bookings":
           $("#navBookings").addClass("active");
           break;

       case "/mainMenu":
           $("#navEmployee").addClass("active");
           break;

       default:
           $("#navHome").addClass("active");
           break;
   }
}

function submitNew(api){
   console.log("Formdata");
   var formData = $("#modalForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
   console.log(formData);
   //var id = formData.id;
   for(var key in formData){
       if(formData[key] == "" || formData == null) delete formData[key];
   }

   console.log(JSON.stringify(formData));


   $.ajax({
       url: api,
       type:"post",
       data: JSON.stringify(formData),
       contentType: "application/json; charset=utf-8",
       success: getData(api),
       error: function(error){
           console.log(error);
       }
   });

    //if(window.location.pathname == "/addBooking"){return;}

   deselect();
   $('#modal').modal('toggle');
}

function submitNewBooking(api){
//   console.log("Formdata");
//   var formData = $("#modalForm").serializeArray().reduce(function(result, object){ result[object.name] = object.value; return result}, {});
//   console.log(formData);
//   //var id = formData.id;
//   for(var key in formData){
//       if(formData[key] == "" || formData == null) delete formData[key];
//   }

   //console.log(JSON.stringify(formData));

console.log(JSON.stringify({
    "guest": {
     "firstName": guestFirstName.value,
     "lastName": guestLastName.value,
     "phoneNumber": phoneNumber.value
},
    "table": {
     "capacity": tableCapacity.value
},
    "date": bookingDate.value,
    "timeSlot": bookingTime.value
}));



   $.ajax({
       url: api,
       type:"post",
       data: JSON.stringify({
        "guest": {
         "firstName": guestFirstName.value,
         "lastName": guestLastName.value,
         "phoneNumber": phoneNumber.value
        },
        "table": {
         "capacity": tableCapacity.value
        },
        "date": bookingDate.value,
        "timeSlot": bookingTime.value
       }),
       contentType: "application/json; charset=utf-8",
       success: alert("Your booking has been confirmed"),
       error: function(error){
           console.log(error);
       }
   });
}

//$( function() {
//    $("#bookingDate").datepicker({dataFormat: "yyyy-MM-dd"});
//} );

