$(document).ready(function(){
    $("btnAdd").click(function(){
        $.get("http://localhost:9090/country", function(data){
            // Display the returned data in browser
            $("#result").html(data);
        });
    });
});