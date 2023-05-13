"use strict"; // 엄격한 문법 검사

function searchFunc() {
	// 똑같은 말임
/*	var boardSearch = $("#boardSearch").val();*/
/*	$("#boardSearch").val(boardSearch); */
	
	// 매퍼에서 조건을 지정해주었고, 컨트롤러에서 값들을 연결 시켜주었으므로, 여기서는 submit으로 넘기기만 하면 됨
	$("#search").submit();
}

function insertBtn() {
	// 상대경로 이므로 './insertOk'임
	$.ajax({
		url: "./insertOk",
		type: "POST",
		data:  {"id": $("#id").val(), "name": $("#name").val() ,"content": $("#content").val()},
		success: function() {
			alert("저장이 완료되었습니다.");
			// 메인 페이지로 이동
			location.href="/test04";
		},
		error: function() {
			alert("error");
		}
	});
}

function updateBtn() {
	$.ajax({
		url: "./updateOk",
		type: "POST",
		data:  {"num": $("#num").val(), "id": $("#id").val(), "name": $("#name").val() ,"content": $("#content").val()},
		success: function() {
			alert("저장이 완료되었습니다.");
			// 메인 페이지로 이동
			location.href="/test04";
		},
		error: function() {
			alert("error");
		}
	});
}

function deleteBtn() {
	$.ajax({
		// 'url' + 변수, url 뒤에 변수가 옴.
		url: "./delete?num=" + $("#num").val(),
		type: "GET",
		success: function() {
			alert("삭제가 완료되었습니다.");
			// 메인 페이지로 이동
			location.href="/test04";
		},
		error: function() {
			alert("error");
		}
	});
}