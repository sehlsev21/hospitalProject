const DOCTOR_API_BASE_URL = 'http://localhost:8080/doctors';
const DOCTOR_API_BY_ID_URL = 'http://localhost:8080/doctors/${dynamic_content}';

class DoctorService{
    getAllDoctors(){
       return fetch(DOCTOR_API_BASE_URL)
              .then((res) => res.json());
    }
    createDoctor(doctor){

          fetch(DOCTOR_API_BASE_URL,
            {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(doctor)
          })
          .then((res) => res.json())
          .then((json) => console.log(json));
    }

    deleteDoctor(doctorId){
      fetch(DOCTOR_API_BASE_URL + "/" + doctorId, 
      { 
        method: 'DELETE' 
      })
      .then(() => this.status = 'Delete successful')
      .then((res) => res.json())
      .then((json) => console.log(json));
      console.log("silindi-DoctorService.js-deleteDoctor")
    }

    updateDoctor(doctor){
      fetch(DOCTOR_API_BASE_URL + "/" + doctor.id, 
      { 
        method: 'PUT' ,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(doctor)
      })
      .then((res) => res.json())
      .then((json) => console.log(json));
      console.log("güncellendi-DoctorService.js-updateDoctor")
    }

}

export default new DoctorService()