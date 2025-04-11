const base = {
    get() {
        return {
            url : "http://localhost:8080/bianminzixingche/",
            name: "bianminzixingche",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/bianminzixingche/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "便民自行车管理系统"
        } 
    }
}
export default base
