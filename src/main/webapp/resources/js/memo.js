"use strict"; // 엄격한 문법 검사

function searchFunc() {
	// 똑같은 말임
/*	var boardSearch = $("#boardSearch").val();*/
/*	$("#boardSearch").val(boardSearch); */
	
	// 매퍼에서 조건을 지정해주었고, 컨트롤러에서 값들을 연결 시켜주었으므로, 여기서는 submit으로 넘기기만 하면 됨
	$("#search").submit();
}

function insertFunc() {
	//var userId = document.getElementsByName("userId")[0].value;
	var userId = $("#userId").val();
	var userName = $("#userName").val();
	var title = $("#title").val();
	
	if(!(userId.trim())) {
		alert("등록 아이디는 반드시 입력해야 합니다.");
		$("#userId").val("");
		$("#userId").focus();
		return;
	} else {
		if(userId.length > 15) {
			alert("등록 아이디는 최대 15자까지 입력 가능합니다.");
			$("#userId").val("");
			$("#userId").focus();
			return;
		}
	}/*else {	// 아이디 중복 체크 코드
		var idCheck = $(".idAlready").is(":visible");
		//alert("idCheck ====>> " + idCheck);
		if(idCheck){
			alert("이미 존재하는 아이디 입니다. 다른 아이디를 입력해주세요.");
			return;
		}
		if(!confirm("저장하시겠습니까?")) {
			return;
		}
	}*/
	
	if(!(userName.trim())) {
		alert("등록자명은 반드시 입력해야 합니다.");
		$("#userName").val("");
		$("#userName").focus();
		return;
	} else {
		if(userName.length > 10) {
			alert("등록자명은 최대 10자까지 입력 가능합니다.");
			return;
		}
	}
	
	if(!(title.trim())) {
		alert("제목은 반드시 입력해야 합니다.");
		$("#title").val("");
		$("#title").focus();
		return;
	} else {
		if(title.length > 50) {
			alert("제목은 최대 50자까지 입력 가능합니다.");
			$("#title").val("");
			$("#title").focus();
			return;
		}
	}
	
	if(!confirm("저장하시겠습니까?")) {
		return;
	}
	
	$("#insert").submit();
}

function updateFunc() {
	var updateId = $("#updateId").val();
	var title = $("#title").val();
	
	if(!(updateId.trim())) {
		alert("수정 아이디는 반드시 입력해야 합니다.");
		$("#updateId").val("");
		$("#updateId").focus();
		return;
	} else {
		if(updateId.length > 15) {
			alert("수정 아이디는 최대 15자까지 입력 가능합니다.");
			$("#updateId").val("");
			$("#updateId").focus();
			return;
		}
	}
	
	if(!(title.trim())) {
		alert("제목은 반드시 입력해야 합니다.");
		$("#title").val("");
		$("#title").focus();
		return;
	} else {
		if(title.length > 50) {
			alert("제목은 최대 50자까지 입력 가능합니다.");
			$("#title").val("");
			$("#title").focus();
			return;
		}
	}
	
	if(!confirm("수정하시겠습니까?")) {
		return;
	}
	$("#update").submit();
}

function deleteFunc() {
	if(!confirm("정말로 삭제하시겠습니까? 이 작업은 실행 후 되돌릴 수 없습니다.")) {
		return;
	}
	$("#delete").submit();
}

function checkDelFunc() {
	var cnt = $("input[name='checkDel']:checked").length;
	var checkArr = new Array();
	
	$('input[name=checkDel]:checked').each(function() {
		checkArr.push($(this).attr('id'));
	});
	
	//alert("checkArr =====>> " + checkArr);
	
	if(cnt == 0) {
		alert("하나 이상의 값을 선택 해주세요.");
	} else {
		$.ajax({
			type: "POST",
			url : './listDeleteOk',
			data: "checkArr=" + checkArr,
			//dataType: "json",
			success : function(data) {
				if(confirm("정말로 삭제하시겠습니까? 이 작업은 실행 후 되돌릴 수 없습니다.")) {
					//alert("data.chkCnt=====>>" + data.chkCnt);
                    alert(data.chkCnt + "건이 정상 삭제 되었습니다.");
                    window.location.reload();
				}
			},
			error : function() {
				alert("error");
			}
		});
	}
}

// home.jsp 에서 사용, 체크박스 삭제 관련
function checkBoxFunc(){
	// '전체 선택 체크박스' 클릭 시, '개별 체크박스' 전체 선택/해제
	$('#checkAll').click(function() {
		var check = $('#checkAll').is(':checked');
		if(check) {
			$('input[name=checkDel]').prop('checked', true);
		} else {
			$('input[name=checkDel]').prop('checked', false);
		}
	});
	// '개별 체크박스'들 전체 선택 시, 자동으로 '전체 선택 체크박스' 활성화
	$("input[name=checkDel]").click(function() {
		var total = $('input[name=checkDel]').length;
		var checked = $('input[name=checkDel]:checked').length;
		
		if(total != checked) {
			$('#checkAll').prop('checked', false);
		} else {
			$('#checkAll').prop('checked', true);
		}
	});
}

// 달력 호출 함수
function calendarFunc(){
	
	/* 달력 구현 */
	var config = {
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    yearSuffix: '년'	,
	    changeMonth: true,
	    changeYear: true,
	    showAnim: 'slide',
	    showMonthAfterYear: true,
		showOtherMonths: true
	}
	$(function() {
		$("input[name='writeDate']").datepicker(config);
	});
};

//페이징 호출부
function fnGoPaging(page) {
    location.href = "/board01?nowPage="+page;
}

// 아이디 중복 체크
/*function checkId() {
	//var userId = document.getElementsByName("userId")[0].value;
	var userId = $("#userId").val();
	
	$.ajax({
		url: './checkId',
		type: 'post',
		data: "userId=" + userId,
		success: function(data){
			//$("#rtCnt").val("반환카운트 : " + data.cntResult);
			if(data.cntResult != 1 && userId.length > 0) { // 사용 가능한 아이디일 떄, '사용 가능한 아이디입니다.'라는 문구 출력
				$('.idOk').css('display', 'inline-block');
				$('.idAlready').css('display', 'none');
			} else if(data.cntResult == 1 && userId.length > 0) { // 중복된 아이디일 떄, '이미 존재하는 아이디입니다.'라는 문구 출력
				$('.idOk').css('display', 'none');
				$('.idAlready').css('display', 'inline-block');
			} else {
				$('.idOk').css('display', 'none');	// 아무것도 입력 하지 않았을 때, 아무 문구도 뜨지 않음
				$('.idAlready').css('display', 'none');
			}
		},
		error: function(){
			alert("error");
		}
	});
}*/