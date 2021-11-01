$(".search-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height()) * 0.9 + "px"
});


Vue.component("other-list", {
    props: ["other"],
    template: "<tr><td scope='row'>{{other.id}}</td><td>{{other.name}}</td><td>{{other.price}}</td><td>{{other.amount}}</td></tr>"
});

let search_others = new Vue({
    el: "#search-div",
    data: {
        "searchInput": "",
        "name": "",
        "others": []
    },
    methods: {
        submitSearch: function () {
            this.name = this.searchInput.trim();
            let that = this;
            axios.post(url + "api/otherGoods/searchByName",
                    Qs.stringify({
                        "name": this.name
                    }))
                .then(function (response) {
                    that.others = response.data.responseResultMap.otherGoodsList;
                });
        }
    }
});