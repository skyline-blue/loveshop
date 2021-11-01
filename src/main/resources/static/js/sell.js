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

let sell = new Vue({
    el: "#sell-div",
    data: {
        "showSellBookInput": true,
        "showSellOthersInput": false,
        "isbn": "",
        "name": "",
        "othersName": "",
        "amount": 0
    },
    methods: {
        showSellBook: function () {
            this.showSellOthersInput = false;
            this.showSellBookInput = true;
        },
        showSellOthers: function () {
            this.showSellBookInput = false;
            this.showSellOthersInput = true;
        },
        sellBook: function () {
            axios.post(url + "api/book/sell", Qs.stringify({
                "isbn": this.isbn,
                "amount": this.amount,
                "time":  new Date().getTime(),
                "admin": getCookie("aname")
            }))
                .then(function (response) {
                    alert(response.data.responseResultMap.message)
                });
        },
        sellOthers: function () {
            axios.post(url + "api/otherGoods/sell", Qs.stringify({
                "name": this.name,
                "amount": this.amount,
                "time":  new Date().getTime(),
                "admin": getCookie("aname")
            }))
                .then(function (response) {
                    alert(response.data.responseResultMap.message)
                });
        }
    }
});