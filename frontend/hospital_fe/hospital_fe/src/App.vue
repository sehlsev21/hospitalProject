<script>
import TableDoctors from "./components/tables/doctors-table.vue";
import TablePatients from "./components/tables/patients-table.vue";
import DoctorService from "./services/DoctorService.js";
import PatientService from "./services/PatientService.js";
import AddDoctorModal from "./components/modals/add-doctor-modal.vue";
import AddPatientModal from "./components/modals/add-patient-modal.vue";
import UpdateDoctorModal from "./components/modals/update-doctor-modal.vue";
import CreateAppointmentModal from "./components/modals/create-appointment-modal.vue";

export default {
  name: "App",
  data() {
    return {
      doctors: [], //denemeSehiladsasd
      patients: [],
      showAddDoctorPopup: false,
      showUpdateDoctorPopup: false,
      showAddPatientPopup: false,
      showCreateAppointmentPopup: false,
      doctorForUpdate:
            {
                name: '',
                surname: '',
                nationalityId: '',
                phoneNumber: ''
            },
      doctorForCreateAppointment:
            {
                id: "",
                name: '',
                surname: '',
                nationalityId: '',
                phoneNumber: ''
            },
    };
  },
  methods: {
    getAllDoctors: function () {
      DoctorService.getAllDoctors().then((json) => {
        this.doctors = json;
      });
    },
    createDoctor(addedDoctor) {
      console.log("createDoctor çalıştı");
      DoctorService.createDoctor(addedDoctor);
    },
    deleteDoctor(id) {
      console.log("deleteDoctor çalıştı");
      DoctorService.deleteDoctor(id);
    },
    updateDoctor() {
      console.log("updateDoctor çalıştı");
    },
    createAppointment() {
      console.log("createAppointment çalıştı");
    },
    getAllPatients: function () {
      PatientService.getAllPatients().then((json) => {
        this.patients = json;
      });
    },
    createPatient: function (patient) {
      console.log("createPatient çalıştı");
      PatientService.createPatient(patient);
    },
    deletePatient() {
      console.log("deletePatient çalıştı");
    },
    updatePatient() {
      console.log("updatePatient çalıştı");
    },




    doktorEKlePopupAc() {
      this.showAddDoctorPopup = true;
    },
    doktorEKlePopupKapat() {
      this.showAddDoctorPopup = false;
    },
    doktorGüncellePopupAc(doctor){
      this.showUpdateDoctorPopup = true;
      this.doctorForUpdate = doctor;
    },
    doktorGüncellePopupKapat(){
      this.showUpdateDoctorPopup = false;
    },
    hastaEKlePopupAc() {
      this.showAddPatientPopup = true;
    },
    hastaEKlePopupKapat() {
      this.showAddPatientPopup = false;
    },
    randevuOlusturPopupAc(doctor){
      this.showCreateAppointmentPopup = true;
      this.doctorForCreateAppointment = doctor;
    },
    randevuOlusturPopupKapat(){
      this.showCreateAppointmentPopup = false;
    }
  },
  created() {
    this.getAllDoctors(), 
    this.getAllPatients()
  },
  components: {
    TableDoctors,
    TablePatients,
    AddDoctorModal,
    AddPatientModal,
    UpdateDoctorModal,
    CreateAppointmentModal
  },
};
</script>

<template>

  <div style="justify-content: center; text-align: center">
      <h1 class="center">Hastane Web Uygulaması</h1>
      <img src="./hospital.svg" alt="Girl in a jacket" width="200" height="200">
  </div>

  <TableDoctors
    :doctorss="this.doctors"
    @openCreateAppointmentPopup="randevuOlusturPopupAc"
    @deleteDoctor="deleteDoctor"
    @openDoctorUpdatePopup="doktorGüncellePopupAc"
    @openDoctorAddPopup="doktorEKlePopupAc"
  />

  <TablePatients
    :patientss="this.patients"
    @deletePatient="deletePatient"
    @updatePatient="updatePatient"
    @openPatientAddPopup="hastaEKlePopupAc"
  />

  <Teleport to="body">
    <AddDoctorModal v-if="showAddDoctorPopup" @close="doktorEKlePopupKapat"
                                              @createDoctor="createDoctor" />

    <AddPatientModal v-if="showAddPatientPopup" @close="hastaEKlePopupKapat"
                                                @createPatient="createPatient" />

    <UpdateDoctorModal v-if="showUpdateDoctorPopup" @close="doktorGüncellePopupKapat"
                                                    :doctorForUpdate= "this.doctorForUpdate"/>

    <CreateAppointmentModal v-if="showCreateAppointmentPopup" @close="randevuOlusturPopupKapat"
                                                    :doctorForCreateAppointment= "this.doctorForCreateAppointment"
                                                    :patientsForCreateAppointment= "this.patients"/>

  </Teleport>
</template>