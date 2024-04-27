<script setup>
import {computed, getCurrentInstance, onMounted, reactive, ref} from "vue";
import {useRoute} from "vue-router";
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

const url = useRoute().fullPath
const input = ref('')
console.log(url)
const tag = computed(()=>{
  let tag = ref('')
  switch (url){
    case '/findBook/title': tag = ref('请输入书名')
      break;
    case '/findBook/author': tag = ref('请输入作者名')
      break;
    case '/findBook/publisher': tag = ref('请输入出版社')
      break;
    case '/findBook/isbn': tag = ref('请输入ISBN编号')
      break;
  }
  return tag.value
})
let param = ref('')
  if (url === '/findBook/title') {
    param = ref('title')
  } else if (url === '/findBook/author') {
    param =  ref('author')
  } else if (url === '/findBook/publisher') {
    param = ref('publisher')
  } else if (url === '/findBook/isbn') {
    param = ref('isbn')
  }


async function findByInput() {

  let res = reactive({})
  try {
    if (param.value === 'title') {
      let url = proxy.$urls.method().findBookByTitle + "?" + param.value + "=" + input.value
      res = await new proxy.$request(url).modeget();
    } else if (param.value === 'author') {
      let url = proxy.$urls.method().findBookByAuthor + "?" + param.value + "=" + input.value
      res = await new proxy.$request(url).modeget();
    } else if (param.value === 'publisher') {
      let url = proxy.$urls.method().findBookByPublisher + "?" + param.value + "=" + input.value
      res = await new proxy.$request(url).modeget();
    } else if (param.value === 'isbn') {
      let url = proxy.$urls.method().findBookByIsbn + "?" + param.value + "=" + input.value
      res = await new proxy.$request(url).modeget();
    }
  }catch(e){
    console.log(e)
  }
  re.data = res.data.data
  re.msg = res.data.msg
  re.code = res.data.code
  if(re.code === '200'){
    ElMessage({
      message:re.msg,
      type:'success'
    })
  }else{
    ElMessage.error(re.msg)
  }
}

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
  console.log(re.msg)
  if(re.code === '200'){
    book.quantity = book.quantity - 1
    ElMessage({
      message:re.msg,
      type:'success'
    })
  }else{
    ElMessage.error(re.msg)
  }
}

</script>

<template>
  <div class="ordering">
    <div class="heading">
      <el-row>
        <el-input v-model="input" type="text" :placeholder="tag" maxlength="15" style="width: 240px"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="findByInput">搜索</el-button>
      </el-row>
    </div>
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
                     current-page="1" >

      </el-pagination>
    </div>
  </div>
</template>

<style scoped>

</style>