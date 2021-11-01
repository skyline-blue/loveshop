function getCookie(name){
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] === name){
            return arr[1];
        }
    }
    return "";
}


let banner = new Vue({
    el: "#banner",
    data: {
        "username": getCookie("aname")
    }
});

function getPosition(level) {
    switch (level) {
        case "001": {
            return "部长";
        }
        case "002": {
            return "副部长";
        }
        case "003": {
            return "老部员";
        }
        case "004": {
            return "部员";
        }
    }
}

let user_info = new Vue({
    el: "#user-info",
    data: {
        "username": getCookie("aname"),
        "studentId": getCookie("studentId"),
        "phone": getCookie("phone"),
        "school": getCookie("school"),
        "department": getCookie("dept"),
        "position": getPosition(getCookie("level")),
        "points": getCookie("points")
    }
});
