$(".bills-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height())*0.9 + "px"
});


Vue.component("bill-list", {
    props: ["bill"],
    template: "<tr><td scope='row'>{{bill.id}}</td><td>{{bill.time}}</td><td>{{bill.admin}}</td><td>{{bill.money}}</td><td>{{bill.goods}}</td><td>{{bill.amount}}</td></tr>"
});

let bill_lists = new Vue({
    el: "#bill-lists",
    data: {
        "bills": []
    },
    created: function () {
        let that = this;
        axios.post(url + "api/bill/selectAll").
            then(function (response) {
                that.bills = response.data.responseResultMap.billList;
            });
    }
});