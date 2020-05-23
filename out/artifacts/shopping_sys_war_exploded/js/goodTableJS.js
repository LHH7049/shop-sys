
$("#sp-m").click(function () {
    //点击后高亮
    $("li.active").prop("class","");
    $("#sp-m").prop("class","active");

    var cur_page = 1;
    var pageSize = 5;       //每页数据量
    var goodSum = 0;    //总商品数量
    var pageSum = 0;    //总页数

    $.post({
        url:"good/goodSum",
        async:false,
        success:function (sum) {
            goodSum = sum;
        }
    });
    //向上取整
    pageSum = Math.ceil( goodSum / pageSize );

    //ajax异步刷新数据
    $.post({
        url:"good/pagination",
        data:{cur_page:cur_page,pageSize:pageSize},
        success:function (data) {
            $("#thead").html(
                "<tr>"
                +"<th>id</th>"
                +"<th>名称</th>"
                +"<th>出厂价</th>"
                +"<th>售价</th>"
                +"<th>库存</th>"
                +"<th>操作</th>"
                +"</tr>"
            );
            $("#tbody").html( newDataRow(data));

            $("#pages").html(newPage(cur_page,pageSum));
        }
    });

    //    商品搜索功能
    $("#search-text").prop("placeholder","商品搜索");
    $("#search-btn").click(function () {
        $.post({
            url:"good/search",
            data:{name:$("#search-text").val()},
            success:function (data) {
                var element = newDataRow(data);
                if (data.length <= 0)
                    $("#tbody").html("未找到"+$("#search-text").val());
                else
                    $("#tbody").html(element);
            }
        })
    });
    //添加商品
    $("#add-btn").prop("href","good/toAddGood").html("添加商品");
});

//删除商品
function del_click(id) {
    event.returnValue =confirm("您确定要删除"+id+"号商品吗？");
    $.ajax({
        url:"good/deleteGood",
        data:{id:id},
        success:function (res) {
            alert(res);
            $("#sp-m").click();
        }
    })
}

//分页点击
function page_cc(val) {

    var pageSize = 5;       //每页数据量
    var goodSum = 0;    //总商品数量
    var pageSum = 0;    //总页数

    $.post({
        url:"good/goodSum",
        async:false,
        success:function (sum) {
            goodSum = sum;
        }
    });

    //向上取整
    pageSum = Math.ceil( goodSum / pageSize );

    var id = parseInt($("#pages li.active a").html());
    var nextid = 0;
    if(val === -2 ){   //前进
        nextid = id + 1;
    }else if(val === -1 ){      //后退
        nextid = id - 1;
    }else if (val === -4 ){     //右移三页
        nextid = id + 3;
    }else if (val === -3){      //左移三页
        nextid = id - 3;
    }else{
        nextid = val;
    }

    //传回去页数
    $.ajax({
        url:"/good/pagination",
        data:{cur_page:nextid,pageSize:pageSize},
        success:function (data) {
            $("#tbody").html( newDataRow(data));
            $("#pages").html(newPage(nextid,pageSum));
        }
    });
}

//新建数据行
function newDataRow(data) {
    var element = "";
    for(var i = 0 ; i < data.length ; i ++){
        element += "<tr><td>"+data[i].id+"</td>"
            +"<td>"+data[i].gname+"</td>"
            +"<td>"+data[i].goprice+"</td>"
            +"<td>"+data[i].grprice+"</td>"
            +"<td>"+data[i].gstore+"</td>"
            +"<td><a type='button' class='btn btn-warning' href='/good/toUpdateGood/" +data[i].id+ "'>详情</a>"
            +"&nbsp;&nbsp;&nbsp;"
            +"<input type='button' class='btn btn-danger' id='del_btn' onclick='del_click(" +data[i].id+ ")' value='删除'/>"
            +"</td></tr>";
    }
    return element;
}

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