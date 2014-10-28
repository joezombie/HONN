/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */

$(function(){
   refreshRatings();

    $("#send_rating").on("click", function(){
        var rating = {};
        rating.comment = $("#comment_field").val();
        rating.rating = parseInt($("#rating").val());
        rating.riderId = 1;
        postRating(rating);
    });

    $("#show_comment_form").on("click", function(){
        $("#add_comment").hide();
        $("#rating_form").show();
    })
});

function refreshRatings(){
    $("#ratings_body").html("");
    $.get("/api/v1/driver/" + driverId + "/ratings", function(data){
        $.each(data, function(index, value){
            $("#ratings_body").append(
                    "<tr>" +
                    "<td>" + value.rating + "</td>" +
                    "<td>" + value.comment + "</td>" +
                    "</tr>"
            );
        })
        $("#ratings_body").append(data);
    });
}

function postRating(rating){
    $.ajax({
        type: "POST",
        url: "/api/v1/driver/" + driverId + "/rating",
        data: JSON.stringify(rating),
        contentType: "application/json",
        success: function() {
            refreshRatings();
            $("#add_comment").show();
            $("#rating_form").hide();
        }
    });
}


