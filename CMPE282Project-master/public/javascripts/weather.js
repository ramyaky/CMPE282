function getCurrentWeather(){
            var url = 'http://api.openweathermap.org/data/2.5/weather';
            $.ajax({
                url: url,
                dataType: "jsonp",
                data: { q: "santa clara,ca" },
                cache: false,
                success: function(data) {
                    tempInCelsius = data.main.temp - 273.15;
                    weatherString = ", ".concat(data.weather[0].main);
                    weatherIcon = data.weather[0].icon;
                    src = "/assets/images/" + weatherIcon + ".png";
                    $("#displayImage").attr("src", src);
                    unitsString = (("0".sup()).concat(" C")).concat(weatherString);
                    var tempString = (Math.round(tempInCelsius).toString()).concat(unitsString);
                    $('#weathervalue').html(tempString);              
                }
            });
        }
        
