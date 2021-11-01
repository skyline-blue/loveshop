$(".connections-div").css({
    "height": (document.documentElement.clientHeight - $(".banner").height())*0.9 + "px"
});

Vue.component("connection-list", {
    props: ["connection"],
    template: "<tr><td scope='row'>{{connection.aid}}</td><td>{{connection.aname}}</td><td>{{connection.school}}</td><td>{{connection.qq}}</td><td>{{connection.phone}}</td></tr>"
});

let connection_lists = new Vue({
    el: "#connections",
    data: {
        "connections": []
    },
    created: function () {
        let that = this;
        axios.post(url + "api/admin/showAllAdminInfo").
            then(function (response) {
                that.connections = response.data.responseResultMap.adminList;
                console.log(response.data.responseResultMap.adminList);
                
            });
    }
});

