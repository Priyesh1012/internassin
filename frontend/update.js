const handlesubmit = (event) => {
    event.preventDefault()
    const jsname = event.target[0].value
    const age = event.target[1].value
    const employId = event.target[2].value
    const country = event.target[3].value
    const formData = {
        name: jsname,
        age: age,
        employId: employId,
        country: country
    }
    fetch(`http://localhost:8080/api/upinf/${employId}`, {
        method: "PUT", body: JSON.stringify(formData), headers: {
            "Content-type": "application/json"
        }
    }).then(() => {
        alert("Information added successfully");
    }).catch((error) => {
        console.log(error);

    })
}
const form = document.querySelector("form")
form.addEventListener("submit", handlesubmit)

