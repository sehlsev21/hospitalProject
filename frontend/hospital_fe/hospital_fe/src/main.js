import { createApp } from 'vue'
import App from './App.vue'
import Select2 from 'vue3-select2-component';

const app = createApp(App)
app.component('Select2', Select2)
app.mount('#app')



