$(function(){
		
	function getUsers(){//定义获取数据的函数
		$.ajax({
			type:'get',
			url:'http://localhost:808/getAllUsers',
				async:true,//异步
				dataType:'json',
				success:function(data){
					
				},
				error:function(error){
					console.log(error);
				}
		})
	}
})