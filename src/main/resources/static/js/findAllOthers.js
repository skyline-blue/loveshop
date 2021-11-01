$(".others-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height())*0.9 + "px"
});


Vue.component("other-list", {
    props: ["other"],
    template: "<tr><td scope='row'>{{other.id}}</td><td>{{other.name}}</td><td>{{other.price}}</td><td>{{other.amount}}</td></tr>"
});

let other_lists = new Vue({
    el: "#other-lists",
    data: {
        "others": []
    },
    created: function () {
        let that = this;
        axios.post(url + "api/otherGoods/selectAll").
            then(function (response) {
                that.others = response.data.responseResultMap.otherGoodsList;
            });
    }
});