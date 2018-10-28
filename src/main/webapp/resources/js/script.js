function sendStartPageFormData(){
    if(($('#iName').val()=="")||($('#iSurname').val()=="")||($('#iNickname').val()==""))
        alert("Fill all fields");
    else {
        $.ajax({
            url: '/saveStartPageFormData',
            method: 'POST',
            data: {
                name: $('#iName').val(),
                surname: $('#iSurname').val(),
                nickname: $('#iNickname').val(),
                day: $('#iDay').val()
            },
            success: function (responseText) {
                if (responseText == "1") {
                    alert('Record have been saved');
                    $('#iName').val("");
                    $('#iSurname').val("");
                    $('#iNickname').val("");
                }
            }
        });
    }
}

function autoFillNickname() {
    $('#iNickname').val($('#iName').val() + $('#iSurname').val());
}
