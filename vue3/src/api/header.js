import axios from 'axios'
import {Base64} from 'js-base64'
import {ElMessageBox} from 'element-plus'


//创建通用axios配置
let instance = axios.create({
    baseURL: "http://localhost:8081",
    //baseURL: "http://localhost:8081/test",
    responseType:"json",
    headers:{'Content-Type':'application/json'}
})

function baseFun(){
    const token = localStorage.getItem('token')
    const base64 = Base64.encode(token + ':')
    return 'Basic' + base64
}

// 请求之前
instance.interceptors.request.use(
    config =>{
        // let token = localStorage.getItem('token')
        // if(token){
        //     config.headers.Authorization = baseFun()
        // }
        return config
    },
    err =>{
        return Promise.reject(err)
    }
)

// 请求之后
instance.interceptors.response.use(
    response =>{
        console.log(response.status)
        if(response.status == 200){
            return Promise.resolve(response)
        }else{
            return Promise.reject(response)
        }
    },
    error =>{
        if(error.response){
            let Error = error.response.status
            let MSG = error.response.data.msg
            let errData = Error == 401 ? MSG : "服务器发生错误"
            console.log(Error + " " + MSG + " " + errData)
            console.log(error.response)
        }
        return Promise.reject(error.response)
    }
)

export default instance