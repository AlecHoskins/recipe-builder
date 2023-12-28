import UserDTO from "@/services/users/UserDto";
import { access } from "fs";
import { defineStore } from "pinia";
import { computed, ref } from "vue";

export const useAuthStore = defineStore("authStore", () => {

  //#region Authenticated User
  const authenticatedUser = ref(null as UserDTO | null);
  const getAuthenticatedUser = computed(() =>  { 
    return authenticatedUser.value;
  });
  function setAuthenticatedUser(newAuthenticatedUser: UserDTO) {
    authenticatedUser.value = newAuthenticatedUser;
  }
  function clearAuthenticatedUser() {
    authenticatedUser.value = {} as UserDTO;
  }
  //#endregion

  //#region Return Url
  const returnUrl = ref(null as string | null);
  const getReturnUrl = computed(() => returnUrl.value);
  function setReturnUrl(newReturnUrl: string | null) {
    returnUrl.value = newReturnUrl;
  }
  //#endregion

  return {
    getAuthenticatedUser,
    setAuthenticatedUser,
    clearAuthenticatedUser,
    getReturnUrl,
    setReturnUrl,
  };
});



