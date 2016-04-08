$(document).ready(function () {


    var getMembers = function () {
        $.ajax({
            url: "http://localhost:8080/AngularJQuery/api/member/complete",
            type: "GET",
            dataType: "json",
        }).then(function (data) {
            var row;
            row = "<tr>\n\
            <td><h4><b>id</b></h4></td><td><h4><b>age</b></h4></td><td><h4><b>eyeColor</b></h4></td><td><h4><b>name</b></h4></td><td><h4><b>email</b></h4></td><td><h4><b>friends</b></h4></td>";
            $('#thead').append(row);

            for (var i = 0; i < data.length; i++) {
//                var friends = [];
//                for (var j = 0; j < data[i].friends.length; j++) {
//                    friends += data[i].friends[j].description + ": " + data[i].friends[j].number + "\n";
//                }
//                var hobbies = "";
//                for (var j = 0; j < data[i].hobbies.length; j++) {
//                    hobbies += data[i].hobbies[j].name + "\n";
//                }
                row = "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].age + "</td>" +
                        "<td>" + data[i].eyeColor + "</td>" +
                        "<td>" + data[i].name + "</td>" +
                        "<td>" + data[i].email + "</td>" +
                        +"</tr>";
//                $("#test").empty();
                $('#tbody').append(row);
            }

        });
    };
    getMembers();
});