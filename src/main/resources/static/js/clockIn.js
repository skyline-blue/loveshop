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

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


let clockIn = new Vue({
    el: "#click-in",
    data: {
        "message": "点我打卡",
        "hasClockIn": ""
    },
    methods: {
        clockIn: function () {
            let that = this;

            // 当天没有打卡，则可以打卡
            if (!that.hasClockIn) {
                axios.post(url + "api/dutyHistory/add", Qs.stringify({
                        "aid": getCookie("aid"),
                        "time": new Date().getTime()
                    }))
                    .then(function (response) {
                        let result = response.data.responseResultMap;

                        if (result.status == 500) {
                            that.message = "今日已打卡！";
                            that.hasClockIn = true;
                        } else {
                            that.message = "打卡失败！";
                            alert("打卡失败！");
                        }

                    });
            }

        }
    },
    created: function () {
        let that = this;
        axios.post(url + "api/dutyHistory/searchLatestDate", Qs.stringify({
                "aid": getCookie("aid")
            }))
            .then(function (response) {
                let dateStr = response.data.responseResultMap.dateStr;
                let latestClockInDate = dateStr.substr(0, 10);

                let dateNow = new Date().Format("yyyy-MM-dd");

                that.hasClockIn = (dateNow == latestClockInDate);
                if (that.hasClockIn) {
                    that.message = "今日已打卡！";
                }
            });

    }
});