<template>
  <div class="modal">
    <div class="modal-inner">

        

        <h2>Randevu Oluştur</h2>
        <label for="name">Doktor: {{ doctorForCreateAppointment.name }} {{ doctorForCreateAppointment.surname }}</label>
        <label v-for="patient in patientsForCreateAppointment" v-bind:key="patient.patientId">Hasta seçiniz: </label>
        <select name="cars" id="cars">
          <option value=nasd>{{patient.name}}</option>
        </select>
        <div>
            <button @click="createAppointment" style="margin-right: 5px">
                Güncelle
            </button>
            <button @click="$emit('close')">Kapat</button>
        </div>
    </div>
  </div>
</template>

<script>
import DoctorService from "../../services/DoctorService.js";

export default {
  props: {
    doctorForCreateAppointment: {
      name: "",
      surname: "",
      nationalityId: "",
      phoneNumber: "",
    },
    patientsForCreateAppointment: [Array],
  },
  methods: {
    createAppointment() {
      console.log("ct calisti");
    }
  }
};
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