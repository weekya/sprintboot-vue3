<script setup>
import {getCurrentInstance, reactive, ref} from "vue";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
console.log('login')
const loginInfo = reactive({
  email:'',
  password:''
})
const router = useRouter()
const {proxy} = getCurrentInstance()
const login = async ()=>{
  const user = {
    "password": loginInfo.password,
    "email": loginInfo.email,
  }
  const res = await new proxy.$request(proxy.$urls.method().login,user).modepost()
  const data = res.data
  console.log(data)
  if(data.code === '200'){
    ElMessage({
      message:data.msg,
      type:'success'
    })
  }else{
    ElMessage.error(data.msg)
  }
  if(data.msg === '登录成功'){
      localStorage.setItem('username',data.data.name)
      localStorage.setItem('userId',data.data.id)
      console.log(localStorage.getItem('username'))
    await router.push({path: '/allBookInfo'})
  }
}

</script>

<template>
  <div id="back-cont">
    <div class="center-content">
      <div class="back-content-login">
        <div class="center-title"> 登录 </div>
        <div class="center-input">
          <p>邮箱</p>
          <el-input v-model="loginInfo.email" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="center-input">
          <p>密码</p>
          <el-input v-model="loginInfo.password" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="change-view">
          <RouterLink to="/register"> 注册 </RouterLink>
        </div>
        <el-button type="success" class="center-btn" @click="login"> 登录 </el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>