function getCurrentWeather(){
            var url = 'http://api.openweathermap.org/data/2.5/weather';
            $.ajax({
                url: url,
                dataType: "jsonp",
                data: { q: "santa clara,ca" },
                cache: false,
                success: function(data) {
                tempInCelsius = data.main.temp - 273.15;
                    unitsString = ("0".sup()).concat(" C");
                    var tempString = (Math.round(tempInCelsius).toString()).concat(unitsString);
                    //document.getElementById("weathervalue").innerHTML = tempString;
                    $('#weathervalue').html(tempString);              
                }
            });
        }
        
