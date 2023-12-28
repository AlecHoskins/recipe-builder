<template>
  <v-app class="v-app">
    <app-nav v-if="isUserAuthenticated" />
    <page-layout />
  </v-app>
</template>

<script lang="ts" setup>
import { useAuthStore } from '@/stores/AuthStore';
import AppNav from './AppNav.vue'
import PageLayout from './PageLayout.vue'
import { getCookieValue } from '@/utils/cookieUtils';
import appConsts from '@/constants/AppConstants';
import { ref } from 'vue';
import { watch } from 'vue';
import { storeToRefs } from 'pinia';

var cookie = getCookieValue(appConsts.tokenCookieName);
const isUserAuthenticated = ref(cookie !== null && cookie !== undefined);


const authStore = useAuthStore();
const { getAuthenticatedUser } = storeToRefs(authStore);

watch(getAuthenticatedUser, () => {
  var newCookie = getCookieValue(appConsts.tokenCookieName);
  if(newCookie && getAuthenticatedUser.value !== null && getAuthenticatedUser.value !== undefined){
    isUserAuthenticated.value = true;
  }
  else{
    isUserAuthenticated.value = false;
  }
}, { immediate: true });

</script>