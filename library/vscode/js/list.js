/* 책 제목 불러오기 */
function getPopUpNew(uniqueNumber){
    console.log(uniqueNumber);
    localStorage.setItem('uniqueNumber', uniqueNumber);
    $('.popUp').css('display', 'block');
    var bookName = "";
    $.ajax({                  
        url: 'http://localhost:8080/library/test/book/'+uniqueNumber,
        type : 'GET',
        dataType : 'json',
        success : function(response){
            console.log(response);
            var bookName = response[0].name;
            $('#book_name').empty();
            $('#book_name').append(bookName);
            $('#backImage .booksCssContent').css('display', 'none');                        
        }
    });
    
}
/* 선택한 도서 예약창 닫기  */    
function popupExit(){
    var val = $('#user_message').val();
    console.log(val);
    $('.popUp').css('display', 'none');
    $('#backImage .booksCssContent').css('display', 'block');
}