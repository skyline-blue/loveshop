let input = new Vue({
    el: "#input-box",
    data: {
        "studentId": "",
        "password": ""
    },
    methods: {
        login: function () {
            axios.post(url + "api/admin/login", Qs.stringify({
                    "studentId": this.studentId,
                    "password": this.password
                }))
                .then(
                    function (response) {
                        if (response.data.responseResultMap.status === 500) {
                            document.cookie = "aid=" + response.data.responseResultMap.aid;
                            document.cookie = "aname=" + response.data.responseResultMap.aname;
                            document.cookie = "studentId=" + response.data.responseResultMap.studentId;
                            document.cookie = "phone=" + response.data.responseResultMap.phone;
                            document.cookie = "QQ=" + response.data.responseResultMap.QQ;
                            document.cookie = "school=" + response.data.responseResultMap.school;
                            document.cookie = "level=" + response.data.responseResultMap.level;
                            document.cookie = "points=" + response.data.responseResultMap.points;
                            document.cookie = "dept=" + response.data.responseResultMap.dept;

                            window.location.href = "../html/index_admin.html";
                            
                        } else {
                            alert(response.data.responseResultMap.message);
                        }
                    });
        }
    }
});