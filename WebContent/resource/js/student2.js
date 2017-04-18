/**
 * Jquery的技术点
 * 
 * 1：在项目中导入jquery的js包。
 * 2：在页面中引入jquery的js文件
 * 3：写一个js文件
 * 4：在页面中引入自己写的js文件
 * 5：在自己的js文件中用
 * $(document).ready(function(){
	getBackData();
});


 * 
 * 
 * 
 * 1：当我们页面一加载就调用js中的某个方法
 * 2: 当页面加载完毕之后，页面就要有数据
 *    数据从servlet中得到
 *    调用servlet
 *    由jquery向服务器发送请求？
 *    post方法中有三个参数
 *      参数一： 请求地址
 *      参数二： 请求参数
 *      参数三： 回调函数
 *    $.post("/stuList",{},function(data){});
 *  3: 怎么把list集合发送到js文件中？
 *  javaScript能正确识别json数据
 *     如何把java中的集合变成json？
 *        json是什么？“字符串”---特定格式的字符串，键值对
 *        
 *        Lits----student  -----属性）-----值
 *        {{name:zhangsan,age:lisi,sex:男}，{}，{}，{}}
 *        List ----list ---list ----student ---属性----值
 *        {{{{name:张三}，{}，{}}，{}，{}}，{}，{}，{}}
 *        
 *   4： 如何把json数据（String）发给javascript
 *   
 *   
 */
$(document).ready(function(){
	getBackData();
});


function init(){
	$("#stuDel").unbind();
	$("#stuDel").bind("click",function(){
		var parm = {id:'1'};
		$.post("stuList",parm,function(data){
			 var obj = jQuery.parseJSON(data);
				//JSON.parse(data);
				 $.each(obj,function(i,item){
					 $("#mainDiv").append(
							 "<tr>"+
					"<input type='hidden' id='"+item.sid+"' value='123'></input>"+	
					"<td>"+item.sname+"</td>"+
					"<td>"+item.ssex+"</td>"+
					"<td>"+item.sage+"</td>"+
					"</tr>"
					 );
				 });
		});
	});
	
	
}


function getBackData(){
	$.post("stuList",{},function(data){
		//如何把字符串变成javaScript类型的对象
		var obj = JSON.parse(data);
		//alert(obj[0][1].sid);
		 $.each(obj[0],function(i,item){
			 $("#mainDiv").append(
					 "<tr>"+
			"<input type='hidden' id='"+item.sid+"' value='123'></input>"+	
			"<td>"+item.sname+"</td>"+
			"<td>"+item.ssex+"</td>"+
			"<td>"+item.sage+"</td>"+
			"</tr>"
			 );
		 });
	});
}

function getId() {
	var id;
	var s = document.getElementsByName("checkSub");
	for (var i = 0; i < s.length; i++) {
		if (s[i].checked == true) {
			id = s[i].value;
		}
	}
	return id;
}


var saveData = {
	studate:{
		id:'',
		name:''
	},

    teadata:{
    	
    }
}