<script setup>

import {getCurrentInstance, ref} from "vue";
import {ElMessage} from "element-plus";

const {proxy} = getCurrentInstance()
const isbn = ref('')
const sumbit = async ()=>{
  const res = await new proxy.$request(proxy.$urls.method().deleteBook + "?isbn=" + isbn.value).modeget()
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
  <div class="ordering">
    <div>
      <el-form style="max-width: 600px" label-position="top">
        <el-form-item label="ISBN编号">
          <el-input v-model="isbn"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="sumbit">
            Submit
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped>

</style>