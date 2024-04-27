<script setup>
import {computed, getCurrentInstance, reactive, ref} from 'vue'
import {useRoute} from "vue-router";
import Login from "@/components/Login.vue";
import Register from "@/components/Register.vue";
import Menu from "@/components/Menu.vue";


const route = reactive(useRoute())
const loginPath ="/Login"
const registerPath = "/Register"
const menuPath = "/Menu"
const isLogin = ref(computed(() =>{
      return loginPath === route.fullPath
    })
)

const isRegister = ref(computed(() => {
  return registerPath === route.fullPath
}))

const isMenu = ref(computed(() => {
  return menuPath === route.fullPath
}))


const {proxy} = getCurrentInstance()
console.log(route)
</script>

<template>
  <router-view></router-view>
<!--  <div id="back-cont" v-if="!isMenu">-->
<!--    <Login v-if="isLogin"/>-->
<!--    <Register v-if="isRegister"/>-->
<!--  </div>-->
<!--  <div v-else>-->
<!--    <Menu v-if="isMenu"/>-->
<!--  </div>-->
</template>

<style scoped>
header {
  line-height: 1.5;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

}
</style>
