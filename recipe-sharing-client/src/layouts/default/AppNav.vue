<template>
  <v-card class="side-menu-card">
    <v-navigation-drawer expand-on-hover rail class="side-menu">
      <!-- <v-list>
          <v-list-item prepend-avatar="https://randomuser.me/api/portraits/women/85.jpg" title="Sandra Adams"
            subtitle="sandra_a88@gmailcom" class="icon-color">
          </v-list-item>
        </v-list> -->
      <v-list>
        <router-link :to="{ path: '/account-details' }" :replace="true" style="text-decoration: none !important;">
          <v-list-item prepend-icon="mdi-account" :title="returnUsername()" :subtitle="authenticatedUser?.email"
            class="icon-color">
          </v-list-item>
        </router-link>
        <v-list-item prepend-icon="mdi-logout" title="Logout" @click="logout"
          class="icon-color">
        </v-list-item>
      </v-list>

      <v-divider class="icon-color"></v-divider>
      <v-list density="compact" nav>
        <router-link :to="{ path: '/recipes' }" :replace="true">
          <v-list-item prepend-icon="mdi-folder-outline" title="My Recipes" value="apps" class="icon-color">
          </v-list-item>
        </router-link>


      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script lang="ts" setup>
import { watch } from 'vue';
import { ref } from 'vue';
import { useAuthStore } from '@/stores/AuthStore'
import { clearToken } from '@/utils/tokenUtils';
import { deleteCookie } from '@/utils/cookieUtils';
import appConsts from '@/constants/AppConstants';
import UserDTO from '@/services/users/UserDto';
import router from '@/router';

const authStore = useAuthStore();

// Create a ref to track the username
const authenticatedUser = ref(authStore.getAuthenticatedUser);

// Use computed to update the username when getAuthenticatedUser changes
const updateAuthenticatedUser = () => {
  authenticatedUser.value = authStore.getAuthenticatedUser;
};

// Watch for changes in getAuthenticatedUser and update the username accordingly
watch(() => authStore.getAuthenticatedUser, updateAuthenticatedUser);

function returnUsername() {
  return authenticatedUser.value?.username ?? "Login/Create Account";
}

//#region methods
function logout(){
  deleteCookie(appConsts.tokenCookieName);
  authStore.setAuthenticatedUser({} as UserDTO);
  router.replace("login");
}
//#endregion
</script>
