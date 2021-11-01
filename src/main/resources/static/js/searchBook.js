$(".search-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height()) * 0.9 + "px"
});

Vue.component("book-list", {
    props: ["book"],
    template: "<tr><td scope='row'>{{book.bid}}</td><td>{{book.isbn}}</td><td>{{book.bookName}}</td><td>{{book.bookCount}}</td><td>{{book.bookPrice}}</td><td>{{book.author}}</td><td>{{book.location}}</td></tr>"
});

let search_book = new Vue({
    el: "#search-div",
    data: {
        "searchInput": "",
        "isbn": "",
        "bookName": "",
        "books": []
    },
    methods: {
        submitSearch: function () {
            if ((this.searchInput.trim().length === 13 || this.searchInput.trim().length === 10) && (/^\+?[1-9][0-9]*$/.test(this.isbn.trim()))) {
                // 查询的是图书ISBN
                this.isbn = this.searchInput.trim();
                let that = this;
                axios.post(url + "api/book/searchByIsbn",
                    Qs.stringify({
                        "isbn": this.isbn
                }))
                    .then(function (response) {
                        that.books = response.data.responseResultMap.bookList;
                    });
            } else {
                /// 查询的是书名
                this.bookName = this.searchInput.trim();
                let that = this;
                axios.post(url + "api/book/searchByName",
                    Qs.stringify({
                        "bookName": this.bookName
                }))
                    .then(function (response) {
                        that.books = response.data.responseResultMap.bookList;
                    });
            }
        }
    }
});