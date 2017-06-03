function createElement(user){
    var img = $("<img>")
            .attr("alt","Immagine del profilo")
            .attr("src",user.urlProfilo);
    var name = $("<strong>").html(user.nome,user.cognome);
    var link = $("<a>")
            .attr("href", "index.html?user="+user.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    var profilePic = $("<div>")
            .attr("class","profilePic")
            .append(img);
    
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(userData);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#search").click(function(){
        
        var wantedCat = $("#searchField")[0].value;
        
        $.ajax({
            url: "CercaAmiciAjax",
            data:{
                cmd:"search",
                nomeUtenteCercato: wantedCat
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
