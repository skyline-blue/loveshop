let others_form = new Vue({
    el: "#others-form",
    data: {
        "name": "",
        "amount": "",
        "price": ""
    },
    methods: {
        submitOtherGoods: function () {
            if (this.name==="" || this.amount==="" || this.price==="") {
                alert("请完整填写商品信息！");
            }
            else if (!(/^\+?[1-9][0-9]*$/.test(this.amount.trim()))) {
                alert("商品数量错误!");
            }
            else if (!(/^[0-9]+(\.[0-9]{1,3})?$/.test(this.price.trim()))) {
                alert("商品价格错误！");
            }
            else {
                let that = this;
                if (confirm("确定要添加吗？")) {
                    axios.post(
                        url + "api/otherGoods/add", Qs.stringify(
                                {
                                    "name": this.name.trim(),
                                    "amount": this.amount.trim(),
                                    "price": this.price.trim()
                                }
                            )
                        )
                        .then(function (response) {
                            alert(response.data.responseResultMap.message);
                            that.name = "";
                            that.amount = "";
                            that.price = "";
                        })
                }
            }
        }
    }
});