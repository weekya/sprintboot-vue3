import axios from 'axios'
import instance from './header.js'
const request = class{
    constructor(url,args){
        this.url = url
        this.args = args
    }
    modepost(){
        return new Promise((resolve,reject)=>{
            instance.post((this.url),this.args)
                .then(res=>{
                    resolve(res)
                }).catch(err=>{
                    reject(err)
            })

        })
    }
    modeget(){
        return new Promise((resolve,reject)=>{
            instance.get((this.url))
                .then(res=>{
                    console.log("yes")
                    resolve(res)
                }).catch(err=>{
                    console.log("no")
                    reject(err)
            })
        })
    }
}

export default request

