<!-- <template>
    <VContainer class="ma-0 pa-0" style="height: 100%;" fluid>
        <VRow class="custom-row" align="center" no-gutters style="height: 100%;">
            <VCol cols="8">
                <img src="../../assets/LoginImage.JPG" style="width: 66vw; height: 100vh; object-fit: cover;"><img>
            </VCol>
            <VCol cols="4">
                <div class="pa-16 ma-15 card-container">
                    <div class="logo-container">
                        <img src="../../assets/CGLabsLogo.JPG" alt="Logo" />
                    </div>
                    <VForm ref="form" @submit.prevent="login">
                        <VSnackbar v-model="validateCredentials" type="error" color="red" min-width="0">Incorrect username
                            or password
                            <template v-slot:actions>
                                <VBtn color="white" variant="flat" @click="loginError = false">close</VBtn>
                            </template>
                        </VSnackbar>
                        <VTextField v-model="username" label="Username" variant="outlined" class="blue-border mb-3"
                            :rules="[v => !!v || 'Username is required']" required></VTextField>
                        <VTextField v-model="password" label="Password" variant="outlined" type="password"
                            :rules="[v => !!v || 'Password is required']"></VTextField>
                        <VRow>
                            <VCol cols="6">
                                <VSpacer />
                            </VCol>
                            <VCol cols="6" class="text-right">
                                <VBtn variant="plain" :ripple="false" color="blue" @click="forgotPasswordModalOpen">Forgot
                                    Password?</VBtn>
                            </VCol>
                        </VRow>
                        <VBtn :loading="isLoading" color="blue" style="margin-top: 20px;" block type="submit">Login</VBtn>
                    </VForm>
                </div>
            </VCol>
        </VRow>
    </VContainer>
    <ForgotPassword :dialogVisible="forgotPassword" @close="forgotPassword = false" />
    <ResetPassword :resetDialogVisible="ResetPasswordRoute" @close="resetPassword = false" />
</template>

<script lang="ts">
import { VContainer, VRow, VCol, VForm, VTextField, VBtn, VSnackbar } from 'vuetify/lib/components/index.mjs';
import ForgotPassword from '@/components/modals/ForgotPasswordModal.vue';
import ResetPassword from '@/components/modals/ResetPasswordModal.vue';
import { Auth } from '@/services/auth/AuthEndPoint';
import usersStore from '@/permissions';
import router from '@/router';


export default {
    name: "LoginPage",
    components: {
        VContainer,
        VRow,
        VTextField,
        VCol,
        VForm,
        VBtn,
        VSnackbar,
        ForgotPassword,
        ResetPassword
    },
    data() {
        return {
            username: '' as string,
            password: '' as string,
            loginError: false,
            isLoading: false,
            forgotPassword: false,
            resetPassword: false,
        };
    },
    computed: {
        validateCredentials() {
            return this.loginError === true;
        },
        ResetPasswordRoute() {
            const type = router.currentRoute.value?.query.type;
            if (type === 'forgot') {
                this.resetPassword = true;
                return true;
            } else return false;
        }
    },
    methods: {
        async login() {
            const form = this.$refs.form as InstanceType<typeof VForm>;
            const { valid } = await form.validate();
            if (valid) {
                this.isLoading = true;
                Auth.login({ UserNameOrEmailAddress: this.username, Password: this.password })
                    .then(async () => {
                        await usersStore.getUserInformation();
                        return router.push('boxes');
                    }).finally(() => {
                        this.isLoading = false;
                    }).catch(() => {
                        this.loginError = true;
                    });
            }

        },
        forgotPasswordModalOpen() {
            this.forgotPassword = true;
        }
    }
};
</script>

<style>
.VContainer {
    padding: 0px;
}

.custom-row {
    flex: 1;
}

.card-container {
    margin-top: -100px;
}

.custom-left {
    text-align: left;
}

.blue-border .v-input__control {
    border-color: blue;
}

.logo-container {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
}
</style> -->
