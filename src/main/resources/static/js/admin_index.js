function getCookie(name) {
    let strCookie = document.cookie; //获取cookie字符串
    let arrCookie = strCookie.split("; "); //分割
    //遍历匹配
    for (let i = 0; i < arrCookie.length; i++) {
        let arr = arrCookie[i].split("=");
        if (arr[0] === name) {
            return arr[1];
        }
    }
    return "";
}

let date = {
    isDuringDate: function (beginDateStr, endDateStr) {
        let curDate = new Date(),
            beginDate = new Date(beginDateStr),
            endDate = new Date(endDateStr);
        return curDate >= beginDate && curDate <= endDate;

    }
}

function formatDate() {
    let year = new Date().getFullYear();
    let month = new Date().getMonth() + 1;
    let day = new Date().getDate();

    return year + "/" + month + "/" + day;
}

function getTimeStr() {
    let dateStr = formatDate();

    let weekList = ["7", "1", "2", "3", "4", "5", "6"];
    let week = new Date().getDay();
    let weekStr = weekList[week];

    if (weekStr === "6" || weekStr === "7") {
        return "0-00-00";
    }

    if (date.isDuringDate(dateStr + " 8:30", dateStr + " 10:05")) {
        return weekStr + "-01-01";
    }
    else if (date.isDuringDate(dateStr + " 10:20", dateStr + " 11:55")) {
        return weekStr + "-01-02";
    }
    else if (date.isDuringDate(dateStr + " 12:45", dateStr + " 14:10")) {
        return weekStr + "-02-01";
    }
    else if (date.isDuringDate(dateStr + " 14:30", dateStr + " 16:05")) {
        return weekStr + "-03-01";
    }
    else if (date.isDuringDate(dateStr + " 16:20", dateStr + " 17:55")) {
        return weekStr + "-03-02";
    }
    else if (date.isDuringDate(dateStr + " 19:30", dateStr + " 21:55")) {
        return weekStr + "-04-01";
    }
    else {
        return "0-00-00";
    }

}

let banner = new Vue({
    el: "#banner",
    data: {
        "username": getCookie("aname"),
    }
});

let weather = new Vue({
    el: "#weather",
    data: {
        "weather_position": "成都市高新西区",
        "weather_info_text": "",
        "weather_degree": "-",
        "weather_info_imgUrl": ""
    },
    created: function () {
        let that = this;
        axios.get("http://wthrcdn.etouch.cn/weather_mini?city=郫县")
            .then(function (response) {
                switch (response.data.data.forecast[0].type) {
                    case "多云": {
                        that.weather_info_imgUrl = "../img/weather_cloudy.png"
                    }
                }
                that.weather_info_text = response.data.data.forecast[0].type;
                that.weather_degree = response.data.data.wendu;
            });
    }
});

let workInfo = new Vue({
    el: "#workInfo",
    data: {
        // 当前值班人员
        "work_now": [],
        // 当前值班人员的备注
        "work_now_detail": [],
        "income_today": "0",
        "guest_today": "0"
    },
    created: function () {
        let that = this;
        // 获取当日收入
        axios.post(url + "api/bill/getTodayTotalBill")
            .then(function (response) {
                let income_today = response.data.responseResultMap.todayTotalBill;
                if (income_today == null) {
                    that.income_today = 0;
                } else {
                    that.income_today = income_today.toFixed(2);
                }
            });

        // 获取格式化后的时间段，对应数据库的time
        let time = getTimeStr();
        // 获取当日值班
        axios.post(url + "api/duty/getOnDutyAdmin", Qs.stringify({
                "time": time
            }))
            .then(function (response) {
                let onDutyAdminList = response.data.responseResultMap.onDutyAdminResultList;
                // 没有安排值班
                if (onDutyAdminList.length === 0) {
                    that.work_now = [{
                            aname: "空气"
                        },
                        {
                            aname: "空气"
                        }
                    ];
                } else {
                    // 有安排值班
                    that.work_now = onDutyAdminList;
                }
            });
    }
});

let task = new Vue({
    el: "#task",
    data: {
        "tasks": [{
                "index": 1,
                "time": "9月7日",
                "task_info": "招新宣传视频剪辑"
            },
            {
                "index": 2,
                "time": "10月9日",
                "task_info": "银杏黄策划书修改"
            }
        ]
    }
});

/* $(".log_info").focus(
    function () {
        $(".footer").hide();
    }
);

$(".log_info").blur(
    function () {
        $(".footer").show();
    }
); */
