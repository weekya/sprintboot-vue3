<script setup>
import {getCurrentInstance, onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
const {proxy} = getCurrentInstance()
const re = reactive({
  code:'',
  msg:'',
  data:[]
})

async function pullBorrowList() {
  try {
    let res = await new proxy.$request(proxy.$urls.method().allBorrow).modeget()
    re.data = res.data.data
    re.msg = res.data.msg
    re.code = res.data.code
  }catch(e){
  }
}
onMounted(()=>{
  pullBorrowList()
})

async function deleteBorrow(borrow) {
  console.log(borrow)
  try {
    let res = await new proxy.$request(proxy.$urls.method().deleteBorrow + "?id=" + borrow.id).modeget()
    re.data = res.data.data
    re.msg = res.data.msg
    re.code = res.data.code
  }catch(e){
    console.log(e)
  }
  console.log(res.data)
  if(re.code === '200'){
    ElMessage({
      message:re.msg,
      type:'success'
    })
  }else{
    ElMessage.error(re.msg)
  }
}


const search = ref('')
function findBorrow(){
  console.log('findBorrow')
}

</script>

<template>
  <div class="ordering">
    <div class="heading">借阅信息</div>
    <div>
      <el-table :data="re.data" style=" width: 100%">
        <el-table-column prop="bookTitle" label = "书名" min-width="160"></el-table-column>
        <el-table-column prop="userName" label = "借阅人" min-width="160"></el-table-column>
        <el-table-column prop="borrowDate" label = "借阅时间" min-width="220"></el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button
                size="small"
                type="danger"
                @click="deleteBorrow(scope.row)"
            >
              Delete
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div>
      <el-pagination background layout="prev, pager, next" :total="400"
                     current-page="1" >

      </el-pagination>
    </div>
  </div>
</template>

<style scoped>

</style>