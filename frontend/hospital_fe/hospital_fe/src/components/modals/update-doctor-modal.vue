<template>
    <div class="modal">
        <div class="modal-inner">
            <h2>Doktor Güncelle</h2>
            <form>
                <label for="name">İsim:</label>
                <input type="text" v-model="doctorForUpdate.name" id="name" name="name" value="doctorForUpdate.name"><br><br>
                <label for="surname">Soyisim:</label>
                <input type="text" v-model="doctorForUpdate.surname" id="surname" name="surname"  value="doctorForUpdate.surname"><br><br>
                <label for="nationalityId">Tc Kimlik No:</label>
                <input type="text" v-model="doctorForUpdate.nationalityId" id="nationalityId" name="nationalityId"  value="doctorForUpdate.nationalityId"><br><br>
                <label for="phoneNumber">Telefon No:</label>
                <input type="text" v-model="doctorForUpdate.phoneNumber" id="phoneNumber" name="phoneNumber"  value="doctorForUpdate.phoneNumber"><br><br>
                <button @click="updateDoctor">Güncelle</button>
                <button @click="$emit('close')">Kapat</button>
            </form>
        </div>
    </div>
</template>

<script>
import DoctorService from "../../services/DoctorService.js";
export default {
    
    props: {
        doctorForUpdate:
            {
                name: '',
                surname: '',
                nationalityId: '',
                phoneNumber: ''
            }
    },
    methods:{
        updateDoctor() {
            DoctorService.updateDoctor(this.doctorForUpdate);
        },
    }
}
</script>

<style>
.root {
    position: relative;
}

.modal {
    position: absolute;
    top: 0;
    left: 0;
    background-color: rgba(0, 0, 0, 0.1);
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-inner {
    background-color: #fff;
    padding: 50px;
    border-radius: 10px;
    border: 1px solid black;
}
</style>