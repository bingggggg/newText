layui.use(['layer', 'form', 'jquery', 'element'], function() {
	var layer = layui.layer,
		$ = layui.jquery,
		form = layui.form;
    /**备案边民信息弹窗*/
	$('.add-payacc').on('click', function() {
		layer.open({
			type: 2,
			shade: 0.8,
			move: false,
			area: ['60%', '65%'],
			content: 'border_information.html' //这里content是一个普通的String
		});
	});
	/**备案商铺信息弹窗*/
	$('.add-store-info').on('click', function() {
		layer.open({
			type: 2,
			shade: 0.8,
			move: false,
			area: ['60%', '65%'],
			content: 'store_information.html' //这里content是一个普通的String
		});
	});
	/**设置系统参数弹窗*/
	$('.param-btn').on('click', function() {
		layer.open({
			type: 2,
			shade: 0.8,
			move: false,
			area: ['60%', '50%'],
			content: 'system_param.html' //这里content是一个普通的String
		});
	});
	form.on('checkbox(checkbox)', function(data) {
		if(data.elem.checked) {
			$(".layui-pay-show").removeClass("layui-hide");
		}else{
			$(".layui-pay-show").addClass("layui-hide");
		} 
	});

})