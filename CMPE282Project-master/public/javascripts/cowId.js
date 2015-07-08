JSONTest = function() {
            var value = document.getElementById('cowId').value; 
		    var url = "http://localhost:9000/compute/AmazonS3/Requests/"+value; 
		     
            $.ajax({
                url: url,
                type: 'POST',
                data: {"username":sravya},
                async: false,
                success: function (result) {
                /*alert("In success");
                switch (result) {
                    case true:
                          processResponse(result);
                          break;
                    default:
                          resultDiv.html(result);
                }*/
             },
             error: function (xhr, ajaxOptions, thrownError) {
             alert("Successfully uploaded files. Please check dashboard");
             //alert(xhr.status);
             //alert(thrownError);
             }
           });
          };
                  