<template>
    <div class="genel">
        <h1>Doktorlar</h1>
        <div class="tablo">
            <table>
                <thead>
                    <tr>
                        <th>Doktor Id</th>
                        <th>Doktor Adı</th>
                        <th>Doktor Soyadı</th>
                        <th>Doktor Tc Kimlik No</th>
                        <th>Doktor Telefon No</th>
                        <th>İşlemler</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="doctor in doctorss" v-bind:key="doctor.id">
                        <td>{{ doctor.id }}</td>
                        <td>{{ doctor.name }}</td>
                        <td>{{ doctor.surname }}</td>
                        <td>{{ doctor.nationalityId }}</td>
                        <td>{{ doctor.phoneNumber }}</td>
                        <td>
                            <button @click="$emit('openCreateAppointmentPopup', doctor)">Randevu Oluştur</button>
                            <button @click="$emit('deleteDoctor', doctor.id)">Sil</button>
                            <button @click="$emit('openDoctorUpdatePopup', doctor)">Güncelle</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <button @click="$emit('openDoctorAddPopup')">Doktor Ekle</button>
    </div>
</template>


<script>
export default {
    props: {
        doctorss: [Array]
    }
}
</script>

<style>
table,
th,
td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 5px;
    text-align: center
}

.tablo {
    margin: auto;
}

.genel {
    display: flex;
    border: 1px solid black;
    padding: 10px;
    justify-content: center;
}
</style>