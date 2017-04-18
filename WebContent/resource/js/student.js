function checkAll() {
	var check = document.getElementById("checkAll");
	if (check.checked == true) {
		checkSub('checkAll');
	} else {
		checkSub('noCheckAll');
	}

}

function checkSub(flag) {
	var parm = {
		"name" : "jiwei"
	};
	$("#but").click(function() {
		$.post("stuList", parm, function(date) {
			$("#t").text(date);
		});
	});
	if (flag == "checkAll") {
		var s = document.getElementsByName("checkSub");
		for (var i = 0; i < s.length; i++) {
			s[i].checked = true;
		}
	} else {
		var s = document.getElementsByName("checkSub");
		for (var i = 0; i < s.length; i++) {
			s[i].checked = false;
		}
	}
}

function getId() {
	var id;
	var arr = new Array();
	var s = document.getElementsByName("checkSub");
	for (var i = 0; i < s.length; i++) {
		if (s[i].checked == true) {
			id = s[i].value;
			arr[arr.length] = id
		}
	}
	return arr;
}

function stuDel() {
	var ids = getId();
	// alert("您确定要删除"+ids+"条数据？");
	if (confirm("您确定要删除" + ids.length + "条数据？")) {
		window.location = "stuList?action=del&id=" + ids;
	}
}

function updateStu() {
	var ids = getId();
	if (ids.length > 1) {
		if (confirm("请选择一条需要修改的数据")) {

		}
		;
		return;
	}
	window.location = "stuList?action=findOneStuForId&ids=" + ids;
}
