/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'
import { createPinia } from 'pinia'




// const pinia = createPinia()
// const app = createApp(App)
// app.use(pinia)

// // ✅ works because the pinia instance is now active
// const userStore = useUserStore()
const pinia = createPinia();

const app = createApp(App);

app.use(pinia);

registerPlugins(app)

app.mount('#app')
