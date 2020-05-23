//新建分页
function newPage(cur_page,pageSum) {

    var element = "";
    var back = "-1";
    var pre = "-2";
    var leftLeave = "-3";
    var rightLeave = "-4";

    if(cur_page === 1){
        element += "<li class='disabled'><a >&laquo;</a></li>";
    }else {
        element += "<li ><a onclick='page_cc("+back+")'>&laquo;</a></li>";
    }

    //当前页的左边三页
    if(cur_page - 5 > 0){
        element += "<li><a id='li"+1+ "' onclick='page_cc("+1+")'>"+1+"</a></li>";
        element += "<li><a onclick='page_cc("+leftLeave+")'>...</a></li>";
        for (var i = cur_page-3 ; i < cur_page ; i ++){
            element += "<li><a id='li"+i+ "' onclick='page_cc("+i+")'>"+i+"</a></li>";
        }
    }else {
        for (i = 1 ; i < cur_page ; i ++){
            element += "<li><a id='li"+i+ "' onclick='page_cc("+i+")'>"+i+"</a></li>";
        }
    }

    element += "<li  class='active'><a id='li"+cur_page+"' onclick='page_cc("+cur_page+")'>"+cur_page+"</a></li>";

    //当前页的右边三页
    if(cur_page + 5 < pageSum){
        for (var j = cur_page+1 ; j < pageSum ; j ++){
            element += "<li><a id='li"+j+ "' onclick='page_cc("+j+")'>"+j+"</a></li>";
        }
        element += "<li><a onclick='page_cc("+rightLeave+")'>...</a></li>";
        element += "<li><a id='li"+pageSum+ "' onclick='page_cc("+pageSum+")'>"+pageSum+"</a></li>";
    }else {
        for (j = cur_page+1 ; j <= pageSum ; j ++){
            element += "<li><a id='li"+j+ "' onclick='page_cc("+j+")'>"+j+"</a></li>";
        }
    }
    if(cur_page === pageSum){
        element += "<li class='disabled'><a >&raquo;</a></li>";
    }else {
        element += "<li><a onclick='page_cc("+pre+")'>&raquo;</a></li>";
    }


    return element;
}