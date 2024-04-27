<script setup>
import {getCurrentInstance, reactive} from "vue";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";

const registerInfo = reactive({
    username:'',
    password:'',
    email:'',
    phone:''
})
const {proxy} = getCurrentInstance()
const register = async ()=>{
  console.log('register now')
  console.log(proxy.$urls.method().register)
  const user = {
    "id": '',
    "name": registerInfo.username,
    "password": registerInfo.password,
    "email": registerInfo.email,
    "privilege": false,
    "phone": registerInfo.phone
  }
  const res = await new proxy.$request(proxy.$urls.method().register,user).modepost()
  const data = res.data
  if(data.code === '200'){
    ElMessage({
      message:data.msg,
      type:'success'
    })
  }else{
    ElMessage.error(data.msg)
  }
  console.log(data)

}

</script>

<template>
  <div id="back-cont">
    <div class="center-content">
      <div class="back-content-register">
        <div class="center-title"> 注册 </div>
        <div class="center-input">
          <p>用户名</p>
          <el-input v-model="registerInfo.username" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="center-input">
          <p>密码</p>
          <el-input v-model="registerInfo.password" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="center-input">
          <p>邮箱</p>
          <el-input v-model="registerInfo.email" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="center-input">
          <p>电话</p>
          <el-input v-model="registerInfo.phone" placeholder="Please input" class="inputflex"/>
        </div>
        <div class="change-view">
          <RouterLink to="/login"> 登录 </RouterLink>
        </div>
        <el-button type="success" class="center-btn" @click="register"> 注册 </el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>