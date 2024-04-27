<script setup>
import {getCurrentInstance, onMounted, reactive} from "vue";
import {ElMessage} from "element-plus";
const {proxy} = getCurrentInstance()
const re = reactive({
  code:'',
  msg:'',
  data:[]
})

async function pullBookList() {
  try {
    let res = await new proxy.$request(proxy.$urls.method().allBook).modeget()
    re.data = res.data.data
    re.msg = res.data.msg
    re.code = res.data.code
  }catch(e){
  }
}
onMounted(()=>{
  pullBookList()
})

const borrow = reactive({
  bookId:"",
  userId:"",
  bookTitle:"",
  userName:"",
  borrowDate:''
})
async function insertBorrow(book) {
  let getTime = new Date().getTime()
  borrow.userId = localStorage.getItem('userId')
  borrow.userName = localStorage.getItem('username')
  borrow.bookId = book.id
  borrow.bookTitle = book.title
  borrow.borrowDate = new Date(getTime)
  console.log(borrow)
  try {
    let res = await new proxy.$request(proxy.$urls.method().insertBorrow,borrow).modepost()
    re.msg = res.data.msg
    re.code = res.data.code
  }catch(e){
  }

  if(re.code === '200'){
    book.quantity = book.quantity - 1
    ElMessage({
      message:re.msg,
      type:'success'
    })
  }else{
    ElMessage.error(re.msg)
  }
  console.log(re.msg)
}

</script>

<template>
  <div class="ordering">
    <div class="heading">图书列表</div>
    <div>
      <el-table :data="re.data" style=" width: 100%">
        <el-table-column prop="title" label = "书名" min-width="160"></el-table-column>
        <el-table-column prop="author" label = "作者" min-width="160"></el-table-column>
        <el-table-column prop="publisher" label = "出版社" min-width="220"></el-table-column>
        <el-table-column prop="category" label = "分类" min-width="160"></el-table-column>
        <el-table-column prop="isbn" label = "ISBN" min-width="160"></el-table-column>
        <el-table-column prop="quantity" label = "数量" min-width="180"></el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button
                size="small"
                type="danger"
                @click="insertBorrow(scope.row)"
            >
              借阅
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div>
      <el-pagination background layout="prev, pager, next" :total="400"
                     current-page="1" @current-change="currentChange">

      </el-pagination>
    </div>
  </div>
</template>

<style scoped>

</style>