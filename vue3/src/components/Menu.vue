<script setup>
import {onMounted, reactive, shallowRef, ref} from "vue";

console.log('menu')

const menuArray = [
  {
    id:'1',
    icon:'',
    title:'所有图书',
    router:'/allBookInfo',
    Subclass:[]
  },
  {
    id:'2',
    icon:'',
    title:'查找图书',
    router:'/findBook',
    Subclass:[
      {
        id:'2-1',
        title:'根据书名查找',
        router:'/findBook/title'
      },
      {
        id:'2-2',
        title:'根据作者查找',
        router:'/findBook/author'
      },
      {
        id:'2-3',
        title:'根据出版社查找',
        router:'/findBook/publisher'
      },
      {
        id:'2-4',
        title:'根据ISBN查找',
        router:'/findBook/isbn'
      }
    ]
  },
  {
    id:'3',
    icon:'',
    title:'修改图书信息',
    router:'/updateBook',
    Subclass:[]
  },
  {
    id:'4',
    icon:'',
    title:'插入图书',
    router:'/insertBook',
    Subclass:[]
  },
  {
    id:'5',
    icon:'',
    title:'删除图书',
    router:'/deleteBook',
    Subclass:[]
  },
  {
    id:'6',
    icon:'',
    title:'借阅信息',
    router:'/borrowInfo',
    Subclass: []
  }
]
const menu = shallowRef(menuArray)


const menu_index = ref('1')
function Select(index,path){
  console.log(index)
  localStorage.setItem('menuId',JSON.stringify(index))
}
onMounted(()=>{
  menu_index.value = JSON.parse(localStorage.getItem('menuId'))
})

</script>

<template>
  <router-view></router-view>
  <div>
    <div class="sidebar-top">
      <div>图书管理系统</div>
      <div >退出</div>
    </div>
    <div class="sidebar-cont">
      <el-menu :default-active="menu_index" @select="Select" :router="true">
        <div v-for="(item,index) in menu" :key="index">
          <el-menu-item v-if="item.Subclass.length == 0" :index="item.router">
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <span>{{item.title}}</span>
          </el-menu-item>
          <el-sub-menu v-if="item.Subclass.length > 0" :index="item.router">
            <template #title>
              <el-icon>
                <component :is="item.icon"></component>
              </el-icon>
              <span>{{item.title}}</span>
            </template>
            <div v-for="(item_2,id) in item.Subclass" :key="id">
              <el-menu-item :index="item_2.router">{{item_2.title}}</el-menu-item>
            </div>
          </el-sub-menu>
        </div>
      </el-menu>
    </div>
  </div>
</template>

<style scoped>

</style>