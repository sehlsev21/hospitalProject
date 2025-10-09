<template>
    <div class="modal">
        <div class="modal-inner">
            <h2>Hasta Ekle</h2>
            <form>
                <label for="name">İsim:</label>
                <input type="text" v-model="patient1.name" id="name" name="name"><br><br>
                <label for="surname">Soyisim:</label>
                <input type="text" v-model="patient1.surname" id="surname" name="surname"><br><br>
                <label for="nationalityId">Tc Kimlik No:</label>
                <input type="text" v-model="patient1.nationalityId" id="nationalityId" name="nationalityId"><br><br>
                <label for="phoneNumber">Telefon No:</label>
                <input type="text" v-model="patient1.phoneNumber" id="phoneNumber" name="phoneNumber"><br><br>
                <button @click="$emit('createPatient', patient1)">Ekle</button>
                <button @click="$emit('close')">Kapat</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            patient1:
            {
                name: '',
                surname: '',
                nationalityId: '',
                phoneNumber: ''
            }
        }
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