<template>
    <div class="genel">
        <h1>Hastalar</h1>
        <div class="tablo">
            <table>
                <thead>
                    <tr>
                        <th>Hasta Id</th>
                        <th>Hasta Adı</th>
                        <th>Hasta Soyadı</th>
                        <th>Hasta Tc Kimlik No</th>
                        <th>Hasta Telefon No</th>
                        <th>İşlemler</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="patient in patientss" v-bind:key="patient.patientId">
                        <td>{{ patient.patientId }}</td>
                        <td>{{ patient.name }}</td>
                        <td>{{ patient.surname }}</td>
                        <td>{{ patient.nationalityId }}</td>
                        <td>{{ patient.phoneNumber }}</td>
                        <td>
                            <button @click="$emit('deletePatient')">Sil</button>
                            <button @click="$emit('updatePatient')">Güncelle</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <button @click="$emit('openPatientAddPopup')">Hasta Ekle</button>
    </div>
</template>


<script>
export default {
    props: {
        patientss: [Array]
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