function picsubmit(){
    let files = $('#picture')[0].files;
    let imgFiles = [];
    for (let i = 0; i < files.length; i++) {
        let file = files[i];
        //保存文件到数组
        imgFiles.push(file);
    }
    let obj = {
        pics:imgFiles
    }
    let formData = new FormData();
    $.each(obj,function(key,value) {
        formData.append(key,value);
    })
    $.ajax({
        type: 'post',
        url: 'upFile',
        cache: false,
        contentType: "multipart/form-data",
        processData: false, //默认为true，默认情况下，发送的数据将被转换为对象，设为false不希望进行转换
        data: formData, //数据
        success: function(data) {
            console.log("请求返回success信息data：", data);
            $('#url').val(data);
            $('#imageview').attr("src","res/"+data);
        }
    });
}

