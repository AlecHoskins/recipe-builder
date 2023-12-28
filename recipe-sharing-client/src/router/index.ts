// Composables
import appConsts from '@/constants/AppConstants';
import AuthEndPoint, { Auth } from '@/services/auth/AuthEndPoint';
import RecipeDTO from '@/services/recipes/RecipeDto';
import { useAuthStore } from '@/stores/AuthStore';
import { getCookieValue } from '@/utils/cookieUtils';
import { createRouter, createWebHistory } from 'vue-router'
import { UserServices } from '@/services/users/UserEndPoint';

const routes = [
  {
    path: '',
    name: 'Base',
    component: () => import('@/layouts/default/AppLayout.vue'),
    meta: { requiresAuth: true },
    children: [
      {
        path: '/login',
        name: 'Login',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/login/Login.vue'),
        meta: { requiresAuth: false }
      },
      {
        path: '/recipes',
        name: 'Recipes',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/recipes/RecipeIndex.vue'),
        meta: { requiresAuth: true }
      },
      {
        path: '/recipe-details/:id?',
        name: 'Recipe Details',
 
        component: () => import('@/views/recipes/RecipeDetails.vue'),
        meta: { requiresAuth: true }
      },
      {
        path: '/account-details',
        name: 'Account Details',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/account/AccountDetails.vue'),
        meta: { requiresAuth: true }
      },
    ]

  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to) => {
  debugger
  const authStore = useAuthStore();
  // if(!authStore.getIsAppInitialized){
    // Auth.authenticate();
  // }
  var accessToken = getCookieValue(appConsts.tokenCookieName);

  if (accessToken && !authStore.getAuthenticatedUser) {
    UserServices.getUserByToken()
      .then((res) => {
        debugger
      });
  }

  if (to.meta.requiresAuth && !accessToken) {
    authStore.setReturnUrl(to.fullPath);
    return '/login';
  } 

});

export default router
