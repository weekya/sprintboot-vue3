<script setup>

import {getCurrentInstance, ref} from "vue";
import {ElMessage} from "element-plus";

const title = ref('')
const author = ref('')
const publisher  = ref('')
const category = ref('')
const isbn = ref('')
const quantity = ref('')
const {proxy} = getCurrentInstance()
const sumbit = async ()=>{
  console.log('submit alrealy')
  const book = {
    "title": title.value,
    "author": author.value,
    "publisher": publisher.value,
    "category": category.value,
    "isbn": isbn.value,
    "quantity": quantity.value
  }
  const res = await new proxy.$request(proxy.$urls.method().insertBook,book).modepost()
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
        <el-form-item label="图书名">
          <el-input v-model="title"></el-input>
        </el-form-item>
        <el-form-item label="作者">
          <el-input v-model="author"></el-input>
        </el-form-item>
        <el-form-item label="出版社">
          <el-input v-model="publisher"></el-input>
        </el-form-item>
        <el-form-item label="种类">
          <el-input v-model="category"></el-input>
        </el-form-item>
        <el-form-item label="ISBN编号">
          <el-input v-model="isbn"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="quantity"></el-input>
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