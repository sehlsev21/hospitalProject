const PATIENT_API_BASE_URL = 'http://localhost:8080/patients';

class PatientService{
    getAllPatients(){
       return fetch(PATIENT_API_BASE_URL)
              .then((res) => res.json());
    }
    createPatient(patient){

          fetch(PATIENT_API_BASE_URL,{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(patient)
          })
          .then((res) => res.json())
          .then((json) => console.log(json));
    }
}

export default new PatientService()