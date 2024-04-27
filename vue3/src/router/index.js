import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import Login from "@/components/Login.vue";
import Register from "@/components/Register.vue"
import Menu from "@/components/Menu.vue";
import AllBookInfo from "@/components/AllBookInfo.vue";
import UpdateBook from "@/components/UpdateBook.vue";
import DeleteBook from "@/components/DeleteBook.vue";
import InsertBook from "@/components/InsertBook.vue";
import FindBook from "@/components/FindBook.vue";
import BorrowInfo from "@/components/BorrowInfo.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: {name: Login},
            redirect: '/login',
        },
        {
            path: '/login',
            name: 'login',
            component: Login,
            sensitive:true
        },
        {
            path: '/register',
            name: 'register',
            component: Register,
            sensitive:true
        },
        {
            path: '/menu',
            name: 'menu',
            component: Menu,
            redirect:'/allBookInfo',
            children:[
                {
                    path:'/allBookInfo',
                    name:'allBookInfo',
                    component:AllBookInfo
                },
                {
                    path:'/findBook',
                    name:'findBook',
                    component:FindBook,
                    redirect:'/findBook/title',
                    children:[
                        {
                            path:'/findBook/title',
                            name:'byTitle'
                        },
                        {
                            path:'/findBook/author',
                            name:'byAuthor'
                        },
                        {
                            path:'/findBook/publisher',
                            name:'byPublisher'
                        },
                        {
                            path:'/findBook/isbn',
                            name:'byIsbn'
                        },
                    ]
                },
                {
                    path:'/updateBook',
                    name:'updateBook',
                    component:UpdateBook
                },
                {
                    path:'/insertBook',
                    name:'insertBook',
                    component:InsertBook
                },
                {
                    path:'/deleteBook',
                    name:'deleteBook',
                    component:DeleteBook
                },
                {
                    path:'/borrowInfo',
                    name:'borrowInfo',
                    component:BorrowInfo
                }
            ],
            sensitive:true
        }
    ]
})

export default router