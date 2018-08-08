$('.addshopcart').click(function(){
	  var csrfParamName = $('meta[name="_csrf_parameter"]').attr('content');
	    var csrfParamValue = $('meta[name="_csrf"]').attr('content');
	    
	    var data = {
	        cellphoneId: $(this).data('cellphone-id')
	    };
	    data[csrfParamName] = csrfParamValue;
	    
	    $.ajax('/shop/uc/shopcart/add', {
	        method: 'POST',
	        data: data // 该data将以表单数据格式编码成文本（Content-Type: application/x-www-form-urlencoded）
	    }).then(function() {
	        console.log('请求成功，加入成功');
	        $('#success').html('加入成功');
	    }).fail(function() {
	        console.error('请求失败');
	        $('#success').html('加入失败');
	    });
});