// 검색엔진
function searchIndex(){
    var test = $('.search-txt').val();
    console.log(test);
    $.ajax({
        url: 'http://localhost:8080/library/test/'+test,
        type : 'GET',
        dataType : 'json',
        success : function(response){                  
            console.log(response);
            var html = "";
            for(var i=0; i<response.length; i++){
                if(response[i].use){
                    html += '<tr id="libraryOne" onclick="getPopUpNew('+(response[i].uniqueNumber)+')"><td>'+response[i].uniqueNumber+'</td><td>'+response[i].name+'</td><td>'+response[i].genre+'</td><td>'+response[i].author+'</td><td>가능</td></tr>'
                }else{
                    html += '<tr id="dontlibraryOne"><td>'+response[i].uniqueNumber+'</td><td>'+response[i].name+'</td><td>'+response[i].genre+'</td><td>'+response[i].author+'</td><td>불가능</td></tr>'
                }                               
            }
            localStorage.setItem('search', html);
            $('.search-txt').empty();
            $('#book_list').empty();
            $('#book_list').append(html);
        }            
    });
}

/* 로그아웃 기능 */
function user_logout(){    
    $('#user_login_id').val("");
    $('#user_login_pw').val("");
    $('#user_message').empty();
    $('#user_message').append("로그인 필요");
    $('#login_popup').css('display', 'block');
}

/* 자동 로그인 기능 구현중...*/   
function login_maintain(){   
    console.log (localStorage.getItem('user_infomation_id'));
    var check = localStorage.getItem('user_infomation_id');
    if(check!=null){
        console.log("실행됨!!!...");
        var message = localStorage.getItem('user_infomation_id')+"님 어서오세요 "+'<i id="logout_btn" class="fa-solid fa-power-off" onclick="user_logout()"></i>';
        $('#user_message').empty();
        $('#user_message').append(message);
    }else{
        var message = "로그인 필요";
        $('#user_message').empty();
        $('#user_message').append(message);
    }
}

/* 로그인 구현 ajax */    
function user_login(){        
    var id = $('#user_login_id').val();
    var pw = $('#user_login_pw').val();
    var message = "";
    $.ajax({            
        url: 'http://localhost:8080/library/test/login/'+id,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response);
            console.log(response[0].pw+","+pw);                
            if(pw==response[0].pw){
                alert("어서와라");
                var identity = response[0].id;
                var password = response[0].pw;
                var name = response[0].name;
                var email = response[0].email;
                message = response[0].id+"님 어서오세요  "+'<i class="fa-solid fa-power-off" onclick="user_logout()"></i>';
                $('#user_message').empty();
                $('#user_message').append(message);
                $('#login_popup').css('display', 'none');
                /* 로컬 세팅 */
                localStorage.setItem('user_infomation_id', identity);                        
                localStorage.setItem('user_infomation_pw', password);      
                localStorage.setItem('user_infomation_name', name);      
                localStorage.setItem('user_infomation_email', email);   
                console.log(localStorage.getItem('user_infomation_id')); 
            }else{
                alert("될줄 알았냐?");                    
            }
        }
          
    });
}    