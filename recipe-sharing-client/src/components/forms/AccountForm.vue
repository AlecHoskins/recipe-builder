<template>
    <VForm>
        <VRow>
            <VCol>
                <VTextField v-model="user.username" label="Username"></VTextField>
            </VCol>
            <VCol>
                <VTextField v-model="user.email" label="Email Address"></VTextField>
            </VCol>
        </VRow>
    </VForm>
</template>

<script setup lang="ts">
import UserDTO from '@/services/users/UserDto';
import { useAuthStore } from '@/stores/AuthStore';
import { ref } from 'vue';

var authStore = useAuthStore();

// #region properties
const user = ref({} as UserDTO);
//#endregion

var authUser = authStore.getAuthenticatedUser;
if(authUser){
    user.value = authUser;
}
//#region methods
// function getUserById(id: number){
//     UserEndPoint.getUserById(id)
//     .then((res)=>{
//         debugger
//     });
// }
//#endregion
</script>