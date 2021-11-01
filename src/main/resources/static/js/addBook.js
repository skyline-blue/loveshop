let book_form = new Vue({
    el: "#book-form",
    data: {
        "isbn": "",
        "bookName": "",
        "bookCount": "",
        "bookPrice": "",
        "author": "",
        "location": ""
    },
    methods: {
        submitBook: function () {
            if (this.isbn === "" || this.bookName === "" || this.bookCount === "" || this.bookPrice === "" || this.author === "" || this.location === "") {
                alert("请完整填写书籍信息！");
            }
            else if (!(/^\+?[1-9][0-9]*$/.test(this.isbn.trim())) || (this.isbn.trim().length !== 13 && this.isbn.trim().length !== 10)) {
                alert("ISBN格式错误！");
            }
            else if (!(/^([\u4E00-\u9FA5A-Za-z0-9_\s{1}]+)-([\u4E00-\u9FA5A-Za-z0-9_]+)-([\u4E00-\u9FA5A-Za-z0-9_]+)$/.test(this.bookName.trim()))) {
                alert("书名格式错误！");
            }
            else if (!(/^\+?[1-9][0-9]*$/.test(this.bookCount.trim()))) {
                alert("图书数量错误！");
            }
            else if (!(/^[0-9]+(\.[0-9]{1,3})?$/.test(this.bookPrice.trim()))) {
                alert("图书价格错误！");
            }
            else if (!(/^[0][1-4]-[A-B]-[0][1-4]$/.test(this.location.trim()))) {
                alert("位置格式错误！");
            }
            else {
                let that = this;
                if (confirm("确定要添加吗？")) {
                    axios.post(
                            url + "api/book/add", Qs.stringify({
                                "isbn": this.isbn.trim(),
                                "bookName": this.bookName.trim(),
                                "bookCount": this.bookCount.trim(),
                                "bookPrice": this.bookPrice.trim(),
                                "author": this.author.trim(),
                                "location": this.location.trim()
                            })
                        )
                        .then(function (response) {
                            alert(response.data.responseResultMap.message);
                            that.isbn = "";
                            that.bookName = "";
                            that.bookCount = "";
                            that.bookPrice = "";
                            that.author = "";
                            that.location = "";
                        })
                }
            }

        }
    }
});