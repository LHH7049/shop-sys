
$("#type-m").click(function () {
    //点击后高亮
    $("li.active").prop("class","");
    $("#type-m").prop("class","active");

    var cur_page = 1;
    var pageSize = 5;       //每页数据量
    var typeSum = 0;    //总商品类别数量
    var pageSum = 0;    //总页数

    $.post({
        url:"goodsType/goodsTypeSum",
        async:false,
        success:function (sum) {
            typeSum = sum;
        }
    });
    //向上取整
    pageSum = Math.ceil( typeSum / pageSize );

    //ajax异步刷新数据
    $.post({
        url:"goodsType/pagination",
        data:{cur_page:cur_page,pageSize:pageSize},
        success:function (data) {
            $("#thead").html(
                "<tr>"
                +"<th>id</th>"
                +"<th>商品类别名称</th>"
                +"</tr>"
            );
            $("#tbody").html( newDataRow(data));
            $("#pages").html(newPage(cur_page,pageSum));
        }
    });

    //    商品搜索功能
    $("#search-text").prop("placeholder","商品类别搜索");
    $("#search-btn").click(function () {
        $.post({
            url:"goodsType/search",
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
    $("#add-btn").prop("href","goodsType/toAddGoodsType").html("添加商品类别");
});

//删除商品
function del_click(id) {
    event.returnValue =confirm("您确定要删除"+id+"号商品类别吗？");
    $.ajax({
        url:"goodsType/deleteGoodsType",
        data:{id:id},
        success:function (res) {
            alert(res);
            $("#type-m").click();
        }
    })
}

//分页点击
function page_cc(val) {

    var pageSize = 5;       //每页数据量
    var typeSum = 0;    //总商品数量
    var pageSum = 0;    //总页数

    $.post({
        url:"goodsType/goodsTypeSum",
        async:false,
        success:function (sum) {
            typeSum = sum;
        }
    });

    //向上取整
    pageSum = Math.ceil( typeSum / pageSize );

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

    //传回页数
    $.ajax({
        url:"goodsType/pagination",
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
            +"<td>"+data[i].typename+"</td>"
            +"<td><a type='button' class='btn btn-warning' href='/goodsType/toUpdateGoodsType/" +data[i].id+ "'>详情</a>"
            +"&nbsp;&nbsp;&nbsp;"
            +"<input type='button' class='btn btn-danger' id='del_btn' onclick='del_click(" +data[i].id+ ")' value='删除'/>"
            +"</td></tr>";
    }
    return element;
}
