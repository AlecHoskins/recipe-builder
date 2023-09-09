<template>
    <v-card>
        <v-tabs v-model="tab" bg-color="primary">
            <v-tab value="Login">Login</v-tab>
            <v-tab value="SignUp">Sign-Up</v-tab>
        </v-tabs>

        <v-card-text>
            <v-window v-model="tab">
                <v-window-item value="Login">
                    <VRow>
                        <VCol>
                            <VTextField label="Username/Email Address" v-model="loginRequest.usernameOrEmail"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VTextField label="Password" v-model="loginRequest.password"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VBtn @click="login">
                                Login
                            </VBtn>
                        </VCol>
                    </VRow>
                </v-window-item>
                <v-window-item value="SignUp">
                    <VRow>
                        <VCol>
                            <VTextField label="Username" v-model="registerRequest.username"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VTextField label="Email Address" v-model="registerRequest.email"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VTextField label="Password" v-model="registerRequest.password"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VBtn @click="register">
                                Register
                            </VBtn>
                        </VCol>
                    </VRow>
                </v-window-item>
            </v-window>
        </v-card-text>
    </v-card>

    <v-snackbar v-model="isErrorShowing" :timeout="2000" color="red">
        {{ errorMessage }}
        <template v-slot:actions>
            <v-btn prepend-icon="mdi-close" color="white" variant="text" @click="isErrorShowing = false"></v-btn>
        </template>
    </v-snackbar>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import { LoginRequestDto } from '@/services/auth/AuthEndPoint';
import { RegisterRequestDto } from '@/services/auth/AuthEndPoint';
import { Auth } from '@/services/auth/AuthEndPoint'
import router from '@/router';

let tab = ref(null);

//#region Form Data
const loginRequest = ref({} as LoginRequestDto);
const registerRequest = ref({} as RegisterRequestDto);
//#endregion

//#region Error
const isErrorShowing = ref(false);
const errorMessage = ref("");
//#endregion

//#region Methods
function login() {
    Auth.login(loginRequest.value)
        .then((returnUrl) => {
            if (returnUrl) {
                router.replace(returnUrl);
            }
            else {
                router.replace("/");
            }
        })
        .catch((e) => {
            errorMessage.value = e.response.data;
            isErrorShowing.value = true;
        });

}
function register() {
    Auth.register(registerRequest.value)
        .catch((e) => {
            errorMessage.value = e.response.data;
            isErrorShowing.value = true;
        });
}
//#endregion
</script>