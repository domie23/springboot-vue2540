import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import cheliang from '@/views/modules/cheliang/list'
    import cheliangCollection from '@/views/modules/cheliangCollection/list'
    import cheliangOrder from '@/views/modules/cheliangOrder/list'
    import cheliangSunhao from '@/views/modules/cheliangSunhao/list'
    import dictionary from '@/views/modules/dictionary/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryCheliang from '@/views/modules/dictionaryCheliang/list'
    import dictionaryCheliangCollection from '@/views/modules/dictionaryCheliangCollection/list'
    import dictionaryCheliangOrder from '@/views/modules/dictionaryCheliangOrder/list'
    import dictionaryCheliangOrderPayment from '@/views/modules/dictionaryCheliangOrderPayment/list'
    import dictionaryChezi from '@/views/modules/dictionaryChezi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryZuyong from '@/views/modules/dictionaryZuyong/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCheliang',
        name: '车辆类型',
        component: dictionaryCheliang
    }
    ,{
        path: '/dictionaryCheliangCollection',
        name: '收藏表类型',
        component: dictionaryCheliangCollection
    }
    ,{
        path: '/dictionaryCheliangOrder',
        name: '订单类型',
        component: dictionaryCheliangOrder
    }
    ,{
        path: '/dictionaryCheliangOrderPayment',
        name: '订单支付类型',
        component: dictionaryCheliangOrderPayment
    }
    ,{
        path: '/dictionaryChezi',
        name: '车辆状态',
        component: dictionaryChezi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryZuyong',
        name: '租用状态',
        component: dictionaryZuyong
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/cheliang',
        name: '车辆',
        component: cheliang
      }
    ,{
        path: '/cheliangCollection',
        name: '车辆收藏',
        component: cheliangCollection
      }
    ,{
        path: '/cheliangOrder',
        name: '车辆订单',
        component: cheliangOrder
      }
    ,{
        path: '/cheliangSunhao',
        name: '车辆损耗管理',
        component: cheliangSunhao
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
