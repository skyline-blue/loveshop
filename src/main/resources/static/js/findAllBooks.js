$(".books-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height())*0.9 + "px"
});


Vue.component("book-list", {
    props: ["book"],
    template: "<tr><td scope='row'>{{book.bid}}</td><td>{{book.isbn}}</td><td>{{book.bookName}}</td><td>{{book.bookCount}}</td><td>{{book.bookPrice}}</td><td>{{book.author}}</td><td>{{book.location}}</td></tr>"
});

let book_lists = new Vue({
    el: "#book-lists",
    data: {
        "books": []
    },
    created: function () {
        let that = this;
        axios.post(url + "api/book/selectAll").
            then(function (response) {
                that.books = response.data.responseResultMap.bookList;
            });
    }
});